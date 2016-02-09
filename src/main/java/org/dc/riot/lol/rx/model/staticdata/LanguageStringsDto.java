package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains language strings data.
 * Various language data (insert 26 languages meme here).
 * 
 * @author Dc
 * @since 1.0.0
 */
public class LanguageStringsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Map<String, String> data;
    private String type;
    private String version;
    
    public LanguageStringsDto() {
    	COUNT++;
    }

    /**
     * <b>HUGE</b> hash map of various kinds of pretty print
     * strings. Probably not super useful to anybody but
     * Riot Games.
     * 
     * @return Data.
     */
    public Map<String, String> getData() {
    	if (data == null) {
    		return new HashMap<>();
    	}

        return data;
    }

    /**
     * @return Type of data.
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
