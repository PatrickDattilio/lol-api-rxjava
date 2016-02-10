package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains summoner spell list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SummonerSpellListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Map<String, SummonerSpellDto> data;
    private String type;
    private String version;
    
    public SummonerSpellListDto() {
    	COUNT++;
    }

    /**
     * @return Data or empty if not defined.
     */
    public Map<String, SummonerSpellDto> getData() {
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
     * @return Version (i.e. patch).
     */
    public String getVersion() {
        return version;
    }
}
