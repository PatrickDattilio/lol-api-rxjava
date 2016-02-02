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
	 * The ID of the rune.
	 */
	public long getRuneId() {
		return runeId;
	}
}
