package org.dc.riot.lol.rx.service;

import java.io.IOException;
import java.util.Map;

import org.dc.riot.lol.rx.model.ChampionListDto;
import org.dc.riot.lol.rx.model.LeagueDto;
import org.dc.riot.lol.rx.model.LeagueEntryDto;
import org.dc.riot.lol.rx.model.MasteryPagesDto;
import org.dc.riot.lol.rx.model.Region;
import org.dc.riot.lol.rx.model.RunePagesDto;
import org.dc.riot.lol.rx.model.SummonerDto;

import rx.Observable;

/**
 * Basic organization structure for all Riot APIs
 * Created by Dc on 9/26/15.
 */
public interface RiotApi {

    /*
     * Subclasses may override this method to handle other response codes.<br/>
     * <br/>
     * 400	Bad request<br/>
     * 401	Unauthorized<br/>
     * 403  Forbidden<br/>
     * 429	Rate limit exceeded<br/>
     * 500	Internal server error<br/>
     * 503	Service unavailable
     *
     * @param response the {@link RiotApiResponse} to react to
     * @return the JSON response or <code>null</code> in the response code
     * couldn't be responded to
     */
//    protected String handleStandardResponse(RiotApiResponse response) {
//        int code = response.getStatus();
//        switch (code) {
//            case 200:
//                try {
//                    return response.getBody();
//                } catch (IOException e) {
//                    return null;
//                }
//            case 400:
//                throw new BadRequestException("Bad request");
//            case 401:
//                throw new UnauthorizedException("Probably forgot API key");
//            case 403:
//                throw new ForbiddenException("Forbidden");
//            case 429:
//                throw new RateExceededException("Endpoint reports rate exceeded");
//            case 500:
//                throw new InternalServerErrorException("Internal server error");
//            case 503:
//                throw new ServiceUnavailableException("Service unavailable");
//            default:
//                throw new UnhandledReponseCodeException("Unhandled response code: " + code);
//        }
//    }

    /**
     * Not for stats. This API is more concerned with enabled, ranked, free to play, etc.
     */
    public interface Champion {

        /**
         * /api/lol/{region}/v1.2/champion<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region the {@link Region}
         * @return {@link ChampionListDto} same as <code>getChampions(false)</code>
         * @throws IOException
         */
        ChampionListDto getChampions(Region region) throws IOException;

        /**
         * /api/lol/{region}/v1.2/champion<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region     the {@link Region}
         * @param freeToPlay fetch only free to play champions
         * @return {@link ChampionListDto}
         * @throws IOException
         */
//        RiotApiResponse<ChampionListDto> getChampions(Region region, boolean freeToPlay) throws IOException;

        /**
         * /api/lol/{region}/v1.2/champion/{id}<br/>
         * <br/>
         * 400	Bad request<br/>
         * 401	Unauthorized<br/>
         * 429	Rate limit exceeded<br/>
         * 500	Internal server error<br/>
         * 503	Service unavailable
         *
         * @param region     the {@link Region}
         * @param championId the champ id
         * @return {@link ChampionDto} single champion dto
         * @throws IOException
         */
//        RiotApiResponse<ChampionDto> getChampion(Region region, long championId) throws IOException;
    }

    /**
     * Spectator details
     */
    public interface CurrentGame {

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
//        RiotApiResponse<CurrentGameInfo> getSpectatorInfo(Region region, long summonerId) throws IOException;
    }

    /**
     * Gain access to the featured games that appear on the main client page
     */
    public interface FeaturedGames {

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
//        RiotApiResponse<FeaturedGamesDto> getFeaturedGames(Region region) throws IOException;
    }

    /**
     * Get recent game data on specific players
     */
    public interface RecentGames {

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
//        RiotApiResponse<RecentGamesDto> getRecentGames(Region region, long summonerId) throws IOException;
    }

    /**
     * Retrieves data about players' leagues. See {@link LeagueDto} and
     * {@link LeagueEntryDto}
     */
    public interface League {

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
//        RiotApiResponse<Map<String, LeagueDto[]>> getBySummonerEntry(Region region, long... summonerIds) throws IOException;

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
//        RiotApiResponse<Map<String, LeagueDto[]>> getBySummoner(Region region, long... summonerIds) throws IOException;

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
//        RiotApiResponse<Map<String, LeagueDto[]>> getByTeam(Region region, String... teamIds) throws IOException;

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
//        RiotApiResponse<Map<String, LeagueDto[]>> getByTeamEntry(Region region, String... teamIds) throws IOException;

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
//        RiotApiResponse<LeagueDto> getChallenger(Region region, QueueType queue) throws IOException;

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
//        RiotApiResponse<LeagueDto> getMaster(Region region, QueueType queue) throws IOException;
    }

