package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.LeagueDto;
import org.dc.riot.lol.rx.model.QueueType;
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

class League_v2_5 extends RiotApiBase implements RiotApi.League {
	
	private Interface inter;

	League_v2_5(ApiKey apiKey, Region region) {
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
		return 2.5f;
	}

	@Override
	public Map<String, LeagueDto[]> getBySummoners(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getBySummoners(region, new CSA.Long(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String, LeagueDto[]> getBySummonerEntries(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getBySummonerEntries(region, new CSA.Long(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String, LeagueDto[]> getByTeams(String... teamIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getByTeams(region, new CSA<String>(teamIds), apiKey);
		});
	}

	@Override
	public Map<String, LeagueDto[]> getByTeamEntries(String... teamIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getByTeamEntries(region, new CSA<String>(teamIds), apiKey);
		});
	}

	@Override
	public LeagueDto getChallenger(QueueType queue) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getChallenger(region, apiKey, queue);
		});
	}

	@Override
	public LeagueDto getMaster(QueueType queue) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getMaster(region, apiKey, queue);
		});
	}

	private interface Interface {
		
		@GET("/api/lol/{region}/v2.5/league/by-summoner/{summonerIds}")
		Call<Map<String,LeagueDto[]>> getBySummoners(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_ley") ApiKey apiKey);
		
		@GET("/api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry")
		Call<Map<String,LeagueDto[]>> getBySummonerEntries(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_ley") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.5/league/by-team/{teamIds}")
		Call<Map<String,LeagueDto[]>> getByTeams(@Path("region") Region region, @Path("teamIds") CSA<String> teamIds, @Query("api_ley") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.5/league/by-team/{teamIds}/entry")
		Call<Map<String,LeagueDto[]>> getByTeamEntries(@Path("region") Region region, @Path("teamIds") CSA<String> teamIds, @Query("api_ley") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.5/league/challenger")
		Call<LeagueDto> getChallenger(@Path("region") Region region, @Query("api_ley") ApiKey apiKey, @Query("type") QueueType type);

		@GET("/api/lol/{region}/v2.5/league/master")
		Call<LeagueDto> getMaster(@Path("region") Region region, @Query("api_ley") ApiKey apiKey, @Query("type") QueueType type);
	}
}
