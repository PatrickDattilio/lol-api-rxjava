package org.dc.riot.lol.rx.model.summoner;

import org.dc.riot.lol.rx.service.Region;

/**
 * This object contains summoner information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SummonerDto {
    private long id;
    private String name;
    private long profileIconId;
    private int summonerLevel;
    private long revisionDate;
    private Region region;

    /**
     * @return Region summoner is registered in.
     */
    public Region getRegion() {
        return region;
    }

	public void setRegion(Region region) {
		if (region == null) {
			this.region = region;
		}
	}

    /**
     * @return 	Summoner ID.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Summoner name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return ID of the summoner icon associated with the summoner.
     */
    public long getProfileIconId() {
        return profileIconId;
    }

    /**
     * @return Summoner level associated with the summoner.
     */
    public int getSummonerLevel() {
        return summonerLevel;
    }

    /**
     * @return Date summoner was last modified specified as epoch milliseconds.
     * The following events will update this timestamp:
     * profile icon change, playing the tutorial or advanced tutorial,
     * finishing a game, summoner name change.
     */
    public long getRevisionDate() {
        return revisionDate;
    }
}
