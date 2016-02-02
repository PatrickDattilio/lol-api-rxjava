package org.dc.riot.lol.rx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.dc.riot.lol.rx.model.champion.ChampionListDto;
import org.dc.riot.lol.rx.model.game.GameDto;
import org.dc.riot.lol.rx.model.game.PlayerDto;
import org.dc.riot.lol.rx.model.game.RecentGamesDto;
import org.dc.riot.lol.rx.model.summoner.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.ObservableFactory;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiExecutors;
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.interfaces.ApiFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Some basic HTTP tests that are consolidated into {@link IntegrationTests}
 * 
 * @author Dc
 * @deprecated
 */
public class RetrofitTests {
	
	private Scheduler scheduler;
	private ApiKey apiKey;
	private Region region;
	private TestPrints debug;
	private ApiFactory factory;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
	
	@Ignore
	@Before
	public void setup() throws FileNotFoundException {
		apiKey = ApiKey.loadApiKeys()[0];
		factory = ApiFactory.newDefaultFactory(apiKey);
		region = Region.NORTH_AMERICA;
		debug = TestPrints.getInstance();
		scheduler = Schedulers.from(RiotApiExecutors.newFixedThreadPool(apiKey.getRules()));
	}
	
	private int testManualObservablesCount = 0;
	private boolean testManualObservablesFailed = false;
	@Ignore
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
	
	@Ignore
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
	
	@Ignore
	@Test
	public void testRetries() throws IOException {
		int gets = 100;
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(region, false);
		for (int i=0; i<gets; i++) {
			try {
				Map<String, SummonerDto> dto = summonerInterface.getByNames("HuskarDc","TheOddOne");
				for (SummonerDto s : dto.values()) {
					TestPrints.getInstance().println(s.getId() + " - " + s.getName());
				}
			} catch (HttpException e) {
				TestPrints.getInstance().println(e.getCode());
			}
		}
	}
}
