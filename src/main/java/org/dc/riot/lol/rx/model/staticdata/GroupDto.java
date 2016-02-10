package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains item group data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class GroupDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String MaxGroupOwnable;
    private String key;
    
    public GroupDto() {
    	COUNT++;
    }

    /**
     * @return Max group ownable.
     */
    public String getMaxGroupOwnable() {
        return MaxGroupOwnable;
    }

    /**
     * @return Key.
     */
    public String getKey() {
        return key;
    }
}
