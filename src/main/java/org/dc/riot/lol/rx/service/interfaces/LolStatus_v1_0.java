package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.Shard;
import org.dc.riot.lol.rx.model.ShardStatus;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

class LolStatus_v1_0 extends RiotApiBase implements RiotApi.LolStatus {

	LolStatus_v1_0(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);
	}

	@Override
	public Shard[] getShards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShardStatus getShard() {
		// TODO Auto-generated method stub
		return null;
	}

}
