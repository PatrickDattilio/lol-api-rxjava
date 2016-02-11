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

	private Long masteryId;
	private Integer rank;
	
	public Mastery() {
		COUNT++;
	}

	/**
	 * @return The ID of the mastery.
	 */
	public long getMasteryId() {
		if (masteryId == null) {
			return -1;
		}

		return masteryId.longValue();
	}
	
	/**
	 * Allows one time setting of rank. This is
	 * to handle inconsistencies in the JSON
	 * schema.
	 * 
	 * @param id ID of the mastery
	 */
	public void setMasteryId(long id) {
		if (this.masteryId == null) {
			this.masteryId = new Long(id);
		}
	}
	
	/**
	 * @return The number of points put into this mastery by the user.
	 */
	public int getRank() {
		if (rank == null) {
			return -1;
		}

		return rank.intValue();
	}

	/**
	 * Allows one time setting of rank. This is
	 * to handle inconsistencies in the JSON
	 * schema.
	 * 
	 * @param rank value (probably 1 or 5).
	 */
	public void setRank(int rank) {
		if (this.rank == null) {
			this.rank = new Integer(rank);
		}
	}
}