package org.dc.riot.lol.rx.model;

import java.util.List;

/**
 * Used by the Team API
 * Created by Dc on 9/20/15.
 */
public class RosterDto {
    private List<TeamMemberInfoDto> memberList;
    private long ownerId;

    public List<TeamMemberInfoDto> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<TeamMemberInfoDto> memberList) {
        this.memberList = memberList;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