    /**
     * Static data on champion stats, items, gold, runes, masteries, etc. all served up on
     * a per patch basis
     */
    public interface StaticData {

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
//        RiotApiResponse<ChampionListDto> getChampions(Region region, String version, String locale, ChampDataTag... champData) throws IOException;

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
//        RiotApiResponse<ChampionDto> getChampion(Region region, long champId, String version, String locale, ChampDataTag... champData) throws IOException;

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
//        RiotApiResponse<ItemListDto> getItems(Region region, String version, String locale, ItemListDataTag... itemListData) throws IOException;

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
//        RiotApiResponse<ItemDto> getItem(Region region, long itemId, String version, String locale, ItemListDataTag... itemData) throws IOException;

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
//        RiotApiResponse<LanguageStringsDto> getLanguageStrings(Region region, String version, String locale) throws IOException;

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
//        RiotApiResponse<String[]> getLocales(Region region) throws IOException;

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
//        RiotApiResponse<MapDataDto> getMap(Region region, String version, String locale) throws IOException;

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
//        RiotApiResponse<MasteryListDto> getMasteries(Region region, String version, String locale, MasteryListDataTag... masteryListData) throws IOException;

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
//        RiotApiResponse<MasteryDto> getMastery(Region region, long id, String version, String locale, MasteryDataTag... masteryData) throws IOException;

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
//        RiotApiResponse<RealmDto> getRealm(Region region) throws IOException;

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
//        RiotApiResponse<RuneListDto> getRunes(Region region, String version, String locale, RuneListDataTag... runeListData) throws IOException;

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
//        RiotApiResponse<RuneDto> getRune(Region region, long id, String version, String locale, RuneDataTag... runeData) throws IOException;

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
//        RiotApiResponse<SummonerSpellListDto> getSummonerSpells(Region region, boolean dataById, String version, String locale, SpellDataTag... spellData) throws IOException;

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
//        RiotApiResponse<SummonerSpellDto> getSummonerSpell(Region region, long id, String version, String locale, SpellDataTag... spellData) throws IOException;

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
//        RiotApiResponse<String[]> getVersions(Region region) throws IOException;
    }

    /**
     * Get statuses of servers. API calls to this endpoint
     * do not count against rate limit
     */
    public interface LolStatus {

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
//        RiotApiResponse<Shard[]> getShards(Region region) throws IOException;

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
//        RiotApiResponse<ShardStatus> getShard(Region region) throws IOException;
    }

    /**
     * This interface is closely related to the {@link MatchList} interface. Retrieves very detailed
     * statistics for specified matches.
     */
    public interface Match {

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
//        RiotApiResponse<MatchDetail> getMatch(Region region, long matchId, boolean includeTimeline) throws IOException;
    }

    /**
     * Interface to allow search of matches by Summoner ID. This interface is closely related
     * to the {@link Match} interface.
     */
    public interface MatchList {

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
         * @param region       the {@link Region}
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
//        RiotApiResponse<MatchListDto> getMatchList(Region region, long summonerId, long[] championIds, RankedQueue[] rankedQueues, Season[] seasons, long beginTime, long endTime, int beginIndex, int endIndex) throws IOException;
    }

    public interface Stats {

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
         * @param region     the {@link Region}
         * @param summonerId ID of summoner. See {@link Summoner} to fetch valid IDs.
         * @param region     the {@link Region}
         * @param season     Optional. Competitive {@link Season} to search.
         * @return a {@link RankedStatsDto} for the specified player.
         * @throws IOException
         */
//        RiotApiResponse<RankedStatsDto> getRanked(Region region, long summonerId, Season season) throws IOException;

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
         * @param region     the {@link Region}
         * @param summonerId ID of summoner. See {@link Summoner} to fetch valid IDs.
         * @param region     the {@link Region}
         * @param season     Optional. Competitive {@link Season} to search.
         * @return Full player stats summary.
         * @throws IOException
         */
//        RiotApiResponse<PlayerStatsSummaryListDto> getSummary(Region region, long summonerId, Season season) throws IOException;
    }

    /**
     * Interface for retrieving data on individual players.
     */
    public interface Summoner {

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

    public interface Team {

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
         * @param region      the {@link Region}
         * @param summonerIds List of summoner IDs to search. See {@link Summoner} to get valid
         *                    summoner IDs.
         * @return Map of stringified summonerIds to list of {@link TeamDto} objects that is the
         * collection of all teams of which that summoner is a member.
         * @throws IOException
         */
//        RiotApiResponse<Map<String, TeamDto[]>> getTeamsBySummoners(Region region, long... summonerIds) throws IOException;

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
         * @param region  the {@link Region}
         * @param teamIds List of team IDs. TODO document how to fetch team IDs
         * @return Map of team ID to {@link TeamDto} objects.
         * @throws IOException
         */
//        RiotApiResponse<Map<String, TeamDto>> getTeams(Region region, String... teamIds) throws IOException;
    }
}
