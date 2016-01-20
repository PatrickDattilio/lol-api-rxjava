package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.ChampionMetaDto;
import org.dc.riot.lol.rx.model.ChampionMetaListDto;
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
class Champion_v1_2 extends RiotApiBase implements RiotApi.Champion {

	private Interface inter;

	Champion_v1_2(ApiKey apiKey, Region region) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + new LowercaseRegion(region) + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(ApiFactory.getGson()))
				.client(client)
				.build();

		inter = ra.create(Interface.class);
	}
	
	@Override
	public float getVersion() {
		return 1.2f;
	}

	@Override
	public ChampionMetaListDto getChampions(final boolean freeToPlay) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getChampions(region, apiKey, freeToPlay);
		});
	}

	@Override
	public ChampionMetaDto getChampion(long championId) throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getChampion(region, championId, apiKey);
		});
	}

	private interface Interface {

		@GET("/api/lol/{region}/v1.2/champion")
		Call<ChampionMetaListDto> getChampions(@Path("region") Region region, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.2/champion")
		Call<ChampionMetaListDto> getChampions(@Path("region") Region region, @Query("api_key") ApiKey apiKey, @Query("freeToPlay") boolean freeToPlay);

		@GET("/api/lol/{region}/v1.2/champion/{championId}")
		Call<ChampionMetaDto> getChampion(@Path("region") Region region, @Path("championId") long championId, @Query("api_key") ApiKey apiKey);
	}

}
