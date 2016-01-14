package org.dc.riot.lol.rx.model;

import org.dc.riot.lol.rx.service.Region;

/**
 * Used by the MatchList interface
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MatchReference {
    private long champion;
    private Lane lane;
    private long matchId;
    private PlatformId platformId;
    private RankedQueue queue;
    private Region region;
    private Role role;
    private Season season;
    private long timestamp;

    public long getChampion() {
        return champion;
    }

    public void setChampion(long champion) {
        this.champion = champion;
    }

    public Lane getLane() {
        return lane;
    }

    public void setLane(Lane lane) {
        this.lane = lane;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public PlatformId getPlatformId() {
        return platformId;
    }

    public void setPlatformId(PlatformId platformId) {
        this.platformId = platformId;
    }

    public RankedQueue getQueue() {
        return queue;
    }

    public void setQueue(RankedQueue queue) {
        this.queue = queue;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
