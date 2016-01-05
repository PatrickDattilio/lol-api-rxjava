package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.Shard;
import org.dc.riot.lol.rx.model.ShardStatus;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

class LolStatus_v1_0 extends RiotApiBase implements RiotApi.LolStatus {
	
	private static Interface INTER = null;

	LolStatus_v1_0(ApiKey apiKey, Region region) {
		super(apiKey, region, null);
		
		if (INTER == null) {
			OkHttpClient client = new OkHttpClient();
//			client.interceptors().add(new TooFastRetryInterceptor());

			Retrofit ra = new Retrofit.Builder()
					.baseUrl("http://status.leagueoflegends.com")
					.addConverterFactory(GsonConverterFactory.create(ApiFactory.getGson()))
					.client(client)
					.build();
			
			INTER = ra.create(Interface.class);
		}
	}

	@Override
	public float getVersion() {
		return 1.0f;
	}

	@Override
	public RateType getRateType() {
		return RateType.SERVICE;
	}

	@Override
	public Shard[] getShards() throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return INTER.getShards();
		});
	}

	@Override
	public ShardStatus getShard() throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return INTER.getShard(region);
		});
	}
	
	private interface Interface {
		
		@GET("/shards")
		Call<Shard[]> getShards();
		
		@GET("/shard/{region}")
		Call<ShardStatus> getShard(@Path("region") Region region);
	}

}
