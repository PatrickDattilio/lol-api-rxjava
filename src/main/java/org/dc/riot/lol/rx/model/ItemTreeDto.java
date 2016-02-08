package org.dc.riot.lol.rx.model;

/**
 * This object contains item tree data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ItemTreeDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String header;
    private String[] tags;

    /**
     * @return Header.
     */
    public String getHeader() {
        return header;
    }

    /**
     * @return Tags.
     */
    public String[] getTags() {
    	if (tags == null) {
    		return new String[0];
    	}

        return tags;
    }
}
