package org.dc.riot.lol.rx.model.league;

/**
 * This object contains league participant
 * information representing a summoner or team.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class LeagueEntryDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Integer leaguePoints;
    private Boolean isFreshBlood;
    private Boolean isHotStreak;
    private String division;
    private Boolean isInactive;
    private Boolean isVeteran;
    private Integer losses;
    private String playerOrTeamName;
    private String playerOrTeamId;
    private Integer wins;
    private MiniSeriesDto miniSeries;
    
    public LeagueEntryDto() {
    	COUNT++;
    }

    /**
     * @return League points of the participant.
     */
    public int getLeaguePoints() {
    	if (leaguePoints == null) {
    		return -1;
    	}

        return leaguePoints.intValue();
    }

    /**
     * @return Specifies if the participant is fresh blood
     * (i.e. new to the league).
     */
    public boolean isFreshBlood() {
    	if (isFreshBlood == null) {
    		return false;
    	}

        return isFreshBlood.booleanValue();
    }

    /**
     * @return Specifies if the participant is on a hot streak.
     */
    public boolean isHotStreak() {
    	if (isHotStreak == null) {
    		return false;
    	}

        return isHotStreak.booleanValue();
    }

    /**
     * @return League division of the participant.
     */
    public String getDivision() {
        return division;
    }

    /**
     * @return Specifies if the participant is inactive.
     */
    public boolean isInactive() {
    	if (isInactive == null) {
    		return false;
    	}

        return isInactive.booleanValue();
    }

    /**
     * @return Specifies if the participant is a veteran.
     */
    public boolean isVeteran() {
    	if (isVeteran == null) {
    		return false;
    	}

        return isVeteran.booleanValue();
    }

    /**
     * @return Number of losses for the participant.
     */
    public int getLosses() {
    	if (losses == null) {
    		return -1;
    	}

        return losses.intValue();
    }

    /**
     * @return Name of the the participant (i.e.,
     * summoner or team) represented by this entry.
     */
    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    /**
     * @return ID of the participant
     * (i.e., summoner or team) represented by this entry.
     */
    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    /**
     * @return Number of wins for the participant.
     */
    public int getWins() {
    	if (wins == null) {
    		return -1;
    	}

        return wins.intValue();
    }

    /**
     * @return Mini series data for the participant.
     * Only present if the participant is currently in a mini series.
     */
    public MiniSeriesDto getMiniSeries() {
        return miniSeries;
    }
}
