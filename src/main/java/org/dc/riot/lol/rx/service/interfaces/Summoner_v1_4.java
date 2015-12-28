package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.MasteryPagesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.RunePagesDto;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.CommaSeparatedArray;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

class Summoner_v1_4 extends RiotApiBase implements RiotApi.Summoner {
	
	private Interface inter;
	
	Summoner_v1_4(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);
		
		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Map<String, SummonerDto> getByNames(String... summonerNames) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return inter.getByNames(region, new CommaSeparatedArray(summonerNames), apiKey);
		});
	}

	@Override
	public Map<String, SummonerDto> getByIds(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return inter.getByIds(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String, MasteryPagesDto> getMasteries(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return inter.getMasteries(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String, String> getNames(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return inter.getNames(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String, RunePagesDto> getRunes(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
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
