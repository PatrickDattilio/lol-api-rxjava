package org.dc.riot.lol.rx.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.TestPrints;
import org.dc.riot.lol.rx.service.TicketBucket.Ticket;
import org.junit.Ignore;
import org.junit.Test;

public class SemaphoreTest {

	private RateRule[] rules = RateRule.getDevelopmentRates();
	private Executor executor = Executors.newFixedThreadPool(10);
	
	private boolean testSemaphoreFailed = false;
	
	@Ignore
	@Test
	public void testSemaphore() throws InterruptedException {
		int trials = 1001;
		long startTime = System.currentTimeMillis();
		TicketBucket tb = new TicketBucket(rules);
		final CountDownLatch lock = new CountDownLatch(trials);
		for (int i=0; i<trials; i++) {
			if (i > 0 && i%10 == 0) {
				Thread.sleep(1000);
				tb.stall(2, TimeUnit.SECONDS);
			}

			final int taskNumber = i+1;
			executor.execute(() -> {
				try {
					Ticket[] tickets = tb.take();
					Thread.sleep(50);
					TestPrints.getInstance().println("Task " + taskNumber);
					tb.put(tickets);
					
				} catch (Exception e) {
					e.printStackTrace();
					testSemaphoreFailed = false;
					for (int j=0; j<trials; j++) {
						lock.countDown();
					}
				} finally {
					lock.countDown();
				}
			});
		}
		
		System.out.println("All threads posted");
		
		lock.await();
		assertFalse(testSemaphoreFailed);
		long endTime = System.currentTimeMillis();
		
		long elapsed = endTime - startTime;
		long minimumElapsed = TimeUnit.MINUTES.toMillis(20);
		long maximumElapsed = minimumElapsed + TimeUnit.SECONDS.toMillis(60);
		assertTrue(elapsed > minimumElapsed);
		assertTrue(elapsed < maximumElapsed);
	}

}
