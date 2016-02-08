package org.dc.riot.lol.rx;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.dc.riot.lol.rx.model.GroupDto;
import org.dc.riot.lol.rx.model.ItemTreeDto;
import org.dc.riot.lol.rx.model.SpellVarsDto;
import org.dc.riot.lol.rx.model.champion.ChampDto;
import org.dc.riot.lol.rx.model.champion.ChampListDto;
import org.dc.riot.lol.rx.model.championmastery.ChampionMasteryDto;
import org.dc.riot.lol.rx.model.common.BannedChampion;
import org.dc.riot.lol.rx.model.common.GameMode;
import org.dc.riot.lol.rx.model.common.GameType;
import org.dc.riot.lol.rx.model.common.Mastery;
import org.dc.riot.lol.rx.model.common.Observer;
import org.dc.riot.lol.rx.model.common.PlatformId;
import org.dc.riot.lol.rx.model.common.QueueType;
import org.dc.riot.lol.rx.model.common.RankedQueue;
import org.dc.riot.lol.rx.model.common.Rune;
import org.dc.riot.lol.rx.model.common.Season;
import org.dc.riot.lol.rx.model.currentgame.CurrentGameInfo;
import org.dc.riot.lol.rx.model.currentgame.CurrentGameParticipant;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedGameInfo;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedGameParticipant;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedGamesDto;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedParticipant;
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
import org.dc.riot.lol.rx.model.staticdata.ImageDto;
import org.dc.riot.lol.rx.model.staticdata.InfoDto;
import org.dc.riot.lol.rx.model.staticdata.ItemDto;
import org.dc.riot.lol.rx.model.staticdata.ItemListDto;
import org.dc.riot.lol.rx.model.staticdata.LanguageStringsDto;
import org.dc.riot.lol.rx.model.staticdata.LevelTipDto;
import org.dc.riot.lol.rx.model.staticdata.MapDataDto;
import org.dc.riot.lol.rx.model.staticdata.MapDetailsDto;
import org.dc.riot.lol.rx.model.staticdata.MetaDataDto;
import org.dc.riot.lol.rx.model.staticdata.PassiveDto;
import org.dc.riot.lol.rx.model.staticdata.RangeDto;
import org.dc.riot.lol.rx.model.staticdata.RecommendedDto;
import org.dc.riot.lol.rx.model.staticdata.RuneDto;
import org.dc.riot.lol.rx.model.staticdata.RuneListDto;
import org.dc.riot.lol.rx.model.staticdata.SkinDto;
import org.dc.riot.lol.rx.model.staticdata.StatsDto;
import org.dc.riot.lol.rx.model.stats.AggregatedStatsDto;
import org.dc.riot.lol.rx.model.stats.ChampionStatsDto;
import org.dc.riot.lol.rx.model.stats.PlayerStatsSummaryDto;
import org.dc.riot.lol.rx.model.stats.PlayerStatsSummaryListDto;
import org.dc.riot.lol.rx.model.stats.PlayerStatsType;
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
import org.dc.riot.lol.rx.service.RiotApi;
import org.dc.riot.lol.rx.service.error.HttpException;
import org.dc.riot.lol.rx.service.interfaces.ApiFactory;
import org.dc.riot.lol.rx.service.request.ChampDataTag;
import org.dc.riot.lol.rx.service.request.ChampListDataTag;
import org.dc.riot.lol.rx.service.request.ItemDataTag;
import org.dc.riot.lol.rx.service.request.ItemListDataTag;
import org.dc.riot.lol.rx.service.request.RuneListDataTag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntegrationTests {

	private final RESTFieldRegister register = new RESTFieldRegister();

	private final String[] names = { "HuskarDc","Ctrl Alt Dc","Nightblue3","TheOddOne","C9 Meteos","C9 TOXIC MID","C9 TOXIC JUNGLE","C9 StealthBomber","Cheer X","6 xp"};
	private final Region region = Region.NORTH_AMERICA;

	private RiotApi.Summoner summonerInterface = null;
	private RiotApi.StaticData staticInterface = null;
	private RiotApi.LolStatus statusInterface = null;
	private RiotApi.Champion championInterface = null;
	private RiotApi.ChampionMastery masteryInterface = null;
	private RiotApi.CurrentGame currentGameInterface = null;
	private RiotApi.FeaturedGames featuredGameInterface = null;
	private RiotApi.League leagueInterface = null;
	private RiotApi.Match matchInterface = null;
	private RiotApi.MatchList matchlistInterface = null;
	private RiotApi.RecentGames recentGameInterface = null;
	private RiotApi.Stats statsInterface = null;
	private RiotApi.Team teamInterface = null;

	private TestPrints prints = TestPrints.getInstance();
	private ApiFactory factory = null;
	
	private boolean testSummonerRan = false;
	private boolean testTeamRan = false;
	private boolean testStatusRan = false;

	@Before
	public void setup() throws FileNotFoundException {

		final ApiKey apiKey = ApiKey.loadApiKeys()[0];
		factory = ApiFactory.newDefaultFactory(apiKey);

		summonerInterface = factory.newSummonerInterface(region, true);
		summonerInterface.setPrintUrl(true);
		staticInterface = factory.newStaticDataInterface(region, true);
		staticInterface.setPrintUrl(false);
		statusInterface = factory.newStatusInterface(region, true);
		statusInterface.setPrintUrl(true);
		championInterface = factory.newChampionInterface(region, true);
		championInterface.setPrintUrl(true);
		currentGameInterface = factory.newCurrentGameInterface(region, true);
		currentGameInterface.setPrintUrl(true);
		featuredGameInterface = factory.newFeaturedGamesInterface(region, true);
		featuredGameInterface.setPrintUrl(true);
		leagueInterface = factory.newLeagueInterface(region, true);
		leagueInterface.setPrintUrl(true);
		teamInterface = factory.newTeamInterface(region, true);
		teamInterface.setPrintUrl(true);
		matchInterface = factory.newMatchInterface(region, true);
		matchInterface.setPrintUrl(true);
		matchlistInterface = factory.newMatchListInterface(region, true);
		matchlistInterface.setPrintUrl(true);
		masteryInterface = factory.newChampionMasteryInterface(region, true);
		masteryInterface.setPrintUrl(true);
		recentGameInterface = factory.newRecentGamesInterface(region, true);
		recentGameInterface.setPrintUrl(true);
		statsInterface = factory.newStatsInterface(region, true);
		statsInterface.setPrintUrl(true);
	}
	
	@Test
	public void testRegister() throws IllegalArgumentException, IllegalAccessException {
		prints.println("Testing TEST REGISTER");
		RESTFieldRegister testRegister = new RESTFieldRegister();
		TestPojo p1 = new TestPojo().withDouble(new Double(3.14));
		testRegister.registerInstance(p1);
		prints.println(testRegister);
		assertFalse(testRegister.testClass(TestPojo.class));
		
		p1.withInteger(new Integer(42));
		testRegister.registerInstance(p1);
		prints.println(testRegister);
		assertFalse(testRegister.testClass(TestPojo.class));
		
		TestPojo p2 = new TestPojo()
				.withDouble(new Double(Math.E))
				.withLong(new Long(5))
				.withString("Some string");
		
		testRegister.registerInstance(p2);
		prints.println(testRegister);
		assertFalse(testRegister.testClass(TestPojo.class));
		
		TestPojo p3 = new TestPojo()
				.withObject(new Object());
		
		testRegister.registerInstance(p3);
		prints.println(testRegister);
		assertTrue(testRegister.testClass(TestPojo.class));
		
		System.out.println();
		System.out.println();
	}
	
	@Test
	public void testStats() throws IOException {
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
			
			assertTrue(AggregatedStatsDto.getInstanceCount() > 0);
			assertTrue(ChampionStatsDto.getInstanceCount() > 0);
			assertTrue(PlayerStatsSummaryDto.getInstanceCount() > 0);
			assertTrue(PlayerStatsSummaryListDto.getInstanceCount() > 0);
			assertTrue(RankedStatsDto.getInstanceCount() > 0);
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
		assertNotNull(dto.getPlayerStatSummaryType());
		AggregatedStatsDto aggDto = dto.getAggregatedStats();
		assertNotNull(aggDto);
		testAggregatedStatsDto(aggDto, dto.getPlayerStatSummaryType());
	}
	
	private void testAggregatedStatsDto(AggregatedStatsDto dto, PlayerStatsType playerStatsType) {
//		assertTrue(dto.getMaxTimePlayed() > 0);
//		assertTrue(dto.getTotalSessionsPlayed() > 0);
//		assertTrue(dto.getTotalGoldEarned() > 0);
//		assertTrue(dto.getMostChampionKillsPerSession() > 0);

		if (playerStatsType == PlayerStatsType.OdinUnranked) {
			prints.println("Dominion scores");
			prints.println(dto.getAverageAssists());
			prints.println(dto.getAverageChampionsKilled());
			prints.println(dto.getAverageCombatPlayerScore());
			prints.println(dto.getAverageNodeCapture());
			prints.println(dto.getAverageNodeCaptureAssist());
			prints.println(dto.getAverageNodeNeutralize());
			prints.println(dto.getAverageNodeNeutralizeAssist());
			prints.println(dto.getAverageNumDeaths());
			prints.println(dto.getAverageObjectivePlayerScore());
			prints.println(dto.getAverageTeamObjective());
			prints.println(dto.getAverageTotalPlayerScore());
			prints.println(dto.getMaxAssists());
			prints.println(dto.getMaxChampionsKilled());
			prints.println(dto.getMaxCombatPlayerScore());
			prints.println(dto.getMaxNodeCapture());
			prints.println(dto.getMaxNodeCaptureAssist());
			prints.println(dto.getMaxNodeNeutralize());
			prints.println(dto.getMaxNodeNeutralizeAssist());
			prints.println(dto.getMaxObjectivePlayerScore());
			prints.println(dto.getMaxTeamObjective());
		}
	}
	
	private void testRankedStatsDto(RankedStatsDto dto) {
		if (!dto.isValid) {
			prints.println("WARNING", "Invalid ranked stats DTO");
			return;
		}

		assertTrue(dto.getModifyDate() > 0);
		assertTrue(dto.getSummonerId() > 0);

		ChampionStatsDto[] champDto = dto.getChampions();
		assertTrue(champDto.length > 0);
		for (ChampionStatsDto championDto : champDto) {
			testChampionStatsDto(championDto);
		}
	}
	
	private void testChampionStatsDto(ChampionStatsDto dto) {
		AggregatedStatsDto aggDto = dto.getStats();
		assertNotNull(aggDto);
		testAggregatedStatsDto(aggDto, null);
	}
	
	@Test
	public void testRecentGame() throws IOException {
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
			
			assertTrue(GameDto.getInstanceCount() > 0);
			assertTrue(PlayerDto.getInstanceCount() > 0);
			assertTrue(RawStatsDto.getInstanceCount() > 0);
			assertTrue(RecentGamesDto.getInstanceCount() > 0);
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
		assertTrue(dto.getSummonerId() > 0);
		GameDto[] gamesDto = dto.getGames();
		assertTrue(gamesDto.length > 0);
		for (GameDto gameDto : gamesDto) {
			testGameDto(gameDto);
		}
	}
	
	private void testGameDto(GameDto dto) {
		assertTrue(dto.getChampionId() > 0);
		assertTrue(dto.getCreateDate() > 0);
		assertTrue(dto.getGameId() > 0);
		assertNotNull(dto.getGameMode());
		assertNotNull(dto.getGameType());
		assertTrue(dto.getMapId() > 0);
		if (dto.getGameType() != GameType.CUSTOM_GAME) {
			assertTrue(dto.getIpEarned() > 0);
		}
		assertTrue(dto.getLevel() > 0);
		assertTrue(dto.getSpell1() > 0);
		assertTrue(dto.getSpell2() > 0);
		assertTrue(dto.getTeamId() > 0);

		if (dto.getGameType() == GameType.MATCHED_GAME) {
			PlayerDto[] playersDto = dto.getFellowPlayers();
			assertTrue(playersDto.length > 0);
			for (PlayerDto playerDto : playersDto) {
				testPlayerDto(playerDto);
			}
		}

		RawStatsDto rawStatsDto = dto.getStats();
		assertNotNull(rawStatsDto);
		testRawStatsDto(rawStatsDto);
	}
	
	private void testPlayerDto(PlayerDto dto) {
		assertTrue(dto.getChampionId() > 0);
		assertTrue(dto.getSummonerId() > 0);
		assertTrue(dto.getTeamId() > 0);
	}
	
	private void testRawStatsDto(RawStatsDto dto) {
		assertTrue(dto.getLevel() > 0);
	}

	@Test
	public void testChampionMastery() throws IOException {
		try {
			prints.println("Testing MASTERY interface");

			Map<String,SummonerDto> summonerMapDto = summonerInterface.getByNames(names);
			int highestMasteryScore = 0;
			for (SummonerDto summonerDto : summonerMapDto.values()) {
				long summonerId = summonerDto.getId();
				int masteryScore = 0;
				if ((masteryScore = masteryInterface.getMasteryScore(summonerId)) > highestMasteryScore) {
					highestMasteryScore = masteryScore;
				}

				// I expect that this returns only champions that have actually been played
				ChampionMasteryDto[] allMastery = masteryInterface.getPlayerAllMastery(summonerId);
				assertNotNull(allMastery);
				for (ChampionMasteryDto cm : allMastery) {
					testChampionMasteryDto(cm);
				}

				ChampionMasteryDto[] topN = masteryInterface.getTopChampions(summonerId, 6);
				assertNotNull(topN);
				for (ChampionMasteryDto cm : topN) {
					testChampionMasteryDto(cm);
				}

				ChampionMasteryDto champDto = masteryInterface.getPlayerChampionMastery(summonerId, 5);	// 5 is Xin Zhao
				if (champDto != null) {
					testChampionMasteryDto(champDto);
				}
			}
			
			assertTrue(ChampionMasteryDto.getCount() > 0);
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
		assertTrue(dto.getChampionId() > 0);
		assertTrue(dto.getChampionLevel() > 0);
		assertTrue(dto.getChampionPoints() > 0);
		assertTrue(dto.getLastPlayTime() > 0);
		assertTrue(dto.getPlayerId() > 0);
	}

	@Test
	public void testMatchAndMatchlist() throws IOException {
		try {
			prints.println("Testing MATCH interface");

			Map<String,SummonerDto> summonerMapDto = summonerInterface.getByNames("HuskarDc");
			SummonerDto summonerDto = summonerMapDto.get("huskardc");
			long summonerId = summonerDto.getId();
			MatchListDto matchListDto = matchlistInterface.getMatchList(summonerId, null, new RankedQueue[] {RankedQueue.RANKED_SOLO_5x5}, new Season[] {Season.SEASON2016}, -1, -1,  -1,  -1);
			assertNotNull(matchListDto);
			long matchId = testMatchListDto(matchListDto, false);

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
			testMatchListDto(boundedListDto, true);

			MatchDetail matchDetail = matchInterface.getMatch(matchId, true);
			assertNotNull(matchDetail);
			testMatchDetail(matchDetail, true);

			boolean includeTimeline = true;
			MatchDetail noTimelineDetail = matchInterface.getMatch(matchId, includeTimeline);
			assertNotNull(noTimelineDetail);
			testMatchDetail(noTimelineDetail, includeTimeline);

			assertTrue(Event.getCount() > 0);
			assertTrue(Frame.getCount() > 0);
			assertTrue(MatchDetail.getCount() > 0);
			assertTrue(MatchListDto.getCount() > 0);
			assertTrue(MatchReference.getCount() > 0);
			assertTrue(Participant.getCount() > 0);
			assertTrue(ParticipantFrame.getCount() > 0);
			assertTrue(ParticipantIdentity.getCount() > 0);
			assertTrue(ParticipantStats.getCount() > 0);
			assertTrue(ParticipantTimeline.getCount() > 0);
			assertTrue(ParticipantTimelineData.getCount() > 0);
			assertTrue(Player.getCount() > 0);
			assertTrue(Position.getCount() > 0);
			assertTrue(Team.getCount() > 0);
			assertTrue(Timeline.getCount() > 0);
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
		assertTrue(dto.getMapId() > 0);
		assertTrue(dto.getMatchCreation() > 0);
		assertTrue(dto.getMatchDuration() > 0);
		assertTrue(dto.getMatchId() > 0);
		assertNotNull(dto.getMatchMode());
		assertNotNull(dto.getMatchType());
		assertNotNull(dto.getMatchVersion());
		assertNotNull(dto.getParticipantIdentities());
		ParticipantIdentity[] identities = dto.getParticipantIdentities();
		assertNotNull(identities);
		for (ParticipantIdentity mpi : identities) {
			testParticipantIdentity(mpi);
		}

		Participant[] participants = dto.getParticipants();
		assertNotNull(participants);
		for (Participant mp : participants) {
			testMatchParticipant(mp, timeLine);
		}

		assertNotNull(dto.getPlatformId());
		assertNotNull(dto.getQueueType());
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
		assertTrue(dto.getTeamId() > 0);
	}

	private void testMatchParticipant(Participant dto, boolean expectTimeline) {
		assertTrue(dto.getChampionId() > 0);
		assertNotNull(dto.getHighestAchievedSeasonTier());
		assertTrue(dto.getParticipantId() > 0);
		assertNotNull(dto.getRunes());
		assertTrue(dto.getSpell1Id() > 0);
		assertTrue(dto.getSpell2Id() > 0);

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
		assertTrue(dto.getParticipantId() > 0);
		assertNotNull(dto.getPlayer());
	}

	private void testTimeline(Timeline dto) {
		assertTrue(dto.getFrameInterval() > 0);
		Frame[] frames = dto.getFrames();
		assertNotNull(frames);
		boolean firstFrame = true;
		for (Frame f : frames) {
			testFrame(f, firstFrame);
			firstFrame = false;
		}
	}
	
	private void testFrame(Frame dto, boolean firstFrame) {
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
			prints.println("MATCH frames " + k);
			ParticipantFrame pf = frames.get(k);
			testParticipantFrame(pf);
		}
	}
	
	private void testEvent(Event dto) {
		assertNotNull(dto.getEventType());
		assertTrue(	dto.getTimestamp() > 0);
	}
	
	private void testParticipantFrame(ParticipantFrame dto) {
//		assertTrue(dto.getCurrentGold() > 0);
		assertTrue(dto.getLevel() > 0);
		assertTrue(dto.getParticipantId() > 0);
//		assertNotNull(dto.getPosition());
//		assertTrue(dto.getTotalGold() > 0);
	}

	private long testMatchListDto(MatchListDto dto, boolean expectNullQueue) {
		assertTrue(dto.getTotalGames() > 0);
		MatchReference[] matchRefs = dto.getMatches();
		long matchId = 0;
		for (MatchReference mf : matchRefs) {
			testMatchReference(mf, expectNullQueue);
			matchId = mf.getMatchId();
		}

		return matchId;
	}

	private void testMatchReference(MatchReference dto, boolean expectNullQueue) {
		assertTrue(dto.getChampion() > 0);
		assertTrue(dto.getMatchId() > 0);
		assertTrue(dto.getTimestamp() > 0);
		assertNotNull(dto.getLane());
		assertNotNull(dto.getPlatformId());
		if (expectNullQueue) {
			assertNull(dto.getQueue());
		} else {
			assertNotNull(dto.getQueue());
		}
		assertNotNull(dto.getRegion());
		assertNotNull(dto.getRole());
		assertNotNull(dto.getSeason());
	}

	private void testParticipantStats(ParticipantStats dto) {
		assertTrue(dto.getTotalDamageDealt() > 0);
	}

	private void testParticipantTimeline(ParticipantTimeline dto) {
//		assertNotNull(dto.getAncientGolemAssistsPerMinCounts());
//		assertNotNull(dto.getAncientGolemKillsPerMinCounts());
//		assertNotNull(dto.getAssistedLaneDeathsPerMinDeltas());
//		assertNotNull(dto.getAssistedLaneKillsPerMinDeltas());
//		assertNotNull(dto.getBaronAssistsPerMinCounts());
//		assertNotNull(dto.getBaronKillsPerMinCounts());
//		assertNotNull(dto.getCreepsPerMinDeltas());
//		assertNotNull(dto.getCsDiffPerMinDeltas());
//		assertNotNull(dto.getDamageTakenDiffPerMinDeltas());
//		assertNotNull(dto.getDamageTakenPerMinDeltas());
//		assertNotNull(dto.getDragonAssistsPerMinCounts());
//		assertNotNull(dto.getDragonKillsPerMinCounts());
//		assertNotNull(dto.getElderLizardAssistsPerMinCounts());
//		assertNotNull(dto.getElderLizardKillsPerMinCounts());
//		assertNotNull(dto.getGoldPerMinDeltas());
//		assertNotNull(dto.getInhibitorAssistsPerMinCounts());
//		assertNotNull(dto.getInhibitorKillsPerMinCounts());
		assertNotNull(dto.getLane());
		assertNotNull(dto.getRole());
//		assertNotNull(dto.getTowerAssistsPerMinCounts());
//		assertNotNull(dto.getTowerKillsPerMinCounts());
//		assertNotNull(dto.getTowerKillsPerMinDeltas());
//		assertNotNull(dto.getVilemawAssistsPerMinCounts());
//		assertNotNull(dto.getVilemawKillsPerMinCounts());
//		assertNotNull(dto.getWardsPerMinDeltas());
//		assertNotNull(dto.getXpDiffPerMinDeltas());
//		assertNotNull(dto.getXpPerMinDeltas());
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
					prints.println("WARNING", "League not found for team");
				} else {
					throw e;
				}
			}
			
			assertTrue(LeagueDto.getInstanceCount() > 0);
			assertTrue(LeagueEntryDto.getInstanceCount() > 0);
			assertTrue(MiniSeriesDto.getInstanceCount() > 0);
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

	private void testLeagueDto(LeagueDto dto) {
		assertNotNull(dto.getQueue());
		assertNotNull(dto.getTier());
		assertNotNull(dto.getName());

		LeagueEntryDto[] lDto = dto.getEntries();
		assertNotNull(lDto);

		boolean foundWins = false;
		boolean foundLosses = false;
		boolean foundLP = false;
		boolean foundFreshBlood = false;
		boolean foundHotStreak = false;
		boolean foundInactive = false;
		boolean foundVeteran = false;
		boolean foundMini = false;
		for (LeagueEntryDto led : lDto) {
			assertNotNull(led.getDivision());
			assertNotNull(led.getPlayerOrTeamId());
			assertNotNull(led.getPlayerOrTeamName());

			if (led.getWins() > 0) {
				foundWins = true;
			}

			if (led.getLosses() > 0) {
				foundLosses = true;
			}

			if (led.getLeaguePoints() > 0) {
				foundLP = true;
			}

			if (led.isFreshBlood()) {
				foundFreshBlood = true;
			}

			if (led.isHotStreak()) {
				foundHotStreak = true;
			}

			if (led.isInactive()) {
				foundInactive = true;
			}

			if (led.isVeteran()) {
				foundVeteran = true;
			}

			MiniSeriesDto miniDto = led.getMiniSeries();
			if (miniDto != null) {
				foundMini = true;
				assertTrue(miniDto.getTarget() > 0);
			}
		}

		if (!foundLP) {
			prints.println("WARNING", "Found no LP");
		}
		if (!foundWins) {
			prints.println("WARNING", "Found no WINS");
		}
		if (!foundLosses) {
			prints.println("WARNING", "Found no LOSSES");
		}
		if (!foundFreshBlood) {
			prints.println("WARNING", "Found no FRESH BLOODS");
		}
		if (!foundHotStreak) {
			prints.println("WARNING", "Found no HOT STREAKS");
		}
		if (!foundInactive) {
			prints.println("WARNING", "Found no INACTIVES");
		}
		if (!foundVeteran) {
			prints.println("WARNING", "Found no VETERANS");
		}
		if (!foundMini) {
			prints.println("WARNING", "Found no MINI SERIES");
		}
	}

	@Test
	public void testFeaturedGame() throws IOException {
		try {
			prints.println("Testing FEATURED GAMES interface");

			FeaturedGamesDto dto = featuredGameInterface.getFeaturedGames();
			assertNotNull(dto);
			assertTrue(dto.getClientRefreshInterval() > 0);
			FeaturedGameInfo[] gameInfos = dto.getGameList();
			assertTrue(gameInfos.length > 0);
			for (FeaturedGameInfo gfo : gameInfos) {
				assertTrue(gfo.getGameId() > 0);
				assertTrue(gfo.getGameLength() > 0);
				assertTrue(gfo.getGameQueueConfigId() > 0);
				assertTrue(gfo.getGameStartTime() > 0);
				assertTrue(gfo.getMapId() > 0);
				assertNotNull(gfo.getGameType());
				assertNotNull(gfo.getGameMode());
				assertNotNull(gfo.getPlatformId());

				BannedChampion[] bans = gfo.getBannedChampions();
				for (BannedChampion bc : bans) {
					assertTrue(bc.getChampionId() > 0);
					assertTrue(bc.getPickTurn() > 0);
					assertTrue(bc.getTeamId() > 0);
				}

				Observer obs = gfo.getObservers();
				assertNotNull(obs);
				assertNotNull(obs.getEncryptionKey());

				FeaturedParticipant[] participants = gfo.getParticipants();
				assertTrue(participants.length > 0);
				for (FeaturedParticipant p : participants) {
					assertTrue(p.getChampionId() > 0);
					assertTrue(p.getSpell1Id() > 0);
					assertTrue(p.getSpell2Id() > 0);
					assertTrue(p.getChampionId() > 0);
					assertTrue(p.getTeamId() > 0);
					assertNotNull(p.getSummonerName());
				}
			}
			
			assertTrue(FeaturedGameInfo.getInstanceCount() > 0);
			assertTrue(FeaturedGameParticipant.getInstanceCount() > 0);
			assertTrue(FeaturedGamesDto.getInstanceCount() > 0);
			assertTrue(FeaturedParticipant.getInstanceCount() > 0);
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

	@Test
	public void testCurrentGame() throws IOException {
		try {
			prints.println("Testing CURRENT GAME interface");

			Map<String,SummonerDto> summonerDto = summonerInterface.getByNames(names);
			boolean somebodyInGame = false;
			for (SummonerDto dto : summonerDto.values()) {
				CurrentGameInfo cgi = currentGameInterface.getSpectatorInfo(dto.getId());
				assertNotNull(cgi);
				if (!cgi.notInGame) {
					somebodyInGame = true;
				} else {
					continue;
				}

				assertTrue(cgi.getGameId() > 0);
				assertTrue(cgi.getGameLength() > 0);
				assertTrue(cgi.getMapId() > 0);
				assertTrue(cgi.getGameQueueConfigId() > 0);
				assertTrue(cgi.getGameStartTime() > 0);

				GameMode gameMode = cgi.getGameMode();
				assertNotNull(gameMode);

				GameType gameType = cgi.getGameType();
				assertNotNull(gameType);

				Observer observers = cgi.getObservers();
				assertNotNull(observers);
				assertNotNull(observers.getEncryptionKey());

				CurrentGameParticipant[] cgp = cgi.getParticipants();
				assertNotNull(cgp);
				for (CurrentGameParticipant p : cgp) {
					assertTrue(p.getChampionId() > 0);
					assertTrue(p.getProfileIconId() > 0);
					assertTrue(p.getSpell1Id() > 0);
					assertTrue(p.getSpell2Id() > 0);
					assertTrue(p.getSummonerId() > 0);
					assertNotNull(p.getSummonerName());

					Mastery[] masteries = p.getMasteries();
					assertNotNull(masteries);
					for (Mastery m : masteries) {
						assertTrue(m.getMasteryId() > 0);
					}

					Rune[] runes = p.getRunes();
					assertNotNull(runes);
					for (Rune r : runes) {
						assertTrue(r.getRuneId() > 0);
					}
				}

				PlatformId pid = cgi.getPlatformId();
				assertNotNull(pid);
				Region r = pid.toRegion();
				assertTrue(r == currentGameInterface.getRegion());

				BannedChampion[] bans = cgi.getBannedChampions();
				assertNotNull(bans);
				for (BannedChampion b : bans) {
					assertTrue(b.getTeamId() > 0);
					assertTrue(b.getChampionId() > 0);
					assertTrue(b.getPickTurn() > 0);
				}
			}

			if (!somebodyInGame) {
				prints.println("WARNING", "Nobody in game to properly test current game");
			} else {
				assertTrue(CurrentGameInfo.getInstanceCount() > 0);
				assertTrue(CurrentGameParticipant.getInstanceCount() > 0);
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

	@Test
	public void testChampion() throws IOException {
		try {
			prints.println("Testing CHAMPION interface");

			ChampListDto freeChamps = championInterface.getChampions(true);
			assertNotNull(freeChamps);
			ChampDto[] metas = freeChamps.getChampions();
			assertNotNull(metas);
			for (ChampDto dto : metas) {
				assertTrue(dto.getId() > 0);
				assertTrue(dto.isFreeToPlay());
			}

			ChampListDto allChamps = championInterface.getChampions(false);
			assertNotNull(allChamps);
			boolean foundBotEnabled = false;
			boolean foundBotMmEnabled = false;
			boolean foundRankedPlayEnabled = false;
			boolean foundActive = false;
			for (ChampDto dto : allChamps.getChampions()) {
				if (dto.isBotEnabled()) {
					foundBotEnabled = true;
				}

				if (dto.isBotMmEnabled()) {
					foundBotMmEnabled = true;
				}

				if (dto.isActive()) {
					foundActive = true;
				}

				if (dto.isRankedPlayEnabled()) {
					foundRankedPlayEnabled = true;
				}
			}

			assertTrue(foundBotEnabled);
			assertTrue(foundBotMmEnabled);
			assertTrue(foundRankedPlayEnabled);
			assertTrue(foundActive);

			for (ChampDto dto : allChamps.getChampions()) {
				long id = dto.getId();
				ChampDto otherDto = championInterface.getChampion(id);
				assertTrue(id == otherDto.getId());
			}
			
			assertTrue(ChampDto.getInstanceCount() > 0);
			assertTrue(ChampListDto.getInstanceCount() > 0);
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

	private void testSummonerRunes(long summonerId) throws IOException, HttpException {
		Map<String,RunePagesDto> mapDto = summonerInterface.getRunes(summonerId);
		assertNotNull("Map dto null", mapDto);

		RunePagesDto dto = mapDto.values().toArray(new RunePagesDto[mapDto.values().size()])[0];
		assertNotNull("Dto null", dto);

		long sid = dto.getSummonerId();
		assertTrue(summonerId == sid);

		RunePageDto[] pages = dto.getPages();
		assertNotNull(pages);
		assertTrue(pages.length > 0);

		for (RunePageDto rp : pages) {
			assertTrue(rp.getId() > 0);
			assertNotNull(rp.getName());
			RuneSlotDto[] slots = rp.getSlots();
			assertNotNull(slots);

			for (RuneSlotDto s : slots) {
				long runeId = s.getRuneId();
				assertTrue(runeId > 0);
				assertTrue(s.getRuneSlotId() > 0);
			}
		}
	}

	private void testSummonerNames(long summonerId) throws IOException, HttpException {
		Map<String,String> mapDto = summonerInterface.getNames(summonerId);
		assertNotNull("Map dto null", mapDto);

		for (String key : mapDto.keySet()) {
			String name = mapDto.get(key);
			assertNotNull(name);

			prints.println(key + " : " + name);
		}
	}

	@Test
	public void testStaticData() throws IOException {
		try {
			// CHAMPION DATA
			ChampionListDto champListDto = staticInterface.getChampions(true, null, null, ChampListDataTag.ALL);
			assertNotNull(champListDto);
			testChampionListDto(champListDto);
			
			for (ChampionDto championDto : champListDto.getData().values()) {
				long champId = championDto.getId();
				ChampionDto champDto = staticInterface.getChampion(champId, null, null, ChampDataTag.ALL);
				assertNotNull(champDto);
				prints.println(champDto.getName());
				testChampionDto(champDto);
			}
			
			// ITEM DATA
			ItemListDto itemListDto = staticInterface.getItems(null, null, ItemListDataTag.ALL);
			assertNotNull(itemListDto);
			testItemListDto(itemListDto);
			
			for (ItemDto itemDto : itemListDto.getData().values()) {
				long itemId = itemDto.getId();
				ItemDto itDto = staticInterface.getItem(itemId, null, null, ItemDataTag.ALL);
				assertNotNull(itDto);
				prints.println(itDto.getName());
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
			
			RuneListDto listDto = staticInterface.getRunes(null, null, RuneListDataTag.ALL);
			assertNotNull(listDto);
//			testRuneListDto(listDto);
			
			assertTrue(BasicDataStatsDto.getInstanceCount() > 0);
			assertTrue(BlockDto.getInstanceCount() > 0);
			assertTrue(BlockItemDto.getInstanceCount() > 0);
			assertTrue(ChampionDto.getInstanceCount() > 0);
			assertTrue(ChampionListDto.getInstanceCount() > 0);
			assertTrue(ChampionSpellDto.getInstanceCount() > 0);
			assertTrue(GoldDto.getInstanceCount() > 0);
			assertTrue(ImageDto.getInstanceCount() > 0);
			assertTrue(InfoDto.getInstanceCount() > 0);
			assertTrue(LevelTipDto.getInstanceCount() > 0);
			assertTrue(MetaDataDto.getInstanceCount() > 0);
			assertTrue(PassiveDto.getInstanceCount() > 0);
			assertTrue(RangeDto.getInstanceCount() > 0);
			assertTrue(RecommendedDto.getInstanceCount() > 0);
			assertTrue(RuneDto.getInstanceCount() > 0);
			assertTrue(RuneListDto.getInstanceCount() > 0);
			assertTrue(SkinDto.getInstanceCount() > 0);
			assertTrue(StatsDto.getInstanceCount() > 0);
			
			fail("Not all endpoints exercised");
			
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
	
	private void testMapDataDto(MapDataDto dto) {
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
		assertTrue(dto.getMapId() > 0);
		assertNotNull(dto.getMapName());
		assertTrue(dto.getUnpurchaseableItemList().length > 0);
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);
	}
	
	private void testLanguageStringsDto(LanguageStringsDto dto) {
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
		assertNotNull(dto.getHeader());
		assertTrue(dto.getTags().length > 0);
	}
	
	private void testGroupDto(GroupDto dto) {
		assertNotNull(dto.getMaxGroupOwnable());
		assertNotNull(dto.getKey());
	}
	
	private void testBasicDataDto(BasicDataDto dto) {
		prints.println("STATIC basicDataDto " + dto.getName());
		if (dto.getId() == 0) {
			prints.println("WARNING", dto);
			return;
		}

		assertNotNull(dto.getName());
		assertNotNull(dto.getDescription());
		
		String plainText = dto.getPlaintext();
		if (plainText == null) {
			prints.println("WARNING", "Plain text null");
		}

		String group = dto.getGroup();
		if (group == null) {
			prints.println("WARNING", "Group null");
		}
		
		String sanDesc = dto.getSanitizedDescription();
		if (sanDesc == null) {
			prints.println("WARNING", "Sanitized description null");
		}

		String[] tags = dto.getTags();
		if (tags.length == 0) {
			prints.println("WARNING", "No tags");
		}

		String colloq = dto.getColloq();
		if (colloq == null) {
			prints.println("WARNING", "Colloq null");
		}

		BasicDataStatsDto basicDataDto = dto.getStats();
		if (basicDataDto != null) {
			testBasicDataStatsDto(basicDataDto);
		} else {
			prints.println("WARNING", "Stats null");
		}
		
		ImageDto imageDto = dto.getImage();
		if (imageDto != null) {
			testImageDto(imageDto);
		} else {
			prints.println("WARNING", "Image data null");
		}
	}
	
	private void testItemDto(ItemDto dto) {
		testBasicDataDto(dto);
		if (dto.getEffect().values().size() == 0) {
			prints.println("WARNING", "No effects");
		}
	}
	
	private void testChampionListDto(ChampionListDto dto) {
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
		assertTrue(dto.sum() > 0);
	}
	
	private void testChampionSpellDto(ChampionSpellDto dto) {
		assertTrue(dto.getCooldown().length > 0);
		assertNotNull(dto.getCooldownBurn());
		assertTrue(dto.getCost().length > 0);
		assertNotNull(dto.getCostBurn());
		assertNotNull(dto.getCostType());
		assertNotNull(dto.getDescription());
//		assertTrue(dto.getEffectBurn().length > 0);
		assertNotNull(dto.getKey());
		assertNotNull(dto.getTooltip());
		assertNotNull(dto.getSanitizedTooltip());
		assertNotNull(dto.getSanitizedDescription());
		if (dto.getResource() == null) {
			prints.println("WARNING", "RESOURCE NULL");
		}

		assertNotNull(dto.getRangeBurn());
		assertNotNull(dto.getName());
		
		ImageDto[] altImageDto = dto.getAltimages();
//		assertTrue(altImageDto.length > 0);
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
		assertNotNull(dto.getLink());
		assertNotNull(dto.getKey());
	}
	
	private void testRangeDto(RangeDto dto) {
		if (dto.isSelf()) {
			assertTrue(dto.getRanges().length == 0);
		} else {
			assertTrue(dto.getRanges().length > 0);
		}
	}
	
	private void testLevelTipDto(LevelTipDto dto) {
		assertTrue(dto.getEffect().length > 0);
		assertTrue(dto.getLabel().length > 0);
	}
	
	private void testSkinDto(SkinDto dto) {
		assertTrue(dto.getId() > 0);
//		assertTrue(dto.getNum() > 0);
		assertNotNull(dto.getName());
	}
	
	private void testRuneListDto(RuneListDto dto) {
		fail();
	}
	
	private void testBasicDataStatsDto(BasicDataStatsDto dto) {
		assertTrue(dto.sum() > 0);
	}
	
	private void testPassiveDto(PassiveDto dto) {
		assertNotNull(dto.getDescription());
		assertNotNull(dto.getName());
		assertNotNull(dto.getSanitizedDescription());
		
		ImageDto imageDto = dto.getImage();
		assertNotNull(imageDto);
		testImageDto(imageDto);
	}

	private void testImageDto(ImageDto dto) {
		assertNotNull(dto.getFull());
		assertNotNull(dto.getGroup());
		assertNotNull(dto.getSprite());
		assertTrue(dto.getH() > 0);
		assertTrue(dto.getW() > 0);
	}
	
	private void testInfoDto(InfoDto dto) {
		assertTrue(dto.sum() > 0);
	}
	
	private void testRecommendedDto(RecommendedDto dto) {
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
//		assertNotNull(dto.getType());
		BlockItemDto[] blockItemListDto = dto.getItems();
		assertTrue(blockItemListDto.length > 0);
		for (BlockItemDto blockItemDto : blockItemListDto) {
			testBlockItemDto(blockItemDto);
		}
	}
	
	private void testBlockItemDto(BlockItemDto dto) {
		assertTrue(dto.getId() > 0);
		assertTrue(dto.getCount() > 0);
	}

	private void testMetaDataDto(MetaDataDto dto) {
		assertNotNull(dto.getTier());
		assertNotNull(dto.getType());
	}

	private void testGoldDto(GoldDto dto) {
		if (dto.isPurchasable()) {
			assertTrue(dto.getBase() > 0);
			assertTrue(dto.getSell() > 0);
			assertTrue(dto.getTotal() > 0);
		} else {
			assertTrue(dto.getBase() == 0);
			assertTrue(dto.getSell() == 0);
			assertTrue(dto.getTotal() == 0);
		}
	}

	private void testRuneDto(RuneDto dto) {
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
	
	@Test
	public void testStatus() throws IOException {
		testStatusRan = true;
		try {
			prints.println("INFO", "Testing STATUS");
			boolean correctUnsupportedRegion = false;
			try {
				factory.newStatusInterface(Region.KOREA, false);
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

		Service[] services = dto.getServices();
		assertNotNull(services);
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
	
	@After
	public void testPojos() {
		prints.println("INFO", "Testing POJOs");
		
		// status POJOs
		if (testStatusRan) {
			assertTrue(Incident.getInstanceCount() > 0);
			assertTrue(Message.getInstanceCount() > 0);
			assertTrue(Service.getInstanceCount() > 0);
			assertTrue(Shard.getInstanceCount() > 0);
			assertTrue(ShardStatus.getInstanceCount() > 0);
			assertTrue(Translation.getInstanceCount() > 0);
			assertTrue(register.testClass(Incident.class));
			assertTrue(register.testClass(Message.class));
			assertTrue(register.testClass(Service.class));
			assertTrue(register.testClass(Shard.class));
			assertTrue(register.testClass(ShardStatus.class));
			assertTrue(register.testClass(Translation.class));
		}

		// summoner POJOs
		if (testSummonerRan) {
			assertTrue(MasteryPageDto.getInstanceCount() > 0);
			assertTrue(MasteryPagesDto.getInstanceCount() > 0);
			assertTrue(RunePageDto.getInstanceCount() > 0);
			assertTrue(RunePagesDto.getInstanceCount() > 0);
			assertTrue(RuneSlotDto.getInstanceCount() > 0);
			assertTrue(SummonerDto.getInstanceCount() > 0);
			assertTrue(register.testClass(MasteryPageDto.class));
			assertTrue(register.testClass(MasteryPagesDto.class));
			assertTrue(register.testClass(RunePageDto.class));
			assertTrue(register.testClass(RunePagesDto.class));
			assertTrue(register.testClass(RuneSlotDto.class));
			assertTrue(register.testClass(SummonerDto.class));
		}
		
		// team POJOs
		if (testTeamRan) {
			assertTrue(MatchHistorySummaryDto.getInstanceCount() > 0);
			assertTrue(RosterDto.getInstanceCount() > 0);
			assertTrue(TeamDto.getInstanceCount() > 0);
			assertTrue(TeamMemberInfoDto.getInstanceCount() > 0);
			assertTrue(TeamStatDetailDto.getInstanceCount() > 0);
			assertTrue(register.testClass(MatchHistorySummaryDto.class));
			assertTrue(register.testClass(RosterDto.class));
			assertTrue(register.testClass(TeamDto.class));
			assertTrue(register.testClass(TeamMemberInfoDto.class));
			assertTrue(register.testClass(TeamStatDetailDto.class));
		}
		
		
		System.out.println();
		prints.println(register);
	}

}
