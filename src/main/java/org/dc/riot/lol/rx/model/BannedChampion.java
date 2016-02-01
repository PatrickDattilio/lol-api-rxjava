package org.dc.riot.lol.rx.model;

/**
 * Banned champion
 *  // TODO clean this POJO up
 * 
 * @author Dc
 * @since 1.0.0
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

    /**
     * Implementation note: the {@link org.dc.riot.lol.rx.service.RiotApi.Match
     * RiotApi.Match} interface will not set this field.
     * 
     * @return
     */
    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
