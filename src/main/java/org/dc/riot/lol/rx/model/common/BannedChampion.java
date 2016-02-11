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

    private Long championId;
    private Integer pickTurn;
    private Long teamId;
    
    public BannedChampion() {
    	COUNT++;
    }

    /**
     * @return Banned champion ID or
     * <code>-1</code> if not defined.
     */
    public long getChampionId() {
    	if (championId == null) {
    		return -1;
    	}

        return championId.longValue();
    }

    /**
     * @return Turn during which the champion was banned or
     * <code>-1</code> if not defined.
     */
    public int getPickTurn() {
    	if (pickTurn == null) {
    		return -1;
    	}

        return pickTurn.intValue();
    }

    /**
     * Implementation note: the {@link org.dc.riot.lol.rx.service.RiotApi.Match
     * RiotApi.Match} interface may not set this field.
     * 
     * @return Banning team ID or <code>-1</code> if not defined.
     */
    public long getTeamId() {
    	if (teamId == null) {
    		return teamId;
    	}

        return teamId.longValue();
    }
}
