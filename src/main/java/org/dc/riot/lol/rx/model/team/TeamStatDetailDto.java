package org.dc.riot.lol.rx.model.team;

/**
 * This object contains team statistics detail information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class TeamStatDetailDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Integer wins;
    private Integer losses;
    private Integer averageGamesPlayed;
    private String teamStatType;

    public TeamStatDetailDto() {
    	COUNT++;
    }

    /**
     * @return This team's wins
     * or <code>-1</code> if not defined.
     */
    public int getWins() {
    	if (wins == null) {
    		return -1;
    	}

        return wins.intValue();
    }

    /**
     * @return This team's losses.
     * or <code>-1</code> if not defined
     */
    public int getLosses() {
    	if (losses == null) {
    		return -1;
    	}

        return losses.intValue();
    }

    /**
     * @return This team's average games played.
     * or <code>-1</code> if not defined
     */
    public int getAverageGamesPlayed() {
    	if (averageGamesPlayed == null) {
    		return -1;
    	}

        return averageGamesPlayed.intValue();
    }

    /**
     * @return Stat type. Possibly make this an
     * enum.
     */
    public String getTeamStatType() {
        return teamStatType;
    }
}