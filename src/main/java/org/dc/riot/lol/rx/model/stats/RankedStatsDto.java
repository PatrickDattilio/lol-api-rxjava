package org.dc.riot.lol.rx.model.stats;

/**
 * This object contains ranked stats information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RankedStatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private ChampionStatsDto[] champions;
    private Long modifyDate;
    private Long summonerId;
    
    public RankedStatsDto() {
    	COUNT++;
    }

    /**
     * @return Collection of aggregated stats summarized by champion.
     */
    public ChampionStatsDto[] getChampions() {
        return champions;
    }

    /**
     * @return Date stats were last modified
     * specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getModifyDate() {
    	if (modifyDate == null) {
    		return -1;
    	}

        return modifyDate.longValue();
    }

    /**
     * @return Summoner ID or <code>-1</code> if
     * not defined.
     */
    public long getSummonerId() {
    	if (summonerId == null) {
    		return -1;
    	}

        return summonerId.longValue();
    }
}
