package org.dc.riot.lol.rx.service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;

public class RiotApiScheduler extends Scheduler {

	@Override
	public Worker createWorker() {
		return new RiotApiWorker();
	}
	
	private static class RiotApiWorker extends Worker {

		@Override
		public void unsubscribe() {
			
		}

		@Override
		public boolean isUnsubscribed() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Subscription schedule(Action0 action) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private static class RiotApiExecutor extends ScheduledThreadPoolExecutor {

		public RiotApiExecutor(int corePoolSize, RejectedExecutionHandler handler) {
			super(corePoolSize, handler);
		}

		public RiotApiExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
			super(corePoolSize, threadFactory, handler);
		}

		public RiotApiExecutor(int corePoolSize, ThreadFactory threadFactory) {
			super(corePoolSize, threadFactory);
		}

		public RiotApiExecutor(int corePoolSize) {
			super(corePoolSize);
		}

		@Override
		protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
			// TODO Auto-generated method stub
			return super.decorateTask(runnable, task);
		}

		@Override
		protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
			// TODO Auto-generated method stub
			return super.decorateTask(callable, task);
		}

		@Override
		public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
			// TODO Auto-generated method stub
			return super.schedule(command, delay, unit);
		}

		@Override
		public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
			// TODO Auto-generated method stub
			return super.schedule(callable, delay, unit);
		}

		@Override
		public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
			// TODO Auto-generated method stub
			return super.scheduleAtFixedRate(command, initialDelay, period, unit);
		}

		@Override
		public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,
				TimeUnit unit) {
			// TODO Auto-generated method stub
			return super.scheduleWithFixedDelay(command, initialDelay, delay, unit);
		}

		@Override
		public void execute(Runnable command) {
			// TODO Auto-generated method stub
			super.execute(command);
		}

		@Override
		public Future<?> submit(Runnable task) {
			// TODO Auto-generated method stub
			return super.submit(task);
		}

		@Override
		public <T> Future<T> submit(Runnable task, T result) {
			// TODO Auto-generated method stub
			return super.submit(task, result);
		}

		@Override
		public <T> Future<T> submit(Callable<T> task) {
			// TODO Auto-generated method stub
			return super.submit(task);
		}

		@Override
		public void setContinueExistingPeriodicTasksAfterShutdownPolicy(boolean value) {
			// TODO Auto-generated method stub
			super.setContinueExistingPeriodicTasksAfterShutdownPolicy(value);
		}

		@Override
		public boolean getContinueExistingPeriodicTasksAfterShutdownPolicy() {
			// TODO Auto-generated method stub
			return super.getContinueExistingPeriodicTasksAfterShutdownPolicy();
		}

		@Override
		public void setExecuteExistingDelayedTasksAfterShutdownPolicy(boolean value) {
			// TODO Auto-generated method stub
			super.setExecuteExistingDelayedTasksAfterShutdownPolicy(value);
		}

		@Override
		public boolean getExecuteExistingDelayedTasksAfterShutdownPolicy() {
			// TODO Auto-generated method stub
			return super.getExecuteExistingDelayedTasksAfterShutdownPolicy();
		}

		@Override
		public void setRemoveOnCancelPolicy(boolean value) {
			// TODO Auto-generated method stub
			super.setRemoveOnCancelPolicy(value);
		}

		@Override
		public boolean getRemoveOnCancelPolicy() {
			// TODO Auto-generated method stub
			return super.getRemoveOnCancelPolicy();
		}

		@Override
		public void shutdown() {
			// TODO Auto-generated method stub
			super.shutdown();
		}

		@Override
		public List<Runnable> shutdownNow() {
			// TODO Auto-generated method stub
			return super.shutdownNow();
		}

		@Override
		public BlockingQueue<Runnable> getQueue() {
			// TODO Auto-generated method stub
			return super.getQueue();
		}
		
		
	}

}
