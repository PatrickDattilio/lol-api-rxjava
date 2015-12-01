package org.dc.riot.lol.rx.model;

/**
 * Created by Dc on 9/14/15.
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
     * @return The leaguePoints
     */
    public int getLeaguePoints() {
        return leaguePoints;
    }

    /**
     * @param leaguePoints The leaguePoints
     */
    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    /**
     * @return The isFreshBlood
     */
    public boolean isIsFreshBlood() {
        return isFreshBlood;
    }

    /**
     * @param isFreshBlood The isFreshBlood
     */
    public void setIsFreshBlood(boolean isFreshBlood) {
        this.isFreshBlood = isFreshBlood;
    }

    /**
     * @return The isHotStreak
     */
    public boolean isIsHotStreak() {
        return isHotStreak;
    }

    /**
     * @param isHotStreak The isHotStreak
     */
    public void setIsHotStreak(boolean isHotStreak) {
        this.isHotStreak = isHotStreak;
    }

    /**
     * @return The division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division The division
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @return The isInactive
     */
    public boolean isIsInactive() {
        return isInactive;
    }

    /**
     * @param isInactive The isInactive
     */
    public void setIsInactive(boolean isInactive) {
        this.isInactive = isInactive;
    }

    /**
     * @return The isVeteran
     */
    public boolean isIsVeteran() {
        return isVeteran;
    }

    /**
     * @param isVeteran The isVeteran
     */
    public void setIsVeteran(boolean isVeteran) {
        this.isVeteran = isVeteran;
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
     * @return The playerOrTeamName
     */
    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    /**
     * @param playerOrTeamName The playerOrTeamName
     */
    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    /**
     * @return The playerOrTeamId
     */
    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    /**
     * @param playerOrTeamId The playerOrTeamId
     */
    public void setPlayerOrTeamId(String playerOrTeamId) {
        this.playerOrTeamId = playerOrTeamId;
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

    /**
     * @return The miniSeries
     */
    public MiniSeriesDto getMiniSeries() {
        return miniSeries;
    }

    /**
     * @param miniSeries The miniSeries
     */
    public void setMiniSeries(MiniSeriesDto miniSeries) {
        this.miniSeries = miniSeries;
    }
}
