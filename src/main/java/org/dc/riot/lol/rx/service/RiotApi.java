package org.dc.riot.lol.rx.service;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.ChampionDto;
import org.dc.riot.lol.rx.model.ChampionListDto;
import org.dc.riot.lol.rx.model.LeagueDto;
import org.dc.riot.lol.rx.model.LeagueEntryDto;
import org.dc.riot.lol.rx.model.MasteryPagesDto;
import org.dc.riot.lol.rx.model.MatchListDto;
import org.dc.riot.lol.rx.model.PlayerStatsSummaryListDto;
import org.dc.riot.lol.rx.model.RankedQueue;
import org.dc.riot.lol.rx.model.RankedStatsDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.RunePagesDto;
import org.dc.riot.lol.rx.model.Season;
import org.dc.riot.lol.rx.model.SummonerDto;
import org.dc.riot.lol.rx.model.TeamDto;

import rx.Observable;

/**
 * Basic organization structure for all Riot APIs
 * Created by Dc on 9/26/15.
 */
public interface RiotApi {
	
	public enum RateType {
		PERSONAL, SERVICE
	}
	
	public static String encodeName(String name) {
		return name.toLowerCase().replace(" ", "").trim();
	}
	
	public default Region[] getSupportedRegions() {
		Region[] regions = new Region[Region.values().length - 1];
		int i = 0;
		for (Region r : Region.values()) {
			if (r == Region.PUBLIC_BETA_ENVIRONMENT) {
				continue;
			}
			
			regions[i] = r;
			i++;
		}
		
		return regions;
	}
	
	public default RateType getRateType() {
		return RateType.PERSONAL;
	}
	
    /**
     * Not for stats. This API is more concerned with enabled, ranked, free to play, etc.
     */
    public interface Champion extends RiotApi {

        /**
         * /api/lol/{region}/v1.2/champion<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @return {@link ChampionListDto} same as <code>getChampions(false)</code>
         * @throws IOException
         */
        Observable<ChampionListDto> getChampions();

        /**
         * /api/lol/{region}/v1.2/champion<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param freeToPlay fetch only free to play champions
         * @return {@link ChampionListDto}
         * @throws IOException
         */
        Observable<ChampionListDto> getChampions(boolean freeToPlay);

        /**
         * /api/lol/{region}/v1.2/champion/{id}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param championId the champ id
         * @return {@link ChampionDto} single champion dto
         * @throws IOException
         */
        Observable<ChampionDto> getChampion(long championId);
    }

    /**
     * Spectator details
     */
    public interface CurrentGame extends RiotApi {

        /**
         * /observer-mode/rest/consumer/getSpectatorGameInfo/{platformId}/{summonerId}<br/>
         * <br/>
         * 403	Forbidden<br/>
         * 429	Rate limit exceeded
         *
         * @param region     the {@link Region}
         * @param summonerId summoner id number
         * @return {@link CurrentGameInfo} object
         * @throws IOException
         */
//        Observable<CurrentGameInfo> getSpectatorInfo(Region region, long summonerId);
    }

    /**
     * Gain access to the featured games that appear on the main client page
     */
    public interface FeaturedGames extends RiotApi {

        /**
         * /observer-mode/rest/featured<br/>
         * <br/>
         * 403	Forbidden<br/>
         * 429	Rate limit exceeded
         *
         * @return {@link FeaturedGames} object with all the featured games for the {@link Region}
         * queried against or <code>null</code> if some network error occurred
         * @throws IOException
         */
//        Observable<FeaturedGamesDto> getFeaturedGames(Region region);
    }

    /**
     * Get recent game data on specific players
     */
    public interface RecentGames extends RiotApi {

        /**
         * /api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  Game data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region     the {@link Region}
         * @param summonerId player's summoner ID, See the {@link Summoner} interface for valid IDs.
         * @return {@link RecentGamesDto} for the given player or <code>null</code> if no data found
         * @throws IOException
         */
//        Observable<RecentGamesDto> getRecentGames(Region region, long summonerId);
    }

    /**
     * Retrieves data about players' leagues. See {@link LeagueDto} and
     * {@link LeagueEntryDto}
     */
    public interface League extends RiotApi {

