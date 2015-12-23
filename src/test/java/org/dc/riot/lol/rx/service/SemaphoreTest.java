package org.dc.riot.lol.rx.service;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.service.RiotApiTokenBucket.Token;
import org.junit.Before;
import org.junit.Test;

public class SemaphoreTest {

	RiotApiRateRule[] rules = RiotApiRateRule.getDevelopmentRates();
	private Debug debug = Debug.getInstance();
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testSemaphore() throws InterruptedException {
		int trials = 1001;
		long startTime = System.currentTimeMillis();
		final CountDownLatch lock = new CountDownLatch(trials);
		RiotApiTokenBucket bucket = new RiotApiTokenBucket(rules);
		bucket.start();
		Executor exec = Executors.newFixedThreadPool(10);
		for (int i=0; i<trials; i++) {
			final int taskNumber = i+1;
			exec.execute(() -> {
				try {
					Token[] tokens = bucket.take();
					Thread.sleep(40);
					debug.println(taskNumber + " on " + Thread.currentThread().getName());
					bucket.put(tokens);
				} catch (Exception e) {
					e.printStackTrace();
				}
				lock.countDown();
			});
		}
		
		System.out.println("All threads posted");
		
		lock.await();
		bucket.stop();

		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		long minimumElapsed = TimeUnit.MINUTES.toMillis(20);
		long maximumElapsed = minimumElapsed + TimeUnit.SECONDS.toMillis(5);
		assertTrue(elapsed > minimumElapsed);
		assertTrue(elapsed < maximumElapsed);
	}

}
