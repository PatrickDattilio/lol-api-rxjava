package org.dc.riot.lol.rx.service;

import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.service.Debug;
import org.dc.riot.lol.rx.service.RiotApiRateRule;
import org.dc.riot.lol.rx.service.RiotApiTicketBucket;
import org.dc.riot.lol.rx.service.RiotApiTicketBucket.Ticket;
import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class ObservableTest {

	private RiotApiRateRule[] rules;
	private Scheduler scheduler;
	private Debug debug;
	private RiotApiTicketBucket bucket;

	@Before
	public void setup() {
		rules = RiotApiRateRule.getDevelopmentRates();
		scheduler = Schedulers.from(Executors.newCachedThreadPool());
		debug = Debug.getInstance();
		bucket = new RiotApiTicketBucket(rules);
	}

	@Test
	public void testObservableMultipleSingleEmitters() throws InterruptedException {
		final int trials = 501;
		final CountDownLatch lock = new CountDownLatch(trials);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<trials; i++) {
			final int observable = i+1;
			Observable.create((Subscriber<? super String> t) -> {
//				new Thread(() -> {
					try {
						Ticket[] tickets = bucket.take();
						debug.println("SUB " + observable + " -> " + Thread.currentThread());
						bucket.put(tickets);
						Thread.sleep(40);
						String s = UUID.randomUUID().toString();
						t.onNext(s);
						t.onCompleted();

					} catch (InterruptedException e) {
						t.onError(e);
					}
//				}).start();
			})
			.map((String t) -> {
				System.out.println("MAP " + observable + " -> " + Thread.currentThread());
				return UUID.fromString(t);
			})
			.subscribeOn(scheduler)
			.subscribe((UUID s) -> {
				lock.countDown();
				System.out.println("DONE " + observable + " -> " + Thread.currentThread());
			},
			(Throwable t) -> t.printStackTrace(),
			() -> {});
		}

		lock.await();
		System.out.println("Done");

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		assertTrue(elapsedTime > TimeUnit.MINUTES.toMillis(10));
		assertTrue(elapsedTime < TimeUnit.MINUTES.toMillis(10) + TimeUnit.SECONDS.toMillis(2));
	}

	@Test
	public void testObservableMultiEmitter() throws InterruptedException {
		final int trials = 501;
		final CountDownLatch lock = new CountDownLatch(trials);
		// retrofit will do this for us
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
		.subscribeOn(scheduler)
		.subscribe((Long s) -> {
			lock.countDown();
			System.out.println(s + "   " + Thread.currentThread());
		},
		(Throwable t) -> t.printStackTrace(),
		() -> System.out.println("Done"));

		lock.await();
	}

}
