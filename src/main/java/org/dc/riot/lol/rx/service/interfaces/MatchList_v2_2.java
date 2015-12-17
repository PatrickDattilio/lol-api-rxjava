package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.MatchListDto;
import org.dc.riot.lol.rx.model.RankedQueue;
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
import rx.Observable;

class MatchList_v2_2 implements RiotApi.MatchList {
	
	private ApiKey apiKey;
	private Region region;
	
	private Interface inter;
	
	MatchList_v2_2(ApiKey apiKey, Region region, OkHttpClient client) {
		this.apiKey = apiKey;
		this.region = region;
		
		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<MatchListDto> getMatchList(long summonerId, long[] championIds,
			RankedQueue[] rankedQueues, Season[] seasons, long beginTime, long endTime, int beginIndex, int endIndex) {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getMatchList(region, summonerId, apiKey, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, endIndex);
		});
	}
	
	private interface Interface {
		
		@GET("/api/lol/{region}/v2.2/matchlist/by-summoner/{summonerId}")
		Call<MatchListDto> getMatchList(@Path("region") Region region, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey,
			 @Query("championIds") long[] championIds, @Query("rankedQueues") RankedQueue[] rankedQueues,
			 @Query("seasons") Season[] seasons, @Query("beginTime") long beginTime, @Query("endTime") long endTime,
			 @Query("beginIndex") int beginIndex, @Query("endIndex") int endIndex);
	}
}
