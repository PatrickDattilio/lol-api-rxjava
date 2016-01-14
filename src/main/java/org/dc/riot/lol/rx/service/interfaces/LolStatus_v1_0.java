package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

import org.dc.riot.lol.rx.model.Shard;
import org.dc.riot.lol.rx.model.ShardStatus;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

class LolStatus_v1_0 extends RiotApiBase implements RiotApi.LolStatus {
	
	private Interface inter = null;

	LolStatus_v1_0(ApiKey apiKey, Region region) {
		super(apiKey, region);
		
		Retrofit ra = new Retrofit.Builder()
				.baseUrl("http://status.leagueoflegends.com")
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
	public RateType getRateType() {
		return RateType.SERVICE;
	}

	@Override
	public Shard[] getShards() throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getShards();
		});
	}

	@Override
	public ShardStatus getShard() throws IOException, HttpException {
		return RetrofitCaller.processCall(() -> {
			return inter.getShard(region);
		});
	}
	
	private interface Interface {
		
		@GET("/shards")
		Call<Shard[]> getShards();
		
		@GET("/shard/{region}")
		Call<ShardStatus> getShard(@Path("region") Region region);
	}

}
