package org.dc.riot.lol.rx.service;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class RiotApiThreadPoolExecutor extends ScheduledThreadPoolExecutor {

	public RiotApiThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler) {
		super(corePoolSize, handler);
	}

	public RiotApiThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
		super(corePoolSize, threadFactory, handler);
	}

	public RiotApiThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
		super(corePoolSize, threadFactory);
	}

	public RiotApiThreadPoolExecutor(int corePoolSize) {
		super(corePoolSize);
	}

	@Override
	public void execute(Runnable command) {
		// TODO call this.schedule(command, computeDelay(), TimeUnit.MILLISECONDS);
		super.execute(command);
	}
}
