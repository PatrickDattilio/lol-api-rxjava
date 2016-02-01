package org.dc.riot.lol.rx.model.team;

import org.dc.riot.lol.rx.model.common.GameMode;

/**
 * This object contains match history summary information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchHistorySummaryDto {
    private GameMode gameMode;
    private int mapId;
    private int assists;
    private String opposingTeamName;
    private boolean invalid;
    private int deaths;
    private long gameId;
    private int kills;
    private boolean win;
    private long date;
    private int opposingTeamKills;

    /**
     * @return Game mode.
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * @return Map ID.
     */
    public int getMapId() {
        return mapId;
    }

    /**
     * @return This team's assists.
     */
    public int getAssists() {
        return assists;
    }

    /**
     * @return Opposing team's name.
     */
    public String getOpposingTeamName() {
        return opposingTeamName;
    }

    /**
     * @return Something is invalid.
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     * @return This team's deaths.
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * @return Game ID.
     */
    public long getGameId() {
        return gameId;
    }

    /**
     * @return This team's kills.
     */
    public int getKills() {
        return kills;
    }

    /**
     * @return Flag if this team won.
     */
    public boolean isWin() {
        return win;
    }

    /**
     * @return 	Date that match was completed
     * specified as epoch milliseconds.
     */
    public long getDate() {
        return date;
    }

    /**
     * @return Opposing team's kills.
     */
    public int getOpposingTeamKills() {
        return opposingTeamKills;
    }
}