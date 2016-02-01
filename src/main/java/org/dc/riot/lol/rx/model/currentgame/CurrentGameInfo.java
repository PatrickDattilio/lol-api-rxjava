package org.dc.riot.lol.rx.model.currentgame;

import org.dc.riot.lol.rx.model.BannedChampion;
import org.dc.riot.lol.rx.model.GameMode;
import org.dc.riot.lol.rx.model.GameType;
import org.dc.riot.lol.rx.model.Observer;
import org.dc.riot.lol.rx.model.PlatformId;

/**
 * Current game data object.
 * 
 * @author Dc
 * @since 1.0.0
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

    /**
     * @return The ID of the game.
     */
    public long getGameId() {
        return gameId;
    }

    /**
     * @return The amount of time in seconds that has passed
     * since the game started.
     */
    public long getGameLength() {
        return gameLength;
    }

    /**
     * @return The game mode.
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * @return The queue type
     * (queue types are documented on the Game Constants page).
     */
    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    /**
     * @return The game start time represented in
     * epoch milliseconds.
     */
    public long getGameStartTime() {
        return gameStartTime;
    }

    /**
     * @return The game type.
     */
    public GameType getGameType() {
        return gameType;
    }

    /**
     * @return Banned champion information.
     */
    public BannedChampion[] getBannedChampions() {
    	if (bannedChampions == null) {
    		return new BannedChampion[0];
    	}

        return bannedChampions;
    }

    /**
     * @return The ID of the map.
     */
    public long getMapId() {
        return mapId;
    }

    /**
     * @return The observer information.
     */
    public Observer getObservers() {
        return observers;
    }

    /**
     * @return The participant information.
     */
    public CurrentGameParticipant[] getParticipants() {
        return participants;
    }

    /**
     * @return The ID of the platform on which
     * the game is being played.
     */
    public PlatformId getPlatformId() {
        return platformId;
    }
}
