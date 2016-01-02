package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.RecentGamesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

class RecentGames_v1_3 extends RiotApiBase implements RiotApi.RecentGames {
	
	private Interface inter;

	RecentGames_v1_3(ApiKey apiKey, Region region) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();
		
		inter = ra.create(Interface.class);
	}
	
	/**
	 * /api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent<br/>
	 * <br/>
	 * 400	Bad request<br/>
	 * 401	Unauthorized<br/>
	 * 404  Game data not found<br/>
	 * 429	Rate limit exceeded<br/>
	 * 500	Internal server error<br/>
	 * 503	Service unavailable
	 *
	 * @param summonerId player's summoner ID, See the {@link Summoner} interface for valid IDs.
	 * @return {@link RecentGamesDto} for the given player or <code>null</code> if no data found
	 * @throws HttpException 
	 * @throws IOException
	 */
    public RecentGamesDto getRecentGames(long summonerId) throws IOException, HttpException {
    	return RetrofitCaller.handleCaller(() -> {
    		return inter.getRecentGames(region, summonerId, apiKey);
    	});
    }

    private interface Interface {

    	@GET("/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    	Call<RecentGamesDto> getRecentGames(@Path("region") Region region, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);

    }
}
