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
	 * @return The number of points put into this mastery by the user.
	 */
	public int getRank() {
		return rank;
	} 
}
