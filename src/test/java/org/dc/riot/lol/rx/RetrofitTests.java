package org.dc.riot.lol.rx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.model.ChampionListDto;
import org.dc.riot.lol.rx.model.GameDto;
import org.dc.riot.lol.rx.model.PlayerDto;
import org.dc.riot.lol.rx.model.RecentGamesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Debug;
import org.dc.riot.lol.rx.service.ObservableFactory;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiExecutors;
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.interfaces.RiotApiFactory;
import org.junit.Before;
import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class RetrofitTests {
	
	private Scheduler scheduler;
	private ApiKey apiKey;
	private Region region;
	private Debug debug;
	private RiotApiFactory factory;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
	
	@Before
	public void setup() {
		apiKey = ApiKey.loadApiKeys()[0];
		factory = RiotApiFactory.newDefaultFactory(apiKey);
		region = Region.NORTH_AMERICA;
		debug = Debug.getInstance();
		scheduler = Schedulers.from(RiotApiExecutors.newFixedThreadPool(apiKey.getRules()));
	}
	
	private int testManualObservablesCount = 0;
	private boolean testManualObservablesFailed = false;
	@Test
	public void testManualObservables() throws InterruptedException {
		final int gets = 501;

		final CountDownLatch lock = new CountDownLatch(gets);
		final Object printLock = new Object();
		
		RiotApi.Champion champInterface = factory.newChampionInterface(region, true);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<gets; i++) {
			ObservableFactory.create(() -> {
				return champInterface.getChampions(true);
			})
			.subscribeOn(scheduler)
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
	public void testRetrofitChainedObservables() throws InterruptedException, IOException, HttpException {
		final int gets = 501;	// this test runs 2 API calls per loop, so this is 1002 calls total

		final CountDownLatch lock = new CountDownLatch(gets);
		final Object printLock = new Object();
		
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(region, true);
		RiotApi.RecentGames recentGameInterface = factory.newRecentGamesInterface(region, true);
		long startTime = System.currentTimeMillis();
		for (int i=0; i<gets; i++) {
			ObservableFactory.create(() -> {
				return summonerInterface.getByNames("HuskarDc");
			})
			.flatMap((Map<String,SummonerDto> t) -> {
				Collection<SummonerDto> summoners = t.values();
				SummonerDto[] array = new SummonerDto[summoners.size()];
				summoners.toArray(array);
				return Observable.from(array);
			})
			.flatMap((SummonerDto t) -> {
				try {
					return Observable.just(recentGameInterface.getRecentGames(t.getId()));
				} catch (IOException | HttpException e) {
					return Observable.empty();
				}
			})
			.subscribeOn(scheduler)
			.subscribe((RecentGamesDto t) -> {
				synchronized (printLock) {
					debug.println(++testManualObservablesCount + " " + Thread.currentThread().getName());
					for (GameDto d : t.getGames()) {
						debug.println(d.getGameId() + " - " + sdf.format(d.getCreateDate()));
						for (PlayerDto player : d.getFellowPlayers()) {
							debug.println("\t" + player.getSummonerId());
						}
					}
					
					debug.println(null);
				}
			},
			(Throwable e) -> {
				if (e instanceof HttpException) {
					HttpException he = (HttpException) e;
					debug.println("Error: " + he.getCode());
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
		assertTrue(elapsedTime < TimeUnit.MINUTES.toMillis(20) + TimeUnit.SECONDS.toMillis(6));
	}
}
