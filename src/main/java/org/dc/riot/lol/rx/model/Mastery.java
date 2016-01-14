package org.dc.riot.lol.rx.model;

/**
 * Basic mastery class
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Mastery {
    private int rank;
    private long masterId;

    public Mastery() { }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public long getMasterId() {
        return masterId;
    }

    public void setMasterId(long masterId) {
        this.masterId = masterId;
    }
}
