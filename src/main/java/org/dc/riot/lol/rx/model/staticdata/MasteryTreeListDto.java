package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains mastery tree list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryTreeListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private MasteryTreeItemDto[] masteryTreeItems;
    
    public MasteryTreeListDto() {
    	COUNT++;
    }

    /**
     * Implementation note: this list may contain <code>null</code>
     * items.
     * 
     * @return Mastery tree item list or empty if not defined.
     */
    public MasteryTreeItemDto[] getMasteryTreeItems() {
    	if (masteryTreeItems == null) {
    		return new MasteryTreeItemDto[0];
    	}

        return masteryTreeItems;
    }
}
