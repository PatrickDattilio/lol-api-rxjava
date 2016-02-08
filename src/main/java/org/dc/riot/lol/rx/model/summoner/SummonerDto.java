package org.dc.riot.lol.rx.model.summoner;

import org.dc.riot.lol.rx.service.Region;

/**
 * This object contains summoner information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SummonerDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long id;
    private String name;
    private Long profileIconId;
    private Integer summonerLevel;
    private Long revisionDate;
    private Region region;
    
    public SummonerDto() {
    	COUNT++;
    }

    /**
     * @return Region summoner is registered in.
     */
    public Region getRegion() {
        return region;
    }

	public void setRegion(Region region) {
		if (this.region == null) {
			this.region = region;
		}
	}

    /**
     * @return Summoner ID or <code>-1</code> if not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id.longValue();
    }

    /**
     * @return Summoner name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return ID of the summoner icon associated with the summoner
     * or <code>-1</code> if not defined.
     */
    public long getProfileIconId() {
    	if (profileIconId == null) {
    		return -1;
    	}

        return profileIconId.longValue();
    }

    /**
     * @return Summoner level associated with the summoner
     * or <code>-1</code> if not defined.
     */
    public int getSummonerLevel() {
    	if (summonerLevel == null) {
    		return -1;
    	}

        return summonerLevel.intValue();
    }

    /**
     * The following events will update this timestamp:
     * profile icon change, playing the tutorial or advanced tutorial,
     * finishing a game, summoner name change.
     * 
     * @return Date summoner was last modified specified as epoch milliseconds
     * or <code>-1</code> if not defined.
     */
    public long getRevisionDate() {
    	if (revisionDate == null) {
    		return -1;
    	}

        return revisionDate.longValue();
    }
}
