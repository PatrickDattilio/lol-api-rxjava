package org.dc.riot.lol.rx.model.stats;

/**
 * This object contains aggregated stat information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class AggregatedStatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private int averageAssists;
    private int averageChampionsKilled;
    private int averageCombatPlayerScore;
    private int averageNodeCapture;
    private int averageNodeCaptureAssist;
    private int averageNodeNeutralize;
    private int averageNodeNeutralizeAssist;
    private int averageNumDeaths;
    private int averageObjectivePlayerScore;
    private int averageTeamObjective;
    private int averageTotalPlayerScore;
    private int botGamesPlayed;
    private int killingSpree;
    private int maxAssists;
    private int maxChampionsKilled;
    private int maxCombatPlayerScore;
    private int maxLargestCriticalStrike;
    private int maxLargestKillingSpree;
    private int maxNodeCapture;
    private int maxNodeCaptureAssist;
    private int maxNodeNeutralize;
    private int maxNodeNeutralizeAssist;
    private int maxNumDeaths;
    private int maxObjectivePlayerScore;
    private int maxTeamObjective;
    private int maxTimePlayed;
    private int maxTimeSpentLiving;
    private int maxTotalPlayerScore;
    private int mostChampionKillsPerSession;
    private int mostSpellsCast;
    private int normalGamesPlayed;
    private int rankedPremadeGamesPlayed;
    private int rankedSoloGamesPlayed;
    private int totalAssists;
    private int totalChampionKills;
    private int totalDamageDealt;
    private int totalDamageTaken;
    private int totalDeathsPerSession;
    private int totalDoubleKills;
    private int totalFirstBlood;
    private int totalGoldEarned;
    private int totalHeal;
    private int totalMagicDamageDealt;
    private int totalMinionKills;
    private int totalNeutralMinionsKilled;
    private int totalNodeCapture;  // Dominion only.
    private int totalNodeNeutralize;   // Dominion only.
    private int totalPentaKills;
    private int totalPhysicalDamageDealt;
    private int totalQuadraKills;
    private int totalSessionsLost;
    private int totalSessionsPlayed;
    private int totalSessionsWon;
    private int totalTripleKills;
    private int totalTurretsKilled;
    private int totalUnrealKills;

    public AggregatedStatsDto() {
    	COUNT++;
    }

    /**
     * Dominion only.
     * 
     * @return Average assists.
     */
    public int getAverageAssists() {
        return averageAssists;
    }

    /**
     * Dominion only.
     * 
     * @return Average champions killed.
     */
    public int getAverageChampionsKilled() {
        return averageChampionsKilled;
    }

    /**
     * Dominion only.
     * 
     * @return Average combat player score.
     */
    public int getAverageCombatPlayerScore() {
        return averageCombatPlayerScore;
    }

    /**
     * Dominion only.
     * 
     * @return Average node captures.
     */
    public int getAverageNodeCapture() {
        return averageNodeCapture;
    }

    /**
     * Dominion only.
     * 
     * @return Average node capture assists.
     */
    public int getAverageNodeCaptureAssist() {
        return averageNodeCaptureAssist;
    }

    /**
     * Dominion only.
     * 
     * @return Average nodes neutralized.
     */
    public int getAverageNodeNeutralize() {
        return averageNodeNeutralize;
    }

    /**
     * Dominion only.
     * 
     * @return Average node neutralize assists.
     */
    public int getAverageNodeNeutralizeAssist() {
        return averageNodeNeutralizeAssist;
    }

    /**
     * Dominion only.
     * 
     * @return Average deaths.
     */
    public int getAverageNumDeaths() {
        return averageNumDeaths;
    }

    /**
     * Dominion only.
     * 
     * @return Average objective player score.
     */
    public int getAverageObjectivePlayerScore() {
        return averageObjectivePlayerScore;
    }

    /**
     * Dominion only.
     * 
     * @return Average team objective.
     */
    public int getAverageTeamObjective() {
        return averageTeamObjective;
    }

    /**
     * Dominion only.
     * 
     * @return Average total player score.
     */
    public int getAverageTotalPlayerScore() {
        return averageTotalPlayerScore;
    }

    public int getBotGamesPlayed() {
        return botGamesPlayed;
    }

    public int getKillingSpree() {
        return killingSpree;
    }

    /**
     * Dominion only.
     * 
     * @return Max assists.
     */
    public int getMaxAssists() {
        return maxAssists;
    }

    public int getMaxChampionsKilled() {
        return maxChampionsKilled;
    }

    /**
     * Dominion only.
     * 
     * @return Max combat player score.
     */
    public int getMaxCombatPlayerScore() {
        return maxCombatPlayerScore;
    }

    public int getMaxLargestCriticalStrike() {
        return maxLargestCriticalStrike;
    }

    public int getMaxLargestKillingSpree() {
        return maxLargestKillingSpree;
    }

    /**
     * Dominion only.
     * 
     * @return Max node captures.
     */
    public int getMaxNodeCapture() {
        return maxNodeCapture;
    }

    /**
     * Dominion only.
     * 
     * @return Max node capture assists.
     */
    public int getMaxNodeCaptureAssist() {
        return maxNodeCaptureAssist;
    }

    /**
     * Dominion only.
     * 
     * @return Max nodes neutralized.
     */
    public int getMaxNodeNeutralize() {
        return maxNodeNeutralize;
    }

    /**
     * Dominion only.
     * 
     * @return Max node neutralize assists.
     */
    public int getMaxNodeNeutralizeAssist() {
        return maxNodeNeutralizeAssist;
    }

    /**
     * Only returned for ranked statistics.
     * 
     * @return Max deaths.
     */
    public int getMaxNumDeaths() {
        return maxNumDeaths;
    }

    /**
     * Dominion only.
     * 
     * @return Max objective player score.
     */
    public int getMaxObjectivePlayerScore() {
        return maxObjectivePlayerScore;
    }

    /**
     * Dominion only.
     * 
     * @return Max team objective.
     */
    public int getMaxTeamObjective() {
        return maxTeamObjective;
    }

    public int getMaxTimePlayed() {
        return maxTimePlayed;
    }

    public int getMaxTimeSpentLiving() {
        return maxTimeSpentLiving;
    }

    /**
     * Dominion only.
     * 
     * @return Max total player score.
     */
    public int getMaxTotalPlayerScore() {
        return maxTotalPlayerScore;
    }

    public int getMostChampionKillsPerSession() {
        return mostChampionKillsPerSession;
    }

    public int getMostSpellsCast() {
        return mostSpellsCast;
    }

    public int getNormalGamesPlayed() {
        return normalGamesPlayed;
    }

    public int getRankedPremadeGamesPlayed() {
        return rankedPremadeGamesPlayed;
    }

    public int getRankedSoloGamesPlayed() {
        return rankedSoloGamesPlayed;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public int getTotalChampionKills() {
        return totalChampionKills;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    /**
     * Only returned for ranked statistics.
     * 
     * @return Total deaths per session.
     */
    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
    }

    public int getTotalDoubleKills() {
        return totalDoubleKills;
    }

    public int getTotalFirstBlood() {
        return totalFirstBlood;
    }

    public int getTotalGoldEarned() {
        return totalGoldEarned;
    }

    public int getTotalHeal() {
        return totalHeal;
    }

    public int getTotalMagicDamageDealt() {
        return totalMagicDamageDealt;
    }

    public int getTotalMinionKills() {
        return totalMinionKills;
    }

    public int getTotalNeutralMinionsKilled() {
        return totalNeutralMinionsKilled;
    }

    /**
     * Dominion only.
     * 
     * @return Total nodes captured.
     */
    public int getTotalNodeCapture() {
        return totalNodeCapture;
    }

    /**
     * Dominion only.
     * 
     * @return Total nodes neutralized.
     */
    public int getTotalNodeNeutralize() {
        return totalNodeNeutralize;
    }

    public int getTotalPentaKills() {
        return totalPentaKills;
    }

    public int getTotalPhysicalDamageDealt() {
        return totalPhysicalDamageDealt;
    }

    public int getTotalQuadraKills() {
        return totalQuadraKills;
    }

    public int getTotalSessionsLost() {
        return totalSessionsLost;
    }

    public int getTotalSessionsPlayed() {
        return totalSessionsPlayed;
    }

    public int getTotalSessionsWon() {
        return totalSessionsWon;
    }

    public int getTotalTripleKills() {
        return totalTripleKills;
    }

    public int getTotalTurretsKilled() {
        return totalTurretsKilled;
    }
    
    public int getTotalUnrealKills() {
    	return totalUnrealKills;
    }
}