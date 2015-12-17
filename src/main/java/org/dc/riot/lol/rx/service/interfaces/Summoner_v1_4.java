package org.dc.riot.lol.rx.service.interfaces;

import java.util.Map;

import org.dc.riot.lol.rx.model.MasteryPagesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.RunePagesDto;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.CommaSeparatedArray;
import org.dc.riot.lol.rx.service.RiotApi;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

class Summoner_v1_4 implements RiotApi.Summoner {
	
	private Region region;
	private ApiKey apiKey;
	
	private Interface inter;
	
	Summoner_v1_4(ApiKey apiKey, Region region) {
		this.region = region;
		this.apiKey = apiKey;
		
		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<Map<String, SummonerDto>> getByNames(String... summonerNames) {
		return RetroRxCaller.makeObservable(() -> {
			String[] array = new String[summonerNames.length];
			for (int i=0; i<array.length; i++) {
				array[i] = RiotApi.encodeName(summonerNames[i]);
			}

			return inter.getByNames(region, new CommaSeparatedArray(array), apiKey);
		});
	}

	@Override
	public Observable<Map<String, SummonerDto>> getByIds(long... summonerIds) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getByIds(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	@Override
	public Observable<Map<String, MasteryPagesDto>> getMasteries(long... summonerIds) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getMasteries(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	@Override
	public Observable<Map<String, String>> getNames(long... summonerIds) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getNames(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	@Override
	public Observable<Map<String, RunePagesDto>> getRunes(long... summonerIds) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getRunes(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	/**
	 * This interface definition comes directly from the Riot API full reference
	 * docs.
	 * @author Dc
	 */
	private interface Interface {

		@GET("/api/lol/{region}/v1.4/summoner/by-name/{summonerNames}")
		Call<Map<String, SummonerDto>> getByNames(@Path("region") Region region, @Path("summonerNames") CommaSeparatedArray encodedSummonerNames, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}")
		Call<Map<String, SummonerDto>> getByIds(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/masteries")
		Call<Map<String, MasteryPagesDto>> getMasteries(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/name")
		Call<Map<String, String>> getNames(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/runes")
		Call<Map<String, RunePagesDto>> getRunes(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

	}
}
