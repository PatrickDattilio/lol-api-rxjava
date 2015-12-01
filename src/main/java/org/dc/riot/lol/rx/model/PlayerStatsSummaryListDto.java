package org.dc.riot.lol.rx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Used by the Stats API
 * Created by Dc on 9/19/15.
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
