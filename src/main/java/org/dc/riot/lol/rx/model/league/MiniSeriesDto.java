package org.dc.riot.lol.rx.model.league;

/**
 * This object contains mini-series information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MiniSeriesDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String progress;
    private Integer target;
    private Integer losses;
    private Integer wins;
    
    public MiniSeriesDto() {
    	COUNT++;
    }

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
    	if (target == null) {
    		return -1;
    	}

        return target.intValue();
    }

    /**
     * @return Number of current losses in the mini series.
     */
    public int getLosses() {
    	if (losses == null) {
    		return -1;
    	}

        return losses.intValue();
    }

    /**
     * @return Number of current wins in the mini series.
     */
    public int getWins() {
    	if (wins == null) {
    		return -1;
    	}

        return wins.intValue();
    }
}
