package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class MiniSeriesDto {
    private String progress;
    private int target;
    private int losses;
    private int wins;

    /**
     * @return The progress (e.g. WWLLN)
     */
    public String getProgress() {
        return progress;
    }

    /**
     * @param progress The progress
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
     * @return The number of wins needed in this series
     */
    public int getTarget() {
        return target;
    }

    /**
     * @param target The target
     */
    public void setTarget(int target) {
        this.target = target;
    }

    /**
     * @return The losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * @param losses The losses
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * @return The wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * @param wins The wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }
}
