package org.dc.riot.lol.rx.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dc on 9/16/15.
 */
public class GameDto {
    private List<PlayerDto> fellowPlayers = new ArrayList<>();
    private GameType gameType;
    private RawStatsDto stats;
    private long gameId;
    private int ipEarned;
    private int spell1;
    private int teamId;
    private int spell2;
    private GameMode gameMode;
    private int mapId;
    private int level;
    private boolean invalid;
    private GameSubType subType;
    private long createDate;
    private int championId;

    /**
     * @return The fellowPlayers
     */
    public List<PlayerDto> getFellowPlayers() {
        return fellowPlayers;
    }

    /**
     * @param fellowPlayers The fellowPlayers
     */
    public void setFellowPlayers(List<PlayerDto> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    /**
     * @return The gameType
     */
    public GameType getGameType() {
        return gameType;
    }

    /**
     * @param gameType The gameType
     */
    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    /**
     * @return The stats
     */
    public RawStatsDto getStats() {
        return stats;
    }

    /**
     * @param stats The stats
     */
    public void setStats(RawStatsDto stats) {
        this.stats = stats;
    }

    /**
     * @return The gameId
     */
    public long getGameId() {
        return gameId;
    }

    /**
     * @param gameId The gameId
     */
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    /**
     * @return The ipEarned
     */
    public int getIpEarned() {
        return ipEarned;
    }

    /**
     * @param ipEarned The ipEarned
     */
    public void setIpEarned(int ipEarned) {
        this.ipEarned = ipEarned;
    }

    /**
     * @return The spell1
     */
    public int getSpell1() {
        return spell1;
    }

    /**
     * @param spell1 The spell1
     */
    public void setSpell1(int spell1) {
        this.spell1 = spell1;
    }

    /**
     * @return The teamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * @param teamId The teamId
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * @return The spell2
     */
    public int getSpell2() {
        return spell2;
    }

    /**
     * @param spell2 The spell2
     */
    public void setSpell2(int spell2) {
        this.spell2 = spell2;
    }

    /**
     * @return The gameMode
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * @param gameMode The gameMode
     */
    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * @return The mapId
     */
    public int getMapId() {
        return mapId;
    }

    /**
     * @param mapId The mapId
     */
    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    /**
     * @return The level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level The level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return The invalid
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     * @param invalid The invalid
     */
    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    /**
     * @return The subType
     */
    public GameSubType getSubType() {
        return subType;
    }

    /**
     * @param subType The subType
     */
    public void setSubType(GameSubType subType) {
        this.subType = subType;
    }

    /**
     * @return The createDate
     */
    public long getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate The createDate
     */
    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    /**
     * @return The championId
     */
    public int getChampionId() {
        return championId;
    }

    /**
     * @param championId The championId
     */
    public void setChampionId(int championId) {
        this.championId = championId;
    }
}
