package org.dc.riot.lol.rx.model.team;

/**
 * This object contains team information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class TeamDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long secondLastJoinDate;
    private Long lastJoinDate;
    private String fullId;
    private MatchHistorySummaryDto[] matchHistory;
    private Long lastJoinedRankedTeamQueueDate;
    private String status;
    private TeamStatDetailDto[] teamStatDetails;
    private String tag;
    private String name;
    private Long thirdLastJoinDate;
    private RosterDto roster;
    private Long lastGameDate;
    private Long modifyDate;
    private Long createDate;
    
    public TeamDto() {
    	COUNT++;
    }

    /**
     * @return Date that second to last member
     * joined specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getSecondLastJoinDate() {
    	if (secondLastJoinDate == null) {
    		return -1;
    	}

        return secondLastJoinDate.longValue();
    }

    /**
     * @return Date that last member joined specified
     * as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getLastJoinDate() {
    	if (lastJoinDate == null) {
    		return -1;
    	}

        return lastJoinDate.longValue();
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
     * queue specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getLastJoinedRankedTeamQueueDate() {
    	if (lastJoinedRankedTeamQueueDate == null) {
    		return -1;
    	}

        return lastJoinedRankedTeamQueueDate.longValue();
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
     * specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getThirdLastJoinDate() {
    	if (thirdLastJoinDate == null) {
    		return -1;
    	}

        return thirdLastJoinDate.longValue();
    }

    /**
     * @return Roster data.
     */
    public RosterDto getRoster() {
        return roster;
    }

    /**
     * @return Date that last game played by team
     * ended specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getLastGameDate() {
    	if (lastGameDate == null) {
    		return -1;
    	}

        return lastGameDate.longValue();
    }

    /**
     * @return 	Date that team was last modified
     * specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getModifyDate() {
    	if (modifyDate == null) {
    		return -1;
    	}

        return modifyDate.longValue();
    }

    /**
     * @return Date that team was created specified
     * as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getCreateDate() {
    	if (createDate == null) {
    		return -1;
    	}

        return createDate.longValue();
    }
}