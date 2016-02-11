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
	public static long getInstanceCount() {
		return COUNT;
	}

	private Long championId;
	private Integer championLevel;
	private Integer championPoints;
	private Long championPointsSinceLastLevel;
	private Long championPointsUntilNextLevel;
	private Boolean chestGranted;
	private String highestGrade;
	private Long lastPlayTime;
	private Long playerId;

	public ChampionMasteryDto() {
		COUNT++;
	}

	/**
	 * @return champion ID
	 */
	public long getChampionId() {
		if (championId == null) {
			return -1;
		}

		return championId.longValue();
	}

	/**
	 * @return champion level for specified player and champion combination
	 */
	public int getChampionLevel() {
		if (championLevel == null) {
			return -1;
		}

		return championLevel.intValue();
	}

	/**
	 * @return total number of champion points for this player and champion combination -
	 * they are used to determine championLevel
	 */
	public int getChampionPoints() {
		if (championPoints == null) {
			return -1;
		}

		return championPoints.intValue();
	}

	/**
	 * @return number of points earned since current level was been achieved. Zero if
	 * player reached maximum champion for this champion.
	 */
	public long getChampionPointsSinceLastLevel() {
		if (championPointsSinceLastLevel == null) {
			return -1;
		}

		return championPointsSinceLastLevel.longValue();
	}

	/**
	 * @return Number of points needed to achieve next level. Zero if player 
	 * has reached maximum level for this champion.
	 */
	public long getChampionPointsUntilNextLevel() {
		if (championPointsUntilNextLevel == null) {
			return -1;
		}

		return championPointsUntilNextLevel.longValue();
	}

	/**
	 * @return If chest has been granted for this champion in the current season
	 */
	public boolean isChestGranted() {
		if (chestGranted == null) {
			return false;
		}

		return chestGranted.booleanValue();
	}

	/**
	 * @return Highest grade received on this champion this season (e.g. S+, A-, etc.).
	 * May return <code>null</code> if no grades have been received (e.g. start of new season).
	 */
	public String getHighestGrade() {
		return highestGrade;
	}

	/**
	 * In Unix milliseconds time format.
	 * 
	 * @return Last time this champion was played by this player
	 * or <code>-1</code> if not defined.
	 */
	public long getLastPlayTime() {
		if (lastPlayTime == null) {
			return -1;
		}

		return lastPlayTime.longValue();
	}

	/**
	 * @return Summoner ID or <code>-1</code> if not
	 * defined.
	 */
	public long getPlayerId() {
		if (playerId == null) {
			return -1;
		}

		return playerId.longValue();
	}
}
