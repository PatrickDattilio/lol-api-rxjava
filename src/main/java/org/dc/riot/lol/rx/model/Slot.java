package org.dc.riot.lol.rx.model;

public class Slot {

    private long runeId;
    private int runeSlotId;

    /**
     * @return The runeId
     */
    public long getRuneId() {
        return runeId;
    }

    /**
     * @param runeId The runeId
     */
    public void setRuneId(long runeId) {
        this.runeId = runeId;
    }

    /**
     * @return The runeSlotId
     */
    public int getRuneSlotId() {
        return runeSlotId;
    }

    /**
     * @param runeSlotId The runeSlotId
     */
    public void setRuneSlotId(int runeSlotId) {
        this.runeSlotId = runeSlotId;
    }
}
