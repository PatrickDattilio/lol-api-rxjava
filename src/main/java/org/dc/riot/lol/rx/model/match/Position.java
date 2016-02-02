package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant frame position information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Position {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}
	
	private int x;
	private int y;
	
	public Position() {
		COUNT++;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
