package org.dc.riot.lol.rx.model;

/**
 * Basic mastery class
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Mastery {
    private int rank;
    private long masteryId;

    public Mastery() { }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public long getMasterId() {
        return masteryId;
    }

    public void setMasterId(long masteryId) {
        this.masteryId = masteryId;
    }
}
