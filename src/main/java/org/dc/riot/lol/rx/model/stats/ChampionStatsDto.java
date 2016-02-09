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

    private Long id;
    private AggregatedStatsDto stats;   // Aggregated stats associated with the champion.
    
    public ChampionStatsDto() {
    	COUNT++;
    }

    /**
     * Note that champion ID 0
     * represents the combined stats for all champions.
     * For static information correlating to champion IDs,
     * please refer to the LoL Static Data API.
     * 
     * @return Champion ID or <code>-1</code> if not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id.longValue();
    }

    /**
     * @return Aggregated stats associated with the champion.
     */
    public AggregatedStatsDto getStats() {
        return stats;
    }
}
