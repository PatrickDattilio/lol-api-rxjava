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

    private Long runeId;
    private Integer runeSlotId;
    
    public RuneSlotDto() {
    	COUNT++;
    }

    /**
     * For static information correlating to rune IDs,
     * please refer to the LoL Static Data API.
     * 
     * @return Rune ID associated with the rune slot
     * or <code>-1</code> if not defined.
     */
    public long getRuneId() {
    	if (runeId == null) {
    		return -1;
    	}

        return runeId.longValue();
    }

    /**
     * <img src="https://s3-us-west-1.amazonaws.com/riot-api/img/rune-slot-ids.png"></img>
     * 
     * @return Rune slot ID or <code>-1</code> if not defined.
     */
    public int getRuneSlotId() {
    	if (runeSlotId == null) {
    		return -1;
    	}

        return runeSlotId.intValue();
    }
}
