package org.dc.riot.lol.rx.service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RiotApiThreadPoolExecutor extends ThreadPoolExecutor {

	public RiotApiThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	}

	public RiotApiThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
	}

	public RiotApiThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
	}

	public RiotApiThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		System.out.println("execute");
		super.execute(command);
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		System.out.println("shutdown");
		super.shutdown();
	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		System.out.println("shutdownNow");
		return super.shutdownNow();
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		System.out.println("isShutdown");
		return super.isShutdown();
	}

	@Override
	public boolean isTerminating() {
		// TODO Auto-generated method stub
		System.out.println("isTerminating");
		return super.isTerminating();
	}

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		System.out.println("isTerminated");
		return super.isTerminated();
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("awaitTermination(long,TimeUnit)");
		return super.awaitTermination(timeout, unit);
	}

	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		System.out.println("finalize");
		super.finalize();
	}

	@Override
	public void setThreadFactory(ThreadFactory threadFactory) {
		// TODO Auto-generated method stub
		System.out.println("setThreadFactory");
		super.setThreadFactory(threadFactory);
	}

	@Override
	public ThreadFactory getThreadFactory() {
		// TODO Auto-generated method stub
		System.out.println("getThreadFactory");
		return super.getThreadFactory();
	}

	@Override
	public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
		// TODO Auto-generated method stub
		System.out.println("setRejectedExec");
		super.setRejectedExecutionHandler(handler);
	}

	@Override
	public RejectedExecutionHandler getRejectedExecutionHandler() {
		// TODO Auto-generated method stub
		System.out.println("getRejectedExex");
		return super.getRejectedExecutionHandler();
	}

	@Override
	public void setCorePoolSize(int corePoolSize) {
		// TODO Auto-generated method stub
		System.out.println("setCorePoolSize");
		super.setCorePoolSize(corePoolSize);
	}

	@Override
	public int getCorePoolSize() {
		// TODO Auto-generated method stub
		System.out.println("getCorePoolSize");
		return super.getCorePoolSize();
	}

	@Override
	public boolean prestartCoreThread() {
		// TODO Auto-generated method stub
		System.out.println("prestartCoreThread");
		return super.prestartCoreThread();
	}

	@Override
	public int prestartAllCoreThreads() {
		// TODO Auto-generated method stub
		System.out.println("prestartAllCoreThreads");
		return super.prestartAllCoreThreads();
	}

	@Override
	public boolean allowsCoreThreadTimeOut() {
		// TODO Auto-generated method stub
		System.out.println("allowsCoreThreadTimeout");
		return super.allowsCoreThreadTimeOut();
	}

	@Override
	public void allowCoreThreadTimeOut(boolean value) {
		// TODO Auto-generated method stub
		super.allowCoreThreadTimeOut(value);
	}

	@Override
	public void setMaximumPoolSize(int maximumPoolSize) {
		// TODO Auto-generated method stub
		super.setMaximumPoolSize(maximumPoolSize);
	}

	@Override
	public int getMaximumPoolSize() {
		// TODO Auto-generated method stub
		System.out.println("getMaxPoolsize");
		return super.getMaximumPoolSize();
	}

	@Override
	public void setKeepAliveTime(long time, TimeUnit unit) {
		// TODO Auto-generated method stub
		super.setKeepAliveTime(time, unit);
	}

	@Override
	public long getKeepAliveTime(TimeUnit unit) {
		// TODO Auto-generated method stub
		System.out.println("getKeepAliveTime");
		return super.getKeepAliveTime(unit);
	}

	@Override
	public BlockingQueue<Runnable> getQueue() {
		// TODO Auto-generated method stub
		System.out.println("getQueueu");
		return super.getQueue();
	}

	@Override
	public boolean remove(Runnable task) {
		// TODO Auto-generated method stub
		System.out.println("remove");
		return super.remove(task);
	}

	@Override
	public void purge() {
		System.out.println("purge");
		// TODO Auto-generated method stub
		super.purge();
	}

	@Override
	public int getPoolSize() {
		System.out.println("getPoolSize");
		// TODO Auto-generated method stub
		return super.getPoolSize();
	}

	@Override
	public int getActiveCount() {
		System.out.println("getActiveCount");
		// TODO Auto-generated method stub
		return super.getActiveCount();
	}

	@Override
	public int getLargestPoolSize() {
		System.out.println("getLargestPoolSize");
		// TODO Auto-generated method stub
		return super.getLargestPoolSize();
	}

	@Override
	public long getTaskCount() {
		System.out.println("getTaskCount");
		// TODO Auto-generated method stub
		return super.getTaskCount();
	}

	@Override
	public long getCompletedTaskCount() {
		System.out.println("getCompletedTaskCount");
		// TODO Auto-generated method stub
		return super.getCompletedTaskCount();
	}

	@Override
	public String toString() {
		System.out.println("toString");
		return super.toString();
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		System.out.println("beforeExecute");
		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		System.out.println("afterExecute");
		super.afterExecute(r, t);
	}

	@Override
	protected void terminated() {
		System.out.println("terminated");
		super.terminated();
	}

}
