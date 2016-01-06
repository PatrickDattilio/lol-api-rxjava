package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.FeaturedGamesDto;
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
			return inter.getFeaturedGames(region, apiKey);
		});
	}
	
	private interface Interface {
		
		@GET("/observer-mode/rest/featured")
		Call<FeaturedGamesDto> getFeaturedGames(@Path("region") Region region, @Query("api_ley") ApiKey apiKey);
	}

}
