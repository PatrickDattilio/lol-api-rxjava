package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains champion list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampionListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Map<String, ChampionDto> data;
	private String format;
	private Map<String, String> keys;
	private String type;
	private String version;
	
	public ChampionListDto() {
		COUNT++;
	}
	
	/**
	 * @return Champion static data.
	 */
	public Map<String, ChampionDto> getData() {
		if (data == null) {
			return new HashMap<String, ChampionDto>();
		}
		
		return data;
	}
	
	/**
	 * Format data is delivered in (e.g. 'full').
	 * 
	 * @return Format.
	 */
	public String getFormat() {
		return format;
	}
	
	/**
	 * @return Keys.
	 */
	public Map<String, String> getKeys() {
		if (keys == null) {
			return new HashMap<String,String>();
		}
		
		return keys;
	}
	
	/**
	 * Type of data (e.g. 'champion').
	 * 
	 * @return Type.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Patch in use (e.g. '6.2.1').
	 * 
	 * @return Version.
	 */
	public String getVersion() {
		return version;
	}
}
