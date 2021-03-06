package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.summoner.MasteryPagesDto;
import org.dc.riot.lol.rx.model.summoner.RunePagesDto;
import org.dc.riot.lol.rx.model.summoner.SummonerDto;
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
 * @author Dc
 * @since 1.0.0
 */
class Summoner_v1_4 extends RiotApiBase implements RiotApi.Summoner {
	
	private Interface inter;
	
	Summoner_v1_4(ApiKey apiKey, Region region) {
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
		return 1.4f;
	}

	@Override
	public Map<String, SummonerDto> getByNames(String... summonerNames) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			String[] encodedNames = new String[summonerNames.length];
			for (int i=0; i<encodedNames.length; i++) {
				encodedNames[i] = RiotApi.Summoner.encodeName(summonerNames[i]);
			}
			return inter.getByNames(region, new CSA<String>(encodedNames), apiKey);
		},
		(Map<String,SummonerDto> dto) -> {
			for (SummonerDto s : dto.values()) {
				s.setRegion(region);
			}
			
			return dto;
		});
	}

	@Override
	public Map<String, SummonerDto> getByIds(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getByIds(region, new CSA.Long(summonerIds), apiKey);
		},
		(Map<String,SummonerDto> dto) -> {
			for (SummonerDto s : dto.values()) {
				s.setRegion(region);
			}
			
			return dto;
		});
	}

	@Override
	public Map<String, SummonerDto> getByAccounts(long... accountIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getByAccounts(region, new CSA.Long(accountIds), apiKey);
		},
		(Map<String,SummonerDto> dto) -> {
			for (SummonerDto s : dto.values()) {
				s.setRegion(region);
			}
			
			return dto;
		});
	}

	@Override
	public Map<String, MasteryPagesDto> getMasteries(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getMasteries(region, new CSA.Long(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String, String> getNames(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getNames(region, new CSA.Long(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String, RunePagesDto> getRunes(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getRunes(region, new CSA.Long(summonerIds), apiKey);
		});
	}
	
	private interface Interface {

		@GET("/api/lol/{region}/v1.4/summoner/by-name/{summonerNames}")
		Call<Map<String, SummonerDto>> getByNames(@Path("region") Region region, @Path("summonerNames") CSA<String> encodedSummonerNames, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}")
		Call<Map<String, SummonerDto>> getByIds(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/by-account/{accountIds}")
		Call<Map<String, SummonerDto>> getByAccounts(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/masteries")
		Call<Map<String, MasteryPagesDto>> getMasteries(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/name")
		Call<Map<String, String>> getNames(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/runes")
		Call<Map<String, RunePagesDto>> getRunes(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);

	}
}
