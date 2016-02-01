package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.championmastery.ChampionMasteryDto;
import org.dc.riot.lol.rx.model.common.PlatformId;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi.ChampionMastery;
import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

class ChampionMastery_v1_0 extends RiotApiBase implements ChampionMastery {
	
	private Interface inter;

	ChampionMastery_v1_0(ApiKey apiKey, Region region) {
		super(apiKey, region);
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://" + new LowercaseRegion(region) + ".api.pvp.net")
				.client(client)
				.addConverterFactory(GsonConverterFactory.create(ApiFactory.getGson()))
				.build();
		
		inter = retrofit.create(Interface.class);
	}

	@Override
	public float getVersion() {
		return 1.0f;
	}

	@Override
	public ChampionMasteryDto getPlayerChampionMastery(long summonerId, long championId) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getPlayerChampionMastery(PlatformId.from(region), summonerId, championId, apiKey);
		});
	}

	@Override
	public ChampionMasteryDto[] getPlayerAllMastery(long summonerId) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getPlayerAllMastery(PlatformId.from(region), summonerId, apiKey);
		});
	}

	@Override
	public int getMasteryScore(long summonerId) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getMasteryScore(PlatformId.from(region), summonerId, apiKey);
		});
	}

	@Override
	public ChampionMasteryDto[] getTopChampions(long summonerId, int count) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getTopChampions(PlatformId.from(region), summonerId, apiKey);
		});
	}
	
	private interface Interface {
		
		@GET("/championmastery/location/{platformId}/player/{summonerId}/champion/{championId}")
		Call<ChampionMasteryDto> getPlayerChampionMastery(@Path("platformId") PlatformId platformId, @Path("summonerId") long summonerId, @Path("championId") long championId, @Query("api_key") ApiKey apiKey);

		@GET("/championmastery/location/{platformId}/player/{summonerId}/champions")
		Call<ChampionMasteryDto[]> getPlayerAllMastery(@Path("platformId") PlatformId platformId, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);
		
		@GET("/championmastery/location/{platformId}/player/{summonerId}/score")
		Call<Integer> getMasteryScore(@Path("platformId") PlatformId platformId, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);
		
		@GET("/championmastery/location/{platformId}/player/{summonerId}/topchampions")
		Call<ChampionMasteryDto[]> getTopChampions(@Path("platformId") PlatformId platformId, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);
		
	}

}
