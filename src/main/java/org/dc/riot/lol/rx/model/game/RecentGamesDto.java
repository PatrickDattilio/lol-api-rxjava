package org.dc.riot.lol.rx.model.game;

/**
 * @author Dc
 * @since 1.0.0
 */
public class RecentGamesDto {
    private GameDto[] games;
    private long summonerId;

    /**
     * @return Collection of recent games played (max 10).
     */
    public GameDto[] getGames() {
    	if (games == null) {
    		return new GameDto[0];
    	}

        return games;
    }

    /**
     * @return The summonerId
     */
    public long getSummonerId() {
        return summonerId;
    }
}
