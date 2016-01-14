package org.dc.riot.lol.rx.model;

/**
 * Ranked stats for a specific players.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RankedStatsDto {
    private ChampionStatsDto[] champions;
    private long modifyDate;
    private long summonerId;

    public ChampionStatsDto[] getChampions() {
        return champions;
    }

    public void setChampions(ChampionStatsDto[] champions) {
        this.champions = champions;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
