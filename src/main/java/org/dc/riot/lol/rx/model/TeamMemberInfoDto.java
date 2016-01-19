package org.dc.riot.lol.rx.model;

/**
 * Used by the Team API
 * 
 * @author Dc
 * @since 1.0.0
 */
public class TeamMemberInfoDto {
    private long joinDate;
    private long inviteDate;
    private String status;
    private long playerId;

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

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }
}
