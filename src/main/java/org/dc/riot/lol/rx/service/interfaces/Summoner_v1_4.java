package org.dc.riot.lol.rx.service.interfaces;

import java.util.Map;

import org.dc.riot.lol.rx.model.MasteryPagesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.RunePagesDto;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.CommaSeparatedArray;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.RiotApiTicketBucket;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

class Summoner_v1_4 extends RiotApiBase implements RiotApi.Summoner {
	
	private Interface inter;
	
	Summoner_v1_4(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);
		
		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://" + region.toString().toLowerCase() + ".api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();
		
		inter = ra.create(Interface.class);
	}

	@Override
	public Observable<Map<String, SummonerDto>> getByNames(String... summonerNames) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<Map<String,SummonerDto>>() {
			@Override
			public Call<Map<String, SummonerDto>> call(RiotApiTicketBucket ticketHolder) {
				String[] array = new String[summonerNames.length];
				for (int i=0; i<array.length; i++) {
					array[i] = RiotApi.encodeName(summonerNames[i]);
				}

				return inter.getByNames(region, new CommaSeparatedArray(array), apiKey);
			}
		},
		getTicketBucket());
	}

	@Override
	public Observable<Map<String, SummonerDto>> getByIds(long... summonerIds) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<Map<String,SummonerDto>>() {
			@Override
			public Call<Map<String, SummonerDto>> call(RiotApiTicketBucket ticketHolder) {
				return inter.getByIds(region, new CommaSeparatedArray(summonerIds), apiKey);
			}
		},
		getTicketBucket());
	}

	@Override
	public Observable<Map<String, MasteryPagesDto>> getMasteries(long... summonerIds) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<Map<String,MasteryPagesDto>>() {
			@Override
			public Call<Map<String, MasteryPagesDto>> call(RiotApiTicketBucket ticketHolder) {
				return inter.getMasteries(region, new CommaSeparatedArray(summonerIds), apiKey);
			}
		},
		getTicketBucket());
	}

	@Override
	public Observable<Map<String, String>> getNames(long... summonerIds) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<Map<String,String>>() {
			@Override
			public Call<Map<String, String>> call(RiotApiTicketBucket ticketHolder) {
				return inter.getNames(region, new CommaSeparatedArray(summonerIds), apiKey);
			}
		},
		getTicketBucket());
	}

	@Override
	public Observable<Map<String, RunePagesDto>> getRunes(long... summonerIds) {
		return RetroRxCaller.makeObservable(new RetroRxCaller<Map<String,RunePagesDto>>() {
			@Override
			public Call<Map<String, RunePagesDto>> call(RiotApiTicketBucket ticketHolder) {
				return inter.getRunes(region, new CommaSeparatedArray(summonerIds), apiKey);
			}
		},
		getTicketBucket());
	}

	/**
	 * This interface definition comes directly from the Riot API full reference
	 * docs.
	 * @author Dc
	 */
	private interface Interface {

		@GET("/api/lol/{region}/v1.4/summoner/by-name/{summonerNames}")
		Call<Map<String, SummonerDto>> getByNames(@Path("region") Region region, @Path("summonerNames") CommaSeparatedArray encodedSummonerNames, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}")
		Call<Map<String, SummonerDto>> getByIds(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/masteries")
		Call<Map<String, MasteryPagesDto>> getMasteries(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/name")
		Call<Map<String, String>> getNames(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

		@GET("/api/lol/{region}/v1.4/summoner/{summonerIds}/runes")
		Call<Map<String, RunePagesDto>> getRunes(@Path("region") Region region, @Path("summonerIds") CommaSeparatedArray summonerIds, @Query("api_key") ApiKey apiKey);

	}
}
