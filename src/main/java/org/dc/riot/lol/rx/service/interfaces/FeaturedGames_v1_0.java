package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.featuredgame.FeaturedGamesDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author Dc
 * @since 1.0.0
 */
class FeaturedGames_v1_0 extends RiotApiBase implements RiotApi.FeaturedGames {
	
	private Interface inter;

	FeaturedGames_v1_0(ApiKey apiKey, Region region) {
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
		return 1.0f;
	}

	@Override
	public FeaturedGamesDto getFeaturedGames() throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getFeaturedGames(apiKey);
		});
	}
	
	private interface Interface {
		
		@GET("/observer-mode/rest/featured")
		Call<FeaturedGamesDto> getFeaturedGames(@Query("api_key") ApiKey apiKey);
	}

}
