package org.dc.riot.lol.rx.model;

/**
 * Champion stats
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionStatsDto {
    /**
     * Champion ID. Note that champion ID 0 represents the combined stats for all champions.
     * For static information correlating to champion IDs, please refer to the LoL Static Data API.
     */
    private long id;
    private AggregatedStatsDto stats;   // Aggregated stats associated with the champion.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AggregatedStatsDto getStats() {
        return stats;
    }

    public void setStats(AggregatedStatsDto stats) {
        this.stats = stats;
    }
}
