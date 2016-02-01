package org.dc.riot.lol.rx.model.featuredgame;

import org.dc.riot.lol.rx.model.BannedChampion;
import org.dc.riot.lol.rx.model.GameMode;
import org.dc.riot.lol.rx.model.GameType;
import org.dc.riot.lol.rx.model.Observer;
import org.dc.riot.lol.rx.model.PlatformId;

/**
 * Featured game information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class FeaturedGameInfo {

	private BannedChampion[] bannedChampions;
	private long gameId;
	private long gameLength;
	private GameMode gameMode;
	private long gameQueueConfigId;
	private long gameStartTime;
	private GameType gameType;
	private long mapId;
	private Observer observers;
	private Participant[] participants;
	private PlatformId platformId;

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
	public Participant[] getParticipants() {
		if (participants == null) {
			return new Participant[0];
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