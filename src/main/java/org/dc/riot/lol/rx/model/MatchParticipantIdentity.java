package org.dc.riot.lol.rx.model;

public class MatchParticipantIdentity {
	private int participantId;
	private MatchPlayer player;

	/**
	 * @return Participant ID
	 */
	public int getParticipantId() {
		return participantId;
	}
	
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	
	/**
	 * @return Player information
	 */
	public MatchPlayer getPlayer() {
		return player;
	}
	
	public void setPlayer(MatchPlayer player) {
		this.player = player;
	}
}
