package org.dc.riot.lol.rx.model.match;

import org.dc.riot.lol.rx.model.MatchMode;
import org.dc.riot.lol.rx.model.MatchType;
import org.dc.riot.lol.rx.model.PlatformId;
import org.dc.riot.lol.rx.model.QueueType;
import org.dc.riot.lol.rx.model.Season;
import org.dc.riot.lol.rx.service.Region;

/**
 * This object contains match detail information.
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
	private ParticipantIdentity[] participantIdentities;
	private Participant[] participants;
	private PlatformId platformId;
	private QueueType queueType;
	private Region region;
	private Season season;
	private Team[] teams;
	private Timeline timeline;

	/**
	 * @return Match map ID.
	 */
	public int getMapId() {
		return mapId;
	}

	/**
	 * @return Match creation time. Designates when the team select
	 * lobby is created and/or the match is made through match making,
	 * not when the game actually starts.
	 */
	public long getMatchCreation() {
		return matchCreation;
	}

	/**
	 * @return matchCreation Match duration.
	 */
	public long getMatchDuration() {
		return matchDuration;
	}

	/**
	 * @return ID of the match.
	 */
	public long getMatchId() {
		return matchId;
	}

	/**
	 * @return the {@link MatchMode}.
	 */
	public MatchMode getMatchMode() {
		return matchMode;
	}

	/**
	 * @return the {@link MatchType}.
	 */
	public MatchType getMatchType() {
		return matchType;
	}

	/**
	 * @return Match version.
	 */
	public String getMatchVersion() {
		return matchVersion;
	}

	/**
	 * @return {@link ParticipantIdentity} information.
	 */
	public ParticipantIdentity[] getParticipantIdentities() {
		return participantIdentities;
	}

	/**
	 * @return {@link Participant} information.
	 */
	public Participant[] getParticipants() {
		return participants;
	}

	/**
	 * @return The {@link PlatformId}.
	 * @see Region
	 */
	public PlatformId getPlatformId() {
		return platformId;
	}

	/**
	 * @return The {@link QueueType}.
	 */
	public QueueType getQueueType() {
		return queueType;
	}

	/**
	 * @return The {@link Region}.
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @return The {@link Season}.
	 */
	public Season getSeason() {
		return season;
	}

	/**
	 * @return The {@link Team} information.
	 */
	public Team[] getTeams() {
		return teams;
	}

	/**
	 * @return The {@link Timeline}. Will be <code>null</code> unless
	 * explicitly asked for.
	 */
	public Timeline getTimeline() {
		return timeline;
	}
}