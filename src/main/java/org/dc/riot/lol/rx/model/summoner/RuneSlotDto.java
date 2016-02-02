package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains rune slot information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RuneSlotDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private long runeId;
    private int runeSlotId;
    
    public RuneSlotDto() {
    	COUNT++;
    }

    /**
     * @return Rune ID associated with the rune slot.
     * For static information correlating to rune IDs,
     * please refer to the LoL Static Data API.
     */
    public long getRuneId() {
        return runeId;
    }

    /**
     * <img src="https://s3-us-west-1.amazonaws.com/riot-api/img/rune-slot-ids.png"></img>
     * 
     * @return Rune slot ID.
     */
    public int getRuneSlotId() {
        return runeSlotId;
    }
}
