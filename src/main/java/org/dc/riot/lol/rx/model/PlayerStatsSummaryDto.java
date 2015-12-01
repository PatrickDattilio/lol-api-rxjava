package org.dc.riot.lol.rx.model;

/**
 * Used by the Stats API
 * Created by Dc on 9/19/15.
 */
public class PlayerStatsSummaryDto {
    private PlayerStatsType playerStatSummaryType;
    private AggregatedStatsDto aggregatedStats;
    private long modifyDate;
    private int wins;
    private int losses;

    /**
     * @return The playerStatSummaryType
     */
    public PlayerStatsType getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    /**
     * @param playerStatSummaryType The playerStatSummaryType
     */
    public void setPlayerStatSummaryType(PlayerStatsType playerStatSummaryType) {
        this.playerStatSummaryType = playerStatSummaryType;
    }

    /**
     * @return The aggregatedStats
     */
    public AggregatedStatsDto getAggregatedStats() {
        return aggregatedStats;
    }

    /**
     * @param aggregatedStats The aggregatedStats
     */
    public void setAggregatedStats(AggregatedStatsDto aggregatedStats) {
        this.aggregatedStats = aggregatedStats;
    }

    /**
     * @return The modifyDate
     */
    public long getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate The modifyDate
     */
    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * @return The wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * @param wins The wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * @return The losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * @param losses The losses
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    public enum PlayerStatsType {
        AramUnranked5x5, Ascension, CAP5x5, CoopVsAI, CoopVsAI3x3, CounterPick, FirstBlood1x1, FirstBlood2x2, Hexakill, KingPoro, NightmareBot, OdinUnranked, OneForAll5x5, RankedPremade3x3, RankedPremade5x5, RankedSolo5x5, RankedTeam3x3, RankedTeam5x5, SummonersRift6x6, Unranked, Unranked3x3, URF, URFBots, Bilgewater;
    }
}
