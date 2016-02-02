package org.dc.riot.lol.rx.model.match;

/**
 * This object contains timeline data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantTimelineData {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}

	private double tenToTwenty;
	private double thirtyToEnd;
	private double twentyToThirty;
	private double zeroToTen;
	
	public ParticipantTimelineData() {
		COUNT++;
	}
	
	/**
	 * @return Value per minute from 10 min to 20 min.
	 */
	public double getTenToTwenty() {
		return tenToTwenty;
	}
	
	/**
	 * @return Value per minute from 30 min to the end of the game.
	 */
	public double getThirtyToEnd() {
		return thirtyToEnd;
	}
	
	/**
	 * @return Value per minute from 20 min to 30 min.
	 */
	public double getTwentyToThirty() {
		return twentyToThirty;
	}
	
	/**
	 * @return Value per minute from the beginning of the game to 10 min.
	 */
	public double getZeroToTen() {
		return zeroToTen;
	}
}
