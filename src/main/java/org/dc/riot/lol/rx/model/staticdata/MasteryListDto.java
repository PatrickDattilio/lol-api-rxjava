package org.dc.riot.lol.rx.model.staticdata;

import java.util.Map;

/**
 * This object contains mastery list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Map<String, MasteryDto> data;
    private MasteryTreeDto tree;
    private String type;
    private String version;
    
    public MasteryListDto() {
    	COUNT++;
    }

    /**
     * @return Map with keys being the Mastery ID values.
     */
    public Map<String, MasteryDto> getData() {
        return data;
    }

    /**
     * @return Mastery tree data.
     */
    public MasteryTreeDto getTree() {
        return tree;
    }

    /**
     * @return Type.
     */
    public String getType() {
        return type;
    }

    /**
     * @return Version (i.e. patch).
     */
    public String getVersion() {
        return version;
    }
}