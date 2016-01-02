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

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

// TODO unconventional base URL
class StaticData_v1_2 extends RiotApiBase implements RiotApi.StaticData {
	
	StaticData_v1_2(ApiKey apiKey, Region region) {
		super(apiKey, region);
		
	}
	
	@Override
	public RateType getRateType() {
		return RateType.SERVICE;
	}

	@Override
	public ChampionListDto getChampions(String version, String locale,
			ChampDataTag... champData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChampionDto getChampion(long champId, String version, String locale, ChampDataTag... champData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemListDto getItems(String version, String locale, ItemListDataTag... itemListData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDto getItem(long itemId, String version, String locale, ItemListDataTag... itemData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LanguageStringsDto getLanguageStrings(String version, String locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapDataDto getMap(String version, String locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasteryListDto getMasteries(String version, String locale,
			MasteryListDataTag... masteryListData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MasteryDto getMastery(long id, String version, String locale, MasteryDataTag... masteryData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RealmDto getRealm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RuneListDto getRunes(String version, String locale, RuneListDataTag... runeListData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RuneDto getRune(long id, String version, String locale, RuneDataTag... runeData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SummonerSpellListDto getSummonerSpells(boolean dataById, String version, String locale,
			SpellDataTag... spellData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SummonerSpellDto getSummonerSpell(long id, String version, String locale,
			SpellDataTag... spellData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getVersions() {
		// TODO Auto-generated method stub
		return null;
	}

	private interface Interface {
		
	}
}
