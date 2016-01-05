package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.TeamDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

class Team_v2_4 extends RiotApiBase implements RiotApi.Team {
	
	private Interface inter;

	public Team_v2_4(ApiKey apiKey, Region region) {
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
		return 2.4f;
	}

	@Override
	public Map<String,TeamDto[]> getTeamsBySummoners(long... summonerIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getTeamsBySummoners(region, new CSA.Long(summonerIds), apiKey);
		});
	}

	@Override
	public Map<String,TeamDto> getTeams(String... teamIds) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getTeams(region, new CSA<String>(teamIds), apiKey);
		});
	}
	
	private interface Interface {
		
		@GET("/api/lol/{region}/v2.4/team/by-summoner/{summonerIds}")
		public Call<Map<String,TeamDto[]>> getTeamsBySummoners(@Path("region") Region region, @Path("summonerIds") CSA.Long summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.4/team/by-summoner/{teamIds}")
		public Call<Map<String,TeamDto>> getTeams(@Path("region") Region region, @Path("teamIds") CSA<String> teamIds, @Query("api_key") ApiKey apiKey);
	}

}
