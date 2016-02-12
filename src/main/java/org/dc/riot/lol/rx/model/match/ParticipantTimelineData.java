package org.dc.riot.lol.rx.model.match;

/**
 * This object contains timeline data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantTimelineData {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Double tenToTwenty;
	private Double thirtyToEnd;
	private Double twentyToThirty;
	private Double zeroToTen;
	
	public ParticipantTimelineData() {
		COUNT++;
	}
	
	/**
	 * @return Value per minute from 10 min to 20 min.
	 */
	public double getTenToTwenty() {
		if (tenToTwenty == null) {
			return 0;
		}

		return tenToTwenty.doubleValue();
	}
	
	/**
	 * @return Value per minute from 30 min to the end of the game.
	 */
	public double getThirtyToEnd() {
		if (thirtyToEnd == null) {
			return 0;
		}

		return thirtyToEnd.doubleValue();
	}
	
	/**
	 * @return Value per minute from 20 min to 30 min.
	 */
	public double getTwentyToThirty() {
		if (twentyToThirty == null) {
			return 0;
		}

		return twentyToThirty.doubleValue();
	}
	
	/**
	 * @return Value per minute from the beginning of the game to 10 min.
	 */
	public double getZeroToTen() {
		if (zeroToTen == null) {
			return 0;
		}

		return zeroToTen.doubleValue();
	}
}
