package org.dc.riot.lol.rx.model;

import org.dc.riot.lol.rx.service.Region;

/**
 * Used by the Match API
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchDetail {
	private int mapId;	// Match map ID
	private long matchCreation;	// Match creation time. Designates when the team select lobby is created and/or the match is made through match making, not when the game actually starts.
	private long matchDuration;	// Match duration
	private long matchId;	// ID of the match
	private String matchMode;	// Match mode (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO)
	private String matchType;	// Match type (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME)
	private String matchVersion;	// Match version
	private ParticipantIdentity participantIdentities;	// ParticipantIdentity]	Participant identity information
	private MatchParticipant participants;	// Participant]	Participant information
	private PlatformId platformId;	// Platform ID of the match
	private QueueType queueType;	// Match queue type (Legal values: CUSTOM, NORMAL_5x5_BLIND, RANKED_SOLO_5x5, RANKED_PREMADE_5x5, BOT_5x5, NORMAL_3x3, RANKED_PREMADE_3x3, NORMAL_5x5_DRAFT, ODIN_5x5_BLIND, ODIN_5x5_DRAFT, BOT_ODIN_5x5, BOT_5x5_INTRO, BOT_5x5_BEGINNER, BOT_5x5_INTERMEDIATE, RANKED_TEAM_3x3, RANKED_TEAM_5x5, BOT_TT_3x3, GROUP_FINDER_5x5, ARAM_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2, SR_6x6, URF_5x5, ONEFORALL_MIRRORMODE_5x5, BOT_URF_5x5, NIGHTMARE_BOT_5x5_RANK1, NIGHTMARE_BOT_5x5_RANK2, NIGHTMARE_BOT_5x5_RANK5, ASCENSION_5x5, HEXAKILL, BILGEWATER_ARAM_5x5, KING_PORO_5x5, COUNTER_PICK, BILGEWATER_5x5)
	private Region region;	// Region where the match was played
	private Season season;	// Season match was played (Legal values: PRESEASON3, SEASON3, PRESEASON2014, SEASON2014, PRESEASON2015, SEASON2015, PRESEASON2016, SEASON2016)
	private MatchTeam teams;	// Team]	Team information
	private Timeline timeline;	// Match timeline data (not included by default)
}
