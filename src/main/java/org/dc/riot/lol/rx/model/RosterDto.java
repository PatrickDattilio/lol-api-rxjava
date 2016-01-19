package org.dc.riot.lol.rx.model;

/**
 * Used by the Team API
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RosterDto {
    private TeamMemberInfoDto[] memberList;
    private long ownerId;

    public TeamMemberInfoDto[] getMemberList() {
    	if (memberList == null) {
    		return new TeamMemberInfoDto[0];
    	}

        return memberList;
    }

    
    public void setMemberList(TeamMemberInfoDto[] memberList) {
        this.memberList = memberList;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
