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

    private int count;
    private long id;
    
    public BlockItemDto() {
    	COUNT++;
    }

    /**
     * @return Count.
     */
    public int getCount() {
        return count;
    }

    /**
     * @return ID.
     */
    public long getId() {
        return id;
    }
}
