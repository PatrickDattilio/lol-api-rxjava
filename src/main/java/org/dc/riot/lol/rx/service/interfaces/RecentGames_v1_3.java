package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.RecentGamesDto;
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
class RecentGames_v1_3 extends RiotApiBase implements RiotApi.RecentGames {
	
	private Interface inter;

	RecentGames_v1_3(ApiKey apiKey, Region region) {
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
		return 1.3f;
	}
	
	@Override
    public RecentGamesDto getRecentGames(long summonerId) throws IOException, HttpException {
    	return RetrofitCaller.processCall(() -> {
    		return inter.getRecentGames(region, summonerId, apiKey);
    	});
    }

    private interface Interface {

    	@GET("/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    	Call<RecentGamesDto> getRecentGames(@Path("region") Region region, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);

    }
}
