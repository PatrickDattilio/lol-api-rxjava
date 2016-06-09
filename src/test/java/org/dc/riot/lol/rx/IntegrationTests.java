package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.dc.riot.lol.rx.model.champion.ChampDto;
import org.dc.riot.lol.rx.model.champion.ChampListDto;
import org.dc.riot.lol.rx.model.championmastery.ChampionMasteryDto;
import org.dc.riot.lol.rx.model.common.BannedChampion;
import org.dc.riot.lol.rx.model.common.GameType;
import org.dc.riot.lol.rx.model.common.Mastery;
import org.dc.riot.lol.rx.model.common.Observer;
import org.dc.riot.lol.rx.model.common.QueueType;
import org.dc.riot.lol.rx.model.common.RankedQueue;
import org.dc.riot.lol.rx.model.common.Rune;
import org.dc.riot.lol.rx.model.common.Season;
import org.dc.riot.lol.rx.model.currentgame.CurrentGameInfo;
import org.dc.riot.lol.rx.model.currentgame.CurrentGameParticipant;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedGameInfo;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedGameParticipant;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedGamesDto;
import org.dc.riot.lol.rx.model.game.GameDto;
import org.dc.riot.lol.rx.model.game.PlayerDto;
import org.dc.riot.lol.rx.model.game.RawStatsDto;
import org.dc.riot.lol.rx.model.game.RecentGamesDto;
import org.dc.riot.lol.rx.model.league.LeagueDto;
import org.dc.riot.lol.rx.model.league.LeagueEntryDto;
import org.dc.riot.lol.rx.model.league.MiniSeriesDto;
import org.dc.riot.lol.rx.model.match.Event;
import org.dc.riot.lol.rx.model.match.Frame;
import org.dc.riot.lol.rx.model.match.MatchDetail;
import org.dc.riot.lol.rx.model.match.MatchListDto;
import org.dc.riot.lol.rx.model.match.MatchReference;
import org.dc.riot.lol.rx.model.match.Participant;
import org.dc.riot.lol.rx.model.match.ParticipantFrame;
import org.dc.riot.lol.rx.model.match.ParticipantIdentity;
import org.dc.riot.lol.rx.model.match.ParticipantStats;
import org.dc.riot.lol.rx.model.match.ParticipantTimeline;
import org.dc.riot.lol.rx.model.match.ParticipantTimelineData;
import org.dc.riot.lol.rx.model.match.Player;
import org.dc.riot.lol.rx.model.match.Position;
import org.dc.riot.lol.rx.model.match.Team;
import org.dc.riot.lol.rx.model.match.Timeline;
import org.dc.riot.lol.rx.model.staticdata.BasicDataDto;
import org.dc.riot.lol.rx.model.staticdata.BasicDataStatsDto;
import org.dc.riot.lol.rx.model.staticdata.BlockDto;
import org.dc.riot.lol.rx.model.staticdata.BlockItemDto;
import org.dc.riot.lol.rx.model.staticdata.ChampionDto;
import org.dc.riot.lol.rx.model.staticdata.ChampionListDto;
import org.dc.riot.lol.rx.model.staticdata.ChampionSpellDto;
import org.dc.riot.lol.rx.model.staticdata.GoldDto;
import org.dc.riot.lol.rx.model.staticdata.GroupDto;
import org.dc.riot.lol.rx.model.staticdata.ImageDto;
import org.dc.riot.lol.rx.model.staticdata.InfoDto;
import org.dc.riot.lol.rx.model.staticdata.ItemDto;
import org.dc.riot.lol.rx.model.staticdata.ItemListDto;
import org.dc.riot.lol.rx.model.staticdata.ItemTreeDto;
import org.dc.riot.lol.rx.model.staticdata.LanguageStringsDto;
import org.dc.riot.lol.rx.model.staticdata.LevelTipDto;
import org.dc.riot.lol.rx.model.staticdata.MapDataDto;
import org.dc.riot.lol.rx.model.staticdata.MapDetailsDto;
import org.dc.riot.lol.rx.model.staticdata.MasteryDto;
import org.dc.riot.lol.rx.model.staticdata.MasteryListDto;
import org.dc.riot.lol.rx.model.staticdata.MasteryTreeDto;
import org.dc.riot.lol.rx.model.staticdata.MasteryTreeItemDto;
import org.dc.riot.lol.rx.model.staticdata.MasteryTreeListDto;
import org.dc.riot.lol.rx.model.staticdata.MetaDataDto;
import org.dc.riot.lol.rx.model.staticdata.PassiveDto;
import org.dc.riot.lol.rx.model.staticdata.RangeDto;
import org.dc.riot.lol.rx.model.staticdata.RealmDto;
import org.dc.riot.lol.rx.model.staticdata.RecommendedDto;
import org.dc.riot.lol.rx.model.staticdata.RuneDto;
import org.dc.riot.lol.rx.model.staticdata.RuneListDto;
import org.dc.riot.lol.rx.model.staticdata.SkinDto;
import org.dc.riot.lol.rx.model.staticdata.SpellVarsDto;
import org.dc.riot.lol.rx.model.staticdata.StatsDto;
import org.dc.riot.lol.rx.model.staticdata.SummonerSpellDto;
import org.dc.riot.lol.rx.model.staticdata.SummonerSpellListDto;
import org.dc.riot.lol.rx.model.stats.AggregatedStatsDto;
import org.dc.riot.lol.rx.model.stats.ChampionStatsDto;
import org.dc.riot.lol.rx.model.stats.PlayerStatsSummaryDto;
import org.dc.riot.lol.rx.model.stats.PlayerStatsSummaryListDto;
import org.dc.riot.lol.rx.model.stats.RankedStatsDto;
import org.dc.riot.lol.rx.model.status.Incident;
import org.dc.riot.lol.rx.model.status.Message;
import org.dc.riot.lol.rx.model.status.Service;
import org.dc.riot.lol.rx.model.status.Shard;
import org.dc.riot.lol.rx.model.status.ShardStatus;
import org.dc.riot.lol.rx.model.status.Translation;
import org.dc.riot.lol.rx.model.summoner.MasteryPageDto;
import org.dc.riot.lol.rx.model.summoner.MasteryPagesDto;
import org.dc.riot.lol.rx.model.summoner.RunePageDto;
import org.dc.riot.lol.rx.model.summoner.RunePagesDto;
import org.dc.riot.lol.rx.model.summoner.RuneSlotDto;
import org.dc.riot.lol.rx.model.summoner.SummonerDto;
import org.dc.riot.lol.rx.model.team.MatchHistorySummaryDto;
import org.dc.riot.lol.rx.model.team.RosterDto;
import org.dc.riot.lol.rx.model.team.TeamDto;
import org.dc.riot.lol.rx.model.team.TeamMemberInfoDto;
import org.dc.riot.lol.rx.model.team.TeamStatDetailDto;
import org.dc.riot.lol.rx.service.ApiKey;
import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.Regions;
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.interfaces.ApiFactory;
import org.dc.riot.lol.rx.service.request.ChampDataTag;
import org.dc.riot.lol.rx.service.request.ChampListDataTag;
import org.dc.riot.lol.rx.service.request.ItemDataTag;
import org.dc.riot.lol.rx.service.request.ItemListDataTag;
import org.dc.riot.lol.rx.service.request.MasteryDataTag;
import org.dc.riot.lol.rx.service.request.MasteryListDataTag;
import org.dc.riot.lol.rx.service.request.RuneDataTag;
import org.dc.riot.lol.rx.service.request.RuneListDataTag;
import org.dc.riot.lol.rx.service.request.SpellDataTag;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;

public class IntegrationTests {

	private static final RESTFieldRegister register = new RESTFieldRegister();

	private static final String[] names = { "HuskarDc","Ctrl Alt Dc","Nightblue3","TheOddOne","C9 Meteos","C9 TOXIC MID","C9 TOXIC JUNGLE","C9 StealthBomber","CHATSPAMKAPPA123" };
	private static final Region region = Regions.getByCode("NA");

	private static RiotApi.Summoner summonerInterface = null;
	private static RiotApi.StaticData staticInterface = null;
	private static RiotApi.LolStatus statusInterface = null;
	private static RiotApi.Champion championInterface = null;
	private static RiotApi.ChampionMastery masteryInterface = null;
	private static RiotApi.CurrentGame currentGameInterface = null;
	private static RiotApi.FeaturedGames featuredGameInterface = null;
	private static RiotApi.League leagueInterface = null;
	private static RiotApi.Match matchInterface = null;
	private static RiotApi.MatchList matchlistInterface = null;
	private static RiotApi.RecentGames recentGameInterface = null;
	private static RiotApi.Stats statsInterface = null;
	private static RiotApi.Team teamInterface = null;

	private static TestPrints prints = TestPrints.getInstance();
	private static ApiFactory factory = null;
	
	private static boolean testChampionRan = false;
	private static boolean testChampionMasteryRan = false;
	private static boolean testCurrentGameRan, somebodyInCurrentGame = false;	// these fields are related
	private static boolean testFeaturedGamesRan = false;
	private static boolean testRecentGameRan = false;
	private static boolean testLeagueRan = false;
	private static boolean testStaticDataRan = false;
	private static boolean testStatusRan = false;
	private static boolean testMatchRan = false;
	private static boolean testMatchListRan = false;
	private static boolean testStatsRan = false;
	private static boolean testSummonerRan = false;
	private static boolean testTeamRan = false;

	@BeforeClass
	public static void setup() throws FileNotFoundException {

		final ApiKey apiKey = ApiKey.loadApiKeys()[0];
		factory = ApiFactory.newDefaultFactory(apiKey);

		summonerInterface = factory.newSummonerInterface(region, true);
		staticInterface = factory.newStaticDataInterface(region, true);
		statusInterface = factory.newStatusInterface(Regions.getByCode("EUW"), true);	// EUW has more incidents and languages and stuff
		championInterface = factory.newChampionInterface(region, true);
		currentGameInterface = factory.newCurrentGameInterface(region, true);
		featuredGameInterface = factory.newFeaturedGamesInterface(region, true);
		leagueInterface = factory.newLeagueInterface(region, true);
		teamInterface = factory.newTeamInterface(region, true);
		matchInterface = factory.newMatchInterface(region, true);
		matchlistInterface = factory.newMatchListInterface(region, true);
		masteryInterface = factory.newChampionMasteryInterface(region, true);
		recentGameInterface = factory.newRecentGamesInterface(region, true);
		statsInterface = factory.newStatsInterface(region, true);
	}
	
