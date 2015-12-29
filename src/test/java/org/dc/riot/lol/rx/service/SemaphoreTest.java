package org.dc.riot.lol.rx.service;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class SemaphoreTest {

	RateRule[] rules = RateRule.getDevelopmentRates();
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testSemaphore() throws InterruptedException {
		int trials = 1001;
		long startTime = System.currentTimeMillis();
		final CountDownLatch lock = new CountDownLatch(trials);
		for (int i=0; i<trials; i++) {
			final int taskNumber = i+1;
		}
		
		System.out.println("All threads posted");
		
		lock.await();
		long endTime = System.currentTimeMillis();
		
		long elapsed = endTime - startTime;
		long minimumElapsed = TimeUnit.MINUTES.toMillis(20);
		long maximumElapsed = minimumElapsed + TimeUnit.SECONDS.toMillis(5);
		assertTrue(elapsed > minimumElapsed);
		assertTrue(elapsed < maximumElapsed);
	}
	
	@Test
	public void testSemaphoreStartup() {
	}

}
