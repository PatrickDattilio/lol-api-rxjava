package org.dc.riot.lol.rx.model.game;

/**
 * @author Dc
 * @since 1.0.0
 */
public class PlayerDto {
    private int championId;
    private int teamId;
    private long summonerId;

    /**
     * @return Champion id associated with player.
     */
    public int getChampionId() {
        return championId;
    }

    /**
     * @return Team id associated with player.
     * 100 for blue, 200 for red
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * @return Summoner id associated with player.
     */
    public long getSummonerId() {
        return summonerId;
    }
}
