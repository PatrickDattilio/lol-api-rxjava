package org.dc.riot.lol.rx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Used by the Stats API
 * 
 * @author Dc
 * @since 1.0.0
 */
public class PlayerStatsSummaryListDto {
    private List<PlayerStatsSummaryDto> playerStatSummaries = new ArrayList<>();
    private long summonerId;

    /**
     * @return The playerStatSummaries
     */
    public List<PlayerStatsSummaryDto> getPlayerStatSummaries() {
        return playerStatSummaries;
    }

    /**
     * @param playerStatSummaries The playerStatSummaries
     */
    public void setPlayerStatSummaries(List<PlayerStatsSummaryDto> playerStatSummaries) {
        this.playerStatSummaries = playerStatSummaries;
    }

    /**
     * @return The summonerId
     */
    public long getSummonerId() {
        return summonerId;
    }

    /**
     * @param summonerId The summonerId
     */
    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
