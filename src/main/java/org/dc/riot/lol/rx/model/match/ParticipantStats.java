package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant statistics information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantStats {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private long assists;
	private long champLevel;
	private long combatPlayerScore;
	private long deaths;
	private long doubleKills;
	private boolean firstBloodAssist;
	private boolean firstBloodKill;
	private boolean firstInhibitorAssist;
	private boolean firstInhibitorKill;
	private boolean firstTowerAssist;
	private boolean firstTowerKill;
	private long goldEarned;
	private long goldSpent;
	private long inhibitorKills;
	private long item0;
	private long item1;
	private long item2;
	private long item3;
	private long item4;
	private long item5;
	private long item6;
	private long killingSprees;
	private long kills;
	private long largestCriticalStrike;
	private long largestKillingSpree;
	private long largestMultiKill;
	private long magicDamageDealt;
	private long magicDamageDealtToChampions;
	private long magicDamageTaken;
	private long minionsKilled;
	private long neutralMinionsKilled;
	private long neutralMinionsKilledEnemyJungle;
	private long neutralMinionsKilledTeamJungle;
	private long nodeCapture;
	private long nodeCaptureAssist;
	private long nodeNeutralize;
	private long nodeNeutralizeAssist;
	private long objectivePlayerScore;
	private long pentaKills;
	private long physicalDamageDealt;
	private long physicalDamageDealtToChampions;
	private long physicalDamageTaken;
	private long quadraKills;
	private long sightWardsBoughtInGame;
	private long teamObjective;
	private long totalDamageDealt;
	private long totalDamageDealtToChampions;
	private long totalDamageTaken;
	private long totalHeal;
	private long totalPlayerScore;
	private long totalScoreRank;
	private long totalTimeCrowdControlDealt;
	private long totalUnitsHealed;
	private long towerKills;
	private long tripleKills;
	private long trueDamageDealt;
	private long trueDamageDealtToChampions;
	private long trueDamageTaken;
	private long unrealKills;
	private long visionWardsBoughtInGame;
	private long wardsKilled;
	private long wardsPlaced;
	private boolean winner;
	
	public ParticipantStats() {
		COUNT++;
	}

	/**
	 * @return Number of assists.
	 */
	public long getAssists() {
		return assists;
	}

	/**
	 * @return Champion level achieved.
	 */
	public long getChampLevel() {
		return champLevel;
	}

	/**
	 * @return If game was a dominion game, player's combat score, otherwise 0.
	 */
	public long getCombatPlayerScore() {
		return combatPlayerScore;
	}

	/**
	 * @return Number of deaths.
	 */
	public long getDeaths() {
		return deaths;
	}

	/**
	 * @return Number of double kills.
	 */
	public long getDoubleKills() {
		return doubleKills;
	}

	/**
	 * @return Flag indicating if participant got an assist on first blood.
	 */
	public boolean isFirstBloodAssist() {
		return firstBloodAssist;
	}

	/**
	 * @return Flag indicating if participant got first blood.
	 */
	public boolean isFirstBloodKill() {
		return firstBloodKill;
	}

	/**
	 * @return Flag indicating if participant got an assist on the first inhibitor.
	 */
	public boolean isFirstInhibitorAssist() {
		return firstInhibitorAssist;
	}

	/**
	 * @return Flag indicating if participant destroyed the first inhibitor.
	 */
	public boolean isFirstInhibitorKill() {
		return firstInhibitorKill;
	}

	/**
	 * @return Flag indicating if participant got an assist on the first tower.
	 */
	public boolean isFirstTowerAssist() {
		return firstTowerAssist;
	}

	/**
	 * @return Flag indicating if participant destroyed the first tower.
	 */
	public boolean isFirstTowerKill() {
		return firstTowerKill;
	}

	/**
	 * @return Gold earned.
	 */
	public long getGoldEarned() {
		return goldEarned;
	}

	/**
	 * @return Gold spent.
	 */
	public long getGoldSpent() {
		return goldSpent;
	}

	/**
	 * @return Number of inhibitor kills.
	 */
	public long getInhibitorKills() {
		return inhibitorKills;
	}

	/**
	 * @return First item ID.
	 */
	public long getItem0() {
		return item0;
	}

	/**
	 * @return Second item ID.
	 */
	public long getItem1() {
		return item1;
	}

	/**
	 * @return Third item ID.
	 */
	public long getItem2() {
		return item2;
	}

	/**
	 * @return Fourth item ID.
	 */
	public long getItem3() {
		return item3;
	}

	/**
	 * @return Fifth item ID.
	 */
	public long getItem4() {
		return item4;
	}

	/**
	 * @return Sixth item ID.
	 */
	public long getItem5() {
		return item5;
	}

	/**
	 * @return Seventh item ID.
	 */
	public long getItem6() {
		return item6;
	}

	/**
	 * @return Number of killing sprees.
	 */
	public long getKillingSprees() {
		return killingSprees;
	}

	/**
	 * @return Number of kills.
	 */
	public long getKills() {
		return kills;
	}

	/**
	 * @return Largest critical strike.
	 */
	public long getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	/**
	 * @return Largest killing spree.
	 */
	public long getLargestKillingSpree() {
		return largestKillingSpree;
	}

	/**
	 * @return Largest multi kill.
	 */
	public long getLargestMultiKill() {
		return largestMultiKill;
	}

	/**
	 * @return Magical damage dealt.
	 */
	public long getMagicDamageDealt() {
		return magicDamageDealt;
	}

	/**
	 * @return Magical damage dealt to champions.
	 */
	public long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	/**
	 * @return Magic damage taken.
	 */
	public long getMagicDamageTaken() {
		return magicDamageTaken;
	}

	/**
	 * @return Minions killed.
	 */
	public long getMinionsKilled() {
		return minionsKilled;
	}

	/**
	 * @return Neutral minions killed.
	 */
	public long getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	/**
	 * @return Neutral jungle minions killed in the enemy team's jungle.
	 */
	public long getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	/**
	 * @return Neutral jungle minions killed in your team's jungle.
	 */
	public long getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	/**
	 * @return If game was a dominion game, number of node captures.
	 */
	public long getNodeCapture() {
		return nodeCapture;
	}

	/**
	 * @return If game was a dominion game, number of node capture assists.
	 */
	public long getNodeCaptureAssist() {
		return nodeCaptureAssist;
	}

	/**
	 * @return If game was a dominion game, number of node neutralizations.
	 */
	public long getNodeNeutralize() {
		return nodeNeutralize;
	}

	/**
	 * @return If game was a dominion game, number of node neutralization assists.
	 */
	public long getNodeNeutralizeAssist() {
		return nodeNeutralizeAssist;
	}

	/**
	 * @return If game was a dominion game, player's objectives score, otherwise 0.
	 */
	public long getObjectivePlayerScore() {
		return objectivePlayerScore;
	}

	/**
	 * @return Number of penta kills.
	 */
	public long getPentaKills() {
		return pentaKills;
	}

	/**
	 * @return Physical damage dealt.
	 */
	public long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	/**
	 * @return Physical damage dealt to champions.
	 */
	public long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	/**
	 * @return Physical damage taken.
	 */
	public long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	/**
	 * @return Number of quadra kills.
	 */
	public long getQuadraKills() {
		return quadraKills;
	}

	/**
	 * @return Sight wards purchased.
	 */
	public long getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}

	/**
	 * @return If game was a dominion game, number of completed team objectives (i.e., quests).
	 */
	public long getTeamObjective() {
		return teamObjective;
	}

	/**
	 * @return Total damage dealt.
	 */
	public long getTotalDamageDealt() {
		return totalDamageDealt;
	}

	/**
	 * @return Total damage dealt to champions.
	 */
	public long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	/**
	 * @return Total damage taken.
	 */
	public long getTotalDamageTaken() {
		return totalDamageTaken;
	}

	/**
	 * @return Total heal amount.
	 */
	public long getTotalHeal() {
		return totalHeal;
	}

	/**
	 * @return If game was a dominion game, player's total score, otherwise 0.
	 */
	public long getTotalPlayerScore() {
		return totalPlayerScore;
	}

	/**
	 * @return If game was a dominion game, team rank of the player's total score (e.g., 1-5).
	 */
	public long getTotalScoreRank() {
		return totalScoreRank;
	}

	/**
	 * @return Total dealt crowd control time.
	 */
	public long getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	/**
	 * @return Total units healed.
	 */
	public long getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	/**
	 * @return Number of tower kills.
	 */
	public long getTowerKills() {
		return towerKills;
	}

	/**
	 * @return Number of triple kills.
	 */
	public long getTripleKills() {
		return tripleKills;
	}

	/**
	 * @return True damage dealt.
	 */
	public long getTrueDamageDealt() {
		return trueDamageDealt;
	}

	/**
	 * @return True damage dealt to champions.
	 */
	public long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	/**
	 * @return True damage taken.
	 */
	public long getTrueDamageTaken() {
		return trueDamageTaken;
	}

	/**
	 * @return Number of unreal kills.
	 */
	public long getUnrealKills() {
		return unrealKills;
	}

	/**
	 * @return Vision wards purchased.
	 */
	public long getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}

	/**
	 * @return Number of wards killed.
	 */
	public long getWardsKilled() {
		return wardsKilled;
	}

	/**
	 * @return Number of wards placed.
	 */
	public long getWardsPlaced() {
		return wardsPlaced;
	}

	/**
	 * @return Flag indicating whether or not the participant won.
	 */
	public boolean isWinner() {
		return winner;
	}
 }