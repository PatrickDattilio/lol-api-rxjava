package org.dc.riot.lol.rx.model.stats;

/**
 * This object contains player stats summary information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class PlayerStatsSummaryDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private PlayerStatsType playerStatSummaryType;
    private AggregatedStatsDto aggregatedStats;
    private long modifyDate;
    private int wins;
    private int losses;
    
    public PlayerStatsSummaryDto() {
    	COUNT++;
    }

    /**
     * @return Player stats summary type.
     * (Legal values: AramUnranked5x5, Ascension,
     * Bilgewater, CAP5x5, CoopVsAI, CoopVsAI3x3,
     * CounterPick, FirstBlood1x1, FirstBlood2x2,
     * Hexakill, KingPoro, NightmareBot, OdinUnranked,
     * OneForAll5x5, RankedPremade3x3, RankedPremade5x5,
     * RankedSolo5x5, RankedTeam3x3, RankedTeam5x5,
     * SummonersRift6x6, Unranked, Unranked3x3, URF, URFBots)
     */
    public PlayerStatsType getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    /**
     * @return Aggregated stats.
     */
    public AggregatedStatsDto getAggregatedStats() {
        return aggregatedStats;
    }

    /**
     * @return Date stats were last modified specified
     * as epoch milliseconds.
     */
    public long getModifyDate() {
        return modifyDate;
    }

    /**
     * @return The wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * @return Number of losses for this queue type.
     * Returned for ranked queue types only.
     */
    public int getLosses() {
        return losses;
    }
}
