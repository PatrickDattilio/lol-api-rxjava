package org.dc.riot.lol.rx.model.currentgame;

/**
 * Current game participant rune data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Rune {
	private int count;
	private long runeId; 

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
