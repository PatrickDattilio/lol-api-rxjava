package org.dc.riot.lol.rx;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.dc.riot.lol.rx.model.BasicDataStatsDto;
import org.dc.riot.lol.rx.model.ChampionMetaDto;
import org.dc.riot.lol.rx.model.ChampionMetaListDto;
import org.dc.riot.lol.rx.model.ImageDto;
import org.dc.riot.lol.rx.model.MasteryMetaDto;
import org.dc.riot.lol.rx.model.MatchParticipantStats;
import org.dc.riot.lol.rx.model.MetaDataDto;
import org.dc.riot.lol.rx.model.RuneDto;
import org.dc.riot.lol.rx.model.RuneListDto;
import org.dc.riot.lol.rx.model.RuneMetaDto;
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
import org.dc.riot.lol.rx.model.featuredgame.FeaturedGamesDto;
import org.dc.riot.lol.rx.model.featuredgame.FeaturedParticipant;
import org.dc.riot.lol.rx.model.league.LeagueDto;
import org.dc.riot.lol.rx.model.league.LeagueEntryDto;
import org.dc.riot.lol.rx.model.league.MiniSeriesDto;
import org.dc.riot.lol.rx.model.match.MatchDetail;
import org.dc.riot.lol.rx.model.match.MatchListDto;
import org.dc.riot.lol.rx.model.match.MatchReference;
import org.dc.riot.lol.rx.model.match.Participant;
import org.dc.riot.lol.rx.model.match.ParticipantIdentity;
import org.dc.riot.lol.rx.model.match.ParticipantTimeline;
import org.dc.riot.lol.rx.model.match.Team;
import org.dc.riot.lol.rx.model.match.Timeline;
import org.dc.riot.lol.rx.model.status.Service;
import org.dc.riot.lol.rx.model.status.Shard;
import org.dc.riot.lol.rx.model.status.ShardStatus;
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
import org.dc.riot.lol.rx.service.request.RuneDataTag;
import org.dc.riot.lol.rx.service.request.RuneListDataTag;
import org.junit.Before;
import org.junit.Test;

public class IntegrationTests {

	private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

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

	@Before
	public void setup() throws FileNotFoundException {
		final ApiKey apiKey = ApiKey.loadApiKeys()[0];
		factory = ApiFactory.newDefaultFactory(apiKey);

		summonerInterface = factory.newSummonerInterface(region, true);
		summonerInterface.setPrintUrl(true);
		staticInterface = factory.newStaticDataInterface(region, true);
		staticInterface.setPrintUrl(true);
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
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
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
			MatchListDto matchListDto = matchlistInterface.getMatchList(summonerId, null, new RankedQueue[] {RankedQueue.RANKED_SOLO_5x5}, new Season[] {Season.PRESEASON2016}, -1, -1,  -1,  -1);
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

			MatchDetail noTimelineDetail = matchInterface.getMatch(matchId, false);
			assertNotNull(noTimelineDetail);
			testMatchDetail(noTimelineDetail, false);
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
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
			testMatchTeams(mt);
		}

