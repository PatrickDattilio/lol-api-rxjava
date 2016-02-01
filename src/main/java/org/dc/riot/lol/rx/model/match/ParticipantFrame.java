package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant frame information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantFrame {
	private int currentGold;	// 
	private int dominionScore;	// Dominion score of the participant
	private int jungleMinionsKilled;	// Number of jungle minions killed by participant
	private int level;	// Participant's current level
	private int minionsKilled;	// Number of minions killed by participant
	private int participantId;	// Participant ID
	private Position position;	// Participant's position
	private int teamScore;	// Team score of the participant
	private int totalGold;	// Participant's total gold
	private int xp;	// Experience earned by participant

	/**
	 * @return Participant's current gold.
	 */
	public int getCurrentGold() {
		return currentGold;
	}

	/**
	 * @return Dominion score of the participant.
	 */
	public int getDominionScore() {
		return dominionScore;
	}

	/**
	 * @return Number of jungle minions killed by participant.
	 */
	public int getJungleMinionsKilled() {
		return jungleMinionsKilled;
	}

	/**
	 * @return Participant's current level.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return Number of minions killed by participant.
	 */
	public int getMinionsKilled() {
		return minionsKilled;
	}

	/**
	 * @return Participant ID.
	 */
	public int getParticipantId() {
		return participantId;
	}

	/**
	 * @return Participant's position.
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @return Team score of the participant.
	 */
	public int getTeamScore() {
		return teamScore;
	}

	/**
	 * @return Participant's total gold.
	 */
	public int getTotalGold() {
		return totalGold;
	}

	/**
	 * @return Experience earned by participant.
	 */
	public int getXp() {
		return xp;
	}
}

