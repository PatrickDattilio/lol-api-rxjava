package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.FeaturedGamesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

class FeaturedGames_v1_0 extends RiotApiBase implements RiotApi.FeaturedGames {

	FeaturedGames_v1_0(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);
	}

	@Override
	public FeaturedGamesDto getFeaturedGames() {
		// TODO Auto-generated method stub
		return null;
	}

}
