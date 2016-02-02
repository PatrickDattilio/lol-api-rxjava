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

	private int count;
	private long runeId; 
	
	public Rune() {
		COUNT++;
	}

	/**
	 * The count of this rune used by the participant.
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * One time setting for custom deserialize.
	 * 
	 * @param count The count.
	 */
	public void setCount(int count) {
		if (this.count == 0) {
			this.count = count;
		}
	}
	
	/**
	 * The ID of the rune.
	 */
	public long getRuneId() {
		return runeId;
	}

	/**
	 * One time setting for custom deserialize.
	 * 
	 * @param runeId The rune ID.
	 */
	public void setRuneId(long runeId) {
		if (this.runeId == 0) {
			this.runeId = runeId;
		}
	}
}
