package org.dc.riot.lol.rx.model.common;

/**
 * Current game participant mastery data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Mastery {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private long masteryId;
	private int rank;
	
	public Mastery() {
		COUNT++;
	}

	/**
	 * @return The ID of the mastery.
	 */
	public long getMasteryId() {
		return masteryId;
	}
	
	/**
	 * One time setting for custom deserialize.
	 * 
	 * @param masteryId The mastery ID.
	 */
	public void setMasteryId(long masteryId) {
		if (this.masteryId == 0) {
			this.masteryId = masteryId;
		}
	}

	/**
	 * @return The number of points put into this mastery by the user.
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * One time setting for custom deserialize.
	 * 
	 * @param rank The rank.
	 */
	public void setRank(int rank) {
		if (this.rank == 0) {
			this.rank = rank;
		}
	} 
}
