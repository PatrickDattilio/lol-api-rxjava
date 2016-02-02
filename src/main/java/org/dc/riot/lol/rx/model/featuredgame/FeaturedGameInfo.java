package org.dc.riot.lol.rx.model.featuredgame;

import org.dc.riot.lol.rx.model.common.BannedChampion;
import org.dc.riot.lol.rx.model.common.GameMode;
import org.dc.riot.lol.rx.model.common.GameType;
import org.dc.riot.lol.rx.model.common.Observer;
import org.dc.riot.lol.rx.model.common.PlatformId;

/**
 * Featured game information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class FeaturedGameInfo {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private BannedChampion[] bannedChampions;
	private long gameId;
	private long gameLength;
	private GameMode gameMode;
	private long gameQueueConfigId;
	private long gameStartTime;
	private GameType gameType;
	private long mapId;
	private Observer observers;
	private FeaturedParticipant[] participants;
	private PlatformId platformId;
	
	public FeaturedGameInfo() {
		COUNT++;
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
	 * @return The ID of the game.
	 */
	public long getGameId() {
		return gameId;
	}

	/**
	 * @return The amount of time in seconds that has
	 * passed since the game started.
	 */
	public long getGameLength() {
		return gameLength;
	}
	
	/**
	 * @return The game mode
	 * (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL,
	 * ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO).
	 */
	public GameMode getGameMode() {
		return gameMode;
	}
	
	/**
	 * @return The queue type (queue types are
	 * documented on the Game Constants page).
	 */
	public long getGameQueueConfigId() {
		return gameQueueConfigId;
	}
	
	/**
	 * @return The game start time represented
	 * in epoch milliseconds.
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
	public FeaturedParticipant[] getParticipants() {
		if (participants == null) {
			return new FeaturedParticipant[0];
		}

		return participants;
	}
	
	/**
	 * @return 	The ID of the platform on which the game
	 * is being played.
	 */
	public PlatformId getPlatformId() {
		return platformId;
	}
}