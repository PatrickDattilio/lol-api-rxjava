package org.dc.riot.lol.rx.model.team;

/**
 * This object contains team member information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class TeamMemberInfoDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private long joinDate;
    private long inviteDate;
    private String status;
    private long playerId;
    
    public TeamMemberInfoDto() {
    	COUNT++;
    }

    /**
     * Implementation note: this value may not be set by the
     * server resulting in <code>0</code>.
     * 
     * @return Date that team member joined team
     * specified as epoch milliseconds.
     */
    public long getJoinDate() {
        return joinDate;
    }

    /**
     * @return Date that team member was
     * invited to team specified as epoch milliseconds.
     */
    public long getInviteDate() {
        return inviteDate;
    }

    /**
     * @return This team member status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return This team member ID (summoner ID?).
     */
    public long getPlayerId() {
        return playerId;
    }
}