package org.dc.riot.lol.rx.model;

/**
 * Used by the Team API
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

    public long getSecondLastJoinDate() {
        return secondLastJoinDate;
    }

    public void setSecondLastJoinDate(long secondLastJoinDate) {
        this.secondLastJoinDate = secondLastJoinDate;
    }

    public long getLastJoinDate() {
        return lastJoinDate;
    }

    public void setLastJoinDate(long lastJoinDate) {
        this.lastJoinDate = lastJoinDate;
    }

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    public MatchHistorySummaryDto[] getMatchHistory() {
    	if (matchHistory == null) {
    		return new MatchHistorySummaryDto[0];
    	}

        return matchHistory;
    }

    public void setMatchHistory(MatchHistorySummaryDto[] matchHistory) {
        this.matchHistory = matchHistory;
    }

    public long getLastJoinedRankedTeamQueueDate() {
        return lastJoinedRankedTeamQueueDate;
    }

    public void setLastJoinedRankedTeamQueueDate(long lastJoinedRankedTeamQueueDate) {
        this.lastJoinedRankedTeamQueueDate = lastJoinedRankedTeamQueueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TeamStatDetailDto[] getTeamStatDetails() {
    	if (teamStatDetails == null) {
    		return new TeamStatDetailDto[0];
    	}

        return teamStatDetails;
    }

    public void setTeamStatDetails(TeamStatDetailDto[] teamStatDetails) {
        this.teamStatDetails = teamStatDetails;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getThirdLastJoinDate() {
        return thirdLastJoinDate;
    }

    public void setThirdLastJoinDate(long thirdLastJoinDate) {
        this.thirdLastJoinDate = thirdLastJoinDate;
    }

    public RosterDto getRoster() {
        return roster;
    }

    public void setRoster(RosterDto roster) {
        this.roster = roster;
    }

    public long getLastGameDate() {
        return lastGameDate;
    }

    public void setLastGameDate(long lastGameDate) {
        this.lastGameDate = lastGameDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}
