package org.dc.riot.lol.rx.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

import org.junit.Before;
import org.junit.Test;

public class SemaphoreTest {

	RiotApiRateRule[] rules = RiotApiRateRule.getDevelopmentRates();
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testSemaphore() throws InterruptedException {
		int trials = 1001;
		final CountDownLatch lock = new CountDownLatch(trials);
		Executor exec = RiotApiThreadPoolExecutor.from(rules);
		for (int i=0; i<trials; i++) {
			final int taskNumber = i+1;
			exec.execute(() -> {
				try {
					Thread.sleep(40);
					Date date = new Date(System.currentTimeMillis());
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.sss");
					System.out.println(sdf.format(date) + " " + taskNumber);
				} catch (Exception e) {
					e.printStackTrace();
				}
				lock.countDown();
			});
		}
		
		System.out.println("All threads posted");
		
		lock.await();
	}
	
	@Test
	public void testSemaphoreStartup() {
		Executor exec = RiotApiThreadPoolExecutor.from(rules);
		exec.execute(() -> System.out.println("Hello, semaphore"));
	}

}
