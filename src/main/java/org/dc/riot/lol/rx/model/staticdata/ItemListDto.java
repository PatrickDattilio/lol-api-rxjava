package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains item list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ItemListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private BasicDataDto basic;
    private Map<String, ItemDto> data;
    private GroupDto[] groups;
    private ItemTreeDto[] tree;
    private String type;
    private String version;
    
    public ItemListDto() {
    	COUNT++;
    }

    /**
     * @return Basic data.
     */
    public BasicDataDto getBasic() {
        return basic;
    }

    /**
     * @return Data.
     */
    public Map<String, ItemDto> getData() {
    	if (data == null) {
    		return new HashMap<String,ItemDto>();
    	}

        return data;
    }

    /**
     * @return Item groups.
     */
    public GroupDto[] getGroups() {
    	if (groups == null) {
    		return new GroupDto[0];
    	}

        return groups;
    }

    /**
     * @return Item recipe tree.
     */
    public ItemTreeDto[] getTree() {
    	if (tree == null) {
    		return new ItemTreeDto[0];
    	}

        return tree;
    }

    /**
     * @return Type of data (e.g. 'items').
     */
    public String getType() {
        return type;
    }

    /**
     * @return Version. Patch for which data was retrieved.
     */
    public String getVersion() {
        return version;
    }
}