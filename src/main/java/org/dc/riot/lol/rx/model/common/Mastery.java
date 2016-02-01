package org.dc.riot.lol.rx.model.currentgame;

/**
 * Current game participant mastery data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Mastery {
	private long masteryId;
	private int rank;

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
