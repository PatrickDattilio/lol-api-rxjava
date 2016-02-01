package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.RankedQueue;
import org.dc.riot.lol.rx.model.Season;
import org.dc.riot.lol.rx.model.match.MatchListDto;
import org.dc.riot.lol.rx.model.match.MatchReference;
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

		final CSA.Long champIdParam = (championIds != null && championIds.length > 0) ? new CSA.Long(championIds) : null;
		final Long beginTimeParam = (beginTime > -1) ? new Long(beginTime) : null;
		final Long endTimeParam = (endTime > -1) ? new Long(endTime) : null;
		final Integer beginIndexParam = (beginIndex > -1) ? new Integer(beginIndex) : null;
		final Integer endIndexParam = (endTime > -1) ? new Integer(endIndex) : null;
		
		return RetrofitCaller.processCall(() -> {
			return inter.getMatchList(new LowercaseRegion(region), summonerId, apiKey, champIdParam,
					new CSA<RankedQueue>(rankedQueues), new CSA<Season>(seasons),
					beginTimeParam, endTimeParam, beginIndexParam, endIndexParam);
		},
		(MatchListDto dto) -> {
			for (MatchReference mr : dto.getMatches()) {
				mr.setRegion(region);
			}

			return dto;
		});
	}
	
	private interface Interface {
		
		@GET("/api/lol/{region}/v2.2/matchlist/by-summoner/{summonerId}")
		Call<MatchListDto> getMatchList(@Path("region") LowercaseRegion region, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey,
			 @Query("championIds") CSA.Long championIds, @Query("rankedQueues") CSA<RankedQueue> rankedQueues,
			 @Query("seasons") CSA<Season> seasons, @Query("beginTime") Long beginTime, @Query("endTime") Long endTime,
			 @Query("beginIndex") Integer beginIndex, @Query("endIndex") Integer endIndex);
	}
}
