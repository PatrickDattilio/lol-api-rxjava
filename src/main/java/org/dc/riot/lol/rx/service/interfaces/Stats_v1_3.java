package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.PlayerStatsSummaryListDto;
import org.dc.riot.lol.rx.model.RankedStatsDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.Season;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

class Stats_v1_3 extends RiotApiBase implements RiotApi.Stats {
	
	private Interface inter;

	Stats_v1_3(ApiKey apiKey, Region region) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public RankedStatsDto getRanked(long summonerId, Season season) {
		return null;
	}

	@Override
	public PlayerStatsSummaryListDto getSummary(long summonerId, Season season) {
		return null;
	}
	
	private interface Interface {

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
		public Call<RankedStatsDto> getRanked(@Path("region") Region region, @Path("summonerId") long summonerId, Season season, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
		public Call<PlayerStatsSummaryListDto> getSummary(@Path("region") Region region, @Path("summonerId") long summonerId, Season season, @Query("api_key") ApiKey apiKey);
	}

}
