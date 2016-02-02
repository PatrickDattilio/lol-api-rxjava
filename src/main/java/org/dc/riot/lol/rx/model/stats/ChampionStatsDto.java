package org.dc.riot.lol.rx.model.stats;

/**
 * This object contains a collection of champion stats information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionStatsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private long id;
    private AggregatedStatsDto stats;   // Aggregated stats associated with the champion.
    
    public ChampionStatsDto() {
    	COUNT++;
    }

    /**
     * @return Champion ID. Note that champion ID 0
     * represents the combined stats for all champions.
     * For static information correlating to champion IDs,
     * please refer to the LoL Static Data API.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Aggregated stats associated with the champion.
     */
    public AggregatedStatsDto getStats() {
        return stats;
    }
}
