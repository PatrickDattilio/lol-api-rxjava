package org.dc.riot.lol.rx.service.interfaces;

import java.util.Map;

import org.dc.riot.lol.rx.model.LeagueDto;
import org.dc.riot.lol.rx.model.QueueType;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;

import com.squareup.okhttp.OkHttpClient;

import rx.Observable;

class League_v2_5 extends RiotApiBase implements RiotApi.League {

	League_v2_5(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);
	}

	@Override
	public Observable<Map<String, LeagueDto[]>> getBySummonerEntry(long... summonerIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Map<String, LeagueDto[]>> getBySummoner(long... summonerIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Map<String, LeagueDto[]>> getByTeam(String... teamIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<Map<String, LeagueDto[]>> getByTeamEntry(String... teamIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<LeagueDto> getChallenger(QueueType queue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<LeagueDto> getMaster(QueueType queue) {
		// TODO Auto-generated method stub
		return null;
	}

}
