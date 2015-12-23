package org.dc.riot.lol.rx.service;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.service.RiotApiTokenBucket.Token;

/**
 * 
 * @author Dc
 * @deprecated
 */
public class RiotApiThreadPoolExecutor extends ThreadPoolExecutor {

    private RiotApiTokenBucket semaphore;
    
//    private ArrayBlockingQueue<Runnable> taskQueue;
//    private Thread managerThread = new Thread(() -> {
//    	try {
//    		while (running) { 
//    			Runnable r = taskQueue.take();
//    			RiotApiThreadPoolExecutor.super.execute(r);
//    		}
//    	} catch (InterruptedException e) {
//    		Thread.currentThread().interrupt();
//    	}
//    });

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
		semaphore = new RiotApiTokenBucket(rules);
//		taskQueue = new ArrayBlockingQueue<>(maximumPoolSize * 5, true);
//		running = true;
//		managerThread.start();
	}

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
		semaphore = new RiotApiTokenBucket(rules);
//		taskQueue = new ArrayBlockingQueue<>(maximumPoolSize * 5);
//		running = true;
//		managerThread.start();
	}

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
		semaphore = new RiotApiTokenBucket(rules);
//		taskQueue = new ArrayBlockingQueue<>(maximumPoolSize * 5);
//		running = true;
//		managerThread.start();
	}

	public RiotApiThreadPoolExecutor(RiotApiRateRule[] rules, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		semaphore = new RiotApiTokenBucket(rules);
//		taskQueue = new ArrayBlockingQueue<>(maximumPoolSize * 5);
//		running = true;
//		managerThread.start();
	}
	
	@Override
	public ThreadFactory getThreadFactory() {
		return new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				return new TicketedThread(r);
			}
		};
	}

	@Override
	public void execute(Runnable command) {
		super.execute(command);
//		try { taskQueue.put(command); } catch (InterruptedException e) { e.printStackTrace(); }
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		try {
			Token[] taskTickets = semaphore.take();
			((TicketedThread)Thread.currentThread()).setTickets(taskTickets);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// shouldn't happen
		}

		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);

		try {
			Token[] taskTickets = ((TicketedThread)Thread.currentThread()).getTickets();
			((TicketedThread)Thread.currentThread()).clearTickets();
			semaphore.put(taskTickets);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// shouldn't happen
		}
	}
	
	protected long getTime() {
		return System.currentTimeMillis();
	}

	public static Executor from(RiotApiRateRule[] rules) {
		int largestRequestCount = 0;
		int smallestRequestCount = Integer.MAX_VALUE;
		for (RiotApiRateRule r : rules) {
			if (r.getRequests() > largestRequestCount) {
				largestRequestCount = r.getRequests();
			}
			if (r.getRequests() < smallestRequestCount) {
				smallestRequestCount = r.getRequests();
			}
		}
		
		largestRequestCount++;
		smallestRequestCount++;
		
		return new RiotApiThreadPoolExecutor(rules, smallestRequestCount, largestRequestCount,
				1, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(largestRequestCount));
	}
	
	@Override
	public void shutdown() {
//		managerThread.interrupt();
		super.shutdown();
	}
	
	@Override
	public List<Runnable> shutdownNow() {
//		managerThread.interrupt();
		return super.shutdownNow();
	}

}
