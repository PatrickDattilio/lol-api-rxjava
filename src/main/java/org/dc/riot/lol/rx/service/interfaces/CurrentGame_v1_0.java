package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.CurrentGameInfo;
import org.dc.riot.lol.rx.model.PlatformId;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiTicketBucket;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public class CurrentGame_v1_0 extends RiotApiBase implements RiotApi.CurrentGame {
	
	private Interface inter;
	
	public CurrentGame_v1_0(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();

		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<CurrentGameInfo> getSpectatorInfo(long summonerId) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<CurrentGameInfo>() {
			@Override
			public Call<CurrentGameInfo> call(RiotApiTicketBucket ticketHolder) {
				return inter.getSpectatorInfo(PlatformId.from(region), summonerId, apiKey);
			}
		},
		getTicketBucket());
	}
	
	private interface Interface {
		
		@GET("/observer-mode/rest/consumer/getSpectatorGameInfo/{platformId}/{summonerId}")
		Call<CurrentGameInfo> getSpectatorInfo(@Path("platformId") PlatformId platformId, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);
	}

}
