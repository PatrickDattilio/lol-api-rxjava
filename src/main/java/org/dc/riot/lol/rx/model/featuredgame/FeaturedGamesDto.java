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

    private long clientRefreshInterval;
    private FeaturedGameInfo[] gameList;
    
    public FeaturedGamesDto() {
    	COUNT++;
    }

    /**
     * @return The suggested interval to wait before
     * requesting FeaturedGames again.
     */
    public long getClientRefreshInterval() {
        return clientRefreshInterval;
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
