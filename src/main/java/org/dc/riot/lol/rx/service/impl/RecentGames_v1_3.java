package org.dc.riot.lol.rx.service.impl;

import org.dc.riot.lol.rx.model.RecentGamesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public class RecentGames_v1_3 implements RiotApi.RecentGames {
	
	private ApiKey apiKey;
	private Region region;
	
	private Interface inter;

	public RecentGames_v1_3(ApiKey apiKey, Region region) {
		this.apiKey = apiKey;
		this.region = region;

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
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
	 * @param region     the {@link Region}
	 * @param summonerId player's summoner ID, See the {@link Summoner} interface for valid IDs.
	 * @return {@link RecentGamesDto} for the given player or <code>null</code> if no data found
	 * @throws IOException
	 */
    public Observable<RecentGamesDto> getRecentGames(long summonerId) {
    	return inter.getRecentGames(region, summonerId, apiKey);
    }

    interface Interface {

    	@GET("/api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    	Observable<RecentGamesDto> getRecentGames(@Path("region") Region region, @Path("summonerId") long summonerId, @Query("api_key") ApiKey apiKey);

    }
}
