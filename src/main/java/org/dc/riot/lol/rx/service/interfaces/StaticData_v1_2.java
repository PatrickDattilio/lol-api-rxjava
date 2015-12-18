package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.model.ChampionDto;
import org.dc.riot.lol.rx.model.ChampionListDto;
import org.dc.riot.lol.rx.model.ItemDto;
import org.dc.riot.lol.rx.model.ItemListDto;
import org.dc.riot.lol.rx.model.LanguageStringsDto;
import org.dc.riot.lol.rx.model.MapDataDto;
import org.dc.riot.lol.rx.model.MasteryDto;
import org.dc.riot.lol.rx.model.MasteryListDto;
import org.dc.riot.lol.rx.model.RealmDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.RuneDto;
import org.dc.riot.lol.rx.model.RuneListDto;
import org.dc.riot.lol.rx.model.SummonerSpellDto;
import org.dc.riot.lol.rx.model.SummonerSpellListDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.request.ChampDataTag;
import org.dc.riot.lol.rx.service.request.ItemListDataTag;
import org.dc.riot.lol.rx.service.request.MasteryDataTag;
import org.dc.riot.lol.rx.service.request.MasteryListDataTag;
import org.dc.riot.lol.rx.service.request.RuneDataTag;
import org.dc.riot.lol.rx.service.request.RuneListDataTag;
import org.dc.riot.lol.rx.service.request.SpellDataTag;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import rx.Observable;

// TODO unconventional base URL
class StaticData_v1_2 extends RiotApiBase implements RiotApi.StaticData {
	
	private static Interface INTER = null;
	private static OkHttpClient CLIENT = null;

	StaticData_v1_2(ApiKey apiKey, Region region, OkHttpClient client) {
		super(apiKey, region);
		
		if (INTER == null || (client != null && client != CLIENT)) {
			INTER = createInterface(client);
			CLIENT = client;
		}
	}
	
	private static Interface createInterface(OkHttpClient client) {
		Retrofit ra = new Retrofit.Builder()
				.baseUrl("https://global.api.pvp.net")
				.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
				.client(client)
				.build();

		return ra.create(Interface.class);
	}
	
	@Override
	public RateType getRateType() {
		return RateType.SERVICE;
	}

	@Override
	public Observable<ChampionListDto> getChampions(String version, String locale,
			ChampDataTag... champData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<ChampionDto> getChampion(long champId, String version, String locale, ChampDataTag... champData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<ItemListDto> getItems(String version, String locale, ItemListDataTag... itemListData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<ItemDto> getItem(long itemId, String version, String locale, ItemListDataTag... itemData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<LanguageStringsDto> getLanguageStrings(String version, String locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<String[]> getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<MapDataDto> getMap(String version, String locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<MasteryListDto> getMasteries(String version, String locale,
			MasteryListDataTag... masteryListData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<MasteryDto> getMastery(long id, String version, String locale, MasteryDataTag... masteryData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<RealmDto> getRealm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<RuneListDto> getRunes(String version, String locale, RuneListDataTag... runeListData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<RuneDto> getRune(long id, String version, String locale, RuneDataTag... runeData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<SummonerSpellListDto> getSummonerSpells(boolean dataById, String version, String locale,
			SpellDataTag... spellData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<SummonerSpellDto> getSummonerSpell(long id, String version, String locale,
			SpellDataTag... spellData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Observable<String[]> getVersions() {
		// TODO Auto-generated method stub
		return null;
	}

	private interface Interface {
		
	}
}
