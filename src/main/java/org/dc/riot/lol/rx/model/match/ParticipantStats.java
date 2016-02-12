package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant statistics information.
 * <br>
 * <br>
 * Getters of this class will return <code>-1</code>
 * for undefined values.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantStats {
	private static int COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Integer assists;
	private Integer champLevel;
	private Integer combatPlayerScore;
	private Integer deaths;
	private Integer doubleKills;
	private Boolean firstBloodAssist;
	private Boolean firstBloodKill;
	private Boolean firstInhibitorAssist;
	private Boolean firstInhibitorKill;
	private Boolean firstTowerAssist;
	private Boolean firstTowerKill;
	private Integer goldEarned;
	private Integer goldSpent;
	private Integer inhibitorKills;
	private Long item0;
	private Long item1;
	private Long item2;
	private Long item3;
	private Long item4;
	private Long item5;
	private Long item6;
	private Integer killingSprees;
	private Integer kills;
	private Integer largestCriticalStrike;
	private Integer largestKillingSpree;
	private Integer largestMultiKill;
	private Integer magicDamageDealt;
	private Integer magicDamageDealtToChampions;
	private Integer magicDamageTaken;
	private Integer minionsKilled;
	private Integer neutralMinionsKilled;
	private Integer neutralMinionsKilledEnemyJungle;
	private Integer neutralMinionsKilledTeamJungle;
	private Integer nodeCapture;
	private Integer nodeCaptureAssist;
	private Integer nodeNeutralize;
	private Integer nodeNeutralizeAssist;
	private Integer objectivePlayerScore;
	private Integer pentaKills;
	private Integer physicalDamageDealt;
	private Integer physicalDamageDealtToChampions;
	private Integer physicalDamageTaken;
	private Integer quadraKills;
	private Integer sightWardsBoughtInGame;
	private Integer teamObjective;
	private Integer totalDamageDealt;
	private Integer totalDamageDealtToChampions;
	private Integer totalDamageTaken;
	private Integer totalHeal;
	private Integer totalPlayerScore;
	private Integer totalScoreRank;
	private Integer totalTimeCrowdControlDealt;
	private Integer totalUnitsHealed;
	private Integer towerKills;
	private Integer tripleKills;
	private Integer trueDamageDealt;
	private Integer trueDamageDealtToChampions;
	private Integer trueDamageTaken;
	private Integer unrealKills;
	private Integer visionWardsBoughtInGame;
	private Integer wardsKilled;
	private Integer wardsPlaced;
	private Boolean winner;
	
	public ParticipantStats() {
		COUNT++;
	}

	/**
	 * @return Number of assists.
	 */
	public int getAssists() {
		if (assists == null) {
			return -1;
		}

		return assists.intValue();
	}

	/**
	 * @return Champion level achieved.
	 */
	public int getChampLevel() {
		if (champLevel == null) {
			return -1;
		}

		return champLevel.intValue();
	}

	/**
	 * @return If game was a dominion game, player's
	 * combat score, otherwise <code>-1</code>.
	 */
	public int getCombatPlayerScore() {
		if (combatPlayerScore == null) {
			return -1;
		}

		return combatPlayerScore.intValue();
	}

	/**
	 * @return Number of deaths.
	 */
	public int getDeaths() {
		if (deaths == null) {
			return -1;
		}

		return deaths.intValue();
	}

	/**
	 * @return Number of double kills.
	 */
	public int getDoubleKills() {
		if (doubleKills == null) {
			return -1;
		}

		return doubleKills.intValue();
	}

	/**
	 * @return Flag indicating if participant got an assist on first blood.
	 */
	public boolean isFirstBloodAssist() {
		if (firstBloodAssist == null) {
			return false;
		}

		return firstBloodAssist.booleanValue();
	}

	/**
	 * @return Flag indicating if participant got first blood.
	 */
	public boolean isFirstBloodKill() {
		if (firstBloodKill == null) {
			return false;
		}

		return firstBloodKill.booleanValue();
	}

	/**
	 * @return Flag indicating if participant got an assist on the first inhibitor.
	 */
	public boolean isFirstInhibitorAssist() {
		if (firstInhibitorAssist == null) {
			return false;
		}

		return firstInhibitorAssist.booleanValue();
	}

	/**
	 * @return Flag indicating if participant destroyed the first inhibitor.
	 */
	public boolean isFirstInhibitorKill() {
		if (firstInhibitorKill == null) {
			return false;
		}

		return firstInhibitorKill.booleanValue();
	}

	/**
	 * @return Flag indicating if participant got an assist on the first tower.
	 */
	public boolean isFirstTowerAssist() {
		if (firstTowerAssist == null) {
			return false;
		}

		return firstTowerAssist.booleanValue();
	}

	/**
	 * @return Flag indicating if participant destroyed the first tower.
	 */
	public boolean isFirstTowerKill() {
		if (firstTowerKill == null) {
			return false;
		}

		return firstTowerKill.booleanValue();
	}

	/**
	 * @return Gold earned.
	 */
	public int getGoldEarned() {
		if (goldEarned == null) {
			return -1;
		}

		return goldEarned.intValue();
	}

	/**
	 * @return Gold spent.
	 */
	public int getGoldSpent() {
		if (goldSpent == null) {
			return -1;
		}

		return goldSpent.intValue();
	}

	/**
	 * @return Number of inhibitor kills.
	 */
	public int getInhibitorKills() {
		if (inhibitorKills == null) {
			return -1;
		}

		return inhibitorKills.intValue();
	}

	/**
	 * @return First item ID.
	 */
	public long getItem0() {
		if (item0 == null) {
			return -1;
		}

		return item0.longValue();
	}

	/**
	 * @return Second item ID.
	 */
	public long getItem1() {
		if (item1 == null) {
			return -1;
		}

		return item1.longValue();
	}

	/**
	 * @return Third item ID.
	 */
	public long getItem2() {
		if (item2 == null) {
			return -1;
		}

		return item2.longValue();
	}

	/**
	 * @return Fourth item ID.
	 */
	public long getItem3() {
		if (item3 == null) {
			return -1;
		}

		return item3.longValue();
	}

	/**
	 * @return Fifth item ID.
	 */
	public long getItem4() {
		if (item4 == null) {
			return -1;
		}

		return item4.longValue();
	}

	/**
	 * @return Sixth item ID.
	 */
	public long getItem5() {
		if (item5 == null) {
			return -1;
		}

		return item5.longValue();
	}

	/**
	 * @return Seventh item ID.
	 */
	public long getItem6() {
		if (item6 == null) {
			return -1;
		}

		return item6.longValue();
	}

	/**
	 * @return Number of killing sprees.
	 */
	public int getKillingSprees() {
		if (killingSprees == null) {
			return -1;
		}

		return killingSprees.intValue();
	}

	/**
	 * @return Number of kills.
	 */
	public int getKills() {
		if (kills == null) {
			return -1;
		}

		return kills.intValue();
	}

	/**
	 * @return Largest critical strike.
	 */
	public int getLargestCriticalStrike() {
		if (largestCriticalStrike == null) {
			return -1;
		}

		return largestCriticalStrike.intValue();
	}

	/**
	 * @return Largest killing spree.
	 */
	public int getLargestKillingSpree() {
		if (largestKillingSpree == null) {
			return -1;
		}

		return largestKillingSpree.intValue();
	}

	/**
	 * @return Largest multi kill.
	 */
	public int getLargestMultiKill() {
		if (largestMultiKill == null) {
			return -1;
		}

		return largestMultiKill.intValue();
	}

	/**
	 * @return Magical damage dealt.
	 */
	public int getMagicDamageDealt() {
		if (magicDamageDealt == null) {
			return -1;
		}

		return magicDamageDealt.intValue();
	}

	/**
	 * @return Magical damage dealt to champions.
	 */
	public int getMagicDamageDealtToChampions() {
		if (magicDamageDealtToChampions == null) {
			return -1;
		}

		return magicDamageDealtToChampions.intValue();
	}

	/**
	 * @return Magic damage taken.
	 */
	public int getMagicDamageTaken() {
		if (magicDamageTaken == null) {
			return -1;
		}

		return magicDamageTaken.intValue();
	}

	/**
	 * @return Minions killed.
	 */
	public int getMinionsKilled() {
		if (minionsKilled == null) {
			return -1;
		}

		return minionsKilled.intValue();
	}

	/**
	 * @return Neutral minions killed.
	 */
	public int getNeutralMinionsKilled() {
		if (neutralMinionsKilled == null) {
			return -1;
		}

		return neutralMinionsKilled.intValue();
	}

	/**
	 * @return Neutral jungle minions killed in the enemy team's jungle.
	 */
	public int getNeutralMinionsKilledEnemyJungle() {
		if (neutralMinionsKilledEnemyJungle == null) {
			return -1;
		}

		return neutralMinionsKilledEnemyJungle.intValue();
	}

	/**
	 * @return Neutral jungle minions killed in your team's jungle.
	 */
	public int getNeutralMinionsKilledTeamJungle() {
		if (neutralMinionsKilledTeamJungle == null) {
			return -1;
		}

		return neutralMinionsKilledTeamJungle.intValue();
	}

	/**
	 * @return If game was a dominion game, number of node captures.
	 */
	public int getNodeCapture() {
		if (nodeCapture == null) {
			return -1;
		}

		return nodeCapture.intValue();
	}

	/**
	 * @return If game was a dominion game, number of node capture assists.
	 */
	public int getNodeCaptureAssist() {
		if (nodeCaptureAssist == null) {
			return -1;
		}

		return nodeCaptureAssist.intValue();
	}

	/**
	 * @return If game was a dominion game, number of node neutralizations.
	 */
	public int getNodeNeutralize() {
		if (nodeNeutralize == null) {
			return -1;
		}

		return nodeNeutralize.intValue();
	}

	/**
	 * @return If game was a dominion game, number of node neutralization assists.
	 */
	public int getNodeNeutralizeAssist() {
		if (nodeNeutralizeAssist == null) {
			return -1;
		}

		return nodeNeutralizeAssist.intValue();
	}

	/**
	 * @return If game was a dominion game, player's objectives score, otherwise 0.
	 */
	public int getObjectivePlayerScore() {
		if (objectivePlayerScore == null) {
			return -1;
		}

		return objectivePlayerScore.intValue();
	}

	/**
	 * @return Number of penta kills.
	 */
	public int getPentaKills() {
		if (pentaKills == null) {
			return -1;
		}

		return pentaKills.intValue();
	}

	/**
	 * @return Physical damage dealt.
	 */
	public int getPhysicalDamageDealt() {
		if (physicalDamageDealt == null) {
			return -1;
		}

		return physicalDamageDealt.intValue();
	}

	/**
	 * @return Physical damage dealt to champions.
	 */
	public int getPhysicalDamageDealtToChampions() {
		if (physicalDamageDealtToChampions == null) {
			return -1;
		}

		return physicalDamageDealtToChampions.intValue();
	}

	/**
	 * @return Physical damage taken.
	 */
	public int getPhysicalDamageTaken() {
		if (physicalDamageTaken == null) {
			return -1;
		}

		return physicalDamageTaken.intValue();
	}

	/**
	 * @return Number of quadra kills.
	 */
	public int getQuadraKills() {
		if (quadraKills == null) {
			return -1;
		}

		return quadraKills.intValue();
	}

	/**
	 * @return Sight wards purchased.
	 */
	public int getSightWardsBoughtInGame() {
		if (sightWardsBoughtInGame == null) {
			return -1;
		}

		return sightWardsBoughtInGame.intValue();
	}

	/**
	 * @return If game was a dominion game, number of completed team objectives (i.e., quests).
	 */
	public int getTeamObjective() {
		if (teamObjective == null) {
			return -1;
		}

		return teamObjective.intValue();
	}

	/**
	 * @return Total damage dealt.
	 */
	public int getTotalDamageDealt() {
		if (totalDamageDealt == null) {
			return -1;
		}

		return totalDamageDealt.intValue();
	}

	/**
	 * @return Total damage dealt to champions.
	 */
	public int getTotalDamageDealtToChampions() {
		if (totalDamageDealtToChampions == null) {
			return -1;
		}

		return totalDamageDealtToChampions.intValue();
	}

	/**
	 * @return Total damage taken.
	 */
	public int getTotalDamageTaken() {
		if (totalDamageTaken == null) {
			return -1;
		}

		return totalDamageTaken.intValue();
	}

	/**
	 * @return Total heal amount.
	 */
	public int getTotalHeal() {
		if (totalHeal == null) {
			return -1;
		}

		return totalHeal.intValue();
	}

	/**
	 * @return If game was a dominion game, player's total score, otherwise 0.
	 */
	public int getTotalPlayerScore() {
		if (totalPlayerScore == null) {
			return -1;
		}

		return totalPlayerScore.intValue();
	}

	/**
	 * @return If game was a dominion game, team rank of the player's total score (e.g., 1-5).
	 */
	public int getTotalScoreRank() {
		if (totalScoreRank == null) {
			return -1;
		}

		return totalScoreRank.intValue();
	}

	/**
	 * @return Total dealt crowd control time.
	 */
	public int getTotalTimeCrowdControlDealt() {
		if (totalTimeCrowdControlDealt == null) {
			return -1;
		}

		return totalTimeCrowdControlDealt.intValue();
	}

	/**
	 * @return Total units healed.
	 */
	public int getTotalUnitsHealed() {
		if (totalUnitsHealed == null) {
			return -1;
		}

		return totalUnitsHealed.intValue();
	}

	/**
	 * @return Number of tower kills.
	 */
	public int getTowerKills() {
		if (towerKills == null) {
			return -1;
		}

		return towerKills.intValue();
	}

	/**
	 * @return Number of triple kills.
	 */
	public int getTripleKills() {
		if (tripleKills == null) {
			return -1;
		}

		return tripleKills.intValue();
	}

	/**
	 * @return True damage dealt.
	 */
	public int getTrueDamageDealt() {
		if (trueDamageDealt == null) {
			return -1;
		}

		return trueDamageDealt.intValue();
	}

	/**
	 * @return True damage dealt to champions.
	 */
	public int getTrueDamageDealtToChampions() {
		if (trueDamageDealtToChampions == null) {
			return -1;
		}

		return trueDamageDealtToChampions.intValue();
	}

	/**
	 * @return True damage taken.
	 */
	public int getTrueDamageTaken() {
		if (trueDamageTaken == null) {
			return -1;
		}

		return trueDamageTaken.intValue();
	}

	/**
	 * @return Number of unreal kills.
	 */
	public int getUnrealKills() {
		if (unrealKills == null) {
			return -1;
		}

		return unrealKills.intValue();
	}

	/**
	 * @return Vision wards purchased.
	 */
	public int getVisionWardsBoughtInGame() {
		if (visionWardsBoughtInGame == null) {
			return -1;
		}

		return visionWardsBoughtInGame.intValue();
	}

	/**
	 * @return Number of wards killed.
	 */
	public int getWardsKilled() {
		if (wardsKilled == null) {
			return -1;
		}

		return wardsKilled.intValue();
	}

	/**
	 * @return Number of wards placed.
	 */
	public int getWardsPlaced() {
		if (wardsPlaced == null) {
			return -1;
		}

		return wardsPlaced.intValue();
	}

	/**
	 * @return Flag indicating whether or not the participant won.
	 */
	public boolean isWinner() {
		if (winner == null) {
			return false;
		}

		return winner.booleanValue();
	}
 }