package org.dc.riot.lol.rx.model.common;

/**
 * Current game participant rune data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Rune {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Integer count;
	private Long runeId; 
	
	public Rune() {
		COUNT++;
	}

	/**
	 * The count of this rune used by the participant.
	 */
	public int getCount() {
		if (count == null) {
			return 0;
		}

		return count.intValue();
	}
	
	/**
	 * The ID of the rune.
	 */
	public long getRuneId() {
		if (runeId == null) {
			return -1;
		}

		return runeId.longValue();
	}
}
