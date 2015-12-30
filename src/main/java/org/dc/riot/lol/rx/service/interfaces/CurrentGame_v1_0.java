package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.CurrentGameInfo;
import org.dc.riot.lol.rx.model.PlatformId;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class CurrentGame_v1_0 extends RiotApiBase implements RiotApi.CurrentGame {
	
	private Interface inter;
	
	public CurrentGame_v1_0(ApiKey apiKey, Region region) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.build();

		inter = ra.create(Interface.class);
	}

	@Override
	public CurrentGameInfo getSpectatorInfo(long summonerId) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return inter.getSpectatorInfo(PlatformId.from(region), summonerId, apiKey);
		});
	}
	
	private interface Interface {
		
		@GET("/observer-mode/rest/consumer/getSpectatorGameInfo/{platformId}/{summonerId}")
		Call<CurrentGameInfo> getSpectatorInfo(@Path("platformId") PlatformId platformId, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);
	}

}
