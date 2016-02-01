package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains rune slot information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RuneSlotDto {

    private long runeId;
    private int runeSlotId;

    /**
     * @return Rune ID associated with the rune slot.
     * For static information correlating to rune IDs, please refer to the LoL Static Data API.
     */
    public long getRuneId() {
        return runeId;
    }

    /**
     * @return Rune slot ID.
     */
    public int getRuneSlotId() {
        return runeSlotId;
    }
}
