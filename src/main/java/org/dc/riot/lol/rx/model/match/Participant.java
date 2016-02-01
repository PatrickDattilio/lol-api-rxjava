package org.dc.riot.lol.rx.model.match;

import org.dc.riot.lol.rx.model.MasteryMetaDto;
import org.dc.riot.lol.rx.model.MatchParticipantStats;
import org.dc.riot.lol.rx.model.RuneMetaDto;
import org.dc.riot.lol.rx.model.common.Tier;

/**
 * Participant information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Participant {
	private int championId;
	private Tier highestAchievedSeasonTier;
	private MasteryMetaDto masteries;
	private int participantId;
	private RuneMetaDto[] runes;
	private long spell1Id;
	private long spell2Id;
	private MatchParticipantStats stats;
	private int teamId;
	private ParticipantTimeline timeline;

	/**
	 * @return Champion ID.
	 */
	public int getChampionId() {
		return championId;
	}

	/**
	 * @return Highest ranked tier achieved for the previous season,
	 * if any, otherwise null. Used to display border in game
	 * loading screen.
	 */
	public Tier getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	/**
	 * @return List of mastery information.
	 */
	public MasteryMetaDto getMasteries() {
		return masteries;
	}

	/**
	 * @return Participant ID.
	 */
	public int getParticipantId() {
		return participantId;
	}

	/**
	 * @return List of rune information.
	 */
	public RuneMetaDto[] getRunes() {
		return runes;
	}

	/**
	 * @return First summoner spell ID.
	 */
	public long getSpell1Id() {
		return spell1Id;
	}

	/**
	 * @return Second summoner spell ID.
	 */
	public long getSpell2Id() {
		return spell2Id;
	}

	/**
	 * @return Participant statistics.
	 */
	public MatchParticipantStats getStats() {
		return stats;
	}

	/**
	 * @return Team ID.
	 */
	public int getTeamId() {
		return teamId;
	}

	/**
	 * @return Timeline data. Delta fields refer to values for
	 * the specified period (e.g., the gold per minute over
	 * the first 10 minutes of the game versus the second 20
	 * minutes of the game. Diffs fields refer to the deltas
	 * versus the calculated lane opponent(s).
	 */
	public ParticipantTimeline getTimeline() {
		return timeline;
	}
}