        /**
         * /api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  League data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region      the {@link Region}
         * @param summonerIds set of summoners to look up
         * @return a Map of summonerId Strings to List of {@link LeagueDto} objects or <code>null</code>
         * if nothing found
         * @throws IOException
         */
//        Observable<Map<String, LeagueDto[]>> getBySummonerEntry(Region region, long... summonerIds);

        /**
         * /api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  League data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region      the {@link Region}
         * @param summonerIds set of summoners to look up
         * @return a Map of summonerId Strings to List of {@link LeagueDto} objects or <code>null</code>
         * if nothing found
         * @throws IOException
         */
//        Observable<Map<String, LeagueDto[]>> getBySummoner(Region region, long... summonerIds);

        /**
         * /api/lol/{region}/v2.5/league/by-team/{teamIds}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  League data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region  the {@link Region}
         * @param teamIds set of teams to look up
         * @return a Map of teamId Strings to List of {@link LeagueDto} objects or <code>null</code>
         * if nothing found
         * @throws IOException
         */
//        Observable<Map<String, LeagueDto[]>> getByTeam(Region region, String... teamIds);

        /**
         * /api/lol/{region}/v2.5/league/by-team/{teamIds}/entry<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  League data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region  the {@link Region}
         * @param teamIds set of teams to look up
         * @return a Map of teamId Strings to List of {@link LeagueDto} objects or <code>null</code>
         * if nothing found
         * @throws IOException
         */
//        Observable<Map<String, LeagueDto[]>> getByTeamEntry(Region region, String... teamIds);

        /**
         * /api/lol/{region}/v2.5/league/challenger<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  League data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region the {@link Region}
         * @param queue  the queue type to search for
         * @return a {@link LeagueDto} object with data
         * @throws IOException
         */
//        Observable<LeagueDto> getChallenger(Region region, QueueType queue);

        /**
         * /api/lol/{region}/v2.5/league/master<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  League data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region the {@link Region}
         * @param queue  the queue type to search for
         * @return a {@link LeagueDto} object with data
         * @throws IOException
         */
//        Observable<LeagueDto> getMaster(Region region, QueueType queue);
    }

    /**
     * Static data on champion stats, items, gold, runes, masteries, etc. all served up on
     * a per patch basis
     */
    public interface StaticData extends RiotApi {
    	
    	@Override
    	public default Region[] getSupportedRegions() {
    		return Region.values();
    	}
    	
    	@Override
    	public default RateType getRateType() {
    		return RateType.SERVICE;
    	}

        /**
         * /api/lol/static-data/{region}/v1.2/champion<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region    the {@link Region}
         * @param version   patch to reference, <code>null</code> will use latest patch
         * @param locale    locale String (e.g. en_US) <code>null</code> will use default for region
         * @param champData Champ data tags to retrieve. Only id, key, name, and title are returned
         *                  by default if this parameter isn't specified, <code>null</code> is ok
         * @return a {@link ChampionDto} object with requested data filled in or <code>null</code>
         * if no champion could be found matching the given query
         * @throws IOException
         */
//        Observable<ChampionListDto> getChampions(Region region, String version, String locale, ChampDataTag... champData);

        /**
         * /api/lol/static-data/{region}/v1.2/champion/{id}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Champion not found, bad champId<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region    the {@link Region}
         * @param champId   the champion ID
         * @param version   patch to reference, <code>null</code> will use latest patch
         * @param locale    locale String (e.g. en_US) <code>null</code> will use default for region
         * @param champData Champ data tags to retrieve. Only id, key, name, and title are returned
         *                  by default if this parameter isn't specified, <code>null</code> is ok
         * @return a {@link ChampionDto} object with requested data filled in or <code>null</code>
         * if no champion could be found matching the given query
         * @throws IOException
         */
//        Observable<ChampionDto> getChampion(Region region, long champId, String version, String locale, ChampDataTag... champData);

        /**
         * /api/lol/static-data/{region}/v1.2/item<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region       the {@link Region}
         * @param version      patch to reference, <code>null</code> will use latest patch
         * @param locale       locale String (e.g. en_US) <code>null</code> will use default for region
         * @param itemListData Tags to return additional data. Only type, version, basic, data, id,
         *                     name, plaintext, group, and description are returned by default if
         *                     this parameter isn't specified. To return all additional data, use
         *                     the tag 'all'.
         * @return {@link ItemListDto} filled in
         * @throws IOException
         */
//        Observable<ItemListDto> getItems(Region region, String version, String locale, ItemListDataTag... itemListData);

