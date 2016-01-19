package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.CurrentGameInfo;
import org.dc.riot.lol.rx.model.PlatformId;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * 
 * @author Dc
 * @since 1.0.0
 */
public class CurrentGame_v1_0 extends RiotApiBase implements RiotApi.CurrentGame {
	
	private Interface inter;
	
	public CurrentGame_v1_0(ApiKey apiKey, Region region) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(ApiFactory.getGson()))
				.client(client)
				.build();

		inter = ra.create(Interface.class);
	}
	
	@Override
	public float getVersion() {
		return 1.0f;
	}

	@Override
	public CurrentGameInfo getSpectatorInfo(long summonerId) throws IOException, HttpException {
		/*
		 * This is a weird looking call, so some explanation.
		 * For the Current Game API, if a player is not in game
		 * it returns a code 404 (makes sense). A 404 typically
		 * results in an HttpException being thrown, but that
		 * is not appropriate here. In this case the notInGame
		 * object will be returned.
		 */
		CurrentGameInfo notInGame = new CurrentGameInfo();
		notInGame.notInGame = true;
		return RetrofitCaller.processCall(() -> {
			return inter.getSpectatorInfo(PlatformId.from(region), summonerId, apiKey);
		}, notInGame, 404);
	}
	
	private interface Interface {
		
		@GET("/observer-mode/rest/consumer/getSpectatorGameInfo/{platformId}/{summonerId}")
		Call<CurrentGameInfo> getSpectatorInfo(@Path("platformId") PlatformId platformId, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);
	}

}
