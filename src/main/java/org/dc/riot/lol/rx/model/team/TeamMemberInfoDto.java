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

    private Long joinDate;
    private Long inviteDate;
    private String status;
    private Long playerId;
    
    public TeamMemberInfoDto() {
    	COUNT++;
    }

    /**
     * Implementation note: this value may not be set by the
     * server resulting in <code>-1</code>.
     * 
     * @return Date that team member joined team
     * specified as epoch milliseconds.
     */
    public long getJoinDate() {
    	if (joinDate == null) {
    		return -1;
    	}

        return joinDate.longValue();
    }

    /**
     * @return Date that team member was
     * invited to team specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getInviteDate() {
    	if (inviteDate == null) {
    		return -1;
    	}

        return inviteDate.longValue();
    }

    /**
     * @return This team member status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return This team member ID (summoner ID?)
     * or <code>-1</code> if not defined.
     */
    public long getPlayerId() {
    	if (playerId == null) {
    		return -1;
    	}

        return playerId.longValue();
    }
}