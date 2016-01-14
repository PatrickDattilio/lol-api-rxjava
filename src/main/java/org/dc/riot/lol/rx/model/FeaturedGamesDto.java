package org.dc.riot.lol.rx.model;

import java.util.List;

/**
 * Spectate featured games
 * 
 * @author Dc
 * @since 1.0.0
 */
public class FeaturedGamesDto {
    private long clientRefreshInterval;
    private List<CurrentGameInfo> gameList;

    public long getClientRefreshInterval() {
        return clientRefreshInterval;
    }

    public void setClientRefreshInterval(long clientRefreshInterval) {
        this.clientRefreshInterval = clientRefreshInterval;
    }

    public List<CurrentGameInfo> getGameList() {
        return gameList;
    }

    public void setGameList(List<CurrentGameInfo> gameList) {
        this.gameList = gameList;
    }
}
