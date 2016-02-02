package org.dc.riot.lol.rx.model.game;

/**
 * This object contains player information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class PlayerDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private int championId;
    private int teamId;
    private long summonerId;
    
    public PlayerDto() {
    	COUNT++;
    }

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
