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
	 * Allows one time setting. This is to
	 * handle inconsistencies in the JSON
	 * schema.
	 * 
	 * @param count number of runes used
	 */
	public void setCount(int count) {
		if (this.count == null) {
			this.count = new Integer(count);
		}
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
	
	/**
	 * Allows one time setting. This is to
	 * handle inconsistencies in the JSON
	 * schema.
	 * 
	 * @param runeId ID of the rune
	 */
	public void setRuneId(long runeId) {
		if (this.runeId == null) {
			this.runeId = new Long(runeId);
		}
	}
}
