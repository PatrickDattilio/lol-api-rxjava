package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.PlayerStatsSummaryListDto;
import org.dc.riot.lol.rx.model.RankedStatsDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.Season;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiTicketBucket;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

class Stats_v1_3 extends RiotApiBase implements RiotApi.Stats {
	
	private Interface inter;

	Stats_v1_3(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<RankedStatsDto> getRanked(long summonerId, Season season) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<RankedStatsDto>() {
			@Override
			public Call<RankedStatsDto> call(RiotApiTicketBucket ticketHolder) {
				return inter.getRanked(region, summonerId, season, apiKey);
			}
		},
		getTicketBucket());
	}

	@Override
	public Observable<PlayerStatsSummaryListDto> getSummary(long summonerId, Season season) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<PlayerStatsSummaryListDto>() {
			@Override
			public Call<PlayerStatsSummaryListDto> call(RiotApiTicketBucket ticketHolder) {
				 return inter.getSummary(region, summonerId, season, apiKey);
			}
		},
		getTicketBucket());
	}
	
	private interface Interface {

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
		public Call<RankedStatsDto> getRanked(@Path("region") Region region, @Path("summonerId") long summonerId, Season season, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
		public Call<PlayerStatsSummaryListDto> getSummary(@Path("region") Region region, @Path("summonerId") long summonerId, Season season, @Query("api_key") ApiKey apiKey);
	}

}
