package org.dc.riot.lol.rx.model.team;

/**
 * This object contains roster information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RosterDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private TeamMemberInfoDto[] memberList;
    private Long ownerId;
    
    public RosterDto() {
    	COUNT++;
    }

    /**
     * @return List of team member info objects
     * or empty of not defined.
     */
    public TeamMemberInfoDto[] getMemberList() {
    	if (memberList == null) {
    		return new TeamMemberInfoDto[0];
    	}

        return memberList;
    }

    /**
     * @return Team owner summoner ID
     * or <code>-1</code> if not defined.
     */
    public long getOwnerId() {
    	if (ownerId == null) {
    		return -1;
    	}

        return ownerId.longValue();
    }
}
