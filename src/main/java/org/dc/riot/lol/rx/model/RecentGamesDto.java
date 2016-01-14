package org.dc.riot.lol.rx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dc
 * @since 1.0.0
 */
public class RecentGamesDto {
    private List<GameDto> games = new ArrayList<>();
    private long summonerId;

    /**
     * @return The games
     */
    public List<GameDto> getGames() {
        return games;
    }

    /**
     * @param games The games
     */
    public void setGames(List<GameDto> games) {
        this.games = games;
    }

    /**
     * @return The summonerId
     */
    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
