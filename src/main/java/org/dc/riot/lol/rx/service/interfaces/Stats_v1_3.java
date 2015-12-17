package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.PlayerStatsSummaryListDto;
import org.dc.riot.lol.rx.model.RankedStatsDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.Season;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

class Stats_v1_3 implements RiotApi.Stats {
	
	private Region region;
	private ApiKey apiKey;
	
	private Interface inter;

	public Stats_v1_3(ApiKey apiKey, Region region) {
		this.apiKey = apiKey;
		this.region = region;

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<RankedStatsDto> getRanked(long summonerId, Season season) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getRanked(region, summonerId, season, apiKey);
		});
	}

	@Override
	public Observable<PlayerStatsSummaryListDto> getSummary(long summonerId, Season season) {
		return RetroRxCaller.makeObservable(() -> {
			 return inter.getSummary(region, summonerId, season, apiKey);
		});
	}
	
	private interface Interface {

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
		public Call<RankedStatsDto> getRanked(@Path("region") Region region, @Path("summonerId") long summonerId, Season season, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
		public Call<PlayerStatsSummaryListDto> getSummary(@Path("region") Region region, @Path("summonerId") long summonerId, Season season, @Query("api_key") ApiKey apiKey);
	}

}
