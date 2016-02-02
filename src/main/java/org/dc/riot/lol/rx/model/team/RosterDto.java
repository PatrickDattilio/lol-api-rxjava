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
    private long ownerId;
    
    public RosterDto() {
    	COUNT++;
    }

    /**
     * @return List of team member info objects.
     */
    public TeamMemberInfoDto[] getMemberList() {
    	if (memberList == null) {
    		return new TeamMemberInfoDto[0];
    	}

        return memberList;
    }

    /**
     * @return Team owner summoner ID.
     */
    public long getOwnerId() {
        return ownerId;
    }
}
