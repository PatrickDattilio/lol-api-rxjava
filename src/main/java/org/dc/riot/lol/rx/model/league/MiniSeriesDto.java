package org.dc.riot.lol.rx.model.league;

/**
 * This object contains mini-series information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MiniSeriesDto {
    private String progress;
    private int target;
    private int losses;
    private int wins;

    /**
     * @return String showing the current, sequential
     * mini series progress where 'W' represents a win,
     * 'L' represents a loss, and 'N' represents a game
     * that hasn't been played yet.
     */
    public String getProgress() {
        return progress;
    }

    /**
     * @return Number of wins required for promotion.
     */
    public int getTarget() {
        return target;
    }

    /**
     * @return Number of current losses in the mini series.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * @return Number of current wins in the mini series.
     */
    public int getWins() {
        return wins;
    }
}