	@Test
	public void testRegister() throws IllegalArgumentException, IllegalAccessException {
		prints.println("Testing TEST REGISTER");
		RESTFieldRegister testRegister = new RESTFieldRegister();

		TestPojo p1 = new TestPojo()
				.withDouble(new Double(3.14));

		testRegister.registerInstance(p1);
		prints.println("p1 " + testRegister);
		assertNotNull(testRegister.testClass(TestPojo.class));
		
		p1.withInteger(new Integer(42));

		testRegister.registerInstance(p1);
		prints.println("p1 " + testRegister);
		assertNotNull(testRegister.testClass(TestPojo.class));
		
		TestPojo p2 = new TestPojo()
				.withDouble(new Double(Math.E))
				.withLong(new Long(5))
				.withString("Some string");
		
		testRegister.registerInstance(p2);
		prints.println("p2 " + testRegister);
		assertNotNull(testRegister.testClass(TestPojo.class));
		
		TestPojo p3 = new TestPojo()
				.withObject(new Object());
		
		testRegister.registerInstance(p3);
		prints.println("p3 " + testRegister);
		assertNull(testRegister.testClass(TestPojo.class));
		
		TestPojo p4 = new TestPojo()
				.withDouble(new Double(Math.PI))
				.withInteger(new Integer(4))
				.withObject(new Object())
				.withString("Should still pass");
		
		testRegister.registerInstance(p4);
		prints.println("p4 " + testRegister);
		assertNull(testRegister.testClass(TestPojo.class));
		
		System.out.println();
		System.out.println();
	}
	
	@Ignore
	@Test
	public void testSpecificResources() throws IOException, HttpException {
		File resourceDirectory = new File("./src/test/resources/");
		
		File outputFile = new File(resourceDirectory, "out.log");
		FileWriter writer = new FileWriter(outputFile);
		
		// static-items.json
		File staticItemsJson = new File(resourceDirectory, "static-items.json");
		FileReader reader = new FileReader(staticItemsJson);
		CharBuffer buffer = CharBuffer.allocate((int)staticItemsJson.length());
		prints.println(reader.read(buffer));
		buffer.rewind();
		String json = buffer.toString().trim();
		reader.close();
		
		writer.write(json);
		Gson gson = new Gson();
		ItemListDto itemListDto = gson.fromJson(json, ItemListDto.class);
		assertNotNull(itemListDto);
		assertTrue(itemListDto.getGroups().length > 0);
		assertTrue(GroupDto.getInstanceCount() > 0);
		
		itemListDto = ApiFactory.getGson().fromJson(json, ItemListDto.class);
		assertNotNull(itemListDto);
		assertTrue(itemListDto.getGroups().length > 0);
		assertTrue(GroupDto.getInstanceCount() > 0);
		
		itemListDto = staticInterface.getItems(null, null, ItemListDataTag.ALL);
		String json1 = gson.toJson(itemListDto).trim();
		writer.write("\n");
		writer.write(json1);
		writer.close();
		assertTrue(json1.equals(json));
		
		prints.println(null);
		prints.println(null);
	}
	
	@Test
	public void testStats() throws IOException {
		testStatsRan = true;
		try {
			prints.println("Testing STATS interface");

			Map<String,SummonerDto> summoners = summonerInterface.getByNames(names);
			for (SummonerDto summonerDto : summoners.values()) {
				long summonerId = summonerDto.getId();
				assertTrue(summonerId > 0);
				RankedStatsDto rankedDto = statsInterface.getRanked(summonerId, null);
				assertNotNull(rankedDto);
				testRankedStatsDto(rankedDto);

				rankedDto = statsInterface.getRanked(summonerId, Season.SEASON2016);
				assertNotNull(rankedDto);
				testRankedStatsDto(rankedDto);

				PlayerStatsSummaryListDto summaryDto = statsInterface.getSummary(summonerId, null);
				assertNotNull(summaryDto);
				testSummaryDto(summaryDto);
				
				summaryDto = statsInterface.getSummary(summonerId, Season.SEASON2015);
				assertNotNull(summaryDto);
				testSummaryDto(summaryDto);
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}		
	}
	
	private void testSummaryDto(PlayerStatsSummaryListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getSummonerId() > 0);
		PlayerStatsSummaryDto[] listDto = dto.getPlayerStatSummaries();
		if (listDto.length == 0) {
			prints.println("WARNING", "Empty player stats summaries");
		}

		for (PlayerStatsSummaryDto statDto : listDto) {
			testPlayerStatSummaryDto(statDto);
		}
	}
	
