package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains map data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MapDataDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Map<String, MapDetailsDto> data;
    private String type;
    private String version;
    
    public MapDataDto() {
    	COUNT++;
    }

    /**
     * @return Data.
     */
    public Map<String, MapDetailsDto> getData() {
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
     * @return Version (patch).
     */
    public String getVersion() {
        return version;
    }
}
