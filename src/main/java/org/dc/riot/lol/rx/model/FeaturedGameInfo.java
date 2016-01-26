package org.dc.riot.lol.rx.model;

/**
 * Featured game information
 * 
 * @author Dc
 * @since 1.0.0
 */
public class FeaturedGameInfo {

	private BannedChampion[] bannedChampions;	// Banned champion information
	private long gameId;	// long	The ID of the game
	private long gameLength;	// The amount of time in seconds that has passed since the game started
	private GameMode gameMode;	// The game mode (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO)
	private long gameQueueConfigId;	// The queue type (queue types are documented on the Game Constants page)
	private long gameStartTime;	// The game start time represented in epoch milliseconds
	private GameType gameType;	// The game type (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME)
	private long mapId;	// The ID of the map
	private Observer observers;	// The observer information
	private FeaturedGameParticipant[] participants;	// The participant information
	private PlatformId platformId;	// The ID of the platform on which the game is being played

	public BannedChampion[] getBannedChampions() {
		if (bannedChampions == null) {
			return new BannedChampion[0];
		}

		return bannedChampions;
	}

	public void setBannedChampions(BannedChampion[] bannedChampions) {
		this.bannedChampions = bannedChampions;
	}

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
	
	public FeaturedGameParticipant[] getParticipants() {
		if (participants == null) {
			return new FeaturedGameParticipant[0];
		}

		return participants;
	}
	
	public void setParticipants(FeaturedGameParticipant[] participants) {
		this.participants = participants;
	}
	
	public PlatformId getPlatformId() {
		return platformId;
	}
	
	public void setPlatformId(PlatformId platformId) {
		this.platformId = platformId;
	}
}
