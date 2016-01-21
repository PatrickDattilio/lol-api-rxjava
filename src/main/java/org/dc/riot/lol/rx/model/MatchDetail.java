package org.dc.riot.lol.rx.model;

import org.dc.riot.lol.rx.service.Region;

/**
 * Used by the Match API. Very detailed match statistics.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchDetail {

	private int mapId;
	private long matchCreation;
	private long matchDuration;
	private long matchId;
	private MatchMode matchMode;
	private MatchType matchType;
	private String matchVersion;
	private ParticipantIdentity participantIdentities;
	private MatchParticipant participants;
	private PlatformId platformId;
	private QueueType queueType;
	private Region region;
	private Season season;
	private MatchTeam teams;
	private Timeline timeline;

	/**
	 * @return the map ID
	 */
	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	/**
	 * @return Match creation time. Designates when the team select
	 * lobby is created and/or the match is made through match making,
	 * not when the game actually starts.
	 */
	public long getMatchCreation() {
		return matchCreation;
	}

	public void setMatchCreation(long matchCreation) {
		this.matchCreation = matchCreation;
	}

	/**
	 * @param matchCreation Match duration
	 */
	public long getMatchDuration() {
		return matchDuration;
	}

	public void setMatchDuration(long matchDuration) {
		this.matchDuration = matchDuration;
	}

	/**
	 * @return ID of the match
	 */
	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	/**
	 * @return the {@link MatchMode}
	 */
	public MatchMode getMatchMode() {
		return matchMode;
	}

	public void setMatchMode(MatchMode matchMode) {
		this.matchMode = matchMode;
	}

	/**
	 * @return the {@link MatchType}
	 */
	public MatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	/**
	 * @return Match version
	 */
	public String getMatchVersion() {
		return matchVersion;
	}

	public void setMatchVersion(String matchVersion) {
		this.matchVersion = matchVersion;
	}

	/**
	 * @return {@link ParticipantIdentity} information object
	 */
	public ParticipantIdentity getParticipantIdentities() {
		return participantIdentities;
	}

	public void setParticipantIdentities(ParticipantIdentity participantIdentities) {
		this.participantIdentities = participantIdentities;
	}

	/**
	 * @return {@link MatchParticipant} information
	 */
	public MatchParticipant getParticipants() {
		return participants;
	}

	public void setParticipants(MatchParticipant participants) {
		this.participants = participants;
	}

	/**
	 * @return The {@link PlatformId}
	 * @see Region
	 */
	public PlatformId getPlatformId() {
		return platformId;
	}

	public void setPlatformId(PlatformId platformId) {
		this.platformId = platformId;
	}

	/**
	 * @return The {@link QueueType}
	 */
	public QueueType getQueueType() {
		return queueType;
	}

	public void setQueueType(QueueType queueType) {
		this.queueType = queueType;
	}

	/**
	 * @return The {@link Region}
	 */
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return The {@link Season}
	 */
	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	/**
	 * @return The {@link MatchTeam} information
	 */
	public MatchTeam getTeams() {
		return teams;
	}

	public void setTeams(MatchTeam teams) {
		this.teams = teams;
	}

	/**
	 * @return The {@link Timeline}. Will be <code>null</code> unless
	 * explicitly asked for.
	 */
	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
}
