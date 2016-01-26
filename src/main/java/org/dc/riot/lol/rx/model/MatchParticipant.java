package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class MatchParticipant {
	private int championId;
	private Tier highestAchievedSeasonTier;
	private MasteryMetaDto masteries;
	private int participantId;
	private RuneMetaDto[] runes;
	private long spell1Id;
	private long spell2Id;
	private MatchParticipantStats stats;
	private int teamId;
	private MatchParticipantTimeline timeline;

	/**
	 * @return Champion ID.
	 */
	public int getChampionId() {
		return championId;
	}

	public void setChampionId(int championId) {
		this.championId = championId;
	}

	/**
	 * @return Highest ranked tier achieved for the previous season,
	 * if any, otherwise null. Used to display border in game
	 * loading screen.
	 */
	public Tier getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	public void setHighestAchievedSeasonTier(Tier highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}

	/**
	 * @return List of mastery information.
	 */
	public MasteryMetaDto getMasteries() {
		return masteries;
	}

	public void setMasteries(MasteryMetaDto masteries) {
		this.masteries = masteries;
	}

	/**
	 * @return Participant ID.
	 */
	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	/**
	 * @return List of rune information.
	 */
	public RuneMetaDto[] getRunes() {
		return runes;
	}

	public void setRunes(RuneMetaDto[] runes) {
		this.runes = runes;
	}

	/**
	 * @return First summoner spell ID.
	 */
	public long getSpell1Id() {
		return spell1Id;
	}

	public void setSpell1Id(long spell1Id) {
		this.spell1Id = spell1Id;
	}

	/**
	 * @return Second summoner spell ID.
	 */
	public long getSpell2Id() {
		return spell2Id;
	}

	public void setSpell2Id(long spell2Id) {
		this.spell2Id = spell2Id;
	}

	/**
	 * @return Participant statistics.
	 */
	public MatchParticipantStats getStats() {
		return stats;
	}

	public void setStats(MatchParticipantStats stats) {
		this.stats = stats;
	}

	/**
	 * @return Team ID.
	 */
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	/**
	 * @return Timeline data. Delta fields refer to values for
	 * the specified period (e.g., the gold per minute over
	 * the first 10 minutes of the game versus the second 20
	 * minutes of the game. Diffs fields refer to the deltas
	 * versus the calculated lane opponent(s).
	 */
	public MatchParticipantTimeline getTimeline() {
		return timeline;
	}

	public void setTimeline(MatchParticipantTimeline timeline) {
		this.timeline = timeline;
	}
}

