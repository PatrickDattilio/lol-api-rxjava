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

    private Long championId;
    private Integer teamId;
    private Long summonerId;
    
    public PlayerDto() {
    	COUNT++;
    }

    /**
     * @return Champion id associated with player
     * or <code>-1</code> if not defined.
     */
    public long getChampionId() {
    	if (championId == null) {
    		return -1;
    	}

        return championId.longValue();
    }

    /**
     * Implementation note: 100 for blue, 200 for red.
     * 
     * @return Team id associated with player
     * or <code>-1</code> if not defined.
     */
    public int getTeamId() {
    	if (teamId == null) {
    		return -1;
    	}

        return teamId.intValue();
    }

    /**
     * @return Summoner id associated with player
     * or <code>-1</code> if not defined.
     */
    public long getSummonerId() {
    	if (summonerId == null) {
    		return -1;
    	}

        return summonerId.longValue();
    }
}
