package org.dc.riot.lol.rx.model.stats;

/**
 * This object contains player stats summary information.<br>
 * <br>
 * Getters of this class will return <code>-1</code> for fields
 * not defined in the JSON response.
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
    private Long modifyDate;
    private Integer wins;
    private Integer losses;
    
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
    	if (modifyDate == null) {
    		return modifyDate;
    	}

        return modifyDate.longValue();
    }

    /**
     * @return Wins.
     */
    public int getWins() {
    	if (wins == null) {
    		return -1;
    	}

        return wins.intValue();
    }

    /**
     * @return Number of losses for this queue type.
     * Returned for ranked queue types only.
     */
    public int getLosses() {
    	if (losses == null) {
    		return -1;
    	}

        return losses.intValue();
    }
}
