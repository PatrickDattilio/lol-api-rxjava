package org.dc.riot.lol.rx.model.stats;

/**
 * This object contains aggregated stat information.<br>
 * <br>
 * Getters of this class will return <code>-1</code> if
 * a value is not defined.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class AggregatedStatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Integer averageAssists;
    private Integer averageChampionsKilled;
    private Integer averageCombatPlayerScore;
    private Integer averageNodeCapture;
    private Integer averageNodeCaptureAssist;
    private Integer averageNodeNeutralize;
    private Integer averageNodeNeutralizeAssist;
    private Integer averageNumDeaths;
    private Integer averageObjectivePlayerScore;
    private Integer averageTeamObjective;
    private Integer averageTotalPlayerScore;
    private Integer botGamesPlayed;
    private Integer killingSpree;
    private Integer maxAssists;
    private Integer maxChampionsKilled;
    private Integer maxCombatPlayerScore;
    private Integer maxLargestCriticalStrike;
    private Integer maxLargestKillingSpree;
    private Integer maxNodeCapture;
    private Integer maxNodeCaptureAssist;
    private Integer maxNodeNeutralize;
    private Integer maxNodeNeutralizeAssist;
    private Integer maxNumDeaths;
    private Integer maxObjectivePlayerScore;
    private Integer maxTeamObjective;
    private Integer maxTimePlayed;
    private Integer maxTimeSpentLiving;
    private Integer maxTotalPlayerScore;
    private Integer mostChampionKillsPerSession;
    private Integer mostSpellsCast;
    private Integer normalGamesPlayed;
    private Integer rankedPremadeGamesPlayed;
    private Integer rankedSoloGamesPlayed;
    private Integer totalAssists;
    private Integer totalChampionKills;
    private Integer totalDamageDealt;
    private Integer totalDamageTaken;
    private Integer totalDeathsPerSession;
    private Integer totalDoubleKills;
    private Integer totalFirstBlood;
    private Integer totalGoldEarned;
    private Integer totalHeal;
    private Integer totalMagicDamageDealt;
    private Integer totalMinionKills;
    private Integer totalNeutralMinionsKilled;
    private Integer totalNodeCapture;  // Dominion only.
    private Integer totalNodeNeutralize;   // Dominion only.
    private Integer totalPentaKills;
    private Integer totalPhysicalDamageDealt;
    private Integer totalQuadraKills;
    private Integer totalSessionsLost;
    private Integer totalSessionsPlayed;
    private Integer totalSessionsWon;
    private Integer totalTripleKills;
    private Integer totalTurretsKilled;
    private Integer totalUnrealKills;

    public AggregatedStatsDto() {
    	COUNT++;
    }

    /**
     * Dominion only.
     * 
     * @return Average assists.
     */
    public int getAverageAssists() {
    	if (averageAssists == null) {
    		return -1;
    	}
    
        return averageAssists.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average champions killed.
     */
    public int getAverageChampionsKilled() {
    	if (averageChampionsKilled == null) {
    		return -1;
    	}
    	
        return averageChampionsKilled.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average combat player score.
     */
    public int getAverageCombatPlayerScore() {
    	if (averageCombatPlayerScore == null) {
    		return -1;
    	}

        return averageCombatPlayerScore.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average node captures.
     */
    public int getAverageNodeCapture() {
    	if (averageNodeCapture == null) {
    		return -1;
    	}

        return averageNodeCapture.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average node capture assists.
     */
    public int getAverageNodeCaptureAssist() {
    	if (averageNodeCaptureAssist == null) {
    		return -1;
    	}

        return averageNodeCaptureAssist.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average nodes neutralized.
     */
    public int getAverageNodeNeutralize() {
    	if (averageNodeNeutralize == null) {
    		return -1;
    	}

        return averageNodeNeutralize.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average node neutralize assists.
     */
    public int getAverageNodeNeutralizeAssist() {
    	if (averageNodeNeutralizeAssist == null) {
    		return -1;
    	}

        return averageNodeNeutralizeAssist.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average deaths.
     */
    public int getAverageNumDeaths() {
    	if (averageNumDeaths == null) {
    		return -1;
    	}

        return averageNumDeaths.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average objective player score.
     */
    public int getAverageObjectivePlayerScore() {
    	if (averageObjectivePlayerScore == null) {
    		return -1;
    	}

        return averageObjectivePlayerScore.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average team objective.
     */
    public int getAverageTeamObjective() {
    	if (averageTeamObjective == null) {
    		return -1;
    	}

        return averageTeamObjective.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Average total player score.
     */
    public int getAverageTotalPlayerScore() {
    	if (averageTotalPlayerScore == null) {
    		return -1;
    	}
    	
        return averageTotalPlayerScore.intValue();
    }

    /**
     * @return Bot games played.
     */
    public int getBotGamesPlayed() {
    	if (botGamesPlayed == null) {
    		return -1;
    	}

        return botGamesPlayed.intValue();
    }

    public int getKillingSpree() {
    	if (killingSpree == null) {
    		return -1;
    	}

        return killingSpree.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max assists.
     */
    public int getMaxAssists() {
    	if (maxAssists == null) {
    		return -1;
    	}

        return maxAssists.intValue();
    }

    public int getMaxChampionsKilled() {
    	if (maxChampionsKilled == null) {
    		return -1;
    	}

        return maxChampionsKilled.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max combat player score.
     */
    public int getMaxCombatPlayerScore() {
    	if (maxCombatPlayerScore == null) {
    		return -1;
    	}
    	
        return maxCombatPlayerScore.intValue();
    }

    public int getMaxLargestCriticalStrike() {
    	if (maxLargestCriticalStrike == null) {
    		return -1;
    	}

        return maxLargestCriticalStrike.intValue();
    }

    public int getMaxLargestKillingSpree() {
    	if (maxLargestKillingSpree == null) {
    		return -1;
    	}

        return maxLargestKillingSpree.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max node captures.
     */
    public int getMaxNodeCapture() {
    	if (maxNodeCapture == null) {
    		return -1;
    	}

        return maxNodeCapture.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max node capture assists.
     */
    public int getMaxNodeCaptureAssist() {
    	if (maxNodeCaptureAssist == null) {
    		return -1;
    	}

        return maxNodeCaptureAssist.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max nodes neutralized.
     */
    public int getMaxNodeNeutralize() {
    	if (maxNodeNeutralize == null) {
    		return -1;
    	}

        return maxNodeNeutralize.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max node neutralize assists.
     */
    public int getMaxNodeNeutralizeAssist() {
    	if (maxNodeNeutralizeAssist == null) {
    		return -1;
    	}

        return maxNodeNeutralizeAssist.intValue();
    }

    /**
     * Only returned for ranked statistics.
     * 
     * @return Max deaths.
     */
    public int getMaxNumDeaths() {
    	if (maxNumDeaths == null) {
    		return -1;
    	}

        return maxNumDeaths.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max objective player score.
     */
    public int getMaxObjectivePlayerScore() {
    	if (maxObjectivePlayerScore == null) {
    		return -1;
    	}

        return maxObjectivePlayerScore.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max team objective.
     */
    public int getMaxTeamObjective() {
    	if (maxTeamObjective == null) {
    		return -1;
    	}

        return maxTeamObjective.intValue();
    }

    public int getMaxTimePlayed() {
    	if (maxTimePlayed == null) {
    		return -1;
    	}

        return maxTimePlayed.intValue();
    }

    public int getMaxTimeSpentLiving() {
    	if (maxTimeSpentLiving == null) {
    		return -1;
    	}

        return maxTimeSpentLiving.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Max total player score.
     */
    public int getMaxTotalPlayerScore() {
    	if (maxTotalPlayerScore == null) {
    		return -1;
    	}

        return maxTotalPlayerScore.intValue();
    }

    public int getMostChampionKillsPerSession() {
    	if (mostChampionKillsPerSession == null) {
    		return -1;
    	}

        return mostChampionKillsPerSession.intValue();
    }

    public int getMostSpellsCast() {
    	if (mostSpellsCast == null) {
    		return -1;
    	}

        return mostSpellsCast.intValue();
    }

    public int getNormalGamesPlayed() {
    	if (normalGamesPlayed == null) {
    		return -1;
    	}

        return normalGamesPlayed;
    }

    public int getRankedPremadeGamesPlayed() {
    	if (rankedPremadeGamesPlayed == null) {
    		return -1;
    	}

        return rankedPremadeGamesPlayed.intValue();
    }

    public int getRankedSoloGamesPlayed() {
    	if (rankedSoloGamesPlayed == null) {
    		return -1;
    	}

        return rankedSoloGamesPlayed;
    }

    public int getTotalAssists() {
    	if (totalAssists == null) {
    		return -1;
    	}

        return totalAssists.intValue();
    }

    public int getTotalChampionKills() {
    	if (totalChampionKills == null) {
    		return -1;
    	}

        return totalChampionKills.intValue();
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

    /**
     * Only returned for ranked statistics.
     * 
     * @return Total deaths per session.
     */
    public int getTotalDeathsPerSession() {
    	if (totalDeathsPerSession == null) {
    		return -1;
    	}

        return totalDeathsPerSession.intValue();
    }

    public int getTotalDoubleKills() {
    	if (totalDoubleKills == null) {
    		return -1;
    	}

        return totalDoubleKills.intValue();
    }

    public int getTotalFirstBlood() {
    	if (totalFirstBlood == null) {
    		return -1;
    	}

        return totalFirstBlood.intValue();
    }

    public int getTotalGoldEarned() {
    	if (totalGoldEarned == null) {
    		return -1;
    	}

        return totalGoldEarned.intValue();
    }

    public int getTotalHeal() {
    	if (totalHeal == null) {
    		return -1;
    	}

        return totalHeal.intValue();
    }

    public int getTotalMagicDamageDealt() {
    	if (totalMagicDamageDealt == null) {
    		return -1;
    	}

        return totalMagicDamageDealt.intValue();
    }

    public int getTotalMinionKills() {
    	if (totalMinionKills == null) {
    		return -1;
    	}

        return totalMinionKills.intValue();
    }

    public int getTotalNeutralMinionsKilled() {
    	if (totalNeutralMinionsKilled == null) {
    		return -1;
    	}

        return totalNeutralMinionsKilled.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Total nodes captured.
     */
    public int getTotalNodeCapture() {
    	if (totalNodeCapture == null) {
    		return -1;
    	}

        return totalNodeCapture.intValue();
    }

    /**
     * Dominion only.
     * 
     * @return Total nodes neutralized.
     */
    public int getTotalNodeNeutralize() {
    	if (totalNodeNeutralize == null) {
    		return -1;
    	}

        return totalNodeNeutralize.intValue();
    }

    public int getTotalPentaKills() {
    	if (totalPentaKills == null) {
    		return -1;
    	}

        return totalPentaKills.intValue();
    }

    public int getTotalPhysicalDamageDealt() {
    	if (totalPhysicalDamageDealt == null) {
    		return -1;
    	}

        return totalPhysicalDamageDealt.intValue();
    }

    public int getTotalQuadraKills() {
    	if (totalQuadraKills == null) {
    		return -1;
    	}

        return totalQuadraKills.intValue();
    }

    public int getTotalSessionsLost() {
    	if (totalSessionsLost == null) {
    		return -1;
    	}

        return totalSessionsLost.intValue();
    }

    public int getTotalSessionsPlayed() {
    	if (totalSessionsPlayed == null) {
    		return -1;
    	}

        return totalSessionsPlayed.intValue();
    }

    public int getTotalSessionsWon() {
    	if (totalSessionsWon == null) {
    		return -1;
    	}

        return totalSessionsWon.intValue();
    }

    public int getTotalTripleKills() {
    	if (totalTripleKills == null) {
    		return -1;
    	}

        return totalTripleKills.intValue();
    }

    public int getTotalTurretsKilled() {
    	if (totalTurretsKilled == null) {
    		return -1;
    	}

        return totalTurretsKilled.intValue();
    }
    
    public int getTotalUnrealKills() {
    	if (totalUnrealKills == null) {
    		return -1;
    	}

    	return totalUnrealKills.intValue();
    }
}