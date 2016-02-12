package org.dc.riot.lol.rx.model.match;

/**
 * This object contains game timeline information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Timeline {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}
	
	private Long frameInterval;	
	private Frame[] frames;	
	
	public Timeline() {
		COUNT++;
	}

	/**
	 * @return Time between each returned frame in
	 * milliseconds or <code>0</code> if not
	 * defined.
	 */
	public long getFrameInterval() {
		if (frameInterval == null) {
			return 0;
		}

		return frameInterval.longValue();
	}

	/**
	 * @return List of timeline frames for the game or
	 * empty if not defined.
	 */
	public Frame[] getFrames() {
		if (frames == null) {
			return new Frame[0];
		}

		return frames;
	}
}
