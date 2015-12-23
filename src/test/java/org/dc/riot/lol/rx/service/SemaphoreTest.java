package org.dc.riot.lol.rx.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.service.RiotApiTicketBucket.Ticket;
import org.junit.Before;
import org.junit.Test;

public class SemaphoreTest {

	private Debug debug;
	RiotApiRateRule[] rules = RiotApiRateRule.getDevelopmentRates();
	
	@Before
	public void setup() {
		debug = Debug.getInstance();
		debug.setDebug(true);
	}
	
	private boolean testSemaphoreFailed = false;
	@Test
	public void testSemaphore() throws InterruptedException {
		int trials = 1001;
		long startTime = System.currentTimeMillis();
		final CountDownLatch lock = new CountDownLatch(trials);
		Executor exec = Executors.newCachedThreadPool();
		RiotApiTicketBucket bucket = new RiotApiTicketBucket(rules);
		for (int i=0; i<trials; i++) {
			final int taskNumber = i+1;
			exec.execute(() -> {
				try {
					Ticket[] tickets = bucket.take();
					Thread.sleep(40);
					debug.println(taskNumber);
					bucket.put(tickets);
				} catch (Exception e) {
					e.printStackTrace();
					testSemaphoreFailed = true;
					
					for (int j=taskNumber-1; j<trials; j++) {
						lock.countDown();
					}
				}
				lock.countDown();
			});
		}
		
		System.out.println("All threads posted");
		
		lock.await();
		long endTime = System.currentTimeMillis();
		
		long elapsed = endTime - startTime;
		long minimumElapsed = TimeUnit.MINUTES.toMillis(20);
		assertFalse(testSemaphoreFailed);
		long maximumElapsed = minimumElapsed + TimeUnit.SECONDS.toMillis(5);
		assertTrue(elapsed > minimumElapsed);
		assertTrue(elapsed < maximumElapsed);
	}

}
