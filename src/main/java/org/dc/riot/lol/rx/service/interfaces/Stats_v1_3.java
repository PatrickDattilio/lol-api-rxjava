package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.common.Season;
import org.dc.riot.lol.rx.model.stats.PlayerStatsSummaryListDto;
import org.dc.riot.lol.rx.model.stats.RankedStatsDto;
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
class Stats_v1_3 extends RiotApiBase implements RiotApi.Stats {
	
	private Interface inter;

	Stats_v1_3(ApiKey apiKey, Region region) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + new LowercaseRegion(region) + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(ApiFactory.getGson()))
				.client(client)
				.build();
		
		inter = ra.create(Interface.class);
	}
	
	@Override
	public float getVersion() {
		return 1.3f;
	}

	@Override
	public RankedStatsDto getRanked(long summonerId, Season season) throws IOException, HttpException {
		RankedStatsDto noRanked = new RankedStatsDto();
		return RetrofitCaller.processCall(() -> {
			return inter.getRanked(new LowercaseRegion(region), summonerId, season, apiKey);
		}, noRanked, 404);
	}

	@Override
	public PlayerStatsSummaryListDto getSummary(long summonerId, Season season) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getSummary(new LowercaseRegion(region), summonerId, season, apiKey);
		});
	}
	
	private interface Interface {

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
		public Call<RankedStatsDto> getRanked(@Path("region") LowercaseRegion region, @Path("summonerId") long summonerId, @Query("season") Season season, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
		public Call<PlayerStatsSummaryListDto> getSummary(@Path("region") LowercaseRegion region, @Path("summonerId") long summonerId, @Query("season") Season season, @Query("api_key") ApiKey apiKey);
	}

}
