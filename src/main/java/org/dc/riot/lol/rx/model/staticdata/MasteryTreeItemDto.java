package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains mastery tree item data.`
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryTreeItemDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long masteryId;
    private String prereq;
    
    public MasteryTreeItemDto() {
    	COUNT++;
    }

    /**
     * @return Mastery ID or <code>-1</code> if not defined.
     */
    public long getMasteryId() {
    	if (masteryId == null) {
    		return -1;
    	}

        return masteryId.longValue();
    }

    /**
     * @return Prerequisite.
     */
    public String getPrereq() {
        return prereq;
    }
}
