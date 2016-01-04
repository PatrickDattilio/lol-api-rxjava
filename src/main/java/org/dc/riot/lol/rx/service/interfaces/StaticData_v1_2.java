package org.dc.riot.lol.rx.service.interfaces;

import java.io.IOException;

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
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.request.ChampDataTag;
import org.dc.riot.lol.rx.service.request.ChampListDataTag;
import org.dc.riot.lol.rx.service.request.ItemDataTag;
import org.dc.riot.lol.rx.service.request.ItemListDataTag;
import org.dc.riot.lol.rx.service.request.MasteryDataTag;
import org.dc.riot.lol.rx.service.request.MasteryListDataTag;
import org.dc.riot.lol.rx.service.request.RuneDataTag;
import org.dc.riot.lol.rx.service.request.RuneListDataTag;
import org.dc.riot.lol.rx.service.request.SpellDataTag;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

class StaticData_v1_2 extends RiotApiBase implements RiotApi.StaticData {
	
	private static Interface INTER = null;
	
	StaticData_v1_2(ApiKey apiKey, Region region) {
		super(apiKey, region);
		
		if (INTER == null) {
			Retrofit ra = new Retrofit.Builder()
					.client(client)
					.baseUrl("https://global.api.pvp.net")
					.addConverterFactory(GsonConverterFactory.create(RiotApiFactory.getGson()))
					.build();

			INTER = ra.create(Interface.class);
		}
	}
	
	@Override
	public Region[] getSupportedRegions() {
		return Region.values();
	}
	
	@Override
	public RateType getRateType() {
		return RateType.SERVICE;
	}