	private void testPlayerStatSummaryDto(PlayerStatsSummaryDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getPlayerStatSummaryType());
		AggregatedStatsDto aggDto = dto.getAggregatedStats();
		assertNotNull(aggDto);
		testAggregatedStatsDto(aggDto);
	}
	
	private void testAggregatedStatsDto(AggregatedStatsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void testRankedStatsDto(RankedStatsDto dto) {
		if (dto.getSummonerId() > 0) {	// avoid checking on our unranked friends
			try {
				register.registerInstance(dto);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

			assertTrue(dto.getModifyDate() > 0);

			ChampionStatsDto[] champDto = dto.getChampions();
			for (ChampionStatsDto championDto : champDto) {
				testChampionStatsDto(championDto);
			}
		}
	}
	
	private void testChampionStatsDto(ChampionStatsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		AggregatedStatsDto aggDto = dto.getStats();
		assertNotNull(aggDto);
		testAggregatedStatsDto(aggDto);
	}
	
	@Test
	public void testRecentGame() throws IOException {
		testRecentGameRan = true;
		try {
			prints.println("Testing RECENT GAME interface");
			Map<String,SummonerDto> summoners = summonerInterface.getByNames(names);
			for (SummonerDto summonerDto : summoners.values()) {
				long summonerId = summonerDto.getId();
				assertTrue(summonerId > 0);
				RecentGamesDto recentDto = recentGameInterface.getRecentGames(summonerId);
				assertNotNull(recentDto);
				testRecentDto(recentDto);
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}	
	}
	
	private void testRecentDto(RecentGamesDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getSummonerId() > 0);
		GameDto[] gamesDto = dto.getGames();
		assertTrue(gamesDto.length > 0);
		for (GameDto gameDto : gamesDto) {
			assertNotNull(gameDto);
			testGameDto(gameDto);
		}
	}
	
	private void testGameDto(GameDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getChampionId() > 0);
		assertTrue(dto.getCreateDate() > 0);
		assertTrue(dto.getGameId() > 0);
		assertNotNull(dto.getGameMode());
		assertNotNull(dto.getGameType());
		assertTrue(dto.getMapId() > 0);
//		if (dto.getGameType() != GameType.CUSTOM_GAME) {
//			assertTrue(dto.getIpEarned() > 0);
//		}
		assertTrue(dto.getLevel() > 0);
		assertTrue(dto.getSpell1() > 0);
		assertTrue(dto.getSpell2() > 0);
		assertTrue(dto.getTeamId() > 0);

		if (dto.getGameType() == GameType.MATCHED_GAME) {
			PlayerDto[] playersDto = dto.getFellowPlayers();
			assertTrue(playersDto.length > 0);
			for (PlayerDto playerDto : playersDto) {
				assertNotNull(playerDto);
				testPlayerDto(playerDto);
			}
		}

		RawStatsDto rawStatsDto = dto.getStats();
		assertNotNull(rawStatsDto);
		testRawStatsDto(rawStatsDto);
	}
	
	private void testPlayerDto(PlayerDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getChampionId() > 0);
		assertTrue(dto.getSummonerId() > 0);
		assertTrue(dto.getTeamId() > 0);
	}
	
	private void testRawStatsDto(RawStatsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getLevel() > 0);
	}

	@Test
	public void testChampionMastery() throws IOException {
		testChampionMasteryRan = true;
		try {
			prints.println("INFO", "Testing CHAMPION MASTERY interface");

			Map<String,SummonerDto> summonerMapDto = summonerInterface.getByNames(names);
			boolean playedXin = false;
			for (SummonerDto summonerDto : summonerMapDto.values()) {
				long summonerId = summonerDto.getId();
				prints.println("INFO",summonerDto.getName() + " : " + summonerId);
				assertTrue(masteryInterface.getMasteryScore(summonerId) > 0);

				// I expect that this returns only champions that have actually been played
				ChampionMasteryDto[] allMastery = masteryInterface.getPlayerAllMastery(summonerId);
				assertNotNull(allMastery);
				for (ChampionMasteryDto championMasteryDto : allMastery) {
					assertNotNull(championMasteryDto);
					testChampionMasteryDto(championMasteryDto);
				}

				ChampionMasteryDto[] topN = masteryInterface.getTopChampions(summonerId, 6);
				assertNotNull(topN);
				for (ChampionMasteryDto cm : topN) {
					testChampionMasteryDto(cm);
				}

				ChampionMasteryDto champDto = masteryInterface.getPlayerChampionMastery(summonerId, 5);	// 5 is Xin Zhao
				if (champDto != null) {
					playedXin = true;
					testChampionMasteryDto(champDto);
				}
			}
			
			assertTrue(playedXin);
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	private void testChampionMasteryDto(ChampionMasteryDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getChampionId() > 0);
		assertTrue(dto.getChampionLevel() > 0);
		assertTrue(dto.getChampionPoints() > 0);
		assertTrue(dto.getLastPlayTime() > 0);
		assertTrue(dto.getPlayerId() > 0);
	}

	@Test
	public void testMatchAndMatchlist() throws IOException {
		testMatchListRan = testMatchRan = true;
		try {
			prints.println("Testing MATCH interface");

			Map<String,SummonerDto> summonerMapDto = summonerInterface.getByNames("HuskarDc");
			SummonerDto summonerDto = summonerMapDto.get("huskardc");
			long summonerId = summonerDto.getId();
			MatchListDto matchListDto = matchlistInterface.getMatchList(summonerId, null, new RankedQueue[] {RankedQueue.RANKED_SOLO_5x5}, new Season[] {Season.SEASON2016}, -1, -1,  -1,  -1);
			assertNotNull(matchListDto);
			testMatchListDto(matchListDto);

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2016);
			cal.set(Calendar.MONTH, Calendar.JANUARY);

			cal.set(Calendar.DAY_OF_MONTH, 1);
			long beginTime = cal.getTimeInMillis();

			cal.set(Calendar.DAY_OF_MONTH, 19);
			long endTime = cal.getTimeInMillis();

			long[] championIds = new long[] { 5, 245 };	// Xin Zhao, Ekko
			MatchListDto boundedListDto = matchlistInterface.getMatchList(summonerId, championIds, null, null, beginTime, endTime, 0, 5);
			assertNotNull(boundedListDto);
			testMatchListDto(boundedListDto);

			for (MatchReference matchReference : boundedListDto.getMatches()) {
				long matchId = matchReference.getMatchId();
				prints.println("INFO", "Match ID: " + matchId);
				boolean includeTimeline = true;
				MatchDetail noTimelineDetail = matchInterface.getMatch(matchId, includeTimeline);
				assertNotNull(noTimelineDetail);
				testMatchDetail(noTimelineDetail, includeTimeline);
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	private void testMatchDetail(MatchDetail dto, boolean timeLine) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getMapId() > 0);
		assertTrue(dto.getMatchCreation() > 0);
		assertTrue(dto.getMatchDuration() > 0);
		assertTrue(dto.getMatchId() > 0);
		assertNotNull(dto.getMatchMode());
		assertNotNull(dto.getMatchType());
		assertNotNull(dto.getMatchVersion());
		assertNotNull(dto.getParticipantIdentities());
		ParticipantIdentity[] participantIdentityList = dto.getParticipantIdentities();
		assertNotNull(participantIdentityList);
		for (ParticipantIdentity participantIdentity : participantIdentityList) {
			assertNotNull(participantIdentity);
			testParticipantIdentity(participantIdentity);
		}

		Participant[] participants = dto.getParticipants();
		assertNotNull(participants);
		for (Participant mp : participants) {
			testMatchParticipant(mp, timeLine);
		}

		assertNotNull(dto.getPlatformId());
//		assertNotNull(dto.getQueueType());
		assertNotNull(dto.getRegion());
		assertNotNull(dto.getSeason());

		assertNotNull(dto.getTeams());
		for (Team mt : dto.getTeams()) {
			testTeams(mt);
		}

		if (timeLine) {
			assertNotNull(dto.getTimeline());
			testTimeline(dto.getTimeline());
		}
	}

	private void testTeams(Team dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getTeamId() > 0);
	}

	private void testMatchParticipant(Participant dto, boolean expectTimeline) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getChampionId() > 0);
		assertNotNull(dto.getHighestAchievedSeasonTier());
		assertTrue(dto.getParticipantId() > 0);
		assertTrue(dto.getSpell1Id() > 0);
		assertTrue(dto.getSpell2Id() > 0);

		Rune[] runeListDto = dto.getRunes();
		for (Rune rune : runeListDto) {
			assertNotNull(rune);
			testRune(rune);
		}

		ParticipantStats matchParticipantStats = dto.getStats();
		assertNotNull(matchParticipantStats);
		testParticipantStats(matchParticipantStats);

		assertTrue(dto.getTeamId() > 0);

		if (expectTimeline) {
			ParticipantTimeline timeline = dto.getTimeline();
			assertNotNull(timeline);
			testParticipantTimeline(timeline);
		}
	}

	private void testParticipantIdentity(ParticipantIdentity dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getParticipantId() > 0);

		Player player = dto.getPlayer();
		assertNotNull(player);
		testPlayer(player);
	}
	
	private void testPlayer(Player dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getProfileIcon() >= 0);
		assertTrue(dto.getSummonerId() > 0);
		assertNotNull(dto.getSummonerName());
		assertNotNull(dto.getMatchHistoryUri());
	}

	private void testTimeline(Timeline dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getFrameInterval() > 0);
		Frame[] frames = dto.getFrames();
		assertTrue(frames.length > 0);
		boolean firstFrame = true;
		for (Frame f : frames) {
			testFrame(f, firstFrame);
			firstFrame = false;
		}
	}
	
	private void testFrame(Frame dto, boolean firstFrame) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		if (!firstFrame) {
			assertTrue(dto.getTimestamp() > 0);
		}

		Event[] events = dto.getEvents();
		assertNotNull(events);
		for (Event e : events) {
			testEvent(e);
		}

		Map<String, ParticipantFrame> frames = dto.getParticipantFrames();
		assertNotNull(frames);
		for (String k : frames.keySet()) {
			ParticipantFrame participantFrame = frames.get(k);
			assertNotNull(participantFrame);
			testParticipantFrame(participantFrame);
		}
	}
	
	private void testEvent(Event dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getEventType());
		assertTrue(	dto.getTimestamp() > 0);
	}
	
	private void testParticipantFrame(ParticipantFrame dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getLevel() > 0);
		assertTrue(dto.getParticipantId() > 0);
		Position position = dto.getPosition();
		if (position != null) {
			testPosition(position);
		}
	}
	
	private void testPosition(Position dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void testMatchListDto(MatchListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getTotalGames() > 0);
		MatchReference[] matchReferenceListsDto = dto.getMatches();
		for (MatchReference matchReference : matchReferenceListsDto) {
			assertNotNull(matchReference);
			testMatchReference(matchReference);
		}
	}

	private void testMatchReference(MatchReference dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getChampion() > 0);
		assertTrue(dto.getMatchId() > 0);
		assertTrue(dto.getTimestamp() > 0);
		assertNotNull(dto.getLane());
		assertNotNull(dto.getPlatformId());
