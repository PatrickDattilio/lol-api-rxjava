package org.dc.riot.lol.rx.model;

/**
 * Older data structure returned by V1.0 of the current game API
 * Created by Dan on 9/2/15.
 */
public class CurrentGameInfo {
    private long gameId;
    private long gameLength;
    private GameMode gameMode;
    private long gameQueueConfigId;
    private long gameStartTime;
    private GameType gameType;
    private BannedChampion[] bannedChampions;
    private long mapId;
    private Observer observers;
    private CurrentGameParticipant[] participants;
    private PlatformId platformId;

    public boolean notInGame = false;

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getGameLength() {
        return gameLength;
    }

    public void setGameLength(long gameLength) {
        this.gameLength = gameLength;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public void setGameQueueConfigId(long gameQueueConfigId) {
        this.gameQueueConfigId = gameQueueConfigId;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(long gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public BannedChampion[] getBannedChampions() {
        return bannedChampions;
    }

    public void setBannedChampions(BannedChampion[] bannedChampions) {
        this.bannedChampions = bannedChampions;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public Observer getObservers() {
        return observers;
    }

    public void setObservers(Observer observers) {
        this.observers = observers;
    }

    public CurrentGameParticipant[] getParticipants() {
        return participants;
    }

    public void setParticipants(CurrentGameParticipant[] participants) {
        this.participants = participants;
    }

    public PlatformId getPlatformId() {

        return platformId;
    }

    public void setPlatformId(PlatformId platformId) {
        this.platformId = platformId;
    }

}