	@Override
	public ChampionListDto getChampions(boolean dataById, String version, String locale, ChampListDataTag... champData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getChampions(region, dataById, locale, version, new CSA<ChampListDataTag>(champData));
		});
	}

	@Override
	public ChampionDto getChampion(long champId, String version, String locale, ChampDataTag... champData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getChampion(region, champId, locale, version, new CSA<ChampDataTag>(champData));
		});
	}

	@Override
	public ItemListDto getItems(String version, String locale, ItemListDataTag... itemListData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getItems(region, locale, version, new CSA<ItemListDataTag>(itemListData));
		});
	}

	@Override
	public ItemDto getItem(long itemId, String version, String locale, ItemDataTag... itemData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getItem(region, itemId, locale, version, new CSA<ItemDataTag>(itemData));
		});
	}

	@Override
	public LanguageStringsDto getLanguageStrings(String version, String locale) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getLanguageStrings(region, locale, version);
		});
	}

	@Override
	public String[] getLocales() throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getLocales(region);
		});
	}

	@Override
	public MapDataDto getMap(String version, String locale) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getMap(region, locale, version);
		});
	}

	@Override
	public MasteryListDto getMasteries(String version, String locale, MasteryListDataTag... masteryListData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getMasteries(region, locale, version, new CSA<MasteryListDataTag>(masteryListData));
		});
	}

	@Override
	public MasteryDto getMastery(long masteryId, String version, String locale, MasteryDataTag... masteryData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getMastery(region, masteryId, locale, version, new CSA<MasteryDataTag>(masteryData));
		});
	}

	@Override
	public RealmDto getRealm() throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getRealm(region);
		});
	}

	@Override
	public RuneListDto getRunes(String version, String locale, RuneListDataTag... runeListData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getRunes(region, locale, version, new CSA<RuneListDataTag>(runeListData));
		});
	}

	@Override
	public RuneDto getRune(long id, String version, String locale, RuneDataTag... runeData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getRune(region, id, locale, version, new CSA<RuneDataTag>(runeData));
		});
	}

	@Override
	public SummonerSpellListDto getSummonerSpells(boolean dataById, String version, String locale, SpellDataTag... spellData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getSummonerSpells(region, dataById, apiKey, locale, version, new CSA<SpellDataTag>(spellData));
		});
	}

	@Override
	public SummonerSpellDto getSummonerSpell(long summonerSpellId, String version, String locale, SpellDataTag... spellData) throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getSummonerSpell(region, summonerSpellId, apiKey, locale, version, new CSA<SpellDataTag>(spellData));
		});
	}

	@Override
	public String[] getVersions() throws IOException, HttpException {
		return RetrofitCaller.handleCaller(() -> {
			return INTER.getVersions(region, apiKey);
		});
	}

	private interface Interface {
		
		@GET("/api/lol/static-data/{region}/v1.2/champion")
		Call<ChampionListDto> getChampions(@Path("region") Region region, @Query("dataById") boolean dataById,
				@Query("locale") String locale, @Query("version") String version,
				@Query("champData") CSA<ChampListDataTag> champData);
		
		@GET("/api/lol/static-data/{region}/v1.2/champion/{id}")
		Call<ChampionDto> getChampion(@Path("region") Region region, @Path("id") long champId,
				@Query("locale") String locale, @Query("version") String version,
				@Query("champData") CSA<ChampDataTag> champData);
		
		@GET("/api/lol/static-data/{region}/v1.2/item")
		Call<ItemListDto> getItems(@Path("region") Region region,
				@Query("locale") String locale, @Query("version") String version,
				@Query("itemData") CSA<ItemListDataTag> itemData);
		
		@GET("/api/lol/static-data/{region}/v1.2/item/{id}")
		Call<ItemDto> getItem(@Path("region") Region region, @Path("id") long itemId,
				@Query("locale") String locale, @Query("version") String version,
				@Query("itemData") CSA<ItemDataTag> itemData);
		
		@GET("/api/lol/static-data/{region}/v1.2/language-strings")
		Call<LanguageStringsDto> getLanguageStrings(@Path("region") Region region, @Query("locale") String locale, @Query("version") String version);
		
		@GET("/api/lol/static-data/{region}/v1.2/languages")
		Call<String[]> getLocales(@Path("region") Region region);
		
		@GET("/api/lol/static-data/{region}/v1.2/map")
		Call<MapDataDto> getMap(@Path("region") Region region,
				@Query("locale") String locale, @Query("version") String version);
		
		@GET("/api/lol/static-data/{region}/v1.2/mastery")
		Call<MasteryListDto> getMasteries(@Path("region") Region region,
				@Query("locale") String locale, @Query("version") String version,
				@Query("masteryData") CSA<MasteryListDataTag> masteryListData);
		
		@GET("/api/lol/static-data/{region}/v1.2/mastery/{id}")
		Call<MasteryDto> getMastery(@Path("region") Region region, @Path("id") long masteryId,
				@Query("locale") String locale, @Query("version") String version,
				@Query("masteryData") CSA<MasteryDataTag> masteryData);
		
		@GET("/api/lol/static-data/{region}/v1.2/realm")
		Call<RealmDto> getRealm(@Path("region") Region region);
		
		@GET("GET /api/lol/static-data/{region}/v1.2/rune")
		Call<RuneListDto> getRunes(@Path("region") Region region,
				@Query("locale") String locale, @Query("version") String version,
				@Query("runeData") CSA<RuneListDataTag> runeData);
		
		@GET("GET /api/lol/static-data/{region}/v1.2/rune/{id}")
		Call<RuneDto> getRune(@Path("region") Region region, @Path("id") long runeId,
				@Query("locale") String locale, @Query("version") String version,
				@Query("runeData") CSA<RuneDataTag> runeData);
		
		@GET("/api/lol/static-data/{region}/v1.2/summoner-spell")
		Call<SummonerSpellListDto> getSummonerSpells(@Path("region") Region region,
				@Query("dataById") boolean dataById, @Query("api_key") ApiKey apiKey, @Query("locale") String locale,
				@Query("version") String version, @Query("spellData") CSA<SpellDataTag> spellData);

		
		@GET("/api/lol/static-data/{region}/v1.2/summoner-spell/{id}")
		Call<SummonerSpellDto> getSummonerSpell(@Path("region") Region region, @Path("id") long id,
				@Query("api_key") ApiKey apiKey, @Query("locale") String locale,
				@Query("version") String version, @Query("spellData") CSA<SpellDataTag> spellData);
		
		@GET("/api/lol/static-data/{region}/v1.2/versions")
		Call<String[]> getVersions(@Path("region") Region region, @Query("api_key") ApiKey apiKey);
	}
}
