package org.dc.riot.lol.rx.model.game;

/**
 * This object contains recent games information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RecentGamesDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private GameDto[] games;
    private Long summonerId;
    
    public RecentGamesDto() {
    	COUNT++;
    }

    /**
     * @return Collection of recent games played (max 10)
     * or empty if not defined.
     */
    public GameDto[] getGames() {
    	if (games == null) {
    		return new GameDto[0];
    	}

        return games;
    }

    /**
     * @return Summoner ID or <code>-1</code>
     * if not defined.
     */
    public long getSummonerId() {
    	if (summonerId == null) {
    		return -1;
    	}

        return summonerId.longValue();
    }
}
