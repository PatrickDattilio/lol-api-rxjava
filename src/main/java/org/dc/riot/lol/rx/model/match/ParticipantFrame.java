package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant frame information.
 * <br>
 * <br>
 * Getters of this class return <code>-1</code> if
 * the values are undefined.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantFrame {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}
	
	private Integer currentGold;
	private Integer dominionScore;
	private Integer jungleMinionsKilled;
	private Integer level;
	private Integer minionsKilled;
	private Integer participantId;
	private Position position;
	private Integer teamScore;
	private Integer totalGold;
	private Integer xp;
	
	public ParticipantFrame() {
		COUNT++;
	}

	/**
	 * @return Participant's current gold or
	 * <code>0</code> if not defined.
	 */
	public int getCurrentGold() {
		if (currentGold == null) {
			return 0;
		}

		return currentGold.intValue();
	}

	/**
	 * @return Dominion score of the participant.
	 */
	public int getDominionScore() {
		if (dominionScore == null) {
			return -1;
		}

		return dominionScore.intValue();
	}

	/**
	 * @return Number of jungle minions killed by participant.
	 */
	public int getJungleMinionsKilled() {
		if (jungleMinionsKilled == null) {
			return -1;
		}

		return jungleMinionsKilled.intValue();
	}

	/**
	 * @return Participant's current level.
	 */
	public int getLevel() {
		if (level == null) {
			return -1;
		}

		return level.intValue();
	}

	/**
	 * @return Number of minions killed by participant.
	 */
	public int getMinionsKilled() {
		if (minionsKilled == null) {
			return -1;
		}

		return minionsKilled.intValue();
	}

	/**
	 * @return Participant ID.
	 */
	public int getParticipantId() {
		if (participantId == null) {
			return -1;
		}

		return participantId.intValue();
	}

	/**
	 * @return Participant's position.
	 * Could be <code>null</code> if not relevant.
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @return Team score of the participant.
	 */
	public int getTeamScore() {
		if (teamScore == null) {
			return -1;
		}

		return teamScore.intValue();
	}

	/**
	 * @return Participant's total gold.
	 */
	public int getTotalGold() {
		if (totalGold == null) {
			return -1;
		}

		return totalGold.intValue();
	}

	/**
	 * @return Experience earned by participant.
	 */
	public int getXp() {
		if (xp == null) {
			return -1;
		}

		return xp.intValue();
	}
}

