package org.dc.riot.lol.rx.model.stats;

/**
 * This object contains a collection of player
 * stats summary information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class PlayerStatsSummaryListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private PlayerStatsSummaryDto[] playerStatSummaries;
    private long summonerId;
    
    public PlayerStatsSummaryListDto() {
    	COUNT++;
    }

    /**
     * @return Collection of player stats summaries
     * associated with the summoner.
     */
    public PlayerStatsSummaryDto[] getPlayerStatSummaries() {
    	if (playerStatSummaries == null) {
    		return new PlayerStatsSummaryDto[0];
    	}

        return playerStatSummaries;
    }

    /**
     * @return Summoner ID.
     */
    public long getSummonerId() {
        return summonerId;
    }
}
