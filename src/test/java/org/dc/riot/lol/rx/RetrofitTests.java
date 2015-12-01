package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.impl.RiotApiFactory;
import org.junit.Test;

import retrofit.HttpException;
import rx.Observable;
import rx.functions.Func1;

public class RetrofitTests {
	
	@Test
	public void testRetrofitInterfaceExtensions() throws IOException {
		ApiKey apiKey = ApiKey.getApiKeys()[0];
		RiotApiFactory factory = RiotApiFactory.getDefaultFactory();
		
		RiotApi.Summoner summonerInterface = factory.newSummonerInterface(apiKey, Region.NORTH_AMERICA);
		for (int i=0; i<11; i++) {
			Observable<Map<String, SummonerDto>> rawStream = summonerInterface.getByNames("HuskarDc","feed l0rd","Wildturtle","Nightblue3","TheOddOne");
			assertNotNull(rawStream);

			Observable<SummonerDto> summonerStream = rawStream.flatMap(new Func1<Map<String,SummonerDto>, Observable<SummonerDto>>() {
				@Override
				public Observable<SummonerDto> call(Map<String, SummonerDto> t) {
					return Observable.from(t.values());	// emits all SummonerDto objects in a loop
				}
			});
			assertNotNull(summonerStream);
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
					System.out.println("Done!");
				}
			);
		}
	}

}
