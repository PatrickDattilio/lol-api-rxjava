package org.dc.riot.lol.rx.model.match;

/**
 * This object contains participant identity information.
 * <br>
 * <br>
 * The embedded {@link Player} object is essentially a {@link
 * org.dc.riot.lol.rx.model.summoner.SummonerDto SummonerDto}
 * object.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantIdentity {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Long participantId;
	private Player player;
	
	public ParticipantIdentity() {
		COUNT++;
	}

	/**
	 * @return Participant ID or <code>-1</code>
	 * if not defined.
	 */
	public long getParticipantId() {
		if (participantId == null) {
			return -1;
		}

		return participantId.longValue();
	}
	
	/**
	 * @return Player information.
	 */
	public Player getPlayer() {
		return player;
	}
}