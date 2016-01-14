package org.dc.riot.lol.rx.model;

import org.dc.riot.lol.rx.service.Region;

/**
 * Basic summoner data transfer object
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

    public SummonerDto() { }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(long revisionDate) {
        this.revisionDate = revisionDate;
    }
}
