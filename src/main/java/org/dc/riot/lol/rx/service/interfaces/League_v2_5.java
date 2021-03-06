package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.common.QueueType;
import org.dc.riot.lol.rx.model.league.LeagueDto;
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
			return inter.getBySummoners(new LowercaseRegion(region), new CSA.Long(summonerIds), apiKey);
		}, null, 400);
	}

	@Override
	public Map<String, LeagueDto[]> getBySummonerEntries(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getBySummonerEntries(new LowercaseRegion(region), new CSA.Long(summonerIds), apiKey);
		}, null, 400);
	}

	@Override
	public Map<String, LeagueDto[]> getByTeams(String... teamIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getByTeams(new LowercaseRegion(region), new CSA<String>(teamIds), apiKey);
		}, null, 400);
	}

	@Override
	public Map<String, LeagueDto[]> getByTeamEntries(String... teamIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getByTeamEntries(new LowercaseRegion(region), new CSA<String>(teamIds), apiKey);
		}, null, 400);
	}

	@Override
	public LeagueDto getChallenger(QueueType.ChallengerMaster queue) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getChallenger(new LowercaseRegion(region), apiKey, queue);
		}, null, 400);
	}

	@Override
	public LeagueDto getMaster(QueueType.ChallengerMaster queue) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getMaster(new LowercaseRegion(region), apiKey, queue);
		}, null, 400);
	}

	private interface Interface {
		
		@GET("/api/lol/{region}/v2.5/league/by-summoner/{summonerIds}")
		Call<Map<String,LeagueDto[]>> getBySummoners(@Path("region") LowercaseRegion region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);
		
		@GET("/api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry")
		Call<Map<String,LeagueDto[]>> getBySummonerEntries(@Path("region") LowercaseRegion region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.5/league/by-team/{teamIds}")
		Call<Map<String,LeagueDto[]>> getByTeams(@Path("region") LowercaseRegion region, @Path("teamIds") CSA<String> teamIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.5/league/by-team/{teamIds}/entry")
		Call<Map<String,LeagueDto[]>> getByTeamEntries(@Path("region") LowercaseRegion region, @Path("teamIds") CSA<String> teamIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.5/league/challenger")
		Call<LeagueDto> getChallenger(@Path("region") LowercaseRegion region, @Query("api_key") ApiKey apiKey, @Query("type") QueueType.ChallengerMaster type);

		@GET("/api/lol/{region}/v2.5/league/master")
		Call<LeagueDto> getMaster(@Path("region") LowercaseRegion region, @Query("api_key") ApiKey apiKey, @Query("type") QueueType.ChallengerMaster type);
	}
}
