package org.dc.riot.lol.rx.model;

/**
 * Used by the Team API
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

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getOpposingTeamName() {
        return opposingTeamName;
    }

    public void setOpposingTeamName(String opposingTeamName) {
        this.opposingTeamName = opposingTeamName;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getOpposingTeamKills() {
        return opposingTeamKills;
    }

    public void setOpposingTeamKills(int opposingTeamKills) {
        this.opposingTeamKills = opposingTeamKills;
    }
}
