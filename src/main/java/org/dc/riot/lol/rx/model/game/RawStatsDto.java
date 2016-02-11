package org.dc.riot.lol.rx.model.game;

/**
 * This object contains raw stat information.<br>
 * <br>
 * With the announcement that Dominion is being
 * retired we need to keep an eye on unit tests
 * pertaining to this class.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RawStatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Integer assists;
    private Integer barracksKilled;
    private Integer championsKilled;
    private Integer totalDamageDealtToChampions;
    private Integer combatPlayerScore;
    private Integer consumablesPurchased;
    private Integer damageDealtPlayer;
    private Integer doubleKills;
    private Integer firstBlood;
    private Integer gold;
    private Integer goldEarned;
    private Integer goldSpent;
    private Integer item0;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;
    private Integer itemsPurchased;
    private Integer killingSprees;
    private Integer largestCriticalStrike;
    private Integer largestKillingSpree;
    private Integer largestMultiKill;
    private Integer legendaryItemsCreated;
    private Integer level;
    private Integer magicDamageDealtPlayer;
    private Integer magicDamageDealtToChampions;
    private Integer magicDamageTaken;
    private Integer minionsDenied;
    private Integer minionsKilled;
    private Integer neutralMinionsKilled;
    private Integer neutralMinionsKilledEnemyJungle;
    private Integer neutralMinionsKilledYourJungle;
    private Boolean nexusKilled;
    private Integer nodeCapture;
    private Integer nodeCaptureAssist;
    private Integer nodeNeutralize;
    private Integer nodeNeutralizeAssist;
    private Integer numDeaths;
    private Integer numItemsBought;
    private Integer objectivePlayerScore;
    private Integer pentaKills;
    private Integer physicalDamageDealtPlayer;
    private Integer physicalDamageDealtToChampions;
    private Integer physicalDamageTaken;
    private PlayerPosition playerPosition;
    private PlayerRole playerRole;
    private Integer quadraKills;
    private Integer sightWardsBought;
    private Integer spell1Cast;
    private Integer spell2Cast;
    private Integer spell3Cast;
    private Integer spell4Cast;
    private Integer summonSpell1Cast;
    private Integer summonSpell2Cast;
    private Integer superMonsterKilled;
    private Integer team;
    private Integer teamObjective;
    private Integer timePlayed;
    private Integer totalDamageDealt;
    private Integer totalDamageTaken;
    private Integer totalHeal;
    private Integer totalPlayerScore;
    private Integer totalScoreRank;
    private Integer totalTimeCrowdControlDealt;
    private Integer totalUnitsHealed;
    private Integer tripleKills;
    private Integer trueDamageDealtPlayer;
    private Integer trueDamageDealtToChampions;
    private Integer trueDamageTaken;
    private Integer turretsKilled;
    private Integer unrealKills;
    private Integer victoryPointTotal;
    private Integer visionWardsBought;
    private Integer wardKilled;
    private Integer wardPlaced;
    private Boolean win;
    
    public RawStatsDto() {
    	COUNT++;
    }

    public int getAssists() {
    	if (assists == null) {
    		return -1;
    	}

        return assists.intValue();
    }

    /**
     * @return Number of enemy inhibitors killed.
     */
    public int getBarracksKilled() {
    	if (barracksKilled == null) {
    		return -1;
    	}

        return barracksKilled.intValue();
    }

    public int getChampionsKilled() {
    	if (championsKilled == null) {
    		return -1;
    	}

        return championsKilled.intValue();
    }

    public int getTotalDamageDealtToChampions() {
    	if (totalDamageDealtToChampions == null) {
    		return -1;
    	}

        return totalDamageDealtToChampions.intValue();
    }

    public int getCombatPlayerScore() {
    	if (combatPlayerScore == null) {
    		return -1;
    	}

        return combatPlayerScore.intValue();
    }

    public int getConsumablesPurchased() {
    	if (consumablesPurchased == null) {
    		return -1;
    	}

        return consumablesPurchased.intValue();
    }

    public int getDamageDealtPlayer() {
    	if (damageDealtPlayer == null) {
    		return -1;
    	}

        return damageDealtPlayer.intValue();
    }

    public int getDoubleKills() {
    	if (doubleKills == null) {
    		return -1;
    	}

        return doubleKills.intValue();
    }

    public int getFirstBlood() {
    	if (firstBlood == null) {
    		return -1;
    	}

        return firstBlood.intValue();
    }

    public int getGold() {
    	if (gold == null) {
    		return -1;
    	}

        return gold.intValue();
    }

    public int getGoldEarned() {
    	if (goldEarned == null) {
    		return -1;
    	}

        return goldEarned.intValue();
    }

    public int getGoldSpent() {
    	if (goldSpent == null) {
    		return -1;
    	}

        return goldSpent.intValue();
    }

    public int getItem0() {
    	if (item0 == null) {
    		return -1;
    	}

        return item0.intValue();
    }

    public int getItem1() {
    	if (item1 == null) {
    		return -1;
    	}

        return item1.intValue();
    }

    public int getItem2() {
    	if (item2 == null) {
    		return -1;
    	}

        return item2.intValue();
    }

    public int getItem3() {
    	if (item3 == null) {
    		return -1;
    	}

        return item3.intValue();
    }

    public int getItem4() {
    	if (item4 == null) {
    		return -1;
    	}

        return item4.intValue();
    }

    public int getItem5() {
    	if (item5 == null) {
    		return -1;
    	}

        return item5.intValue();
    }

    public int getItem6() {
    	if (item6 == null) {
    		return -1;
    	}

        return item6.intValue();
    }

    public int getItemsPurchased() {
    	if (itemsPurchased == null) {
    		return -1;
    	}

        return itemsPurchased.intValue();
    }

    public int getKillingSprees() {
    	if (killingSprees == null) {
    		return -1;
    	}

        return killingSprees.intValue();
    }

    public int getLargestCriticalStrike() {
    	if (largestCriticalStrike == null) {
    		return -1;
    	}

        return largestCriticalStrike.intValue();
    }

    public int getLargestKillingSpree() {
    	if (largestKillingSpree == null) {
    		return -1;
    	}

        return largestKillingSpree.intValue();
    }

    public int getLargestMultiKill() {
    	if (largestMultiKill == null) {
    		return -1;
    	}

        return largestMultiKill.intValue();
    }

    /**
     * @return 	Number of tier 3 items built.
     */
    public int getLegendaryItemsCreated() {
    	if (legendaryItemsCreated == null) {
    		return -1;
    	}

        return legendaryItemsCreated.intValue();
    }

    public int getLevel() {
    	if (level == null) {
    		return -1;
    	}

        return level.intValue();
    }

    public int getMagicDamageDealtPlayer() {
    	if (magicDamageDealtPlayer == null) {
    		return -1;
    	}

        return magicDamageDealtPlayer.intValue();
    }

    public int getMagicDamageDealtToChampions() {
    	if (magicDamageDealtToChampions == null) {
    		return -1;
    	}

        return magicDamageDealtToChampions.intValue();
    }

    public int getMagicDamageTaken() {
    	if (magicDamageTaken == null) {
    		return -1;
    	}

        return magicDamageTaken.intValue();
    }

    public int getMinionsDenied() {
    	if (minionsDenied == null) {
    		return -1;
    	}

        return minionsDenied.intValue();
    }

    public int getMinionsKilled() {
    	if (minionsKilled == null) {
    		return -1;
    	}

        return minionsKilled.intValue();
    }

    public int getNeutralMinionsKilled() {
    	if (neutralMinionsKilled == null) {
    		return -1;
    	}

        return neutralMinionsKilled.intValue();
    }

    public int getNeutralMinionsKilledEnemyJungle() {
    	if (neutralMinionsKilledEnemyJungle == null) {
    		return -1;
    	}

        return neutralMinionsKilledEnemyJungle.intValue();
    }

    public int getNeutralMinionsKilledYourJungle() {
    	if (neutralMinionsKilledYourJungle == null) {
    		return -1;
    	}

        return neutralMinionsKilledYourJungle.intValue();
    }

    /**
     * @return Flag specifying if the summoner
     * got the killing blow on the nexus.
     */
    public boolean isNexusKilled() {
    	if (nexusKilled == null) {
    		return false;
    	}

        return nexusKilled.booleanValue();
    }

    public int getNodeCapture() {
    	if (nodeCapture == null) {
    		return -1;
    	}

        return nodeCapture.intValue();
    }

    public int getNodeCaptureAssist() {
    	if (nodeCaptureAssist == null) {
    		return -1;
    	}

        return nodeCaptureAssist.intValue();
    }

    public int getNodeNeutralize() {
    	if (nodeNeutralize == null) {
    		return -1;
    	}

        return nodeNeutralize.intValue();
    }

    public int getNodeNeutralizeAssist() {
    	if (nodeNeutralizeAssist == null) {
    		return -1;
    	}

        return nodeNeutralizeAssist.intValue();
    }

    public int getNumDeaths() {
    	if (numDeaths == null) {
    		return -1;
    	}

        return numDeaths.intValue();
    }

    public int getNumItemsBought() {
    	if (numItemsBought == null) {
    		return -1;
    	}

        return numItemsBought.intValue();
    }

    public int getObjectivePlayerScore() {
    	if (objectivePlayerScore == null) {
    		return -1;
    	}

        return objectivePlayerScore.intValue();
    }

    public int getPentaKills() {
    	if (pentaKills == null) {
    		return -1;
    	}

        return pentaKills.intValue();
    }

    public int getPhysicalDamageDealtPlayer() {
    	if (physicalDamageDealtPlayer == null) {
    		return -1;
    	}

        return physicalDamageDealtPlayer.intValue();
    }

    public int getPhysicalDamageDealtToChampions() {
    	if (physicalDamageDealtToChampions == null) {
    		return -1;
    	}

        return physicalDamageDealtToChampions;
    }

    public int getPhysicalDamageTaken() {
    	if (physicalDamageTaken == null) {
    		return -1;
    	}

        return physicalDamageTaken.intValue();
    }

    /**
     * @return 	Player position
     * (Legal values: TOP(1), MIDDLE(2), JUNGLE(3), BOT(4))
     */
    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    /**
     * @return Player role (Legal values: DUO(1), SUPPORT(2),
     * CARRY(3), SOLO(4))
     */
    public PlayerRole getPlayerRole() {
        return playerRole;
    }

    public int getQuadraKills() {
    	if (quadraKills == null) {
    		return -1;
    	}

        return quadraKills.intValue();
    }

    public int getSightWardsBought() {
    	if (sightWardsBought == null) {
    		return -1;
    	}

        return sightWardsBought.intValue();
    }

    /**
     * @return Number of times first champion spell was cast.
     */
    public int getSpell1Cast() {
    	if (spell1Cast == null) {
    		return -1;
    	}

        return spell1Cast.intValue();
    }

    /**
     * @return Number of times second champion spell was cast.
     */
    public int getSpell2Cast() {
    	if (spell2Cast == null) {
    		return -1;
    	}

        return spell2Cast.intValue();
    }

    /**
     * @return Number of times third champion spell was cast.
     */
    public int getSpell3Cast() {
    	if (spell3Cast == null) {
    		return -1;
    	}

        return spell3Cast.intValue();
    }

    /**
     * @return Number of times fourth champion spell was cast.
     */
    public int getSpell4Cast() {
    	if (spell4Cast == null) {
    		return -1;
    	}

        return spell4Cast.intValue();
    }

    public int getSummonSpell1Cast() {
    	if (summonSpell1Cast == null) {
    		return -1;
    	}

        return summonSpell1Cast.intValue();
    }

    public int getSummonSpell2Cast() {
    	if (summonSpell2Cast == null) {
    		return -1;
    	}

        return summonSpell2Cast.intValue();
    }

    public int getSuperMonsterKilled() {
    	if (superMonsterKilled == null) {
    		return -1;
    	}

        return superMonsterKilled.intValue();
    }

    public int getTeam() {
    	if (team == null) {
    		return -1;
    	}

        return team.intValue();
    }

    public int getTeamObjective() {
    	if (teamObjective == null) {
    		return -1;
    	}

        return teamObjective.intValue();
    }

    public int getTimePlayed() {
    	if (timePlayed == null) {
    		return -1;
    	}

        return timePlayed.intValue();
    }

    public int getTotalDamageDealt() {
    	if (totalDamageDealt == null) {
    		return -1;
    	}

        return totalDamageDealt.intValue();
    }

    public int getTotalDamageTaken() {
    	if (totalDamageTaken == null) {
    		return -1;
    	}

        return totalDamageTaken.intValue();
    }

    public int getTotalHeal() {
    	if (totalHeal == null) {
    		return -1;
    	}

        return totalHeal.intValue();
    }

    public int getTotalPlayerScore() {
    	if (totalPlayerScore == null) {
    		return -1;
    	}

        return totalPlayerScore.intValue();
    }

    public int getTotalScoreRank() {
    	if (totalScoreRank == null) {
    		return -1;
    	}

        return totalScoreRank.intValue();
    }

    public int getTotalTimeCrowdControlDealt() {
    	if (totalTimeCrowdControlDealt == null) {
    		return -1;
    	}

        return totalTimeCrowdControlDealt.intValue();
    }

    public int getTotalUnitsHealed() {
    	if (totalUnitsHealed == null) {
    		return -1;
    	}

        return totalUnitsHealed.intValue();
    }

    public int getTripleKills() {
    	if (tripleKills == null) {
    		return -1;
    	}

        return tripleKills.intValue();
    }

    public int getTrueDamageDealtPlayer() {
    	if (trueDamageDealtPlayer == null) {
    		return -1;
    	}

        return trueDamageDealtPlayer.intValue();
    }

    public int getTrueDamageDealtToChampions() {
    	if (trueDamageDealtToChampions == null) {
    		return -1;
    	}

        return trueDamageDealtToChampions.intValue();
    }

    public int getTrueDamageTaken() {
    	if (trueDamageTaken == null) {
    		return -1;
    	}

        return trueDamageTaken.intValue();
    }

    public int getTurretsKilled() {
    	if (turretsKilled == null) {
    		return -1;
    	}

        return turretsKilled.intValue();
    }

    public int getUnrealKills() {
    	if (unrealKills == null) {
    		return -1;
    	}

        return unrealKills.intValue();
    }

    public int getVictoryPointTotal() {
    	if (victoryPointTotal == null) {
    		return -1;
    	}

        return victoryPointTotal.intValue();
    }

    public int getVisionWardsBought() {
    	if (visionWardsBought == null) {
    		return -1;
    	}

        return visionWardsBought.intValue();
    }

    public int getWardKilled() {
    	if (wardKilled == null) {
    		return -1;
    	}

        return wardKilled.intValue();
    }

    public int getWardPlaced() {
    	if (wardPlaced == null) {
    		return -1;
    	}

        return wardPlaced.intValue();
    }

    /**
     * @return Flag specifying whether or not this game was won.
     */
    public boolean isWin() {
    	if (win == null) {
    		return false;
    	}

        return win.booleanValue();
    }
}