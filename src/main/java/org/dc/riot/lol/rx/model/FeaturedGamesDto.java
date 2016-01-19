package org.dc.riot.lol.rx.model;

/**
 * Spectate featured games
 * 
 * @author Dc
 * @since 1.0.0
 */
public class FeaturedGamesDto {
    private long clientRefreshInterval;
    private FeaturedGameInfo[] gameList;

    public long getClientRefreshInterval() {
        return clientRefreshInterval;
    }

    public void setClientRefreshInterval(long clientRefreshInterval) {
        this.clientRefreshInterval = clientRefreshInterval;
    }

    public FeaturedGameInfo[] getGameList() {
    	if (gameList == null) {
    		return new FeaturedGameInfo[0];
    	}

        return gameList;
    }

    public void setGameList(FeaturedGameInfo[] gameList) {
        this.gameList = gameList;
    }
}
