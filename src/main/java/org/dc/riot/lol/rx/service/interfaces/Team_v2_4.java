package org.dc.riot.lol.rx.service.interfaces;

import java.util.Map;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.TeamDto;
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

class Team_v2_4 implements RiotApi.Team {
	
	private ApiKey apiKey;
	private Region region;
	
	private Interface inter;

	public Team_v2_4(ApiKey apiKey, Region region) {
		this.apiKey = apiKey;
		this.region = region;

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<Map<String,TeamDto[]>> getTeamsBySummoners(long... summonerIds) {
		return inter.getTeamsBySummoners(region, new CommaSeparatedArray(summonerIds), apiKey);
	}

	@Override
	public Observable<Map<String,TeamDto>> getTeams(String... teamIds) {
		return inter.getTeams(region, new CommaSeparatedArray(teamIds), apiKey);
	}
	
	interface Interface {
		
		@GET("/api/lol/{region}/v2.4/team/by-summoner/{summonerIds}")
		public Observable<Map<String,TeamDto[]>> getTeamsBySummoners(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIdsteamIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v2.4/team/by-summoner/{teamIds}")
		public Observable<Map<String,TeamDto>> getTeams(@Path("region") Region region, @Path("teamIds") CommaSeparatedArray teamIds, @Query("api_key") ApiKey apiKey);
	}

}
