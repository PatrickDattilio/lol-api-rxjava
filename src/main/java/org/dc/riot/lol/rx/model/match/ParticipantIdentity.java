package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant identity information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantIdentity {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}

	private int participantId;
	private Player player;
	
	public ParticipantIdentity() {
		COUNT++;
	}

	/**
	 * @return Participant ID
	 */
	public int getParticipantId() {
		return participantId;
	}
	
	/**
	 * @return Player information
	 */
	public Player getPlayer() {
		return player;
	}
}