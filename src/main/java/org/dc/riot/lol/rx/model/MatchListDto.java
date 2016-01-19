package org.dc.riot.lol.rx.model;

/**
 * Used by the MatchListDto API
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchListDto {
    private int endIndex;
    private MatchReference[] matches;
    private int startIndex;
    private int totalGames;

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public MatchReference[] getMatches() {
    	if (matches == null) {
    		return new MatchReference[0];
    	}

        return matches;
    }

    public void setMatches(MatchReference[] matches) {
        this.matches = matches;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }
}
