package org.dc.riot.lol.rx.service.impl;

import java.util.Map;

import org.dc.riot.lol.rx.model.MasteryPagesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.RunePagesDto;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.CommaSeparatedArray;
import org.dc.riot.lol.rx.service.RiotApi;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
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
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<Map<String, SummonerDto>> getByNames(String... summonerNames) {
		String[] array = new String[summonerNames.length];
		for (int i=0; i<summonerNames.length; i++) {
			array[i] = summonerNames[i].toLowerCase().replace(" ", "").trim();
		}
		return inter.getByNames(region, new CommaSeparatedArray(array), apiKey);
	}

	@Override
	public Observable<Map<String, SummonerDto>> getByIds(long... summonerIds) {
		return inter.getByIds(region, new CommaSeparatedArray(summonerIds), apiKey);
	}

	@Override
	public Observable<Map<String, MasteryPagesDto>> getMasteries(long... summonerIds) {
		return inter.getMasteries(region, new CommaSeparatedArray(summonerIds), apiKey);
	}

	@Override
	public Observable<Map<String, String>> getNames(long... summonerIds) {
		return inter.getNames(region, new CommaSeparatedArray(summonerIds), apiKey);
	}

	@Override
	public Observable<Map<String, RunePagesDto>> getRunes(long... summonerIds) {
		return inter.getRunes(region, new CommaSeparatedArray(summonerIds), apiKey);
	}

	/**
	 * This interface definition comes directly from the Riot API full reference
	 * docs.
	 * @author Dc
	 */
	interface Interface {

		@GET("/api/lol/{region}/v1.4/summoner/by-name/{summonerNames}")
		Observable<Map<String, SummonerDto>> getByNames(@Path("region") Region region, @Path("summonerNames") CommaSeparatedArray encodedSummonerNames, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}")
		Observable<Map<String, SummonerDto>> getByIds(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/masteries")
		Observable<Map<String, MasteryPagesDto>> getMasteries(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/name")
		Observable<Map<String, String>> getNames(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/runes")
		Observable<Map<String, RunePagesDto>> getRunes(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

	}
}
