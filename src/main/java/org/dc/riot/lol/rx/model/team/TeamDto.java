package org.dc.riot.lol.rx.model.team;

/**
 * This object contains team information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class TeamDto {
    private long secondLastJoinDate;
    private long lastJoinDate;
    private String fullId;
    private MatchHistorySummaryDto[] matchHistory;
    private long lastJoinedRankedTeamQueueDate;
    private String status;
    private TeamStatDetailDto[] teamStatDetails;
    private String tag;
    private String name;
    private long thirdLastJoinDate;
    private RosterDto roster;
    private long lastGameDate;
    private long modifyDate;
    private long createDate;

    /**
     * @return Date that second to last member
     * joined specified as epoch milliseconds.
     */
    public long getSecondLastJoinDate() {
        return secondLastJoinDate;
    }

    /**
     * @return Date that last member joined specified
     * as epoch milliseconds.
     */
    public long getLastJoinDate() {
        return lastJoinDate;
    }

    /**
     * @return The full ID.
     */
    public String getFullId() {
        return fullId;
    }

    /**
     * @return The match history.
     */
    public MatchHistorySummaryDto[] getMatchHistory() {
    	if (matchHistory == null) {
    		return new MatchHistorySummaryDto[0];
    	}

        return matchHistory;
    }

    /**
     * @return Date that team last joined the ranked team
     * queue specified as epoch milliseconds.
     */
    public long getLastJoinedRankedTeamQueueDate() {
        return lastJoinedRankedTeamQueueDate;
    }

    /**
     * @return The status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return Team stat details.
     */
    public TeamStatDetailDto[] getTeamStatDetails() {
    	if (teamStatDetails == null) {
    		return new TeamStatDetailDto[0];
    	}

        return teamStatDetails;
    }

    /**
     * @return The tag.
     */
    public String getTag() {
        return tag;
    }

    /**
     * @return Team name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Date that third to last member joined
     * specified as epoch milliseconds.
     */
    public long getThirdLastJoinDate() {
        return thirdLastJoinDate;
    }

    /**
     * @return Roster data.
     */
    public RosterDto getRoster() {
        return roster;
    }

    /**
     * @return Date that last game played by team
     * ended specified as epoch milliseconds.
     */
    public long getLastGameDate() {
        return lastGameDate;
    }

    /**
     * @return 	Date that team was last modified
     * specified as epoch milliseconds.
     */
    public long getModifyDate() {
        return modifyDate;
    }

    /**
     * @return Date that team was created specified
     * as epoch milliseconds.
     */
    public long getCreateDate() {
        return createDate;
    }
}