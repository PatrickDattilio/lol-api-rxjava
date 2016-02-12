package org.dc.riot.lol.rx.model.match;

import org.dc.riot.lol.rx.model.common.PlatformId;
import org.dc.riot.lol.rx.model.common.RankedQueue;
import org.dc.riot.lol.rx.model.common.Season;
import org.dc.riot.lol.rx.service.Region;

/**
 * This object contains match reference information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchReference {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long champion;
    private Lane lane;
    private Long matchId;
    private PlatformId platformId;
    private RankedQueue queue;
    private Region region;
    private Role role;
    private Season season;
    private Long timestamp;
    
    public MatchReference() {
    	COUNT++;
    }

    /**
     * @return Champion ID.
     */
    public long getChampion() {
    	if (champion == null) {
    		return -1;
    	}

        return champion.longValue();
    }

    /**
     * @return Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM.
     */
    public Lane getLane() {
        return lane;
    }

    /**
     * @return The match ID.
     */
    public long getMatchId() {
    	if (matchId == null) {
    		return -1;
    	}

        return matchId.longValue();
    }

    /**
     * @return The platform ID.
     */
    public PlatformId getPlatformId() {
        return platformId;
    }

    /**
     * Legal values: TEAM_BUILDER_DRAFT_RANKED_5x5,
     * RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5.
     * 
     * @return Queue or <code>null</code> if not relevant.
     */
    public RankedQueue getQueue() {
        return queue;
    }

    /**
     * @return The region.
     */
    public Region getRegion() {
        return region;
    }
    
    /**
     * @param region the region associated with this
     * match reference
     */
    public void setRegion(Region region) {
    	if (this.region == null) {
    		this.region = region;
    	}
    }

    /**
     * @return Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT.
     */
    public Role getRole() {
        return role;
    }

    /**
     * @return Legal values: PRESEASON3, SEASON3, PRESEASON2014,
     * SEASON2014, PRESEASON2015, SEASON2015, PRESEASON2016, SEASON2016.
     */
    public Season getSeason() {
        return season;
    }

    /**
     * @return The time stamp.
     */
    public long getTimestamp() {
    	if (timestamp == null) {
    		return -1;
    	}

        return timestamp.longValue();
    }
}