package org.dc.riot.lol.rx.model;

/**
 * Contains single champion mastery information for a player
 * and champion combination.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionMasteryDto {
	private long championId;
	private int championLevel;
	private int championPoints;
	private long championPointsSinceLastLevel;
	private long championPointsUntilNextLevel;
	private boolean chestGranted;
	private String highestGrade;
	private long lastPlayTime;
	private long playerId;

	/**
	 * @return champion ID
	 */
	public long getChampionId() {
		return championId;
	}

	public void setChampionId(long championId) {
		this.championId = championId;
	}

	/**
	 * @return champion level for specified player and champion combination
	 */
	public int getChampionLevel() {
		return championLevel;
	}

	public void setChampionLevel(int championLevel) {
		this.championLevel = championLevel;
	}

	/**
	 * @return total number of champion points for this player and champion combination -
	 * they are used to determine championLevel
	 */
	public int getChampionPoints() {
		return championPoints;
	}

	public void setChampionPoints(int championPoints) {
		this.championPoints = championPoints;
	}

	/**
	 * @return number of points earned since current level was been achieved. Zero if
	 * player reached maximum champion for this champion.
	 */
	public long getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}

	public void setChampionPointsSinceLastLevel(long championPointsSinceLastLevel) {
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
	}

	/**
	 * @return number of points needed to achieve next level. Zero if player 
	 * has reached maximum level for this champion.
	 */
	public long getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}

	public void setChampionPointsUntilNextLevel(long championPointsUntilNextLevel) {
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
	}

	/**
	 * @return if chest has been granted for this champion in the current season
	 */
	public boolean isChestGranted() {
		return chestGranted;
	}

	public void setChestGranted(boolean chestGranted) {
		this.chestGranted = chestGranted;
	}

	/**
	 * @return Highest grade received on this champion this season (e.g. S+, A-, etc.).
	 * May return <code>null</code> if no grades have been received (e.g. start of new season).
	 */
	public String getHighestGrade() {
		return highestGrade;
	}

	public void setHighestGrade(String highestGrade) {
		this.highestGrade = highestGrade;
	}

	/**
	 * @return last time this champion was played by this player - in Unix milliseconds time format
	 */
	public long getLastPlayTime() {
		return lastPlayTime;
	}

	public void setLastPlayTime(long lastPlayTime) {
		this.lastPlayTime = lastPlayTime;
	}

	/**
	 * @return summoner ID
	 */
	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
}
