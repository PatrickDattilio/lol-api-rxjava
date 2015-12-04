package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

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
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RetrofitTests {
	
	private Scheduler scheduler;
	private ApiKey apiKey;
	
	@Before
	public void setup() {
		apiKey = ApiKey.getFirstDevelopmentKey();
		RiotApiRateRule[] rules = (apiKey.isDevelopmentKey()) ? RiotApiRateRule.getDevelopmentRates() : RiotApiRateRule.getProductionRates();
		scheduler = Schedulers.from(new RiotApiThreadPoolExecutor(rules, 10));
	}
	
	@Test
	public void testRetrofitInterfaceExtensions() throws IOException {
		RiotApiFactory factory = RiotApiFactory.getDefaultFactory();
		
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(apiKey, Region.NORTH_AMERICA);
		for (int i=0; i<10; i++) {
			Observable<Map<String, SummonerDto>> rawStream = summonerInterface.getByNames("HuskarDc","feed l0rd","Wildturtle","Nightblue3","TheOddOne");
			assertNotNull(rawStream);

			Observable<SummonerDto> summonerStream = rawStream.observeOn(scheduler).flatMap(new Func1<Map<String,SummonerDto>, Observable<SummonerDto>>() {
				@Override
				public Observable<SummonerDto> call(Map<String, SummonerDto> t) {
					return Observable.from(t.values());	// emits all SummonerDto objects in a loop
				}
			});
			summonerStream.subscribe(
				(SummonerDto dto) -> {
					System.out.println(dto.getId() + " : " + dto.getName());
				},
				(Throwable e) -> {
					if (e instanceof HttpException) {
						HttpException ex = (HttpException) e;
						System.out.println(" got code: " + ex.response().code());
					} else {
						e.printStackTrace();
					}
				},
				() -> {
					System.out.println("Done! " + Thread.currentThread());
				}
			);
		}
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
