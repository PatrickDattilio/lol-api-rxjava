package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.MatchDetail;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

import rx.Observable;

class Match_v2_2 extends RiotApiBase implements RiotApi.Match {

	Match_v2_2(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);
	}

	@Override
	public Observable<MatchDetail> getMatch(long matchId, boolean includeTimeline) {
		// TODO Auto-generated method stub
		return null;
	}

}
