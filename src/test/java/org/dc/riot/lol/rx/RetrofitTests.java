package org.dc.riot.lol.rx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiRateRule;
import org.dc.riot.lol.rx.service.RiotApiThreadPoolExecutor;
import org.dc.riot.lol.rx.service.interfaces.RiotApiFactory;
import org.junit.Before;
import org.junit.Test;

import retrofit.HttpException;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
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
	
	boolean testRetrofitInterfaceExtensionsFailed = false;
	private int processedSummoners = 0;
	@Test
	public void testRetrofitInterfaceExtensions() throws IOException, InterruptedException {
		String[] names = new String[] {"HuskarDc","feed l0rd","Wildturtle","Nightblue3","TheOddOne"};
		int gets = 521;

		RiotApiFactory factory = RiotApiFactory.getDefaultFactory();
		final CountDownLatch lock = new CountDownLatch(gets);
		
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(apiKey, Region.NORTH_AMERICA);
		Subscription s = null;
		for (int i=0; i<gets; i++) {
			Observable<Map<String, SummonerDto>> rawStream = summonerInterface.getByNames(names);
			assertNotNull(rawStream);

			s = rawStream.observeOn(scheduler)
			.flatMap(new Func1<Map<String,SummonerDto>, Observable<SummonerDto>>() {
				@Override
				public Observable<SummonerDto> call(Map<String, SummonerDto> t) {
					return Observable.from(t.values());	// emits all SummonerDto objects in a loop
				}
			})
			.subscribe(
				(SummonerDto dto) -> {
					processedSummoners++;
					System.out.println(dto.getName() + " count " + processedSummoners + " on " + Thread.currentThread().getName());
				},
				(Throwable e) -> {
					if (e instanceof HttpException) {
						lock.countDown();
						HttpException ex = (HttpException) e;
						System.out.println(" got code: " + ex.response().code());
					} else {
						e.printStackTrace();
					}

					testRetrofitInterfaceExtensionsFailed = true;
					for (int j=0; j<gets; j++) {
						lock.countDown();
					}
				},
				() -> {
					lock.countDown();
				}
			);
		}
		
		System.out.println("All streams posted");
		lock.await();
		s.unsubscribe();
		assertFalse(testRetrofitInterfaceExtensionsFailed);
	}
	
	@Test
	public void testObservableNoNet() {
		// retrofit will do this for us
		Observable<String> o = Observable.create(new OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> t) {
				try {
					for (int i=0; i<500; i++) {
						Thread.sleep(40);
						String s = UUID.randomUUID().toString();
						t.onNext(s);
					}

					t.onCompleted();

				} catch (InterruptedException e) {
					t.onError(e);
				}
			}
		});
		
		o.observeOn(scheduler)
			.subscribe((String s) -> System.out.println(s),
					(Throwable t) -> t.printStackTrace(),
					() -> System.out.println("done"));
	}

}