        /**
         * /api/lol/static-data/{region}/v1.2/item/{id}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  Item id not found<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region   the {@link Region}
         * @param itemId   item id to fetch
         * @param version  patch to reference, <code>null</code> will use latest patch
         * @param locale   locale String (e.g. en_US) <code>null</code> will use default for region
         * @param itemData Tags to return additional data. Only id, name, plaintext, group, and
         *                 description are returned by default if this parameter isn't specified.
         *                 To return all additional data, use the tag 'all'.
         * @return {@link ItemListDto} filled in according to itemListData
         * @throws IOException
         */
//        Observable<ItemDto> getItem(Region region, long itemId, String version, String locale, ItemListDataTag... itemData);

        /**
         * /api/lol/static-data/{region}/v1.2/language-strings<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region  the {@link Region}
         * @param version patch to reference, <code>null</code> will use latest patch
         * @param locale  locale String (e.g. en_US) <code>null</code> will use default for region
         * @return {@link LanguageStringsDto}
         * @throws IOException
         */
//        Observable<LanguageStringsDto> getLanguageStrings(Region region, String version, String locale);

        /**
         * /api/lol/static-data/{region}/v1.2/languages<br/>
         * <br/>
         * Gets language strings<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region the {@link Region}
         * @return String array of all supported locales
         * @throws IOException
         */
//        Observable<String[]> getLocales(Region region);

        /**
         * /api/lol/static-data/{region}/v1.2/map<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region  the {@link Region}
         * @param version patch to reference, <code>null</code> will use latest patch
         * @param locale  locale String (e.g. en_US) <code>null</code> will use default for region
         * @return {@link MapDataDto} object
         * @throws IOException
         */
//        Observable<MapDataDto> getMap(Region region, String version, String locale);

        /**
         * /api/lol/static-data/{region}/v1.2/mastery<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region          the {@link Region}
         * @param version         patch to reference, <code>null</code> will use latest patch
         * @param locale          locale String (e.g. en_US) <code>null</code> will use default for region
         * @param masteryListData Tags to return additional data. Only type, version, data, id, name,
         *                        and description are returned by default if this parameter isn't
         *                        specified. To return all additional data, use the tag 'all'.
         * @return {@link MasteryListDto} filled in according to tags
         * @throws IOException
         */
//        Observable<MasteryListDto> getMasteries(Region region, String version, String locale, MasteryListDataTag... masteryListData);

        /**
         * /api/lol/static-data/{region}/v1.2/mastery/{id}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  Mastery data not found<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region      the {@link Region}
         * @param version     patch to reference, <code>null</code> will use latest patch
         * @param locale      locale String (e.g. en_US) <code>null</code> will use default for region
         * @param masteryData Tags to return additional data. Only id, name, and description are
         *                    returned by default if this parameter isn't specified. To return all
         *                    additional data, use the tag 'all'.
         * @return {@link MasteryListDto} filled in according to tags
         * @throws IOException
         */
//        Observable<MasteryDto> getMastery(Region region, long id, String version, String locale, MasteryDataTag... masteryData);

        /**
         * /api/lol/static-data/{region}/v1.2/realm<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region the {@link Region}
         * @return {@link RealmDto} object
         * @throws IOException
         */
//        Observable<RealmDto> getRealm(Region region);

        /**
         * /api/lol/static-data/na/v1.2/rune<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region       the {@link Region}
         * @param version      patch to reference, <code>null</code> will use latest patch
         * @param locale       locale String (e.g. en_US) <code>null</code> will use default for region
         * @param runeListData Tags to return additional data. Only type, version, data, id, name,
         *                     rune, and description are returned by default if this parameter isn't
         *                     specified. To return all additional data, use the tag 'all'.
         * @return {@link RuneListDto} object filled in according to tags
         * @throws IOException
         */
//        Observable<RuneListDto> getRunes(Region region, String version, String locale, RuneListDataTag... runeListData);

        /**
         * /api/lol/static-data/na/v1.2/rune/{id}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  Rune data not found<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region   the {@link Region}
         * @param id       rune id to query
         * @param version  patch to reference, <code>null</code> will use latest patch
         * @param locale   locale String (e.g. en_US) <code>null</code> will use default for region
         * @param runeData Tags to return additional data. Only id, name, rune, and description are
         *                 returned by default if this parameter isn't specified. To return all
         *                 additional data, use the tag 'ALL'.
         * @return {@link RuneListDto} object filled in according to tags
         * @throws IOException
         */
//        Observable<RuneDto> getRune(Region region, long id, String version, String locale, RuneDataTag... runeData);

