package org.dc.riot.lol.rx.model.match;

import org.dc.riot.lol.rx.model.common.Mastery;
import org.dc.riot.lol.rx.model.common.Rune;
import org.dc.riot.lol.rx.model.common.Tier;

/**
 * Participant information. 
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Participant {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Long championId;
	private Tier highestAchievedSeasonTier;
	private Mastery[] masteries;
	private Long participantId;
	private Rune[] runes;
	private Long spell1Id;
	private Long spell2Id;
	private ParticipantStats stats;
	private Integer teamId;
	private ParticipantTimeline timeline;
	
	public Participant() {
		COUNT++;
	}

	/**
	 * @return Champion ID or <code>-1</code> if
	 * not defined.
	 */
	public long getChampionId() {
		if (championId == null) {
			return -1;
		}

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
	 * @return List of mastery information or
	 * empty if not defined.
	 */
	public Mastery[] getMasteries() {
		if (masteries == null) {
			return new Mastery[0];
		}

		return masteries;
	}

	/**
	 * @return Participant ID or
	 * <code>-1</code> if not defined.
	 */
	public long getParticipantId() {
		if (participantId == null) {
			return -1;
		}

		return participantId;
	}

	/**
	 * @return List of rune information
	 * or empty if not defined.
	 */
	public Rune[] getRunes() {
		return runes;
	}

	/**
	 * @return First summoner spell ID
	 * or <code>-1</code> if not defined.
	 */
	public long getSpell1Id() {
		if (spell1Id == null) {
			return -1;
		}

		return spell1Id;
	}

	/**
	 * @return Second summoner spell ID
	 * or <code>-1</code> if not defined.
	 */
	public long getSpell2Id() {
		if (spell2Id == null) {
			return -1;
		}

		return spell2Id;
	}

	/**
	 * @return Participant statistics.
	 */
	public ParticipantStats getStats() {
		return stats;
	}

	/**
	 * @return Team ID or <code>-1</code>
	 * if not defined.
	 */
	public int getTeamId() {
		if (teamId == null) {
			return -1;
		}

		return teamId;
	}

	/**
	 * @return Timeline data. 
	 */
	public ParticipantTimeline getTimeline() {
		return timeline;
	}
}