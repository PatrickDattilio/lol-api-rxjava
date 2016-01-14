package org.dc.riot.lol.rx.model;

/**
 * Basic rune class
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Rune {
    private int count;
    private long runeId;

    public Rune() { }

    public long getRuneId() {
        return runeId;
    }

    public void setRuneId(long runeId) {
        this.runeId = runeId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