        /**
         * /api/lol/static-data/{region}/v1.2/summoner-spell<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region    the {@link Region}
         * @param dataById  If specified as true, the returned data map will use the spells' IDs as
         *                  the keys. If not specified or specified as false,
         *                  the returned data map will use the spells' keys instead.
         * @param version   patch to reference, <code>null</code> will use latest patch
         * @param locale    locale String (e.g. en_US) <code>null</code> will use default for region
         * @param spellData Tags to return additional data. Only type, version, data, id, key, name,
         *                  description, and summonerLevel are returned by default if this parameter
         *                  isn't specified. To return all additional data, use the tag 'ALL'.
         * @return {@link SummonerSpellListDto} object filled in according to tags
         * @throws IOException
         */
//        Observable<SummonerSpellListDto> getSummonerSpells(Region region, boolean dataById, String version, String locale, SpellDataTag... spellData);

        /**
         * /api/lol/static-data/{region}/v1.2/summoner-spell/{id}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404  Summoner spell data not found<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region    the {@link Region}
         * @param id        summoner spell ID
         * @param version   patch to reference, <code>null</code> will use latest patch
         * @param locale    locale String (e.g. en_US) <code>null</code> will use default for region
         * @param spellData Tags to return additional data. Only type, version, data, id, key, name,
         *                  description, and summonerLevel are returned by default if this parameter
         *                  isn't specified. To return all additional data, use the tag 'ALL'.
         * @return {@link SummonerSpellDto} object filled in according to tags
         * @throws IOException
         */
//        Observable<SummonerSpellDto> getSummonerSpell(Region region, long id, String version, String locale, SpellDataTag... spellData);

        /**
         * /api/lol/static-data/{region}/v1.2/versions<br/>
         * <br/>
         * 401	Unauthorized<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @return String array with every patch arranged from newest at [0] to oldest
         * at [length - 1]
         * @throws IOException
         */
//        Observable<String[]> getVersions(Region region);
    }

    /**
     * Get statuses of servers. API calls to this endpoint
     * do not count against rate limit
     */
    public interface LolStatus extends RiotApi {

        /**
         * /shards<br/>
         * <br/>
         * Most useful for finding which locales are supported on which servers<br/>
         * <br/>
         * 403	Forbidden
         *
         * @return Array of {@link Shard} statuses
         * @throws IOException
         */
//        Observable<Shard[]> getShards(Region region);

        /**
         * /shards/{region}<br/>
         * <br/>
         * Get shard status. Returns the data available on the status.leagueoflegends.com website for the given region.<br/>
         * <br/>
         * 403	Forbidden
         *
         * @param region the {@link Region} to query against
         * @return a {@link ShardStatus} for the specified {@link Region}
         * @throws IOException
         */
//        Observable<ShardStatus> getShard(Region region);
    }

    /**
     * This interface is closely related to the {@link MatchList} interface. Retrieves very detailed
     * statistics for specified matches.
     */
    public interface Match extends RiotApi {

        /**
         * /api/lol/{region}/v2.2/match/{matchId}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Match not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region          the {@link Region}
         * @param matchId         see {@link MatchList} interface to get valid match IDs
         * @param includeTimeline Attempt to include timeline data. Not all matches have timeline
         *                        data associated with them.
         * @return a {@link MatchDetail}
         * @throws IOException
         */
//        Observable<MatchDetail> getMatch(Region region, long matchId, boolean includeTimeline);
    }

    /**
     * Interface to allow search of matches by Summoner ID. This interface is closely related
     * to the {@link Match} interface.
     */
    public interface MatchList extends RiotApi {

