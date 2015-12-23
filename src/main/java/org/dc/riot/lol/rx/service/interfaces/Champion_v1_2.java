package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.ChampionDto;
import org.dc.riot.lol.rx.model.ChampionListDto;
import org.dc.riot.lol.rx.model.Region;
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

// TODO not fully implemented
class Champion_v1_2 extends RiotApiBase implements RiotApi.Champion {

	private Interface inter;

	Champion_v1_2(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);

		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();

		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<ChampionListDto> getChampions() {
		return RetroRxCaller.makeObservable(() -> {
			return inter.getChampions(region, apiKey);
		});
	}

	@Override
	public Observable<ChampionListDto> getChampions(boolean freeToPlay) {
		return null;
	}

	@Override
	public Observable<ChampionDto> getChampion(long championId) {
		return null;
	}

	private interface Interface {

		@GET("/api/lol/{region}/v1.2/champion")
		Call<ChampionListDto> getChampions(@Path("region") Region region, @Query("api_key") ApiKey apiKey);
	}

}
