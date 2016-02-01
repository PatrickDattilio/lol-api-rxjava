package org.dc.riot.lol.rx.model.team;

/**
 * This object contains team statistics detail information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class TeamStatDetailDto {
    private int wins;
    private int losses;
    private int averageGamesPlayed;
    private String teamStatType;

    /**
     * @return This team's wins.
     */
    public int getWins() {
        return wins;
    }

    /**
     * @return This team's losses.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * @return This team's average games played.
     */
    public int getAverageGamesPlayed() {
        return averageGamesPlayed;
    }

    /**
     * @return Stat type. Possibly make this an
     * enum.
     */
    public String getTeamStatType() {
        return teamStatType;
    }
}