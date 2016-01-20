package org.dc.riot.lol.rx.service;

import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.TestPrints;
import org.dc.riot.lol.rx.service.RateRule;
import org.dc.riot.lol.rx.service.RiotApiExecutors;
import org.dc.riot.lol.rx.service.TicketBucket;
import org.dc.riot.lol.rx.service.TicketBucket.Ticket;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Learning how to use {@link Observable}s
 * 
 * @author Dc
 * @deprecated
 */
public class ObservableTest {

	private TestPrints debug = TestPrints.getInstance();
	private RateRule[] rules;
	private Scheduler scheduler;
	private TicketBucket bucket;
	
	@Ignore
	@Test
	public void regionTest() {
		Region[] regions = Region.getExcluding(Region.PUBLIC_BETA_ENVIRONMENT);
		debug.println(regions.length);
		printRegions(regions);
		debug.println("");
		
		regions = Region.getExcluding(Region.PUBLIC_BETA_ENVIRONMENT, null);
		debug.println(regions.length);
		printRegions(regions);
		debug.println("");
		
		regions = Region.getExcluding(Region.PUBLIC_BETA_ENVIRONMENT, Region.PUBLIC_BETA_ENVIRONMENT);
		debug.println(regions.length);
		printRegions(regions);
		debug.println("");

		regions = Region.getExcluding(Region.PUBLIC_BETA_ENVIRONMENT, Region.PUBLIC_BETA_ENVIRONMENT, null);
		debug.println(regions.length);
		printRegions(regions);
		debug.println("");

		regions = Region.getExcluding(Region.PUBLIC_BETA_ENVIRONMENT, Region.PUBLIC_BETA_ENVIRONMENT, Region.BRAZIL, null);
		debug.println(regions.length);
		printRegions(regions);
		debug.println("");
	}
	
	private void printRegions(Region... regions) {
		for (Region r : regions) {
			debug.println(r);
		}
	}

	@Ignore
	@Before
	public void setup() {
		rules = RateRule.getDevelopmentRates();
		scheduler = Schedulers.from(RiotApiExecutors.newFixedThreadPool(rules));
		bucket = new TicketBucket(rules);
	}

	@Ignore
	@Test
	public void testObservableMultipleSingleEmitters() throws InterruptedException {
		final int trials = 501;
		final CountDownLatch lock = new CountDownLatch(trials);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<trials; i++) {
			final int observable = i+1;
			debug.println("Executing " + observable);
			Observable.create((Subscriber<? super UUID> t) -> {
				try {
					Ticket[] tickets = bucket.take();
					Thread.sleep(50);
					bucket.put(tickets);
					UUID ru = UUID.randomUUID();
					t.onNext(ru);
					t.onCompleted();
				} catch (Exception e) {
					t.onError(e);
				}
			})
			.subscribeOn(scheduler)
			.subscribe((UUID t) -> {
				debug.println(t);
				lock.countDown();
			},
			(Throwable t) -> t.printStackTrace(),
			() -> debug.println("DONE " + observable));
		}

		lock.await();
		debug.println("Done");

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		assertTrue(elapsedTime > TimeUnit.MINUTES.toMillis(10));
		assertTrue(elapsedTime < TimeUnit.MINUTES.toMillis(10) + TimeUnit.SECONDS.toMillis(2));
	}

	@Ignore
	@Test
	public void testObservableMultiEmitter() throws InterruptedException {
		final int trials = 501;
		final CountDownLatch lock = new CountDownLatch(trials);
		Observable.create((Subscriber<? super String> t) -> {
			try {
				for (int i=0; i<trials; i++) {
					Thread.sleep(40);
					String s = UUID.randomUUID().toString();
					t.onNext(s);
				}

				t.onCompleted();

			} catch (InterruptedException e) {
				t.onError(e);
			}
		})
		.map((String t) -> {
			System.out.println(t + "   " + Thread.currentThread());
			return UUID.fromString(t).getLeastSignificantBits();
		})
		.subscribe((Long s) -> {
			lock.countDown();
			System.out.println(s + "   " + Thread.currentThread());
		},
				(Throwable t) -> t.printStackTrace(),
				() -> System.out.println("Done"));

		lock.await();
	}

}
