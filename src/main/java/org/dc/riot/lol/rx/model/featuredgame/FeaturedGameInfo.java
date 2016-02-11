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
	private Long gameId;
	private Long gameLength;
	private GameMode gameMode;
	private Long gameQueueConfigId;
	private Long gameStartTime;
	private GameType gameType;
	private Long mapId;
	private Observer observers;
	private FeaturedGameParticipant[] participants;
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
	 * @return Amount of time in seconds that has
	 * passed since the game started or <code>-1</code>
	 * if not defined.
	 */
	public long getGameLength() {
		if (gameLength == null) {
			return -1;
		}

		return gameLength.longValue();
	}
	
	/**
	 * @return Game mode
	 * (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL,
	 * ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO).
	 */
	public GameMode getGameMode() {
		return gameMode;
	}
	
	/**
	 * @return Queue type (queue types are
	 * documented on the Game Constants page)
	 * or <code>-1</code> if not defined.
	 */
	public long getGameQueueConfigId() {
		if (gameQueueConfigId == null) {
			return -1;
		}

		return gameQueueConfigId.longValue();
	}
	
	/**
	 * @return Game start time represented
	 * in epoch milliseconds or <code>-1</code>
	 * if not defined.
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
	 * @return Participant information or empty
	 * if not defined.
	 */
	public FeaturedGameParticipant[] getParticipants() {
		if (participants == null) {
			return new FeaturedGameParticipant[0];
		}

		return participants;
	}
	
	/**
	 * @return 	ID of the platform on which the game
	 * is being played.
	 */
	public PlatformId getPlatformId() {
		return platformId;
	}
}