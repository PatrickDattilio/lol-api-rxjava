package org.dc.riot.lol.rx.model.match;

public class ParticipantTimeline {
	private ParticipantTimelineData ancientGolemAssistsPerMinCounts; //	Ancient golem assists per minute timeline counts
	private ParticipantTimelineData ancientGolemKillsPerMinCounts; //	Ancient golem kills per minute timeline counts
	private ParticipantTimelineData assistedLaneDeathsPerMinDeltas; //	Assisted lane deaths per minute timeline data
	private ParticipantTimelineData assistedLaneKillsPerMinDeltas; //	Assisted lane kills per minute timeline data
	private ParticipantTimelineData baronAssistsPerMinCounts; //	Baron assists per minute timeline counts
	private ParticipantTimelineData baronKillsPerMinCounts; //	Baron kills per minute timeline counts
	private ParticipantTimelineData creepsPerMinDeltas; //	Creeps per minute timeline data
	private ParticipantTimelineData csDiffPerMinDeltas; //	Creep score difference per minute timeline data
	private ParticipantTimelineData damageTakenDiffPerMinDeltas; //	Damage taken difference per minute timeline data
	private ParticipantTimelineData damageTakenPerMinDeltas; //	Damage taken per minute timeline data
	private ParticipantTimelineData dragonAssistsPerMinCounts; //	Dragon assists per minute timeline counts
	private ParticipantTimelineData dragonKillsPerMinCounts; //	Dragon kills per minute timeline counts
	private ParticipantTimelineData elderLizardAssistsPerMinCounts; //	Elder lizard assists per minute timeline counts
	private ParticipantTimelineData elderLizardKillsPerMinCounts; //	Elder lizard kills per minute timeline counts
	private ParticipantTimelineData goldPerMinDeltas; //	Gold per minute timeline data
	private ParticipantTimelineData inhibitorAssistsPerMinCounts; //	Inhibitor assists per minute timeline counts
	private ParticipantTimelineData inhibitorKillsPerMinCounts; //	Inhibitor kills per minute timeline counts
	private Lane lane; //	Participant's lane (Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM)
	private Role role; //	Participant's role (Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT)
	private ParticipantTimelineData towerAssistsPerMinCounts; //	Tower assists per minute timeline counts
	private ParticipantTimelineData towerKillsPerMinCounts; //	Tower kills per minute timeline counts
	private ParticipantTimelineData towerKillsPerMinDeltas; //	Tower kills per minute timeline data
	private ParticipantTimelineData vilemawAssistsPerMinCounts; //	Vilemaw assists per minute timeline counts
	private ParticipantTimelineData vilemawKillsPerMinCounts; //	Vilemaw kills per minute timeline counts
	private ParticipantTimelineData wardsPerMinDeltas; //	Wards placed per minute timeline data
	private ParticipantTimelineData xpDiffPerMinDeltas; //	Experience difference per minute timeline data
	private ParticipantTimelineData xpPerMinDeltas; //	Experience per minute timeline data
}
