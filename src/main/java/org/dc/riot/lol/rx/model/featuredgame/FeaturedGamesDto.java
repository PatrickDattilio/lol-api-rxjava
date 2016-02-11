package org.dc.riot.lol.rx.model.featuredgame;

/**
 * Spectate featured games DTO.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class FeaturedGamesDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long clientRefreshInterval;
    private FeaturedGameInfo[] gameList;
    
    public FeaturedGamesDto() {
    	COUNT++;
    }

    /**
     * @return The suggested interval to wait before
     * requesting FeaturedGames again or
     * <code>-1</code> if not defined.
     */
    public long getClientRefreshInterval() {
    	if (clientRefreshInterval == null) {
    		return -1;
    	}

        return clientRefreshInterval.longValue();
    }

    /**
     * @return The list of featured games.
     */
    public FeaturedGameInfo[] getGameList() {
    	if (gameList == null) {
    		return new FeaturedGameInfo[0];
    	}

        return gameList;
    }
}
