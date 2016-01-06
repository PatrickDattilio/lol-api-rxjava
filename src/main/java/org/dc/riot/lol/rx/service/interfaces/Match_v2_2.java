package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.MatchDetail;
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

class Match_v2_2 extends RiotApiBase implements RiotApi.Match {
	
	private Interface inter;

	Match_v2_2(ApiKey apiKey, Region region) {
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
	public MatchDetail getMatch(long matchId, boolean includeTimeline) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getMatch(region, matchId, apiKey, includeTimeline);
		});
	}
	
	private interface Interface {
		
		@GET("/api/lol/{region}/v2.2/match/{matchId}")
		Call<MatchDetail> getMatch(@Path("region") Region region, @Path("matchId") long matchId,
				@Query("api_key") ApiKey apiKey, @Query("includeTimeline") boolean includeTimeline);
	}

}
