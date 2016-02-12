package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant frame position information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Position {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}
	
	private Integer x;
	private Integer y;
	
	public Position() {
		COUNT++;
	}
	
	public int getX() {
		if (x == null) {
			return 0;
		}

		return x;
	}
	
	public int getY() {
		if (y == null) {
			return 0;
		}

		return y;
	}
}
