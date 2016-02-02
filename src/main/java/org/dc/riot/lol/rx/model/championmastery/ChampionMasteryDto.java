package org.dc.riot.lol.rx.model.championmastery;

/**
 * Contains single champion mastery information for a player
 * and champion combination.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionMasteryDto {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}

	private long championId;
	private int championLevel;
	private int championPoints;
	private long championPointsSinceLastLevel;
	private long championPointsUntilNextLevel;
	private boolean chestGranted;
	private String highestGrade;
	private long lastPlayTime;
	private long playerId;

	public ChampionMasteryDto() {
		COUNT++;
	}

	/**
	 * @return champion ID
	 */
	public long getChampionId() {
		return championId;
	}

	/**
	 * @return champion level for specified player and champion combination
	 */
	public int getChampionLevel() {
		return championLevel;
	}

	/**
	 * @return total number of champion points for this player and champion combination -
	 * they are used to determine championLevel
	 */
	public int getChampionPoints() {
		return championPoints;
	}

	/**
	 * @return number of points earned since current level was been achieved. Zero if
	 * player reached maximum champion for this champion.
	 */
	public long getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}

	/**
	 * @return number of points needed to achieve next level. Zero if player 
	 * has reached maximum level for this champion.
	 */
	public long getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}

	/**
	 * @return if chest has been granted for this champion in the current season
	 */
	public boolean isChestGranted() {
		return chestGranted;
	}

	/**
	 * @return Highest grade received on this champion this season (e.g. S+, A-, etc.).
	 * May return <code>null</code> if no grades have been received (e.g. start of new season).
	 */
	public String getHighestGrade() {
		return highestGrade;
	}

	/**
	 * @return last time this champion was played by this player - in Unix milliseconds time format
	 */
	public long getLastPlayTime() {
		return lastPlayTime;
	}

	/**
	 * @return summoner ID
	 */
	public long getPlayerId() {
		return playerId;
	}
}
