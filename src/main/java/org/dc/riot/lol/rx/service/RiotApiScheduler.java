package org.dc.riot.lol.rx.service;

import java.util.ArrayList;
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
		
		private final Object lock = new Object();

		private RiotApiWorker(RiotApiRateRule[] rules) {
			this.rules = rules;
			// TODO dynamic these numbers
			int poolSize = 10;
			
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
				return schedule(action, 0, TimeUnit.SECONDS);
			}
		}

		@Override
		public Subscription schedule(final Action0 action, long delayTime, TimeUnit unit) {
			synchronized (lock) {
				if (isUnsubscribed()) {
					return Subscriptions.unsubscribed();
				}

				try {
					taskPool.put(() -> {
						try {
							long delay = unit.toMillis(delayTime);
							System.out.println(" delay: " + delay);
							Thread.sleep(delay);
							action.call();
						} catch (Exception e) {
							// eat this
							e.printStackTrace();
						}
					});
				} catch (InterruptedException e) {
					// eat this
				}


				return this;
			}
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
					Runnable r = tasks.take();
					r.run();
				} catch (InterruptedException e) {
					// just eat this
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
			super.interrupt();
		}
	}
	
}
