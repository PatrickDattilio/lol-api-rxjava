package org.dc.riot.lol.rx.model;

/**
 * Banned champion
 * Created by Dan on 9/2/15.
 */
public class BannedChampion {
    private long championId;
    private int pickTurn;
    private long teamId;

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(int pickTurn) {
        this.pickTurn = pickTurn;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
