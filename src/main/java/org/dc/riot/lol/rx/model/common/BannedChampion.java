package org.dc.riot.lol.rx.model.common;

/**
 * Banned champion information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class BannedChampion {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private long championId;
    private int pickTurn;
    private long teamId;
    
    public BannedChampion() {
    	COUNT++;
    }

    /**
     * @return Banned champion ID.
     */
    public long getChampionId() {
        return championId;
    }

    /**
     * @return Turn during which the champion was banned.
     */
    public int getPickTurn() {
        return pickTurn;
    }

    /**
     * Implementation note: the {@link org.dc.riot.lol.rx.service.RiotApi.Match
     * RiotApi.Match} interface may not set this field.
     * 
     * @return Banning team ID.
     */
    public long getTeamId() {
        return teamId;
    }
}
