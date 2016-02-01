package org.dc.riot.lol.rx.model.match;

public class ParticipantIdentity {
	private int participantId;
	private Player player;

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