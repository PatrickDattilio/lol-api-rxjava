package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains rune list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RuneListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private BasicDataDto basic;
    private Map<String, RuneDto> data;
    private String type;
    private String version;
    
    public RuneListDto() {
    	COUNT++;
    }

    /**
     * Details returned by this object can be
     * applied to all {@link RuneDto} objects
     * returned by {@link #getData()}. So individual
     * {@link RuneDto} instances may not have certain items
     * defined, those items are defined here.
     * 
     * @return Basic data.
     */
    public BasicDataDto getBasic() {
        return basic;
    }

    /**
     * @return Map of rune data.
     */
    public Map<String, RuneDto> getData() {
    	if (data == null) {
    		return new HashMap<>();
    	}

        return data;
    }

    /**
     * @return Type.
     */
    public String getType() {
        return type;
    }

    /**
     * @return Version.
     */
    public String getVersion() {
        return version;
    }
}