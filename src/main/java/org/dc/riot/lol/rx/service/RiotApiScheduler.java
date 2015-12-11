package org.dc.riot.lol.rx.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class RiotApiScheduler extends Scheduler {

	private Worker worker;

	public RiotApiScheduler(RiotApiRateRule[] rules) {
		this.worker = new RiotApiWorker(rules);
	}

	@Override
	public Worker createWorker() {
		return worker;
	}

	private static class RiotApiWorker extends Scheduler.Worker implements Subscription {

		private boolean isSubscribed = true;
		private RiotApiRateRule[] rules;

		private List<WorkerThread> workerThreads;
		private ArrayBlockingQueue<Runnable> taskPool;

		private static final int TIME_BUFFER_MIN = 1000;

		private long timeBuffer = 2000;		// 2 second time buffer
		
		private RiotApiScheduleTimeline timeline = new RiotApiScheduleTimeline();

		private final Object lock = new Object();

		private RiotApiWorker(RiotApiRateRule[] rules) {
			this.rules = rules;
			
			int poolSize = 10;
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

				this.rules = tempList.toArray(new RiotApiRateRule[tempList.size()]);
				poolSize = this.rules[rules.length - 1].getRequests();
			}

			System.out.println("poolSize: " + poolSize);
			workerThreads = new ArrayList<WorkerThread>(poolSize);
			taskPool = new ArrayBlockingQueue<>(5000);
			for (int i=0; i<poolSize; i++) {
				WorkerThread wt = new WorkerThread(taskPool);
				workerThreads.add(wt);
				wt.start();
			}
		}

		@Override
		public void unsubscribe() {
			synchronized (lock) {
				isSubscribed = false;

				taskPool.drainTo(new ArrayList<Runnable>());

				for (WorkerThread wt : workerThreads) {
					wt.doStop();
				}
				
				timeline.clear();
				workerThreads.clear();
			}
		}

		@Override
		public boolean isUnsubscribed() {
			synchronized (lock) {
				return !isSubscribed;
			}
		}

		@Override
		public Subscription schedule(Action0 action) {
			synchronized (lock) {
				if (isUnsubscribed()) {
					return Subscriptions.unsubscribed();
				}

				// TODO schedule according to RULES
				long timeNow = getTime();
				return schedule(action, computeDelay(timeNow), TimeUnit.MILLISECONDS);
			}
		}

		@Override
		public Subscription schedule(final Action0 action, final long delayTime, final TimeUnit unit) {
			synchronized (lock) {
				if (isUnsubscribed()) {
					return Subscriptions.unsubscribed();
				}

				try {
					taskPool.put(() -> {
						try {
							long timeNow = getTime();
							timeline.clean(rules[0], timeNow);
							long delay = unit.toMillis(delayTime);
							RiotApiTime time = new RiotApiTime(timeNow + delay);
							timeline.add(time);
							System.out.println(" delay: " + delay);
							Thread.sleep(delay);
							action.call();
							time.setTime(getTime());
							time.executed();
						} catch (Exception e) {
							// eat this
							e.printStackTrace();
						}
					});
				} catch (InterruptedException e) {
					// eat this
							e.printStackTrace();
				}


				return this;
			}
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

		protected long getTime() {
			return System.currentTimeMillis();
		}
	}

	private static class WorkerThread extends Thread {
		private boolean running = false;
		private BlockingQueue<Runnable> tasks;

		public WorkerThread(BlockingQueue<Runnable> tasks) {
			this.tasks = tasks;
		}

		@Override
		public void run() {
			while (running) {
				try {
					synchronized (tasks) {
					Runnable r = tasks.take();
					r.run();
					}
				} catch (InterruptedException e) {
					// just eat this
							e.printStackTrace();
				}
			}
		}

		@Override
		public void start() {
			running = true;
			super.start();
		}

		public void doStop() {
			running = false;
			System.out.println("doStop");
			super.interrupt();
		}
	}

}