        /**
         * /api/lol/{region}/v2.2/matchlist/by-summoner/{summonerId}<br/>
         * <br/>
         * A number of optional parameters are provided for filtering.
         * It is up to the caller to ensure that the combination of filter parameters provided is
         * valid for the requested summoner, otherwise, no matches may be returned.
         * If either of the beginTime or endTime parameters is set, they must both be set,
         * although there is no maximum limit on their range. If the beginTime parameter is
         * specified on its own, endTime is assumed to be the current time.
         * If the endTime parameter is specified on its own, beginTime is assumed to be the start
         * of the summoner's match history.<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Game not found<br/>
         * 422	Summoner has an entry, but hasn't played since the start of 2013<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param summonerId   ID of summoner to search. See the {@link Summoner} interface for valid IDs.
         * @param championIds  Optional. ID(s) to search; <code>null</code> is ok.
         * @param rankedQueues Optional. Ranked queues to search.
         * @param seasons      Optional. Seasons to search.
         * @param beginTime    Optional. Specify -1 for no value.
         * @param endTime      Optional. Specify -1 for no value.
         * @param beginIndex   Optional. Specify -1 for no value.
         * @param endIndex     Optional. Specify -1 for no value.
         * @return {@link MatchListDto}
         * @throws IOException
         */
        Observable<MatchListDto> getMatchList(long summonerId, long[] championIds, RankedQueue[] rankedQueues, Season[] seasons, long beginTime, long endTime, int beginIndex, int endIndex);
    }

    public interface Stats extends RiotApi {

        /**
         * /api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param summonerId ID of summoner. See {@link Summoner} to fetch valid IDs.
         * @param season     Optional. Competitive {@link Season} to search.
         * @return a {@link RankedStatsDto} for the specified player.
         * @throws IOException
         */
        Observable<RankedStatsDto> getRanked(long summonerId, Season season);

        /**
         * /api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param summonerId ID of summoner. See {@link Summoner} to fetch valid IDs.
         * @param season     Optional. Competitive {@link Season} to search.
         * @return Full player stats summary.
         * @throws IOException
         */
        Observable<PlayerStatsSummaryListDto> getSummary(long summonerId, Season season);
    }

    /**
     * Interface for retrieving data on individual players.
     */
    public interface Summoner extends RiotApi {

        /**
         * /api/lol/{region}/v1.4/summoner/by-name/{summonerNames}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region        the {@link Region}
         * @param summonerNames array of String names
         * @return Map of encoded names (name with all lowercase and spaces trimmed) to
         * {@link SummonerDto}
         * @throws IOException
         */
        Observable<Map<String, SummonerDto>> getByNames(String... summonerNames);

        /**
         * /api/lol/{region}/v1.4/summoner/{summonerIds}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region      the {@link Region}
         * @param summonerIds List of long IDs
         * @return Map of summoner IDs mapped from longs to Strings
         * @throws IOException
         */
        Observable<Map<String, SummonerDto>> getByIds(long... summonerIds);

        /**
         * /api/lol/{region}/v1.4/summoner/{summonerIds}/masteries<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region      the {@link Region}
         * @param summonerIds List of long IDs
         * @return Map of summoner IDs mapped from longs to Strings
         * @throws IOException
         */
        Observable<Map<String, MasteryPagesDto>> getMasteries(long... summonerIds);

        /**
         * /api/lol/{region}/v1.4/summoner/{summonerIds}/name<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region      the {@link Region}
         * @param summonerIds List of long IDs
         * @return Map of summoner IDs mapped from longs to Strings
         * @throws IOException
         */
        Observable<Map<String, String>> getNames(long... summonerIds);

        /**
         * /api/lol/{region}/v1.4/summoner/{summonerIds}/runes<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region      the {@link Region}
         * @param summonerIds List of long IDs
         * @return Map of summoner IDs mapped from longs to Strings
         * @throws IOException
         */
        Observable<Map<String, RunePagesDto>> getRunes(long... summonerIds);
    }

    public interface Team extends RiotApi {

        /**
         * /api/lol/{region}/v2.4/team/by-summoner/{summonerIds}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Stats data not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param summonerIds List of summoner IDs to search. See {@link Summoner} to get valid
         *                    summoner IDs.
         * @return Map of stringified summonerIds to list of {@link TeamDto} objects that is the
         * collection of all teams of which that summoner is a member.
         * @throws IOException
         */
        Observable<Map<String, TeamDto[]>> getTeamsBySummoners(long... summonerIds);

        /**
         * /api/lol/{region}/v2.4/team/{teamIds}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 404	Team not found<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param teamIds List of team IDs. TODO document how to fetch team IDs
         * @return Map of team ID to {@link TeamDto} objects.
         * @throws IOException
         */
        Observable<Map<String, TeamDto>> getTeams(String... teamIds);
    }
}
