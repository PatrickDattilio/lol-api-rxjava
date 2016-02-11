package org.dc.riot.lol.rx.model.match;

import org.dc.riot.lol.rx.model.common.MatchMode;
import org.dc.riot.lol.rx.model.common.MatchType;
import org.dc.riot.lol.rx.model.common.PlatformId;
import org.dc.riot.lol.rx.model.common.QueueType;
import org.dc.riot.lol.rx.model.common.Season;
import org.dc.riot.lol.rx.service.Region;

/**
 * This object contains match detail information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchDetail {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Integer mapId;
	private Long matchCreation;
	private Long matchDuration;
	private Long matchId;
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
	
	public MatchDetail() {
		COUNT++;
	}

	/**
	 * @return Match map ID or <code>-1</code>
	 * if not defined.
	 */
	public int getMapId() {
		if (mapId == null) {
			return -1;
		}
		
		return mapId.intValue();
	}

	/**
	 * Designates when the team select
	 * lobby is created and/or the match
	 * is made through match making,
	 * not when the game actually starts.
	 * 
	 * @return Match creation time or <code>-1</code>
	 * if not defined.
	 */
	public long getMatchCreation() {
		if (matchCreation == null) {
			return matchCreation;
		}

		return matchCreation.longValue();
	}

	/**
	 * @return Match duration or <code>-1</code>
	 * if not defined.
	 */
	public long getMatchDuration() {
		if (matchDuration == null) {
			return -1;
		}

		return matchDuration.longValue();
	}

	/**
	 * @return ID of the match.
	 */
	public long getMatchId() {
		if (matchId == null) {
			return -1;
		}

		return matchId.longValue();
	}

	/**
	 * @return {@link MatchMode}.
	 */
	public MatchMode getMatchMode() {
		return matchMode;
	}

	/**
	 * @return {@link MatchType}.
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
		if (region == null && platformId != null) {
			return platformId.toRegion();
		}

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