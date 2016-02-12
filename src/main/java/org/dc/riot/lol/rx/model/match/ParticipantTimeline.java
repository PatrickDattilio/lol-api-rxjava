package org.dc.riot.lol.rx.model.match;

/**
 * Delta fields refer to values for
 * the specified period (e.g. the gold per minute over
 * the first 10 minutes of the game versus the second 20
 * minutes of the game. Diffs fields refer to the deltas
 * versus the calculated lane opponent(s).
 *
 * @author Dc
 * @since 1.0.0
 */
public class ParticipantTimeline {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private ParticipantTimelineData ancientGolemAssistsPerMinCounts;
	private ParticipantTimelineData ancientGolemKillsPerMinCounts;
	private ParticipantTimelineData assistedLaneDeathsPerMinDeltas;
	private ParticipantTimelineData assistedLaneKillsPerMinDeltas;
	private ParticipantTimelineData baronAssistsPerMinCounts;
	private ParticipantTimelineData baronKillsPerMinCounts;
	private ParticipantTimelineData creepsPerMinDeltas;
	private ParticipantTimelineData csDiffPerMinDeltas;
	private ParticipantTimelineData damageTakenDiffPerMinDeltas;
	private ParticipantTimelineData damageTakenPerMinDeltas;
	private ParticipantTimelineData dragonAssistsPerMinCounts;
	private ParticipantTimelineData dragonKillsPerMinCounts;
	private ParticipantTimelineData elderLizardAssistsPerMinCounts;
	private ParticipantTimelineData elderLizardKillsPerMinCounts;
	private ParticipantTimelineData goldPerMinDeltas;
	private ParticipantTimelineData inhibitorAssistsPerMinCounts;
	private ParticipantTimelineData inhibitorKillsPerMinCounts;
	private Lane lane;
	private Role role;
	private ParticipantTimelineData towerAssistsPerMinCounts;
	private ParticipantTimelineData towerKillsPerMinCounts;
	private ParticipantTimelineData towerKillsPerMinDeltas;
	private ParticipantTimelineData vilemawAssistsPerMinCounts;
	private ParticipantTimelineData vilemawKillsPerMinCounts;
	private ParticipantTimelineData wardsPerMinDeltas;
	private ParticipantTimelineData xpDiffPerMinDeltas;
	private ParticipantTimelineData xpPerMinDeltas;
	
	public ParticipantTimeline() {
		COUNT++;
	}

	/**
	 * @return Ancient golem assists per minute timeline counts.
	 */
	public ParticipantTimelineData getAncientGolemAssistsPerMinCounts() {
		return ancientGolemAssistsPerMinCounts;
	}

	/**
	 * @return Ancient golem kills per minute timeline counts.
	 */
	public ParticipantTimelineData getAncientGolemKillsPerMinCounts() {
		return ancientGolemKillsPerMinCounts;
	}

	/**
	 * @return Assisted lane deaths per minute timeline data.
	 */
	public ParticipantTimelineData getAssistedLaneDeathsPerMinDeltas() {
		return assistedLaneDeathsPerMinDeltas;
	}

	/**
	 * @return Assisted lane kills per minute timeline data.
	 */
	public ParticipantTimelineData getAssistedLaneKillsPerMinDeltas() {
		return assistedLaneKillsPerMinDeltas;
	}

	/**
	 * @return Baron assists per minute timeline counts.
	 */
	public ParticipantTimelineData getBaronAssistsPerMinCounts() {
		return baronAssistsPerMinCounts;
	}

	/**
	 * @return Baron kills per minute timeline counts.
	 */
	public ParticipantTimelineData getBaronKillsPerMinCounts() {
		return baronKillsPerMinCounts;
	}

	/**
	 * @return Creeps per minute timeline data.
	 */
	public ParticipantTimelineData getCreepsPerMinDeltas() {
		return creepsPerMinDeltas;
	}

	/**
	 * @return Creep score difference per minute timeline data.
	 */
	public ParticipantTimelineData getCsDiffPerMinDeltas() {
		return csDiffPerMinDeltas;
	}

	/**
	 * @return Damage taken difference per minute timeline data.
	 */
	public ParticipantTimelineData getDamageTakenDiffPerMinDeltas() {
		return damageTakenDiffPerMinDeltas;
	}

	/**
	 * @return Damage taken per minute timeline data.
	 */
	public ParticipantTimelineData getDamageTakenPerMinDeltas() {
		return damageTakenPerMinDeltas;
	}

	/**
	 * @return Dragon assists per minute timeline counts.
	 */
	public ParticipantTimelineData getDragonAssistsPerMinCounts() {
		return dragonAssistsPerMinCounts;
	}

	/**
	 * @return Dragon kills per minute timeline counts.
	 */
	public ParticipantTimelineData getDragonKillsPerMinCounts() {
		return dragonKillsPerMinCounts;
	}

	/**
	 * @return Elder lizard assists per minute timeline counts.
	 */
	public ParticipantTimelineData getElderLizardAssistsPerMinCounts() {
		return elderLizardAssistsPerMinCounts;
	}

	/**
	 * @return Elder lizard kills per minute timeline counts.
	 */
	public ParticipantTimelineData getElderLizardKillsPerMinCounts() {
		return elderLizardKillsPerMinCounts;
	}

	/**
	 * @return Gold per minute timeline data.
	 */
	public ParticipantTimelineData getGoldPerMinDeltas() {
		return goldPerMinDeltas;
	}

	/**
	 * @return Inhibitor assists per minute timeline counts.
	 */
	public ParticipantTimelineData getInhibitorAssistsPerMinCounts() {
		return inhibitorAssistsPerMinCounts;
	}

	/**
	 * @return Inhibitor kills per minute timeline counts.
	 */
	public ParticipantTimelineData getInhibitorKillsPerMinCounts() {
		return inhibitorKillsPerMinCounts;
	}

	/**
	 * @return Participant's lane (Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM).
	 */
	public Lane getLane() {
		return lane;
	}

	/**
	 * @return Participant's role (Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT).
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @return Tower assists per minute timeline counts.
	 */
	public ParticipantTimelineData getTowerAssistsPerMinCounts() {
		return towerAssistsPerMinCounts;
	}

	/**
	 * @return Tower kills per minute timeline counts.
	 */
	public ParticipantTimelineData getTowerKillsPerMinCounts() {
		return towerKillsPerMinCounts;
	}

	/**
	 * @return Tower kills per minute timeline data.
	 */
	public ParticipantTimelineData getTowerKillsPerMinDeltas() {
		return towerKillsPerMinDeltas;
	}

	/**
	 * @return Vilemaw assists per minute timeline counts.
	 */
	public ParticipantTimelineData getVilemawAssistsPerMinCounts() {
		return vilemawAssistsPerMinCounts;
	}

	/**
	 * @return Vilemaw kills per minute timeline counts.
	 */
	public ParticipantTimelineData getVilemawKillsPerMinCounts() {
		return vilemawKillsPerMinCounts;
	}

	/**
	 * @return Wards placed per minute timeline data.
	 */
	public ParticipantTimelineData getWardsPerMinDeltas() {
		return wardsPerMinDeltas;
	}

	/**
	 * @return Experience difference per minute timeline data.
	 */
	public ParticipantTimelineData getXpDiffPerMinDeltas() {
		return xpDiffPerMinDeltas;
	}

	/**
	 * @return Experience per minute timeline data.
	 */
	public ParticipantTimelineData getXpPerMinDeltas() {
		return xpPerMinDeltas;
	}
}
