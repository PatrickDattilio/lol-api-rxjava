package org.dc.riot.lol.rx.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.dc.riot.lol.rx.service.TicketBucket.Ticket;

public class TicketedFuture<T> extends FutureTask<T> {
	
	private TicketBucket bucket;

	public TicketedFuture(TicketBucket bucket, Callable<T> callable) {
		super(callable);
		this.bucket = bucket;
	}

	public TicketedFuture(TicketBucket bucket, Runnable runnable, T result) {
		super(runnable, result);
		this.bucket = bucket;
	}

	@Override
	public T get() throws InterruptedException, ExecutionException {
		Ticket[] tickets = null;
		try {
			if (bucket != null) {
				tickets = bucket.take();
			}

			return super.get();
		} finally {
			if (tickets != null) {
				bucket.put(tickets);
			}
		}
	}

	@Override
	public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		Ticket[] tickets = null;
		try {
			if (bucket != null) {
				tickets = bucket.take();
			}

			return super.get(timeout, unit);
		} finally {
			if (tickets != null) {
				bucket.put(tickets);
			}
		}
	}
}
