package org.dc.riot.lol.rx.model.league;

/**
 * This object contains league participant
 * information representing a summoner or team.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class LeagueEntryDto {
    private int leaguePoints;
    private boolean isFreshBlood;
    private boolean isHotStreak;
    private String division;
    private boolean isInactive;
    private boolean isVeteran;
    private int losses;
    private String playerOrTeamName;
    private String playerOrTeamId;
    private int wins;
    private MiniSeriesDto miniSeries;

    /**
     * @return The league points of the participant.
     */
    public int getLeaguePoints() {
        return leaguePoints;
    }

    /**
     * @return Specifies if the participant is fresh blood
     * (i.e. new to the league).
     */
    public boolean isFreshBlood() {
        return isFreshBlood;
    }

    /**
     * @return Specifies if the participant is on a hot streak.
     */
    public boolean isHotStreak() {
        return isHotStreak;
    }

    /**
     * @return The league division of the participant.
     */
    public String getDivision() {
        return division;
    }

    /**
     * @return Specifies if the participant is inactive.
     */
    public boolean isInactive() {
        return isInactive;
    }

    /**
     * @return Specifies if the participant is a veteran.
     */
    public boolean isVeteran() {
        return isVeteran;
    }

    /**
     * @return The number of losses for the participant.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * @return The name of the the participant (i.e.,
     * summoner or team) represented by this entry.
     */
    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    /**
     * @return The ID of the participant
     * (i.e., summoner or team) represented by this entry.
     */
    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    /**
     * @return The number of wins for the participant.
     */
    public int getWins() {
        return wins;
    }

    /**
     * @return Mini series data for the participant.
     * Only present if the participant is currently in a mini series.
     */
    public MiniSeriesDto getMiniSeries() {
        return miniSeries;
    }
}
