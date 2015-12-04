package org.dc.riot.lol.rx.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class RiotApiThreadPoolExecutor extends ScheduledThreadPoolExecutor {

	private static final int TIME_BUFFER_MIN = 1000;

    private RiotApiRateRule[] rules;
    private long timeBuffer = 2000;		// 2 second time buffer
    
    private RiotApiScheduleTimeline timeline = new RiotApiScheduleTimeline();
    private boolean running = true;
    
    private ArrayBlockingQueue<Runnable> backPressureBuffer;

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize, RejectedExecutionHandler handler) {
		super(corePoolSize, handler);
		init(rules);
	}

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, threadFactory, handler);
		init(rules);
	}

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize, ThreadFactory threadFactory) {
		super(corePoolSize, threadFactory);
		init(rules);
	}

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize) {
		super(corePoolSize);
		init(rules);
	}
	
	private void init(RiotApiRateRule[] rules) {
		this.rules = rules;
		backPressureBuffer = new ArrayBlockingQueue<>(5000);	// TODO find some function to optimize this number
		
		super.execute(new Runnable() {
			@Override
			public void run() {
				while (running) {
					try {
						Runnable command = backPressureBuffer.take();
						long timeNow = onGetTime();
						synchronized (timeline) {
							if (rules != null && rules.length > 0) {
								timeline.clean(rules[0], timeNow);
							}

							RiotApiScheduleEntry entry = new RiotApiScheduleEntry(command);

							long delay = computeDelay(timeNow);
							entry.setScheduledTime(timeNow + delay);
							timeline.add(entry);
							RiotApiThreadPoolExecutor.this.schedule(command, delay, TimeUnit.MILLISECONDS);
						}
					} catch (InterruptedException e) {
						// shutting down, so swallow this Exception
					}
				}
			}
		});
	}

	@Override
	public void execute(Runnable command) {
		try {
			backPressureBuffer.put(command);
		} catch (InterruptedException e) {
			running = false;
		}
	}
	
	protected long onGetTime() {
		return System.currentTimeMillis();
	}
	
    private long computeDelay(long timeNow) {
    	if (rules == null || rules.length == 0) {
			return 0;
    	}
    	
    	// our smallest time window isn't even full yet, so go ahead and return 0;
    	if (rules[rules.length - 1].getRequests() > timeline.getEntries().length) {
    		return 0;
    	}
    	
    	long timeBuffer = this.timeBuffer;	// create a copy of timeBuffer so that synchronization errors can't happen
    	if (timeBuffer < TIME_BUFFER_MIN) {
    		timeBuffer = TIME_BUFFER_MIN;
    		this.timeBuffer += TIME_BUFFER_MIN;
    	}

    	long nextAvailableTime = timeNow;
    	for (RiotApiRateRule r : rules) {
    		long candidateTime = r.getNextTime(timeNow, 0, timeline.getEntries());
    		if (candidateTime > nextAvailableTime) {
    			nextAvailableTime = candidateTime;
    		}
    	}

    	return nextAvailableTime - timeNow + timeBuffer;
    }

	public static RiotApiThreadPoolExecutor fromRateRules(RiotApiRateRule[] rules) {
    	int threadpoolSize = 10;
        if (rules != null) {
            ArrayList<RiotApiRateRule> tempList = new ArrayList<>();
            for (RiotApiRateRule r : rules) {
                tempList.add(r);
            }

            Collections.sort(tempList, new Comparator<RiotApiRateRule>() {
                @Override
                public int compare(RiotApiRateRule lhs, RiotApiRateRule rhs) {
                    if (lhs.getSeconds() > rhs.getSeconds()) {
                        return -1;
                    } else if (lhs.getSeconds() == rhs.getSeconds()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });

            RiotApiRateRule[] sortedRuleArray = tempList.toArray(new RiotApiRateRule[tempList.size()]);
            threadpoolSize = sortedRuleArray[rules.length - 1].getRequests();
        }
        
        return new RiotApiThreadPoolExecutor(rules, threadpoolSize + 1);
	}
}