//		assertNotNull(dto.getQueue());
		assertNotNull(dto.getRegion());
		assertNotNull(dto.getRole());
		assertNotNull(dto.getSeason());
	}

	private void testParticipantStats(ParticipantStats dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getTotalDamageDealt() > 0);
	}

	private void testParticipantTimeline(ParticipantTimeline dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		

		if (dto.getAncientGolemAssistsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getAncientGolemAssistsPerMinCounts());
		}
		if (dto.getAncientGolemKillsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getAncientGolemKillsPerMinCounts());
		}
		if (dto.getAssistedLaneDeathsPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getAssistedLaneDeathsPerMinDeltas());
		}
		if (dto.getAssistedLaneKillsPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getAssistedLaneKillsPerMinDeltas());
		}
		if (dto.getBaronAssistsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getBaronAssistsPerMinCounts());
		}
		if (dto.getBaronKillsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getBaronKillsPerMinCounts());
		}
		if (dto.getCreepsPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getCreepsPerMinDeltas());
		}
		if (dto.getCsDiffPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getCsDiffPerMinDeltas());
		}
		if (dto.getDamageTakenDiffPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getDamageTakenDiffPerMinDeltas());
		}
		if (dto.getDamageTakenPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getDamageTakenPerMinDeltas());
		}
		if (dto.getDragonAssistsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getDragonAssistsPerMinCounts());
		}
		if (dto.getDragonKillsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getDragonKillsPerMinCounts());
		}
		if (dto.getElderLizardAssistsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getElderLizardAssistsPerMinCounts());
		}
		if (dto.getElderLizardKillsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getElderLizardKillsPerMinCounts());
		}
		if (dto.getGoldPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getGoldPerMinDeltas());
		}
		if (dto.getInhibitorAssistsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getInhibitorAssistsPerMinCounts());
		}
		if (dto.getInhibitorKillsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getInhibitorKillsPerMinCounts());
		}
		assertNotNull(dto.getLane());
		assertNotNull(dto.getRole());
		if (dto.getTowerAssistsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getTowerAssistsPerMinCounts());
		}
		if (dto.getTowerKillsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getTowerKillsPerMinCounts());
		}
		if (dto.getTowerKillsPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getTowerKillsPerMinDeltas());
		}
		if (dto.getVilemawAssistsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getVilemawAssistsPerMinCounts());
		}
		if (dto.getVilemawKillsPerMinCounts() != null) {
			testParticipantTimelineData(dto.getVilemawKillsPerMinCounts());
		}
		if (dto.getWardsPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getWardsPerMinDeltas());
		}
		if (dto.getXpDiffPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getXpDiffPerMinDeltas());
		}
		if (dto.getXpPerMinDeltas() != null) {
			testParticipantTimelineData(dto.getXpPerMinDeltas());
		}
	}
	
	private void testParticipantTimelineData(ParticipantTimelineData dto) {
		assertNotNull(dto);
		
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTeam() throws IOException {
		testTeamRan = true;
		try {
			prints.println("Testing TEAM interface");
			Map<String,SummonerDto> summonersDto = summonerInterface.getByNames(names);
			long[] summonerIds = getSummonerIds(summonersDto);
			Map<String,TeamDto[]> summonerTeams = teamInterface.getTeamsBySummoners(summonerIds);
			for (String key : summonerTeams.keySet()) {
				TeamDto[] teamsDto = summonerTeams.get(key);
				for (TeamDto teamDto : teamsDto) {
					assertNotNull(teamDto);
					testTeamDto(teamDto);
				}
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	private void testTeamDto(TeamDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getCreateDate() > 0);
		assertTrue(dto.getLastJoinDate() > 0);
		assertTrue(dto.getLastGameDate() > 0);
		assertTrue(dto.getLastJoinedRankedTeamQueueDate() > 0);
		assertTrue(dto.getModifyDate() > 0);
		assertTrue(dto.getSecondLastJoinDate() > 0);
		assertNotNull(dto.getThirdLastJoinDate() > 0);
		assertNotNull(dto.getStatus());
		assertNotNull(dto.getName());
		assertNotNull(dto.getFullId());

		MatchHistorySummaryDto[] matchHistory = dto.getMatchHistory();
		for (MatchHistorySummaryDto mhDto : matchHistory) {
			testMatchHistorySummaryDto(mhDto);
		}

		RosterDto rosterDto = dto.getRoster();
		assertNotNull(rosterDto);
		testRosterDto(rosterDto);

		TeamStatDetailDto[] teamStatDetails = dto.getTeamStatDetails();
		for (TeamStatDetailDto teamStatDto : teamStatDetails) {
			testTeamStatDetailDto(teamStatDto);
		}
	}

	private void testTeamStatDetailDto(TeamStatDetailDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getTeamStatType());
	}

	private void testRosterDto(RosterDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getOwnerId() > 0);
		TeamMemberInfoDto[] teamMembersDto = dto.getMemberList();
		assertTrue(teamMembersDto.length > 0);
		for (TeamMemberInfoDto teamMember : teamMembersDto) {
			testTeamMemberInfoDto(teamMember);
		}
	}

	private void testTeamMemberInfoDto(TeamMemberInfoDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getInviteDate() > 0);
		assertTrue(dto.getPlayerId() > 0);
		assertNotNull(dto.getStatus());
	}

	private void testMatchHistorySummaryDto(MatchHistorySummaryDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getGameId() > 0);
		assertTrue(dto.getMapId() > 0);
		assertTrue(dto.getDate() > 0);
		assertNotNull(dto.getGameMode());
		assertNotNull(dto.getOpposingTeamName());
	}

	@Test
	public void testLeague() throws IOException {
		testLeagueRan = true;
		try {
			for (QueueType.ChallengerMaster qt : QueueType.ChallengerMaster.values()) {
				LeagueDto dto = leagueInterface.getChallenger(qt);
				if (dto != null) {
					testLeagueDto(dto);
				}
			}

			for (QueueType.ChallengerMaster qt : QueueType.ChallengerMaster.values()) {
				LeagueDto dto = leagueInterface.getMaster(qt);
				if (dto != null) {
					testLeagueDto(dto);
				}
			}

			Map<String,SummonerDto> summonersDto = summonerInterface.getByNames(names);
			long[] summonerIds = getSummonerIds(summonersDto);

			Map<String,LeagueDto[]> summonerLeagues = leagueInterface.getBySummoners(summonerIds);
			Map<String,String> summonerNames = summonerInterface.getNames(summonerIds);
			for (String key : summonerLeagues.keySet()) {
				prints.println("League for " + summonerNames.get(key));

				LeagueDto[] dtoArray = summonerLeagues.get(key);
				for (LeagueDto dto : dtoArray) {
					testLeagueDto(dto);
				}
			}

			Map<String,TeamDto[]> teamsDto = teamInterface.getTeamsBySummoners(summonerIds);
			ArrayList<String> unboundedIds = new ArrayList<>();
			for (TeamDto[] teamList : teamsDto.values()) {
				for (TeamDto tDto : teamList) {
					unboundedIds.add(tDto.getFullId());
					if (unboundedIds.size() == 10) {
						break;
					}
				}

				if (unboundedIds.size() == 10) {
					break;
				}
			}

			String[] teamIds = unboundedIds.toArray(new String[unboundedIds.size()]);

			try {
				Map<String,LeagueDto[]> teamLeagues = leagueInterface.getByTeams(teamIds);
				assertNotNull(teamLeagues);
				for (LeagueDto[] leagueList : teamLeagues.values()) {
					for (LeagueDto dto : leagueList) {
						testLeagueDto(dto);
					}
				}
			} catch (HttpException e) {
				if (e.getCode() == 404) {
					prints.println("WARNING", "Dynamic queue makes leagueInterface.getByTeams obsolete for now");
				} else {
					throw e;
				}
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				e.printStackTrace();
				fail(e.getCode() + " " + e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	private void testLeagueDto(LeagueDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getQueue());
		assertNotNull(dto.getTier());
		assertNotNull(dto.getName());

		LeagueEntryDto[] leagueEntryListDto = dto.getEntries();
		for (LeagueEntryDto leagueEntryDto : leagueEntryListDto) {
			assertNotNull(leagueEntryDto);
			testLeagueEntryDto(leagueEntryDto);
		}
	}
	
	private void testLeagueEntryDto(LeagueEntryDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getDivision());
		assertTrue(dto.getLeaguePoints() >= 0);
		assertTrue(dto.getLosses() >= 0);
		assertTrue(dto.getWins() >= 0);
		
		MiniSeriesDto miniSeriesDto = dto.getMiniSeries();
		if (miniSeriesDto != null) {
			testMiniSeriesDto(miniSeriesDto);
		}
	}
	
	private void testMiniSeriesDto(MiniSeriesDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getLosses() >= 0);
		assertTrue(dto.getWins() >= 0);
		assertTrue(dto.getTarget() > 0);
	}

	@Test
	public void testFeaturedGame() throws IOException {
		testFeaturedGamesRan = true;
		try {
			prints.println("Testing FEATURED GAMES interface");

			FeaturedGamesDto featuredGamesDto = featuredGameInterface.getFeaturedGames();
			assertNotNull(featuredGamesDto);
			testFeaturedGamesDto(featuredGamesDto);
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}
	
	private void testFeaturedGamesDto(FeaturedGamesDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getClientRefreshInterval() > 0);
		FeaturedGameInfo[] featuredGameInfoListDto = dto.getGameList();
		assertTrue(featuredGameInfoListDto.length > 0);
		for (FeaturedGameInfo featuredGameInfoDto : featuredGameInfoListDto) {
			assertNotNull(featuredGameInfoDto);
			testFeaturedGameInfo(featuredGameInfoDto);
		}
	}
	
	private void testFeaturedGameInfo(FeaturedGameInfo dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getGameId() > 0);
		assertTrue(dto.getGameLength() >= 0);
		assertTrue(dto.getGameQueueConfigId() > 0);
		assertTrue(dto.getGameStartTime() > 0);
		assertTrue(dto.getMapId() > 0);
		assertNotNull(dto.getGameType());
		assertNotNull(dto.getGameMode());
		assertNotNull(dto.getPlatformId());
		
		Observer observersDto = dto.getObservers();
		assertNotNull(observersDto);
		testObserver(observersDto);
		
		FeaturedGameParticipant[] featuredGameParticipantListDto = dto.getParticipants();
		assertTrue(featuredGameParticipantListDto.length > 0);
		for (FeaturedGameParticipant featuredGameParticipantDto : featuredGameParticipantListDto) {
			assertNotNull(featuredGameParticipantDto);
			testFeaturedGameParticipant(featuredGameParticipantDto);
		}
	}
	
	private void testFeaturedGameParticipant(FeaturedGameParticipant dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getChampionId() > 0);
		assertTrue(dto.getProfileIconId() >= 0);
		assertTrue(dto.getSpell1Id() > 0);
		assertTrue(dto.getSpell2Id() > 0);
		assertTrue(dto.getTeamId() > 0);
		assertNotNull(dto.getSummonerName());
	}

	@Test
	public void testCurrentGame() throws IOException {
		testCurrentGameRan = true;
		try {
			prints.println("INFO", "Testing CURRENT GAME interface");

			Map<String,SummonerDto> summonerDto = summonerInterface.getByNames(names);
			for (SummonerDto dto : summonerDto.values()) {
				CurrentGameInfo currentGameInfo = currentGameInterface.getSpectatorInfo(dto.getId());
				assertNotNull(currentGameInfo);
				if (!currentGameInfo.notInGame) {
					somebodyInCurrentGame = true;
				} else {
					continue;
				}
				
				testCurrentGameInfo(currentGameInfo);
			}

			if (!somebodyInCurrentGame) {
				prints.println("WARNING", "Nobody in game to properly test current game");
			} 
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}
	
	private void testCurrentGameInfo(CurrentGameInfo dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getGameId() > 0);
		assertTrue(dto.getGameLength() >= 0);
		assertTrue(dto.getGameQueueConfigId() > 0);
		assertTrue(dto.getGameStartTime() > 0);
		assertTrue(dto.getMapId() > 0);
		assertNotNull(dto.getPlatformId());
		assertNotNull(dto.getGameType());
		assertNotNull(dto.getGameMode());
		
		CurrentGameParticipant[] currentGameParticipantListDto = dto.getParticipants();
		assertTrue(currentGameParticipantListDto.length > 0);
		for (CurrentGameParticipant cgp : currentGameParticipantListDto) {
			assertNotNull(cgp);
			testCurrentGameParticipant(cgp);
		}
		
		Observer observerDto = dto.getObservers();
		assertNotNull(observerDto);
		testObserver(observerDto);
		
		BannedChampion[] bannedChampionListDto = dto.getBannedChampions();
		for (BannedChampion bannedChampionDto : bannedChampionListDto) {
			assertNotNull(bannedChampionDto);
			testBannedChampion(bannedChampionDto);
		}
	}
	
	private void testBannedChampion(BannedChampion dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getPickTurn() >= 0);
		assertTrue(dto.getChampionId() > 0);
	}
	
	private void testCurrentGameParticipant(CurrentGameParticipant dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getProfileIconId() > 0);
		assertTrue(dto.getSpell1Id() > 0);
		assertTrue(dto.getSpell2Id() > 0);
		assertTrue(dto.getSummonerId() > 0);
		assertTrue(dto.getTeamId() > 0);
		assertNotNull(dto.getSummonerName());

		Mastery[] masteryListDto = dto.getMasteries();
		assertTrue(masteryListDto.length > 0);
		for (Mastery mastery : masteryListDto) {
			assertNotNull(mastery);
			testMastery(mastery);
		}

		Rune[] runeListDto = dto.getRunes();
		assertTrue(runeListDto.length > 0);
		for (Rune rune : runeListDto) {
			assertNotNull(rune);
			testRune(rune);
		}
	}
	
	private void testObserver(Observer dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getEncryptionKey());
	}

	@Test
	public void testChampion() throws IOException {
		testChampionRan = true;
		try {
			prints.println("Testing CHAMPION interface");

			ChampListDto freeChamps = championInterface.getChampions(true);
			assertNotNull(freeChamps);
			testChampListDto(freeChamps, true);

			ChampListDto allChamps = championInterface.getChampions(false);
			assertNotNull(allChamps);
			testChampListDto(allChamps, false);
			
			ChampDto[] champListDto = allChamps.getChampions();
			for (ChampDto champDto : champListDto) {
				ChampDto cDto = championInterface.getChampion(champDto.getId());
				assertNotNull(cDto);
				prints.println("Champ ID : " + cDto.getId());
				testChampDto(cDto, false);
			}
			
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}
	
	private void testChampListDto(ChampListDto dto, boolean expectFree) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getChampions().length > 0);
		for (ChampDto champDto : dto.getChampions()) {
			assertNotNull(champDto);
			testChampDto(champDto, expectFree);
		}
	}
	
	private void testChampDto(ChampDto dto, boolean expectFree) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getId() > 0);
		if (expectFree) {
			assertTrue(dto.isFreeToPlay());
		}
		
		// other fields in this DTO are constantly changing
		// best to let the instance count and register stuff
		// verify it's working
	}

	@Test
	public void testSummoners() throws IOException {
		testSummonerRan = true;
		try {
			Map<String,SummonerDto> summonersDto = summonerInterface.getByNames(names);

			assertNotNull("RiotApi.Summoner.getByNames(String[]) returned null", summonersDto);
			assertTrue("No summoners found", summonersDto.values().size() > 0);

			for (SummonerDto summonerDto : summonersDto.values()) {
				testSummonerDto(summonerDto);
				
				long summonerId = summonerDto.getId();
				Map<String,SummonerDto> idMapDto = summonerInterface.getByIds(summonerId);	// will be only 1 KvP
				for (SummonerDto idDto : idMapDto.values()) {
					assertNotNull(idMapDto);
					testSummonerDto(idDto);
				}

				Map<String,MasteryPagesDto> masteryPagesMapDto = summonerInterface.getMasteries(summonerId);	
				assertNotNull(masteryPagesMapDto);
				for (MasteryPagesDto masteryPagesDto : masteryPagesMapDto.values()) {
					assertNotNull(masteryPagesDto);
					testMasteryPagesDto(masteryPagesDto);
				}
				
				Map<String,RunePagesDto> runePagesMapDto = summonerInterface.getRunes(summonerId);
				assertNotNull(runePagesMapDto);
				for (RunePagesDto runePagesDto : runePagesMapDto.values()) {
					assertNotNull(runePagesDto);
					testRunePagesDto(runePagesDto);
				}
				
				Map<String,String> nameMapDto = summonerInterface.getNames(summonerId);
				assertTrue(nameMapDto.values().size() == 1);
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	private void testRunePagesDto(RunePagesDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getSummonerId() > 0);
		
		for (RunePageDto runePageDto : dto.getPages()) {
			assertNotNull(runePageDto);
			testRunePageDto(runePageDto);
		}
	}
	
	private void testRunePageDto(RunePageDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getId() > 0);
		
		for (RuneSlotDto runeSlotDto : dto.getSlots()) {
			assertNotNull(runeSlotDto);
			testRuneSlotDto(runeSlotDto);
		}
	}
	
	private void testRuneSlotDto(RuneSlotDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getRuneSlotId() > 0);
	}

	private void testSummonerDto(SummonerDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull("Name is null", dto.getName());
		assertNotNull("Region is null", dto.getRegion());
		assertTrue("No icon id", dto.getProfileIconId() > 0);
		assertTrue("Revision date not set", dto.getRevisionDate() > 0);
		assertTrue("Level not set", dto.getSummonerLevel() > 0);
		assertTrue("No summonerId", dto.getId() > 0);
	}
	
	private void testMasteryPagesDto(MasteryPagesDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getSummonerId() > 0);

		MasteryPageDto[] masteryPageListDto = dto.getPages();
		for (MasteryPageDto masteryPageDto : masteryPageListDto) {
			testMasteryPageDto(masteryPageDto);
		}
	}
	
	private void testMasteryPageDto(MasteryPageDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getId() > 0);
		
		for (Mastery mastery : dto.getMasteries()) {
			testMastery(mastery);
		}
	}
	
	private void testMastery(Mastery dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getMasteryId() > 0);
	}
	
	private void testRune(Rune dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getRuneId() > 0);
	}

	@Test
	public void testStaticData() throws IOException {
		testStaticDataRan = true;
		try {
			// CHAMPION DATA
			ChampionListDto champListDto = staticInterface.getChampions(true, null, null, ChampListDataTag.ALL);
			assertNotNull(champListDto);
			testChampionListDto(champListDto);
			
			for (ChampionDto championDto : champListDto.getData().values()) {
				long champId = championDto.getId();
				ChampionDto champDto = staticInterface.getChampion(champId, null, null, ChampDataTag.ALL);
				assertNotNull(champDto);
				prints.println(champDto.getName() + " : " + champDto.getId());
				testChampionDto(champDto);
			}
			
			// ITEM DATA
			ItemListDto itemListDto = staticInterface.getItems(null, null, ItemListDataTag.ALL);
			assertNotNull(itemListDto);
			testItemListDto(itemListDto);
			
			for (ItemDto itemDto : itemListDto.getData().values()) {
				ItemDto itDto = staticInterface.getItem(itemDto.getId(), null, null, ItemDataTag.ALL);
				assertNotNull(itDto);
				prints.println(itDto.getName() + " : " + itDto.getId());
				testItemDto(itDto);
			}
			
			// LANGUAGE STRINGS
			LanguageStringsDto languageStringsDto = staticInterface.getLanguageStrings(null, null);
			assertNotNull(languageStringsDto);
			testLanguageStringsDto(languageStringsDto);
			
			// LANGUAGES
			String[] languageDto = staticInterface.getLocales();
			assertNotNull(languageDto);
			assertTrue(languageDto.length > 0);
			
			// MAP DATA
			MapDataDto mapDataDto = staticInterface.getMap(null, null);
			assertNotNull(mapDataDto);
			testMapDataDto(mapDataDto);
			
			// MASTERY DATA
			MasteryListDto masteryListDto = staticInterface.getMasteries(null, null, MasteryListDataTag.ALL);
			assertNotNull(masteryListDto);
			testMasteryListDto(masteryListDto);
			
			for (MasteryDto masteryDto : masteryListDto.getData().values()) {
				MasteryDto mastDto = staticInterface.getMastery(masteryDto.getId(), null, null, MasteryDataTag.ALL);
				assertNotNull(mastDto);
				prints.println(mastDto.getName() + " : " + mastDto.getId());
				testMasteryDto(mastDto);
			}
			
			// REALM DATA
			RealmDto realmDto = staticInterface.getRealm();
			assertNotNull(realmDto);
			testRealmDto(realmDto);
			
			// RUNE DATA
			RuneListDto runeListDto = staticInterface.getRunes(null, null, RuneListDataTag.ALL);
			assertNotNull(runeListDto);
			testRuneListDto(runeListDto);
			
			for (RuneDto runeDto : runeListDto.getData().values()) {
				assertNotNull(runeDto);
				RuneDto rDto = staticInterface.getRune(runeDto.getId(), null, null, RuneDataTag.ALL);
				assertNotNull(rDto);
				prints.println(rDto.getName() + " : " + rDto.getId());
				testRuneDto(rDto);
			}
			
			// SUMMONER SPELL DATA
			SummonerSpellListDto summonerSpellListDto = staticInterface.getSummonerSpells(true, null, null, SpellDataTag.ALL);
			assertNotNull(summonerSpellListDto);
			testSummonerSpellListDto(summonerSpellListDto);
			
			for (SummonerSpellDto summonerSpellDto : summonerSpellListDto.getData().values()) {
				assertNotNull(summonerSpellDto);
				SummonerSpellDto sDto = staticInterface.getSummonerSpell(summonerSpellDto.getId(), null, null, SpellDataTag.ALL);
				assertNotNull(sDto);
				prints.println(sDto.getName() + " : " + sDto.getId());
				testSummonerSpellDto(sDto);
			}
			
			// VERSION DATA
			String[] versionListDto = staticInterface.getVersions();
			assertNotNull(versionListDto);
			assertTrue(versionListDto.length > 0);

		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}
	
	private void testSummonerSpellListDto(SummonerSpellListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertNotNull(dto.getType());
		assertNotNull(dto.getVersion());
		assertTrue(dto.getData().size() > 0);
		
		for (SummonerSpellDto summonerSpellDto : dto.getData().values()) {
			assertNotNull(summonerSpellDto);
			testSummonerSpellDto(summonerSpellDto);
		}
	}
	
	private void testSummonerSpellDto(SummonerSpellDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getCooldown().length > 0);
		assertNotNull(dto.getCooldownBurn());
		assertTrue(dto.getCost().length > 0);
		assertNotNull(dto.getCostBurn());
		assertNotNull(dto.getCostType());
		assertNotNull(dto.getDescription());
//		assertTrue(dto.getEffect().length > 0);
		assertNotNull(dto.getEffectBurn());
		assertTrue(dto.getId() > 0);
		assertNotNull(dto.getKey());
		assertTrue(dto.getMaxrank() > 0);
		assertTrue(dto.getModes().length > 0);
		assertNotNull(dto.getName());
		assertNotNull(dto.getRangeBurn());
		assertNotNull(dto.getResource());
		assertNotNull(dto.getSanitizedDescription());
		assertNotNull(dto.getSanitizedTooltip());
		assertTrue(dto.getSummonerLevel() > 0);
		assertNotNull(dto.getTooltip());

		SpellVarsDto[] spellVarsListDto = dto.getVars();
//		assertTrue(spellVarsListDto.length > 0);
		for (SpellVarsDto spellVarsDto : spellVarsListDto) {
			assertNotNull(spellVarsDto);
			testSpellVarsDto(spellVarsDto);
		}
		
		LevelTipDto levelTipDto = dto.getLeveltip();
		if (levelTipDto != null) {
			testLevelTipDto(levelTipDto);
		}
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);
		
		RangeDto rangeDto = dto.getRange();
		assertNotNull(rangeDto);
		testRangeDto(rangeDto);
	}
	
	private void testRealmDto(RealmDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertNotNull(dto.getCdn());
		assertNotNull(dto.getCss());
		assertNotNull(dto.getDd());
		assertNotNull(dto.getL());
		assertNotNull(dto.getLg());
		assertTrue(dto.getN().size() > 0);
		assertTrue(dto.getProfileiconmax() < 500);
		assertNotNull(dto.getV());
	}
	
	private void testMasteryListDto(MasteryListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertNotNull(dto.getVersion());
		assertNotNull(dto.getType());

		MasteryTreeDto masteryTreeDto = dto.getTree();
		assertNotNull(masteryTreeDto);
		testMasteryTreeDto(masteryTreeDto);
		
		Map<String,MasteryDto> masteryMapDto = dto.getData();
		assertNotNull(masteryMapDto);
		for (MasteryDto masteryDto : masteryMapDto.values()) {
			assertNotNull(masteryDto);
			testMasteryDto(masteryDto);
		}
	}
	
	private void testMasteryDto(MasteryDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getId() > 0);
		assertTrue(dto.getDescription().length > 0);
		assertTrue(dto.getSanitizedDescription().length > 0);
		assertTrue(dto.getRanks() > 0);
		assertNotNull(dto.getName());
		assertNotNull(dto.getMasteryTree());
		assertNotNull(dto.getPrereq());
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);
	}
	
	private void testMasteryTreeDto(MasteryTreeDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		MasteryTreeListDto[] cunningListDto = dto.getCunning();
		for (MasteryTreeListDto masteryTreeListDto : cunningListDto) {
			assertNotNull(masteryTreeListDto);
			testMasteryTreeListDto(masteryTreeListDto);
		}

		MasteryTreeListDto[] ferocityListDto = dto.getFerocity();
		for (MasteryTreeListDto masteryTreeListDto : ferocityListDto) {
			assertNotNull(masteryTreeListDto);
			testMasteryTreeListDto(masteryTreeListDto);
		}

		MasteryTreeListDto[] resolveListDto = dto.getResolve();
		for (MasteryTreeListDto masteryTreeListDto : resolveListDto) {
			assertNotNull(masteryTreeListDto);
			testMasteryTreeListDto(masteryTreeListDto);
		}
	}
	
	private void testMasteryTreeListDto(MasteryTreeListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		MasteryTreeItemDto[] masteryTreeItemListDto = dto.getMasteryTreeItems();
		for (int i=0; i<masteryTreeItemListDto.length; i++) {
			MasteryTreeItemDto masteryTreeItemDto = masteryTreeItemListDto[i];
			if (!(masteryTreeItemDto == null && i == 1)) {	// sometimes the second item in the list will be null
				assertNotNull(masteryTreeItemDto);
				testMasteryTreeItemDto(masteryTreeItemDto);
			}
		}
	}
	
	private void testMasteryTreeItemDto(MasteryTreeItemDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getMasteryId() > 0);
		assertNotNull(dto.getPrereq());
	}
	
	private void testMapDataDto(MapDataDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getVersion());
		prints.println("STATIC mapData version " + dto.getVersion());
		assertNotNull(dto.getType());
		prints.println("STATIC mapData type " + dto.getType());
		assertNotNull(dto.getData());
		for (String key : dto.getData().keySet()) {
			prints.println("STATIC mapData key " + key);
			MapDetailsDto mapDetailsDto = dto.getData().get(key);
			assertNotNull(mapDetailsDto);
			testMapDetailsDto(mapDetailsDto);
		}
	}
	
	private void testMapDetailsDto(MapDetailsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getMapId() > 0);
		assertNotNull(dto.getMapName());
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);
	}
	
	private void testLanguageStringsDto(LanguageStringsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getVersion());
		prints.println("STATIC languageString version " + dto.getVersion());
		assertNotNull(dto.getType());
		prints.println("STATIC languageString type " + dto.getType());
		assertNotNull(dto.getData());
		for (String key : dto.getData().keySet()) {
			prints.println("STATIC languageString data " + key + " -> " + dto.getData().get(key));
		}
	}
	
	private void testItemListDto(ItemListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getType());
		assertNotNull(dto.getVersion());

		BasicDataDto basicDataDto = dto.getBasic();
		assertNotNull(basicDataDto);
		testBasicDataDto(basicDataDto);

		Map<String, ItemDto> itemMapDto = dto.getData();
		for (ItemDto itemDto : itemMapDto.values()) {
			testItemDto(itemDto);
		}

		GroupDto[] groupListDto = dto.getGroups();
		for (GroupDto groupDto : groupListDto) {
			testGroupDto(groupDto);
		}

		ItemTreeDto[] itemTreeDto = dto.getTree();
		for (ItemTreeDto itDto : itemTreeDto) {
			testItemTreeDto(itDto);
		}
	}
	
	private void testItemTreeDto(ItemTreeDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getHeader());
		assertTrue(dto.getTags().length > 0);
	}
	
	private void testGroupDto(GroupDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

//		assertNotNull(dto.getMaxGroupOwnable());
		assertNotNull(dto.getKey());
	}
	
	private void testBasicDataDto(BasicDataDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		MetaDataDto metaDataDto = dto.getRune();
		if (metaDataDto != null) {
			testMetaDataDto(metaDataDto);
		}

		ImageDto imageDto = dto.getImage();
		if (imageDto != null) {
			testImageDto(imageDto);
		}

		GoldDto goldDto = dto.getGold();
		if (goldDto != null) {
			testGoldDto(goldDto);
		}

		BasicDataStatsDto basicDataStatsDto = dto.getStats();
		if (basicDataStatsDto != null) {
			testBasicDataStatsDto(basicDataStatsDto);
		}

		if (dto.getId() == 0) {
			return;
		}

		assertNotNull(dto.getName());
		assertNotNull(dto.getDescription());
		assertNotNull(dto.getDescription());
		assertTrue(dto.getId() > 0);
	}
	
	private void testItemDto(ItemDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		testBasicDataDto(dto);
	}
	
	private void testChampionListDto(ChampionListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getFormat());
		assertNotNull(dto.getVersion());
		assertNotNull(dto.getType());
		
		Map<String,String> keys = dto.getKeys();
		assertTrue(keys.keySet().size() > 0);

		Map<String,ChampionDto> dataMapDto = dto.getData();
		assertTrue(dataMapDto.keySet().size() > 0);
		for (String key : dataMapDto.keySet()) {
			ChampionDto champDto = dataMapDto.get(key);
			assertNotNull(champDto);
			testChampionDto(champDto);
		}
	}
	
	private void testChampionDto(ChampionDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getAllytips().length > 0);
		assertNotNull(dto.getBlurb());
		assertTrue(dto.getEnemytips().length > 0);
		assertNotNull(dto.getId());
		assertNotNull(dto.getKey());
		assertNotNull(dto.getLore());
		assertNotNull(dto.getName());
		assertNotNull(dto.getPartype());
		assertTrue(dto.getTags().length > 0);
		assertNotNull(dto.getTitle());
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);
		
		InfoDto infoDto = dto.getInfo();
		assertNotNull(infoDto);
		testInfoDto(infoDto);
		
		PassiveDto passiveDto = dto.getPassive();
		assertNotNull(passiveDto);
		testPassiveDto(passiveDto);
		
		RecommendedDto[] recommendedListDto = dto.getRecommended();
		assertTrue(recommendedListDto.length > 0);
		for (RecommendedDto rDto : recommendedListDto) {
			testRecommendedDto(rDto);
		}
		
		SkinDto[] skinListDto = dto.getSkins();
		assertTrue(skinListDto.length > 0);
		for (SkinDto skinDto : skinListDto) {
			testSkinDto(skinDto);
		}
		
		ChampionSpellDto[] spellListDto = dto.getSpells();
		assertTrue(spellListDto.length > 0);
		for (ChampionSpellDto spellDto : spellListDto) {
			testChampionSpellDto(spellDto);
		}
		
		StatsDto statsDto = dto.getStats();
		assertNotNull(statsDto);
		testStatsDto(statsDto);
	}
	
	private void testStatsDto(StatsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void testChampionSpellDto(ChampionSpellDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getCooldown().length > 0);
		assertNotNull(dto.getCooldownBurn());
		assertTrue(dto.getCost().length > 0);
		assertNotNull(dto.getCostBurn());
		assertNotNull(dto.getCostType());
		assertNotNull(dto.getDescription());
		assertNotNull(dto.getKey());
		assertNotNull(dto.getTooltip());
		assertNotNull(dto.getSanitizedTooltip());
		assertNotNull(dto.getSanitizedDescription());

		assertNotNull(dto.getRangeBurn());
		assertNotNull(dto.getName());
		
		ImageDto[] altImageDto = dto.getAltimages();
		for (ImageDto imageDto : altImageDto) {
			assertNotNull(imageDto);
			testImageDto(imageDto);
		}
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);

		LevelTipDto levelTipDto = dto.getLeveltip();
		assertNotNull(levelTipDto);
		testLevelTipDto(levelTipDto);
		
		RangeDto rangeDto = dto.getRange();
		assertNotNull(rangeDto);
		testRangeDto(rangeDto);
		
		SpellVarsDto[] spellVarListDto = dto.getVars();
		for (SpellVarsDto spellVarsDto : spellVarListDto) {
			assertNotNull(spellVarsDto);
			testSpellVarsDto(spellVarsDto);
		}
	}
	
	private void testSpellVarsDto(SpellVarsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getLink());
		assertNotNull(dto.getKey());
	}
	
	private void testRangeDto(RangeDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		if (dto.isSelf()) {
			assertTrue(dto.getRanges().length == 0);
		} else {
			assertTrue(dto.getRanges().length > 0);
		}
	}
	
	private void testLevelTipDto(LevelTipDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getEffect().length > 0);
		assertTrue(dto.getLabel().length > 0);
	}
	
	private void testSkinDto(SkinDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getId() > 0);
		assertNotNull(dto.getName());
	}
	
	private void testRuneListDto(RuneListDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getType());
		assertNotNull(dto.getVersion());

		Map<String,RuneDto> runeMapDto = dto.getData();
		assertTrue(runeMapDto.size() > 0);
		for (RuneDto runeDto : runeMapDto.values()) {
			assertNotNull(runeDto);
			testRuneDto(runeDto);
		}
	}

	private void testRuneDto(RuneDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getDepth());
		assertNotNull(dto.getDescription());
		assertNotNull(dto.getSanitizedDescription());
		assertNotNull(dto.getFrom());
		assertNotNull(dto.getInto());
		assertNotNull(dto.getMaps());
		assertNotNull(dto.getName());
		assertTrue(dto.getId() > 0);
		assertNotNull(dto.getTags());

		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);

		MetaDataDto metaDto = dto.getRune();
		assertNotNull(metaDto);
		testMetaDataDto(metaDto);

		BasicDataStatsDto bdsDto = dto.getStats();
		assertNotNull(bdsDto);
		testBasicDataStatsDto(bdsDto);
	}
	
	private void testBasicDataStatsDto(BasicDataStatsDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void testPassiveDto(PassiveDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getDescription());
		assertNotNull(dto.getName());
		assertNotNull(dto.getSanitizedDescription());
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);
	}

	private void testImageDto(ImageDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getFull());
		assertNotNull(dto.getGroup());
		assertNotNull(dto.getSprite());
		assertTrue(dto.getH() > 0);
		assertTrue(dto.getW() > 0);
	}
	
	private void testInfoDto(InfoDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void testRecommendedDto(RecommendedDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getChampion());
		assertNotNull(dto.getMap());
		assertNotNull(dto.getMode());
		assertNotNull(dto.getTitle());
		assertNotNull(dto.getType());
		
		BlockDto[] blockListDto = dto.getBlocks();
		assertTrue(blockListDto.length > 0);
		for (BlockDto blockDto : blockListDto) {
			testBlockDto(blockDto);
		}
	}
	
	private void testBlockDto(BlockDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		BlockItemDto[] blockItemListDto = dto.getItems();
		assertTrue(blockItemListDto.length > 0);
		for (BlockItemDto blockItemDto : blockItemListDto) {
			testBlockItemDto(blockItemDto);
		}
	}
	
	private void testBlockItemDto(BlockItemDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertTrue(dto.getId() > 0);
		assertTrue(dto.getCount() > 0);
	}

	private void testMetaDataDto(MetaDataDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getTier());
		assertNotNull(dto.getType());
	}

	private void testGoldDto(GoldDto dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStatus() throws IOException {
		testStatusRan = true;
		try {
			prints.println("INFO", "Testing STATUS");
			boolean correctUnsupportedRegion = false;
			try {
				factory.newStatusInterface(Regions.getByCode("KR"), false);
			} catch (IllegalArgumentException e) {
				correctUnsupportedRegion = true;
			}

			assertTrue(correctUnsupportedRegion);

			Shard[] shards = statusInterface.getShards();
			assertNotNull(shards);
			for (Shard s : shards) {
				testShard(s);
			}

			ShardStatus statusDto = statusInterface.getShard();
			assertNotNull(statusDto);
			testShardStatus(statusDto);
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			if (e.getCode() == 500) {
				prints.println("WARNING", "Server error interrupted test");
			} else {
				fail(e.getMessage());
			}
		} finally {
			System.out.println();
			System.out.println();
		}
	}
	
	private void testShardStatus(ShardStatus dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		assertNotNull(dto.getHostname());
		assertNotNull(dto.getLocales());
		assertNotNull(dto.getName());
		assertNotNull(dto.getRegionTag());
		assertNotNull(dto.getSlug());
		
		Service[] serviceListDto = dto.getServices();
		for (Service serviceDto : serviceListDto) {
			testService(serviceDto);
		}
	}
	
	private void testService(Service dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertNotNull(dto.getName());
		assertNotNull(dto.getSlug());
		assertNotNull(dto.getStatus());

		Incident[] incidentListDto = dto.getIncidents();
		for (Incident incidentDto : incidentListDto) {
			testIncident(incidentDto);
		}
	}
	
	private void testIncident(Incident dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertTrue(dto.getId() > 0);

		Message[] messageListDto = dto.getUpdates();
		for (Message messageDto : messageListDto) {
			testMessage(messageDto);
		}
	}
	
	private void testMessage(Message dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		assertNotNull(dto.getId());
		assertNotNull(dto.getContent());
		assertNotNull(dto.getUpdatedAt());

		Translation[] translationListDto = dto.getTranslations();
		for (Translation translationDto : translationListDto) {
			testTranslation(translationDto);
		}
	}
	
	private void testTranslation(Translation dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
//		assertNotNull(dto.getUpdatedAt());
		assertNotNull(dto.getContent());
		assertNotNull(dto.getLocale());
	}
	
	private void testShard(Shard dto) {
		try {
			register.registerInstance(dto);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private long[] getSummonerIds(Map<String,SummonerDto> summonersDto) {
		long[] ids = new long[summonersDto.values().size()];
		int i = 0;
		for (SummonerDto dto : summonersDto.values()) {
			ids[i] = dto.getId();
			i++;
		}

		return ids;
	}
	
	@AfterClass
	public static void verifyTests() {
		prints.println("INFO", "Testing POJOs");
		
		// champion POJOs
		if (testChampionRan) {
			assertTrue(ChampDto.getInstanceCount() > 0);
			assertTrue(ChampListDto.getInstanceCount() > 0);
			assertNull(register.testClass(ChampDto.class));
			assertNull(register.testClass(ChampListDto.class));
		}
		
		// champion mastery POJOs
		if (testChampionMasteryRan) {
			assertTrue(ChampionMasteryDto.getInstanceCount() > 0);
			assertNull(register.testClass(ChampionMasteryDto.class, "chestGranted","highestGrade"));
		}
		
		// current game POJOs
		if (testCurrentGameRan && somebodyInCurrentGame) {
			assertTrue(CurrentGameInfo.getInstanceCount() > 0);
			assertTrue(CurrentGameParticipant.getInstanceCount() > 0);
			assertNull(register.testClass(CurrentGameInfo.class));
			assertNull(register.testClass(CurrentGameParticipant.class));
		}
		
		// featured game POJOs
		if (testFeaturedGamesRan) {
			assertTrue(FeaturedGameInfo.getInstanceCount() > 0);
			assertTrue(FeaturedGameParticipant.getInstanceCount() > 0);
			assertTrue(FeaturedGamesDto.getInstanceCount() > 0);
			assertNull(register.testClass(FeaturedGameInfo.class));
			assertNull(register.testClass(FeaturedGameParticipant.class));
			assertNull(register.testClass(FeaturedGamesDto.class));
		}
		
		// game POJOs
		if (testRecentGameRan) {
			assertTrue(GameDto.getInstanceCount() > 0);
			assertTrue(PlayerDto.getInstanceCount() > 0);
			assertTrue(RawStatsDto.getInstanceCount() > 0);
			assertTrue(RecentGamesDto.getInstanceCount() > 0);
			assertNull(register.testClass(GameDto.class));
			assertNull(register.testClass(PlayerDto.class));
			assertNull(register.testClass(RawStatsDto.class,
					"combatPlayerScore", "nodeCapture", "nodeCaptureAssist",
					"nodeNeutralize", "objectivePlayerScore", "teamObjective",
					"totalPlayerScore", "totalScoreRank",
					"consumablesPurchased", "damageDealtPlayer",
					"firstBlood", "gold", "itemsPurchased",
					"legendaryItemsCreated", "minionsDenied",
					"nexusKilled", "nodeNeutralizeAssist",
					"numItemsBought", "pentaKills", "playerPosition",
					"playerRole", "sightWardsBought", "spell1Cast",
					"spell2Cast", "spell3Cast", "spell4Cast",
					"summonSpell1Cast", "summonSpell2Cast",
					"superMonsterKilled", "unrealKills", "victoryPointTotal"));
			assertNull(register.testClass(RecentGamesDto.class));
		}
		
		// league POJOs
		if (testLeagueRan) {
			assertTrue(LeagueDto.getInstanceCount() > 0);
			assertTrue(LeagueEntryDto.getInstanceCount() > 0);
			
			assertNull(register.testClass(LeagueDto.class));
			assertNull(register.testClass(LeagueEntryDto.class));
			
			if (MiniSeriesDto.getInstanceCount() > 0) {
				assertNull(register.testClass(MiniSeriesDto.class));
			} else {
				prints.println("WARNING", "Nobody in mini-series to properly test");
			}
		}
		
		// static data POJOs
		if (testStaticDataRan) {
			assertTrue(BasicDataDto.getInstanceCount() > 0);
			assertTrue(BasicDataStatsDto.getInstanceCount() > 0);
			assertTrue(BlockDto.getInstanceCount() > 0);
			assertTrue(BlockItemDto.getInstanceCount() > 0);
			assertTrue(ChampionDto.getInstanceCount() > 0);
			assertTrue(ChampionListDto.getInstanceCount() > 0);
			assertTrue(ChampionSpellDto.getInstanceCount() > 0);
			assertTrue(GoldDto.getInstanceCount() > 0);
			assertTrue(GroupDto.getInstanceCount() > 0);
			assertTrue(ImageDto.getInstanceCount() > 0);
			assertTrue(InfoDto.getInstanceCount() > 0);
			assertTrue(ItemDto.getInstanceCount() > 0);
			assertTrue(ItemListDto.getInstanceCount() > 0);
			assertTrue(ItemTreeDto.getInstanceCount() > 0);
			assertTrue(LanguageStringsDto.getInstanceCount() > 0);
			assertTrue(LevelTipDto.getInstanceCount() > 0);
			assertTrue(MapDataDto.getInstanceCount() > 0);
			assertTrue(MapDetailsDto.getInstanceCount() > 0);
			assertTrue(MasteryDto.getInstanceCount() > 0);
			assertTrue(MasteryListDto.getInstanceCount() > 0);
			assertTrue(MasteryTreeDto.getInstanceCount() > 0);
			assertTrue(MasteryTreeItemDto.getInstanceCount() > 0);
			assertTrue(MasteryTreeListDto.getInstanceCount() > 0);
			assertTrue(MetaDataDto.getInstanceCount() > 0);
			assertTrue(PassiveDto.getInstanceCount() > 0);
			assertTrue(RangeDto.getInstanceCount() > 0);
			assertTrue(RealmDto.getInstanceCount() > 0);
			assertTrue(RecommendedDto.getInstanceCount() > 0);
			assertTrue(RuneDto.getInstanceCount() > 0);
			assertTrue(RuneListDto.getInstanceCount() > 0);
			assertTrue(SkinDto.getInstanceCount() > 0);
			assertTrue(SpellVarsDto.getInstanceCount() > 0);
			assertTrue(StatsDto.getInstanceCount() > 0);
			assertTrue(SummonerSpellDto.getInstanceCount() > 0);
			assertTrue(SummonerSpellListDto.getInstanceCount() > 0);

			assertNull(register.testClass(BasicDataDto.class, "image"));
			assertNull(register.testClass(BasicDataStatsDto.class));
			assertNull(register.testClass(BlockDto.class));
			assertNull(register.testClass(BlockItemDto.class));
			assertNull(register.testClass(ChampionDto.class));
			assertNull(register.testClass(ChampionListDto.class));
			assertNull(register.testClass(ChampionSpellDto.class, "altimages"));
			assertNull(register.testClass(GoldDto.class));
			assertNull(register.testClass(GroupDto.class));
			assertNull(register.testClass(ImageDto.class));
			assertNull(register.testClass(InfoDto.class));
			assertNull(register.testClass(ItemDto.class));
			assertNull(register.testClass(ItemListDto.class));
			assertNull(register.testClass(ItemTreeDto.class));
			assertNull(register.testClass(LanguageStringsDto.class));
			assertNull(register.testClass(LevelTipDto.class));
			assertNull(register.testClass(MapDataDto.class));
			assertNull(register.testClass(MapDetailsDto.class, "unpurchaseableItemList"));
			assertNull(register.testClass(MasteryDto.class));
			assertNull(register.testClass(MasteryListDto.class));
			assertNull(register.testClass(MasteryTreeDto.class));
			assertNull(register.testClass(MasteryTreeItemDto.class));
			assertNull(register.testClass(MasteryTreeListDto.class));
			assertNull(register.testClass(MetaDataDto.class));
			assertNull(register.testClass(PassiveDto.class));
			assertNull(register.testClass(RangeDto.class));
			assertNull(register.testClass(RealmDto.class, "store"));
			assertNull(register.testClass(RecommendedDto.class));
			assertNull(register.testClass(RuneDto.class,
					"colloq", "consumeOnFull", "consumed", "depth", "from",
					"group", "hideFromAll", "inStore", "into", "maps", "plaintext",
					"requiredChampion", "specialRecipe", "stacks"));	// these fields are exempted because the BasicDataDto has them
			assertNull(register.testClass(RuneListDto.class));
			assertNull(register.testClass(SkinDto.class));
			assertNull(register.testClass(StatsDto.class));
		}

		// status POJOs
		if (testStatusRan) {
			assertTrue(Service.getInstanceCount() > 0);
			assertTrue(Shard.getInstanceCount() > 0);
			assertTrue(ShardStatus.getInstanceCount() > 0);
			if (Incident.getInstanceCount() == 0) {
				prints.println("WARNING", "No " + Incident.class.getSimpleName() + " deserialized");
			}
			if (Message.getInstanceCount() == 0) {
				prints.println("WARNING", "No " + Message.class.getSimpleName() + " deserialized");
			}
			if (Translation.getInstanceCount() == 0) {
				prints.println("WARNING", "No " + Translation.class.getSimpleName() + " deserialized");
			}

			assertNull(register.testClass(Service.class));
			assertNull(register.testClass(Shard.class));
			assertNull(register.testClass(ShardStatus.class));

			if (Incident.getInstanceCount() > 0) {
				assertNull(register.testClass(Incident.class));
			}
			if (Message.getInstanceCount() > 0) {
				assertNull(register.testClass(Message.class, "author"));
			}
			if (Translation.getInstanceCount() > 0) {
				assertNull(register.testClass(Translation.class, "updated_at"));
			}
		}
		
		// match POJOs
		if (testMatchListRan && testMatchRan) {
			assertTrue(Event.getInstanceCount() > 0);
			assertTrue(Frame.getInstanceCount() > 0);
			assertTrue(MatchDetail.getInstanceCount() > 0);
			assertTrue(MatchListDto.getInstanceCount() > 0);
			assertTrue(MatchReference.getInstanceCount() > 0);
			assertTrue(Participant.getInstanceCount() > 0);
			assertTrue(ParticipantFrame.getInstanceCount() > 0);
			assertTrue(ParticipantIdentity.getInstanceCount() > 0);
			assertTrue(ParticipantStats.getInstanceCount() > 0);
			assertTrue(ParticipantTimeline.getInstanceCount() > 0);
			assertTrue(ParticipantTimelineData.getInstanceCount() > 0);
			assertTrue(Player.getInstanceCount() > 0);
			assertTrue(Position.getInstanceCount() > 0);
			assertTrue(Team.getInstanceCount() > 0);
			assertTrue(Timeline.getInstanceCount() > 0);
			
			assertNull(register.testClass(Event.class, "ascendedType","pointCaptured"));
			assertNull(register.testClass(Frame.class));
			assertNull(register.testClass(MatchDetail.class));
			assertNull(register.testClass(MatchListDto.class));
			assertNull(register.testClass(MatchReference.class));
			assertNull(register.testClass(Participant.class));
			assertNull(register.testClass(ParticipantFrame.class));
			assertNull(register.testClass(ParticipantIdentity.class));
			assertNull(register.testClass(ParticipantStats.class,
					"nodeCapture", "nodeCaptureAssist", "nodeNeutralize",
					"nodeNeutralizeAssist", "teamObjective"));
			assertNull(register.testClass(ParticipantTimeline.class,
					"ancientGolemAssistsPerMinCounts", "ancientGolemKillsPerMinCounts",
					"assistedLaneDeathsPerMinDeltas", "assistedLaneKillsPerMinDeltas",
					"baronAssistsPerMinCounts", "baronKillsPerMinCounts", "dragonAssistsPerMinCounts",
					"dragonKillsPerMinCounts", "elderLizardAssistsPerMinCounts",
					"elderLizardKillsPerMinCounts", "inhibitorAssistsPerMinCounts",
					"inhibitorKillsPerMinCounts", "towerAssistsPerMinCounts",
					"towerKillsPerMinCounts", "towerKillsPerMinDeltas", "vilemawAssistsPerMinCounts",
					"vilemawKillsPerMinCounts", "wardsPerMinDeltas"));
			assertNull(register.testClass(ParticipantTimelineData.class));
			assertNull(register.testClass(Player.class));
			assertNull(register.testClass(Position.class));
			assertNull(register.testClass(Team.class, "bans"));
			assertNull(register.testClass(Timeline.class));
		}
		
		// stats POJOs
		if (testStatsRan) {
			assertTrue(AggregatedStatsDto.getInstanceCount() > 0);
			assertTrue(ChampionStatsDto.getInstanceCount() > 0);
			assertTrue(PlayerStatsSummaryDto.getInstanceCount() > 0);
			assertTrue(PlayerStatsSummaryListDto.getInstanceCount() > 0);
			assertTrue(RankedStatsDto.getInstanceCount() > 0);
			assertNull(register.testClass(AggregatedStatsDto.class));
			assertNull(register.testClass(ChampionStatsDto.class));
			assertNull(register.testClass(PlayerStatsSummaryDto.class));
			assertNull(register.testClass(PlayerStatsSummaryListDto.class));
			assertNull(register.testClass(RankedStatsDto.class));
		}

		// summoner POJOs
		if (testSummonerRan) {
			assertTrue(MasteryPageDto.getInstanceCount() > 0);
			assertTrue(MasteryPagesDto.getInstanceCount() > 0);
			assertTrue(RunePageDto.getInstanceCount() > 0);
			assertTrue(RunePagesDto.getInstanceCount() > 0);
			assertTrue(RuneSlotDto.getInstanceCount() > 0);
			assertTrue(SummonerDto.getInstanceCount() > 0);
			assertNull(register.testClass(MasteryPageDto.class));
			assertNull(register.testClass(MasteryPagesDto.class));
			assertNull(register.testClass(RunePageDto.class));
			assertNull(register.testClass(RunePagesDto.class));
			assertNull(register.testClass(RuneSlotDto.class));
			assertNull(register.testClass(SummonerDto.class));
		}
		
		// team POJOs
		if (testTeamRan) {
			assertTrue(MatchHistorySummaryDto.getInstanceCount() > 0);
			assertTrue(RosterDto.getInstanceCount() > 0);
			assertTrue(TeamDto.getInstanceCount() > 0);
			assertTrue(TeamMemberInfoDto.getInstanceCount() > 0);
			assertTrue(TeamStatDetailDto.getInstanceCount() > 0);
			assertNull(register.testClass(MatchHistorySummaryDto.class));
			assertNull(register.testClass(RosterDto.class));
			assertNull(register.testClass(TeamDto.class));
			assertNull(register.testClass(TeamMemberInfoDto.class));
			assertNull(register.testClass(TeamStatDetailDto.class));
		}

		boolean allTestsComplete = false;
		if (testChampionRan &&
				testChampionMasteryRan &&
				testCurrentGameRan &&
				testFeaturedGamesRan &&
				testRecentGameRan &&
				testLeagueRan &&
				testStaticDataRan &&
				testStatusRan &&
				testMatchRan &&
				testMatchListRan &&
				testStatsRan &&
				testSummonerRan &&
				testTeamRan) {

			// common POJOs
			assertTrue(Mastery.getInstanceCount() > 0);
			assertTrue(Observer.getInstanceCount() > 0);
			assertTrue(Rune.getInstanceCount() > 0);
			if (BannedChampion.getInstanceCount() > 0) {
				assertNull(register.testClass(BannedChampion.class));
			} else {
				prints.println("WARNING", "No Banned Champions");
			}
			assertNull(register.testClass(Mastery.class));
			assertNull(register.testClass(Observer.class));
			assertNull(register.testClass(Rune.class));
			
			allTestsComplete = true;
			
			if (!somebodyInCurrentGame) {
				prints.println("WARNING", "Nobody in current game to properly test.");
			}
		}

		assertTrue("Partial tests complete", allTestsComplete);
		prints.println("SUCCESS", "All tests passed with expected fields");
	}

}
