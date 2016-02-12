package org.dc.riot.lol.rx.model.match;

import org.dc.riot.lol.rx.model.common.BannedChampion;

/**
 * MatchTeam DTO used by the {@link org.dc.riot.lol.rx.service.RiotApi.Match
 * RiotApi.Match} interface.
 * 
 * @author Dc
 * @since 1.0.0
 * @see org.dc.riot.lol.rx.service.RiotApi.MatchList RiotApi.MatchList
 */
public class Team {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private BannedChampion[] bans;
	private Integer baronKills;
	private Long dominionVictoryScore;
	private Integer dragonKills;
	private Boolean firstBaron;
	private Boolean firstBlood;
	private Boolean firstDragon;
	private Boolean firstInhibitor;
	private Boolean firstRiftHerald;
	private Boolean firstTower;
	private Integer inhibitorKills;
	private Integer riftHeraldKills;
	private Integer teamId;
	private Integer towerKills;
	private Integer vilemawKills;
	private Boolean winner;
	
	public Team() {
		COUNT++;
	}

	/**
	 * @return If game was draft mode, contains banned champion data,
	 * otherwise empty.
	 */
	public BannedChampion[] getBans() {
		if (bans == null) {
			return new BannedChampion[0];
		}

		return bans;
	}

	/**
	 * @return Number of times the team killed baron.
	 */
	public int getBaronKills() {
		if (baronKills == null) {
			return -1;
		}

		return baronKills.intValue();
	}

	/**
	 * @return If game was a dominion game, specifies
	 * the points the team had at game end,
	 * otherwise <code>-1</code>.
	 */
	public long getDominionVictoryScore() {
		if (dominionVictoryScore == null) {
			return -1;
		}

		return dominionVictoryScore.longValue();
	}

	/**
	 * @return Number of times the team killed
	 * dragon or <code>-1</code> if not defined.
	 */
	public int getDragonKills() {
		if (dragonKills == null) {
			return -1;
		}

		return dragonKills.intValue();
	}

	/**
	 * @return Flag indicating whether or not the
	 * team got the first baron kill.
	 */
	public boolean isFirstBaron() {
		if (firstBaron == null) {
			return false;
		}

		return firstBaron.booleanValue();
	}

	/**
	 * @return Flag indicating whether or not the
	 * team got first blood.
	 */
	public boolean isFirstBlood() {
		if (firstBlood == null) {
			return false;
		}

		return firstBlood.booleanValue();
	}

	/**
	 * @return Flag indicating whether or not
	 * the team got the first dragon kill.
	 */
	public boolean isFirstDragon() {
		if (firstDragon == null) {
			return false;
		}

		return firstDragon.booleanValue();
	}

	/**
	 * @return Flag indicating whether or
	 * not the team destroyed the first inhibitor.
	 */
	public boolean isFirstInhibitor() {
		if (firstInhibitor == null) {
			return false;
		}

		return firstInhibitor.booleanValue();
	}

	/**
	 * @return Flag indicating whether or not the team got
	 * the first rift herald kill.
	 */
	public boolean isFirstRiftHerald() {
		if (firstRiftHerald == null) {
			return false;
		}

		return firstRiftHerald.booleanValue();
	}

	/**
	 * @return Flag indicating whether or not
	 * the team destroyed the first tower.
	 */
	public boolean isFirstTower() {
		if (firstTower == null) {
			return false;
		}

		return firstTower.booleanValue();
	}

	/**
	 * @return Number of inhibitors the
	 * team destroyed or <code>-1</code>
	 * if not defined.
	 */
	public int getInhibitorKills() {
		if (inhibitorKills == null) {
			return -1;
		}

		return inhibitorKills.intValue();
	}

	/**
	 * @return Number of times the team killed
	 * rift herald or <code>-1</code>
	 * if not defined.
	 */
	public int getRiftHeraldKills() {
		if (riftHeraldKills == null) {
			return -1;
		}

		return riftHeraldKills.intValue();
	}

	/**
	 * @return Team ID or <code>-1</code> if
	 * not defined.
	 */
	public int getTeamId() {
		if (teamId == null) {
			return -1;
		}

		return teamId.intValue();
	}

	/**
	 * @return Number of towers the
	 * team destroyed or <code>-1</code>
	 * if not defined.
	 */
	public int getTowerKills() {
		if (towerKills == null) {
			return -1;
		}

		return towerKills.intValue();
	}

	/**
	 * @return Number of times the team killed
	 * vilemaw or <code>-1</code>
	 * if not defined.
	 */
	public int getVilemawKills() {
		if (vilemawKills == null) {
			return -1;
		}

		return vilemawKills.intValue();
	}

	/**
	 * @return Flag indicating whether or not
	 * the team won.
	 */
	public boolean isWinner() {
		if (winner == null) {
			return false;
		}

		return winner.booleanValue();
	}
}