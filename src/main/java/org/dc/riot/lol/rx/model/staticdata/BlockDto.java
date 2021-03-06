package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion recommended block data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class BlockDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private BlockItemDto[] items;
    private Boolean recMath;
    private String type;
    
    public BlockDto() {
    	COUNT++;
    }

    /**
     * @return Items.
     */
    public BlockItemDto[] getItems() {
    	if (items == null) {
    		return new BlockItemDto[0];
    	}

        return items;
    }

    /**
     * @return Is rec math or <code>false</code> if not defined.
     */
    public boolean isRecMath() {
    	if (recMath == null) {
    		return false;
    	}

        return recMath.booleanValue();
    }

    /**
     * Implementation note: it is OK for this value
     * to be <code>null</code>.
     * 
     * @return Type.
     */
    public String getType() {
        return type;
    }
}