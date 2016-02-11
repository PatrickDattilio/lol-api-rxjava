package org.dc.riot.lol.rx.model.currentgame;

import org.dc.riot.lol.rx.model.common.BannedChampion;
import org.dc.riot.lol.rx.model.common.GameMode;
import org.dc.riot.lol.rx.model.common.GameType;
import org.dc.riot.lol.rx.model.common.Observer;
import org.dc.riot.lol.rx.model.common.PlatformId;

/**
 * Current game data object.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class CurrentGameInfo {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long gameId;
    private Long gameLength;
    private GameMode gameMode;
    private Long gameQueueConfigId;
    private Long gameStartTime;
    private GameType gameType;
    private BannedChampion[] bannedChampions;
    private Long mapId;
    private Observer observers;
    private CurrentGameParticipant[] participants;
    private PlatformId platformId;

    public boolean notInGame = false;
    
    public CurrentGameInfo() {
    	COUNT++;
    }

    /**
     * @return ID of the game or
     * <code>-1</code> if not defined.
     */
    public long getGameId() {
    	if (gameId == null) {
    		return -1;
    	}

        return gameId.longValue();
    }

    /**
     * @return Amount of time in seconds that has passed
     * since the game started or
     * <code>-1</code> if not defined.
     */
    public long getGameLength() {
    	if (gameLength == null) {
    		return -1;
    	}

        return gameLength;
    }

    /**
     * @return Game mode.
     */
    public GameMode getGameMode() {
        return gameMode;
    }

    /**
     * @return Queue type
     * (queue types are documented on the Game Constants page).
     */
    public long getGameQueueConfigId() {
    	if (gameQueueConfigId == null) {
    		return -1;
    	}

        return gameQueueConfigId.longValue();
    }

    /**
     * @return Game start time represented in
     * epoch milliseconds or
     * <code>-1</code> if not defined.
     */
    public long getGameStartTime() {
    	if (gameStartTime == null) {
    		return -1;
    	}

        return gameStartTime.longValue();
    }

    /**
     * @return Game type.
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
     * @return ID of the map or
     * <code>-1</code> if not defined.
     */
    public long getMapId() {
    	if (mapId == null) {
    		return -1;
    	}

        return mapId.longValue();
    }

    /**
     * @return Observer information.
     */
    public Observer getObservers() {
        return observers;
    }

    /**
     * @return Participant information.
     */
    public CurrentGameParticipant[] getParticipants() {
    	if (participants == null) {
    		return new CurrentGameParticipant[0];
    	}

        return participants;
    }

    /**
     * @return ID of the platform on which
     * the game is being played.
     */
    public PlatformId getPlatformId() {
        return platformId;
    }
}
