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
	public static long getCount() {
		return COUNT;
	}

	private BannedChampion[] bans;	// BannedChampion]	If game was draft mode, contains banned champion data, otherwise null
	private int baronKills;	// Number of times the team killed baron
	private long dominionVictoryScore;	// If game was a dominion game, specifies the points the team had at game end, otherwise null
	private int dragonKills;	// Number of times the team killed dragon
	private boolean firstBaron;	// Flag indicating whether or not the team got the first baron kill
	private boolean firstBlood;	// Flag indicating whether or not the team got first blood
	private boolean firstDragon;	// Flag indicating whether or not the team got the first dragon kill
	private boolean firstInhibitor;	// Flag indicating whether or not the team destroyed the first inhibitor
	private boolean firstRiftHerald;	// Flag indicating whether or not the team got the first rift herald kill
	private boolean firstTower;	// Flag indicating whether or not the team destroyed the first tower
	private int inhibitorKills;	// Number of inhibitors the team destroyed
	private int riftHeraldKills;	// Number of times the team killed rift herald
	private int teamId;	// Team ID
	private int towerKills;	// Number of towers the team destroyed
	private int vilemawKills;	// Number of times the team killed vilemaw
	private boolean winner;	// Flag indicating whether or not the team won
	
	public Team() {
		COUNT++;
	}

	public BannedChampion[] getBans() {
		if (bans == null) {
			return new BannedChampion[0];
		}

		return bans;
	}

	public void setBans(BannedChampion[] bans) {
		this.bans = bans;
	}

	public int getBaronKills() {
		return baronKills;
	}

	public void setBaronKills(int baronKills) {
		this.baronKills = baronKills;
	}

	public long getDominionVictoryScore() {
		return dominionVictoryScore;
	}

	public void setDominionVictoryScore(long dominionVictoryScore) {
		this.dominionVictoryScore = dominionVictoryScore;
	}

	public int getDragonKills() {
		return dragonKills;
	}

	public void setDragonKills(int dragonKills) {
		this.dragonKills = dragonKills;
	}

	public boolean isFirstBaron() {
		return firstBaron;
	}

	public void setFirstBaron(boolean firstBaron) {
		this.firstBaron = firstBaron;
	}

	public boolean isFirstBlood() {
		return firstBlood;
	}

	public void setFirstBlood(boolean firstBlood) {
		this.firstBlood = firstBlood;
	}

	public boolean isFirstDragon() {
		return firstDragon;
	}

	public void setFirstDragon(boolean firstDragon) {
		this.firstDragon = firstDragon;
	}

	public boolean isFirstInhibitor() {
		return firstInhibitor;
	}

	public void setFirstInhibitor(boolean firstInhibitor) {
		this.firstInhibitor = firstInhibitor;
	}

	public boolean isFirstRiftHerald() {
		return firstRiftHerald;
	}

	public void setFirstRiftHerald(boolean firstRiftHerald) {
		this.firstRiftHerald = firstRiftHerald;
	}

	public boolean isFirstTower() {
		return firstTower;
	}

	public void setFirstTower(boolean firstTower) {
		this.firstTower = firstTower;
	}

	public int getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(int inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public int getRiftHeraldKills() {
		return riftHeraldKills;
	}

	public void setRiftHeraldKills(int riftHeraldKills) {
		this.riftHeraldKills = riftHeraldKills;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getTowerKills() {
		return towerKills;
	}

	public void setTowerKills(int towerKills) {
		this.towerKills = towerKills;
	}

	public int getVilemawKills() {
		return vilemawKills;
	}

	public void setVilemawKills(int vilemawKills) {
		this.vilemawKills = vilemawKills;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
}
