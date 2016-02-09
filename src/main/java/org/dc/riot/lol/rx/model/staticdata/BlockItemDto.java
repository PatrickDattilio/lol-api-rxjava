package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion recommended block item data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class BlockItemDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Integer count;
    private Long id;
    
    public BlockItemDto() {
    	COUNT++;
    }

    /**
     * @return Count or <code>0</code> if not defined.
     */
    public int getCount() {
    	if (count == null) {
    		return 0;
    	}

        return count;
    }

    /**
     * @return ID or <code>-1</code> if not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id;
    }
}
