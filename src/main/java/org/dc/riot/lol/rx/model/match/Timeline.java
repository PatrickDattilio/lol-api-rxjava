package org.dc.riot.lol.rx.model.match;

/**
 * This object contains game timeline information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Timeline {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}
	
	private long frameInterval;	
	private Frame[] frames;	
	
	public Timeline() {
		COUNT++;
	}

	/**
	 * @return Time between each returned frame in milliseconds.
	 */
	public long getFrameInterval() {

		return frameInterval;
	}

	/**
	 * @return List of timeline frames for the game.
	 */
	public Frame[] getFrames() {
		return frames;
	}
}
