package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object is deserialized from either a String "self" or a List of Integer.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RangeDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private boolean self;
    private int[] ranges;

    public RangeDto(int[] ranges) {
    	COUNT++;
        this.ranges = ranges;
        if (ranges == null) {
            self = true;
        } else {
            self = false;
        }
    }

    /**
     * @return Self range.
     */
    public boolean isSelf() {
        return self;
    }

    /**
     * @return Range values.
     */
    public int[] getRanges() {
    	if (ranges == null) {
    		return new int[0];
    	}

        return ranges;
    }
}
