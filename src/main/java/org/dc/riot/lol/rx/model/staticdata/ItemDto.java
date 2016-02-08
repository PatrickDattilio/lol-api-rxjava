package org.dc.riot.lol.rx.model.staticdata;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains item data.<br><br>
 * 
 * <a href="https://developer.riotgames.com/discussion/announcements/show/6OqJwp1E">Inheritance
 * Discussion</a>
 * 
 * @author Dc
 * @since 1.0.0
 * @see BasicDataDto
 */
public class ItemDto extends BasicDataDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Map<String, String> effect;
    
    public ItemDto() {
    	super(true);
    	COUNT++;
    }

    /**
     * Implementation note: might be <code>null</code>.
     * 
     * @return Effects.
     */
    public Map<String, String> getEffect() {
    	if (effect == null) {
    		return new HashMap<>();
    	}

        return effect;
    }
}
