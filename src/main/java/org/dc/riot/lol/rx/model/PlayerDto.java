package org.dc.riot.lol.rx.model;

/**
 * Created by Dc on 9/16/15.
 */
public class PlayerDto {
    private int championId;
    private int teamId;
    private long summonerId;

    /**
     * @return The championId
     */
    public int getChampionId() {
        return championId;
    }

    /**
     * @param championId The championId
     */
    public void setChampionId(int championId) {
        this.championId = championId;
    }

    /**
     * @return 100 for blue, 200 for red
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * @param teamId The teamId
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
