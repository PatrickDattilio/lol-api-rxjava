package org.dc.riot.lol.rx;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Debug;
import org.dc.riot.lol.rx.service.ObservableFactory;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiExecutors;
import org.dc.riot.lol.rx.service.interfaces.ApiFactory;
import org.junit.Before;
import org.junit.Test;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class EndpointTests {
	
	private ApiKey apiKey = null;
	private ApiFactory factory = null;
	private Scheduler scheduler = null;
	private Debug debug = Debug.getInstance();
	
	@Before
	public void setup() {
		apiKey = ApiKey.loadApiKeys()[0];
		factory = ApiFactory.newDefaultFactory(apiKey);
		scheduler = Schedulers.from(RiotApiExecutors.newFixedThreadPool(apiKey.getRules()));
	}

	@Test
	public void testAll() throws IOException, InterruptedException {
		final Object lock = new Object();
		final Region region = Region.NORTH_AMERICA;
		final String[] names = { "HuskarDc","Nightblue3","TheOddOne","feed l0rd"};
		
		final RiotApi.Summoner summonerInterface = factory.newSummonerInterface(region, true);
		
		ObservableFactory.create(() -> {
			return summonerInterface.getByNames(names);
		})
		.subscribeOn(scheduler)
		.subscribe((Object o) -> {
			
		},
		(Throwable e) -> {
			e.printStackTrace();
			
			// release the main thread
			synchronized (lock) {
				lock.notify();
			}
		},
		() -> {
			synchronized (lock) {
				lock.notify();
			}
		});
		
		debug.println("Waiting for tests to conclude ...");
		synchronized (lock) {
			lock.wait();
		}
		debug.println("Tests complete");

		fail();
	}
}
