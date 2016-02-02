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
    private long modifyDate;
    private long summonerId;
    
    /**
     * If <code>false</code> all fields in this object will be useless.
     * This flag is typically set when a code 404 is returned by the
     * Riot API endpoint.
     */
    public boolean isValid = true;
    
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
     * @return Date stats were last modified specified as epoch milliseconds.
     */
    public long getModifyDate() {
        return modifyDate;
    }

    /**
     * @return Summoner ID.
     */
    public long getSummonerId() {
        return summonerId;
    }
}
