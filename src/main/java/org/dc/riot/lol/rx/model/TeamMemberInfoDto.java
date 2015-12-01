package org.dc.riot.lol.rx.model;

/**
 * Used by the Team API
 * Created by Dc on 9/20/15.
 */
public class TeamMemberInfoDto {
    private long joinDate;
    private long inviteDate;
    private String status;
    private int playerId;

    public long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(long joinDate) {
        this.joinDate = joinDate;
    }

    public long getInviteDate() {
        return inviteDate;
    }

    public void setInviteDate(long inviteDate) {
        this.inviteDate = inviteDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
