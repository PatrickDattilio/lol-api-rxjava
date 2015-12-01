package org.dc.riot.lol.rx.model;

/**
 * This object is deserialized from either a String "Self" or a List&lt;Integer>
 * Created by Dc on 10/4/15.
 */
public class RangeDto {

    private boolean self;
    private int[] ranges;

    public RangeDto(int[] ranges) {
        this.ranges = ranges;
        if (ranges == null) {
            self = true;
        } else {
            self = false;
        }
    }

    public boolean isSelf() {
        return self;
    }

    public int[] getRanges() {
        return ranges;
    }
}
