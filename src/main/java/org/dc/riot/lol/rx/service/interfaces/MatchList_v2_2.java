package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.MatchListDto;
import org.dc.riot.lol.rx.model.RankedQueue;
import org.dc.riot.lol.rx.model.Season;
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
class MatchList_v2_2 extends RiotApiBase implements RiotApi.MatchList {
	
	private Interface inter;
	
	MatchList_v2_2(ApiKey apiKey, Region region) {
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
		return 2.2f;
	}

	@Override
	public MatchListDto getMatchList(long summonerId, long[] championIds,
			RankedQueue[] rankedQueues, Season[] seasons, long beginTime,
			long endTime, int beginIndex, int endIndex) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getMatchList(region, summonerId, apiKey, new CSA.Long(championIds),
					new CSA<RankedQueue>(rankedQueues), new CSA<Season>(seasons),
					beginTime, endTime, beginIndex, endIndex);
		});
	}
	
	private interface Interface {
		
		@GET("/api/lol/{region}/v2.2/matchlist/by-summoner/{summonerId}")
		Call<MatchListDto> getMatchList(@Path("region") Region region, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey,
			 @Query("championIds") CSA.Long championIds, @Query("rankedQueues") CSA<RankedQueue> rankedQueues,
			 @Query("seasons") CSA<Season> seasons, @Query("beginTime") long beginTime, @Query("endTime") long endTime,
			 @Query("beginIndex") int beginIndex, @Query("endIndex") int endIndex);
	}
}
