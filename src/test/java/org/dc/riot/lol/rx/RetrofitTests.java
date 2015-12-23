package org.dc.riot.lol.rx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.model.ChampionListDto;
import org.dc.riot.lol.rx.model.GameDto;
import org.dc.riot.lol.rx.model.RecentGamesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Debug;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiRateRule;
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.interfaces.RiotApiFactory;
import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

public class RetrofitTests {
	
	private Scheduler scheduler;
	private ApiKey apiKey;
	private RiotApiRateRule[] rules;
	private Region region;
	private Debug debug;
	
	@Before
	public void setup() {
		apiKey = ApiKey.getApiKeys()[0];
		rules = apiKey.getRateRules();
		region = Region.NORTH_AMERICA;
		debug = Debug.getInstance();
		debug.setDebug(true);
	}
	
	private int testManualObservablesCount = 0;
	private boolean testManualObservablesFailed = false;
	@Test
	public void testManualObservables() throws InterruptedException {
		final int gets = 501;

		RiotApiFactory factory = RiotApiFactory.getDefaultFactory();
		final CountDownLatch lock = new CountDownLatch(gets);
		final Object printLock = new Object();
		
		RiotApi.Champion champInterface = factory.newChampionInterface(apiKey, region);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<gets; i++) {
			Observable<ChampionListDto> obs = champInterface.getChampions(false);
			obs.subscribeOn(scheduler)
			.subscribe((ChampionListDto dto) -> {
				synchronized (printLock) {
					debug.println(++testManualObservablesCount);
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
	public void testRetrofitChainedObservables() throws InterruptedException {
		final int gets = 11;

		RiotApiFactory factory = RiotApiFactory.getDefaultFactory();
		final CountDownLatch lock = new CountDownLatch(gets);
		final Object printLock = new Object();
		
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(apiKey, region);
		RiotApi.RecentGames recentGameInterface = factory.newRecentGamesInterface(apiKey, region);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<gets; i++) {
			Observable<Map<String,SummonerDto>> obs = summonerInterface.getByNames("HuskarDc");
			obs.flatMap((Map<String,SummonerDto> t) -> {
				Collection<SummonerDto> summoners = t.values();
				SummonerDto[] array = new SummonerDto[summoners.size()];
				summoners.toArray(array);
				return Observable.from(array);
			})
			.map((SummonerDto d) -> {
				long id = d.getId();
				return recentGameInterface.getRecentGames(id);
			})
			.flatMap((Observable<RecentGamesDto> o) -> {
				return o;
			})
			.subscribeOn(scheduler)
			.subscribe((RecentGamesDto t) -> {
				synchronized (printLock) {
					debug.println(++testManualObservablesCount + " " + Thread.currentThread().getName());
					for (GameDto d : t.getGames()) {
						debug.println("\t" + d.getFellowPlayers().size());
					}
				}
			},
			(Throwable e) -> {
				if (e instanceof HttpException) {
					HttpException he = (HttpException) e;
					debug.println("Error: " + he.getCode());
				} else {
					e.printStackTrace();
				}
				
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
		assertTrue(elapsedTime > TimeUnit.MINUTES.toMillis(20));
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
			debug.println("Observable count: " + i);
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
					debug.println(dto.getId() + " : " + dto.getName());
				},
				(Throwable e) -> {
					e.printStackTrace();
				},
				() -> {
					debug.println("Done");
					lock.countDown();
				}
			);
		}
		
		debug.println("All streams posted");
		lock.await();
		debug.println("Main thread complete");
	}
	
}