		assertNotNull(dto.getTimeline());
		testMatchTimeline(dto.getTimeline());
	}

	private void testMatchTeams(Team teams) {
		fail();
	}

	private void testMatchParticipant(Participant dto, boolean expectTimeline) {
		assertTrue(dto.getChampionId() > 0);
		assertNotNull(dto.getHighestAchievedSeasonTier());
		assertTrue(dto.getParticipantId() > 0);
		assertNotNull(dto.getRunes());
		assertTrue(dto.getSpell1Id() > 0);
		assertTrue(dto.getSpell2Id() > 0);

		MatchParticipantStats matchParticipantStats = dto.getStats();
		assertNotNull(matchParticipantStats);
		testMatchParticipantStats(matchParticipantStats);

		assertTrue(dto.getTeamId() > 0);

		if (expectTimeline) {
			ParticipantTimeline timeline = dto.getTimeline();
			assertNotNull(timeline);
			testMatchParticipantTimeline(timeline);
		}
	}

	private void testParticipantIdentity(ParticipantIdentity dto) {
		fail();
	}

	private void testMatchTimeline(Timeline dto) {
		fail();
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

	private void testMatchParticipantStats(MatchParticipantStats dto) {
		fail();
	}

	private void testMatchParticipantTimeline(ParticipantTimeline dto) {
		fail();
	}

	@Test
	public void testTeam() throws IOException {
		try {
			prints.println("Testing TEAM interface");

			Map<String,SummonerDto> summonersDto = summonerInterface.getByNames(names);
			long[] summonerIds = getSummonerIds(summonersDto);
			Map<String,String> summonerNames = summonerInterface.getNames(summonerIds);
			Map<String,TeamDto[]> summonerTeams = teamInterface.getTeamsBySummoners(summonerIds);
			for (String key : summonerTeams.keySet()) {
				prints.println("TEAMS for " + summonerNames.get(key));
				TeamDto[] teamsDto = summonerTeams.get(key);
				for (TeamDto teamDto : teamsDto) {
					prints.println(teamDto.getName());
					assertNotNull(teamDto);
					testTeamDto(teamDto);
				}
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	private void testTeamDto(TeamDto dto) {
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
		assertNotNull(dto.getTeamStatType());

		if (dto.getAverageGamesPlayed() == 0) {
			prints.println("WARNING", "Team with no average games played");
		}

		if (dto.getWins() == 0) {
			prints.println("WARNING", "Team with no wins");
		}

		if (dto.getLosses() == 0) {
			prints.println("WARNING", "Team with no losses");
		}
	}

	private void testRosterDto(RosterDto dto) {
		assertTrue(dto.getOwnerId() > 0);
		TeamMemberInfoDto[] teamMembersDto = dto.getMemberList();
		assertTrue(teamMembersDto.length > 0);
		for (TeamMemberInfoDto teamMember : teamMembersDto) {
			testTeamMemberInfoDto(teamMember);
		}
	}

	private void testTeamMemberInfoDto(TeamMemberInfoDto dto) {
		assertTrue(dto.getInviteDate() > 0);
		assertTrue(dto.getJoinDate() > 0);
		assertTrue(dto.getPlayerId() > 0);
		assertNotNull(dto.getStatus());
	}

	private void testMatchHistorySummaryDto(MatchHistorySummaryDto dto) {
		assertTrue(dto.getGameId() > 0);
		assertTrue(dto.getMapId() > 0);
		assertTrue(dto.getDate() > 0);
		assertNotNull(dto.getGameMode());
		assertNotNull(dto.getOpposingTeamName());

		if (dto.getKills() == 0 || dto.getAssists() == 0) {
			prints.println("WARNING", "Found game with NO KILLS OR ASSISTS " + dto.getGameId());
		}

		if (dto.getDate() == 0) {
			prints.println("WARNING", "Found game with NO DEATHS " + dto.getGameId());
		}

		if (dto.getOpposingTeamKills() == 0) {
			prints.println("WARNING", "Found game with NO OPPOSING KILLS " + dto.getGameId());
		}
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
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
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
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
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
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	@Test
	public void testChampion() throws IOException {
		try {
			prints.println("Testing CHAMPION interface");

			ChampionMetaListDto freeChamps = championInterface.getChampions(true);
			assertNotNull(freeChamps);
			ChampionMetaDto[] metas = freeChamps.getChampions();
			assertNotNull(metas);
			for (ChampionMetaDto dto : metas) {
				assertTrue(dto.getId() > 0);
				assertTrue(dto.isFreeToPlay());
			}

			ChampionMetaListDto allChamps = championInterface.getChampions(false);
			assertNotNull(allChamps);
			boolean foundBotEnabled = false;
			boolean foundBotMmEnabled = false;
			boolean foundRankedPlayEnabled = false;
			boolean foundActive = false;
			for (ChampionMetaDto dto : allChamps.getChampions()) {
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

			for (ChampionMetaDto dto : allChamps.getChampions()) {
				long id = dto.getId();
				ChampionMetaDto otherDto = championInterface.getChampion(id);
				assertTrue(id == otherDto.getId());
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	@Test
	public void testSummoners() throws IOException {
		try {
			Map<String,SummonerDto> summonersDto = summonerInterface.getByNames(names);

			assertNotNull("RiotApi.Summoner.getByNames(String[]) returned null", summonersDto);
			assertTrue("No summoners found", summonersDto.values().size() > 0);

			for (SummonerDto summonerDto : summonersDto.values()) {
				long summonerId = testSummonerDatas(summonerDto);
				testSummonerDatas(summonerId);
				testSummonerMasteries(summonerId);
				testSummonerRunes(summonerId);
				testSummonerNames(summonerId);
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
		} finally {
			System.out.println();
			System.out.println();
		}
	}

	private long testSummonerDatas(SummonerDto dto) {
		prints.println("testSummonerDatas(SummonerDto)");

		assertNotNull("Name is null", dto.getName());
		prints.println(dto.getName());

		assertNotNull("Region is null", dto.getRegion());
		prints.println(dto.getRegion());

		long iconId = dto.getProfileIconId();
		assertTrue("No icon id", iconId > 0);

		assertTrue("Revision date not set", dto.getRevisionDate() > 0);
		Date date = new Date(dto.getRevisionDate());
		prints.println(sdf.format(date));

		long level = dto.getSummonerLevel();
		assertTrue("Level not set", level > 0);

		long summonerId = dto.getId();
		assertTrue("No summonerId", summonerId > 0);

		return summonerId;
	}

	private void testSummonerDatas(long summonerId) throws IOException, HttpException {
		prints.println("testSummonerDatas(long)");

		Map<String,SummonerDto> mapDto = summonerInterface.getByIds(summonerId);
		assertNotNull(mapDto);

		SummonerDto dto = mapDto.values().toArray(new SummonerDto[mapDto.values().size()])[0];
		assertNotNull(dto);

		assertNotNull("Name is null", dto.getName());
		prints.println(dto.getName());

		assertNotNull("Region is null " + dto.getName(), dto.getRegion());
		prints.println(dto.getRegion());

		long iconId = dto.getProfileIconId();
		assertTrue("No icon id", iconId > 0);

		assertTrue("Revision date not set", dto.getRevisionDate() > 0);
		Date date = new Date(dto.getRevisionDate());
		prints.println(sdf.format(date));

		long level = dto.getSummonerLevel();
		assertTrue("Level not set", level > 0);

		long id = dto.getId();
		assertTrue("No summonerId", id == summonerId);
	}

	private void testSummonerMasteries(long summonerId) throws IOException, HttpException {
		prints.println("testSummonerMasteries(long)");

		Map<String,MasteryPagesDto> mapDto = summonerInterface.getMasteries(summonerId);
		assertNotNull("Map dto null", mapDto);

		MasteryPagesDto dto = mapDto.values().toArray(new MasteryPagesDto[mapDto.values().size()])[0];
		assertNotNull("Dto null", dto);

		assertNotNull("Dto is null", dto);
		assertTrue("Mismatch summoner ID", dto.getSummonerId() == summonerId);

		for (MasteryPageDto mp : dto.getPages()) {
			long pageId = mp.getId();
			assertTrue("No mastery page ID", pageId > 0);

			String pageName = mp.getName();
			assertNotNull("Mastery page has no name", pageName);

			MasteryMetaDto[] masteries = mp.getMasteries();
			assertNotNull("Mastery page is null", masteries);
			for (MasteryMetaDto m : masteries) {
				assertTrue("No mastery rank", m.getRank() > 0);
				assertTrue("No mastery id", m.getId() > 0);
			}
		}
	}

	private void testSummonerRunes(long summonerId) throws IOException, HttpException {
		prints.println("testSummonerRunes(long)");

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
		prints.println("testSummonerNames(long)");

		Map<String,String> mapDto = summonerInterface.getNames(summonerId);
		assertNotNull("Map dto null", mapDto);

		for (String key : mapDto.keySet()) {
			String name = mapDto.get(key);
			assertNotNull(name);

			prints.println(key + " : " + name);
		}
	}

	@Test
	public void testStaticRunes() throws IOException {
		try {
			RuneListDto listDto = staticInterface.getRunes(null, null, RuneListDataTag.ALL);
			for (RuneDto runeDto : listDto.getData().values()) {
				long runeId = runeDto.getId();
				RuneDto dto = staticInterface.getRune(runeId, null, null, RuneDataTag.ALL);
				testRuneDto(dto);
			}
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
		} finally {
			System.out.println();
			System.out.println();
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
	}

	private void testImageDto(ImageDto dto) {
		assertNotNull(dto.getFull());
		assertNotNull(dto.getGroup());
		assertNotNull(dto.getSprite());
		assertTrue(dto.getH() > 0);
		assertTrue(dto.getW() > 0);
	}

	private void testMetaDataDto(MetaDataDto dto) {
		assertNotNull(dto.getTier());
		assertNotNull(dto.getType());
	}

	@Test
	public void testStatus() throws IOException {
		try {
			prints.println("testStatus()");
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
				assertNotNull(s.getHostname());
				assertNotNull(s.getLocales());
				assertNotNull(s.getName());
				assertNotNull(s.getSlug());
				if (s.getRegionTag() == null) {
					prints.println(s.getSlug() + " null region tag");
				}
			}

			ShardStatus statusDto = statusInterface.getShard();
			assertNotNull(statusDto);

			assertNotNull(statusDto.getHostname());
			assertNotNull(statusDto.getLocales());
			assertNotNull(statusDto.getName());
			assertNotNull(statusDto.getRegionTag());
			assertNotNull(statusDto.getSlug());

			Service[] services = statusDto.getServices();
			assertNotNull(services);
		} catch (HttpException e) {
			prints.println("ERROR", e.getCode());
			fail(e.getMessage());
		} finally {
			System.out.println();
			System.out.println();
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

}
