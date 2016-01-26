package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class MatchParticipantStats {
	private long assists;
	private long champLevel;
	private long combatPlayerScore;
	private long deaths;
	private long doubleKills;	// Number of double kills
	private boolean firstBloodAssist;	// Flag indicating if participant got an assist on first blood
	private boolean firstBloodKill;	// Flag indicating if participant got first blood
	private boolean firstInhibitorAssist;	// Flag indicating if participant got an assist on the first inhibitor
	private boolean firstInhibitorKill;	// Flag indicating if participant destroyed the first inhibitor
	private boolean firstTowerAssist;	// Flag indicating if participant got an assist on the first tower
	private boolean firstTowerKill;	// Flag indicating if participant destroyed the first tower
	private long goldEarned;	// Gold earned
	private long goldSpent;	// Gold spent
	private long inhibitorKills;	// Number of inhibitor kills
	private long item0;	// First item ID
	private long item1;	// Second item ID
	private long item2;	// Third item ID
	private long item3;	// Fourth item ID
	private long item4;	// Fifth item ID
	private long item5;	// Sixth item ID
	private long item6;	// Seventh item ID
	private long killingSprees;	// Number of killing sprees
	private long kills;	// Number of kills
	private long largestCriticalStrike;	// Largest critical strike
	private long largestKillingSpree;	// Largest killing spree
	private long largestMultiKill;	// Largest multi kill
	private long magicDamageDealt;	// Magical damage dealt
	private long magicDamageDealtToChampions;	// Magical damage dealt to champions
	private long magicDamageTaken;	// Magic damage taken
	private long minionsKilled;	// Minions killed
	private long neutralMinionsKilled;	// Neutral minions killed
	private long neutralMinionsKilledEnemyJungle;	// Neutral jungle minions killed in the enemy team's jungle
	private long neutralMinionsKilledTeamJungle;	// Neutral jungle minions killed in your team's jungle
	private long nodeCapture;	// If game was a dominion game, number of node captures
	private long nodeCaptureAssist;	// If game was a dominion game, number of node capture assists
	private long nodeNeutralize;	// If game was a dominion game, number of node neutralizations
	private long nodeNeutralizeAssist;	// If game was a dominion game, number of node neutralization assists
	private long objectivePlayerScore;	// If game was a dominion game, player's objectives score, otherwise 0
	private long pentaKills;	// Number of penta kills
	private long physicalDamageDealt;	// Physical damage dealt
	private long physicalDamageDealtToChampions;	// Physical damage dealt to champions
	private long physicalDamageTaken;	// Physical damage taken
	private long quadraKills;	// Number of quadra kills
	private long sightWardsBoughtInGame;	// Sight wards purchased
	private long teamObjective;	// If game was a dominion game, number of completed team objectives (i.e., quests)
	private long totalDamageDealt;	// Total damage dealt
	private long totalDamageDealtToChampions;	// Total damage dealt to champions
	private long totalDamageTaken;	// Total damage taken
	private long totalHeal;	// Total heal amount
	private long totalPlayerScore;	// If game was a dominion game, player's total score, otherwise 0
	private long totalScoreRank;	// If game was a dominion game, team rank of the player's total score (e.g., 1-5)
	private long totalTimeCrowdControlDealt;	// Total dealt crowd control time
	private long totalUnitsHealed;	// Total units healed
	private long towerKills;	// Number of tower kills
	private long tripleKills;	// Number of triple kills
	private long trueDamageDealt;	// True damage dealt
	private long trueDamageDealtToChampions;	// True damage dealt to champions
	private long trueDamageTaken;	// True damage taken
	private long unrealKills;	// Number of unreal kills
	private long visionWardsBoughtInGame;	// Vision wards purchased
	private long wardsKilled;	// Number of wards killed
	private long wardsPlaced;	// Number of wards placed
	private boolean winner;	// Flag indicating whether or not the participant won

	/**
	 * @return Assist count.
	 */
	public long getAssists() {
		return assists;
	}

	public void setAssists(long assists) {
		this.assists = assists;
	}

	/**
	 * @return Champion level at game end.
	 */
	public long getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(long champLevel) {
		this.champLevel = champLevel;
	}

	/**
	 * @return If dominion, the player's game score. Otherwise <code>0</code>.
	 */
	public long getCombatPlayerScore() {
		return combatPlayerScore;
	}

	public void setCombatPlayerScore(long combatPlayerScore) {
		this.combatPlayerScore = combatPlayerScore;
	}

	/**
	 * @return Number of deaths.
	 */
	public long getDeaths() {
		return deaths;
	}

	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}

	/**
	 * @return Number of double kills.
	 */
	public long getDoubleKills() {
		return doubleKills;
	}

	public void setDoubleKills(long doubleKills) {
		this.doubleKills = doubleKills;
	}

	public boolean isFirstBloodAssist() {
		return firstBloodAssist;
	}

	public void setFirstBloodAssist(boolean firstBloodAssist) {
		this.firstBloodAssist = firstBloodAssist;
	}

	public boolean isFirstBloodKill() {
		return firstBloodKill;
	}

	public void setFirstBloodKill(boolean firstBloodKill) {
		this.firstBloodKill = firstBloodKill;
	}

	public boolean isFirstInhibitorAssist() {
		return firstInhibitorAssist;
	}

	public void setFirstInhibitorAssist(boolean firstInhibitorAssist) {
		this.firstInhibitorAssist = firstInhibitorAssist;
	}

	public boolean isFirstInhibitorKill() {
		return firstInhibitorKill;
	}

	public void setFirstInhibitorKill(boolean firstInhibitorKill) {
		this.firstInhibitorKill = firstInhibitorKill;
	}

	public boolean isFirstTowerAssist() {
		return firstTowerAssist;
	}

	public void setFirstTowerAssist(boolean firstTowerAssist) {
		this.firstTowerAssist = firstTowerAssist;
	}

	public boolean isFirstTowerKill() {
		return firstTowerKill;
	}

	public void setFirstTowerKill(boolean firstTowerKill) {
		this.firstTowerKill = firstTowerKill;
	}

	public long getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(long goldEarned) {
		this.goldEarned = goldEarned;
	}

	public long getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(long goldSpent) {
		this.goldSpent = goldSpent;
	}

	public long getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(long inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public long getItem0() {
		return item0;
	}

	public void setItem0(long item0) {
		this.item0 = item0;
	}

	public long getItem1() {
		return item1;
	}

	public void setItem1(long item1) {
		this.item1 = item1;
	}

	public long getItem2() {
		return item2;
	}

	public void setItem2(long item2) {
		this.item2 = item2;
	}

	public long getItem3() {
		return item3;
	}

	public void setItem3(long item3) {
		this.item3 = item3;
	}

	public long getItem4() {
		return item4;
	}

	public void setItem4(long item4) {
		this.item4 = item4;
	}

	public long getItem5() {
		return item5;
	}

	public void setItem5(long item5) {
		this.item5 = item5;
	}

	public long getItem6() {
		return item6;
	}

	public void setItem6(long item6) {
		this.item6 = item6;
	}

	public long getKillingSprees() {
		return killingSprees;
	}

	public void setKillingSprees(long killingSprees) {
		this.killingSprees = killingSprees;
	}

	public long getKills() {
		return kills;
	}

	public void setKills(long kills) {
		this.kills = kills;
	}

	public long getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public void setLargestCriticalStrike(long largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public long getLargestKillingSpree() {
		return largestKillingSpree;
	}

	public void setLargestKillingSpree(long largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}

	public long getLargestMultiKill() {
		return largestMultiKill;
	}

	public void setLargestMultiKill(long largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}

	public long getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public void setMagicDamageDealt(long magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(long magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public long getMagicDamageTaken() {
		return magicDamageTaken;
	}

	public void setMagicDamageTaken(long magicDamageTaken) {
		this.magicDamageTaken = magicDamageTaken;
	}

	public long getMinionsKilled() {
		return minionsKilled;
	}

	public void setMinionsKilled(long minionsKilled) {
		this.minionsKilled = minionsKilled;
	}

	public long getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(long neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public long getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	public void setNeutralMinionsKilledEnemyJungle(long neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}

	public long getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	public void setNeutralMinionsKilledTeamJungle(long neutralMinionsKilledTeamJungle) {
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
	}

	public long getNodeCapture() {
		return nodeCapture;
	}

	public void setNodeCapture(long nodeCapture) {
		this.nodeCapture = nodeCapture;
	}

	public long getNodeCaptureAssist() {
		return nodeCaptureAssist;
	}

	public void setNodeCaptureAssist(long nodeCaptureAssist) {
		this.nodeCaptureAssist = nodeCaptureAssist;
	}

	public long getNodeNeutralize() {
		return nodeNeutralize;
	}

	public void setNodeNeutralize(long nodeNeutralize) {
		this.nodeNeutralize = nodeNeutralize;
	}

	public long getNodeNeutralizeAssist() {
		return nodeNeutralizeAssist;
	}

	public void setNodeNeutralizeAssist(long nodeNeutralizeAssist) {
		this.nodeNeutralizeAssist = nodeNeutralizeAssist;
	}

	public long getObjectivePlayerScore() {
		return objectivePlayerScore;
	}

	public void setObjectivePlayerScore(long objectivePlayerScore) {
		this.objectivePlayerScore = objectivePlayerScore;
	}

	public long getPentaKills() {
		return pentaKills;
	}

	public void setPentaKills(long pentaKills) {
		this.pentaKills = pentaKills;
	}

	public long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public void setPhysicalDamageDealt(long physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(long physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public void setPhysicalDamageTaken(long physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public long getQuadraKills() {
		return quadraKills;
	}

	public void setQuadraKills(long quadraKills) {
		this.quadraKills = quadraKills;
	}

	public long getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}

	public void setSightWardsBoughtInGame(long sightWardsBoughtInGame) {
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
	}

	public long getTeamObjective() {
		return teamObjective;
	}

	public void setTeamObjective(long teamObjective) {
		this.teamObjective = teamObjective;
	}

	public long getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(long totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(long totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public long getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(long totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public long getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(long totalHeal) {
		this.totalHeal = totalHeal;
	}

	public long getTotalPlayerScore() {
		return totalPlayerScore;
	}

	public void setTotalPlayerScore(long totalPlayerScore) {
		this.totalPlayerScore = totalPlayerScore;
	}

	public long getTotalScoreRank() {
		return totalScoreRank;
	}

	public void setTotalScoreRank(long totalScoreRank) {
		this.totalScoreRank = totalScoreRank;
	}

	public long getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	public void setTotalTimeCrowdControlDealt(long totalTimeCrowdControlDealt) {
		this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
	}

	public long getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	public void setTotalUnitsHealed(long totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}

	public long getTowerKills() {
		return towerKills;
	}

	public void setTowerKills(long towerKills) {
		this.towerKills = towerKills;
	}

	public long getTripleKills() {
		return tripleKills;
	}

	public void setTripleKills(long tripleKills) {
		this.tripleKills = tripleKills;
	}

	public long getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public void setTrueDamageDealt(long trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public void setTrueDamageDealtToChampions(long trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public long getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public void setTrueDamageTaken(long trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public long getUnrealKills() {
		return unrealKills;
	}

	public void setUnrealKills(long unrealKills) {
		this.unrealKills = unrealKills;
	}

	public long getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}

	public void setVisionWardsBoughtInGame(long visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}

	public long getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(long wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public long getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(long wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public boolean isWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
}
