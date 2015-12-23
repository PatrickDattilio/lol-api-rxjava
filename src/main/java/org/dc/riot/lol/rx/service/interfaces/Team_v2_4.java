package org.dc.riot.lol.rx.service.interfaces;

import java.util.Map;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.TeamDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

class Team_v2_4 extends RiotApiBase implements RiotApi.Team {
	
	private Interface inter;

	public Team_v2_4(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<Map<String,TeamDto[]>> getTeamsBySummoners(long... summonerIds) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getTeamsBySummoners(region, new CommaSeparatedArray(summonerIds), apiKey);
		});
	}

	@Override
	public Observable<Map<String,TeamDto>> getTeams(String... teamIds) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getTeams(region, new CommaSeparatedArray(teamIds), apiKey);
		});
	}
	
	interface Interface {
		
		@GET("/api/lol/{region}/v2.4/team/by-summoner/{summonerIds}")
		public Call<Map<String,TeamDto[]>> getTeamsBySummoners(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIdsteamIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.4/team/by-summoner/{teamIds}")
		public Call<Map<String,TeamDto>> getTeams(@Path("region") Region region, @Path("teamIds") CommaSeparatedArray teamIds, @Query("api_key") ApiKey apiKey);
	}

}
