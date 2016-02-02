package org.dc.riot.lol.rx.model.match;

/**
 * This object contains match list information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchListDto {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}

    private int endIndex;
    private MatchReference[] matches;
    private int startIndex;
    private int totalGames;
    
    public MatchListDto() {
    	COUNT++;
    }

    /**
     * @return The end index
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * @return The matches
     */
    public MatchReference[] getMatches() {
    	if (matches == null) {
    		return new MatchReference[0];
    	}

        return matches;
    }

    /**
     * @return The start index
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * @return Total games
     */
    public int getTotalGames() {
        return totalGames;
    }
}