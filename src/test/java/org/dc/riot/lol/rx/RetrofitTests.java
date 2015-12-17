package org.dc.riot.lol.rx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.model.ChampionListDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiRateRule;
import org.dc.riot.lol.rx.service.RiotApiThreadPoolExecutor;
import org.dc.riot.lol.rx.service.interfaces.RiotApiFactory;
import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RetrofitTests {
	
	private Scheduler scheduler;
	private ApiKey apiKey;
	private RiotApiRateRule[] rules;
	
	@Before
	public void setup() {
		apiKey = ApiKey.getFirstDevelopmentKey();
		rules = (apiKey.isDevelopmentKey()) ? RiotApiRateRule.getDevelopmentRates() : RiotApiRateRule.getProductionRates();
		scheduler = Schedulers.from(RiotApiThreadPoolExecutor.from(rules));
	}
	
	private int testManualObservablesCount = 0;
	private boolean testManualObservablesFailed = true;
	@Test
	public void testManualObservables() throws InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.sss");
		final int gets = 501;

		RiotApiFactory factory = RiotApiFactory.getDefaultFactory();
		final CountDownLatch lock = new CountDownLatch(gets);
		final Object printLock = new Object();
		
		RiotApi.Champion champInterface = factory.newChampionInterface(apiKey, Region.NORTH_AMERICA);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<gets; i++) {
			Observable<ChampionListDto> obs = champInterface.getChampions();
			obs.subscribeOn(scheduler)
			.subscribe((ChampionListDto dto) -> {
				synchronized (printLock) {
					System.out.println(sdf.format(new Date(System.currentTimeMillis())) + "  " + ++testManualObservablesCount);
				}
			},
			(Throwable e) -> {
				e.printStackTrace();
				
				testManualObservablesFailed = true;
				for (int j=0; j<gets; j++) {
					lock.countDown();
				}
			},
			() -> {
				lock.countDown();
			});
		}
		
		lock.await();
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		assertFalse(testManualObservablesFailed);
		assertTrue(elapsedTime > TimeUnit.MINUTES.toMillis(10));
		assertTrue(elapsedTime < TimeUnit.MINUTES.toMillis(10) + TimeUnit.SECONDS.toMillis(5));
	}

	@Test
	public void testRetrofitInterfaceExtensions() throws IOException, InterruptedException {
		String[] names = new String[] {"HuskarDc","feed l0rd","Wildturtle","Nightblue3","TheOddOne"};
		int gets = 11;

		RiotApiFactory factory = RiotApiFactory.getDefaultFactory();
		final CountDownLatch lock = new CountDownLatch(gets);
		
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(apiKey, Region.NORTH_AMERICA);
		for (int i=0; i<gets; i++) {
			System.out.println("Observable count: " + i);
			Observable<Map<String, SummonerDto>> rawStream = summonerInterface.getByNames(names);
			assertNotNull(rawStream);

			rawStream
			.subscribeOn(scheduler)
			.flatMap(new Func1<Map<String,SummonerDto>, Observable<SummonerDto>>() {
				@Override
				public Observable<SummonerDto> call(Map<String, SummonerDto> t) {
					return Observable.from(t.values());	// emits all SummonerDto objects in a loop
				}
			})
			.subscribe(
				(SummonerDto dto) -> {
					System.out.println(dto.getId() + " : " + dto.getName());
				},
				(Throwable e) -> {
					e.printStackTrace();
				},
				() -> {
					System.out.println("Done");
					lock.countDown();
				}
			);
		}
		
		System.out.println("All streams posted");
		lock.await();
		System.out.println("Main thread complete");
	}
	
}
