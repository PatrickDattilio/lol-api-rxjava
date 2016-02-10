package org.dc.riot.lol.rx.model.staticdata;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * This object contains item group data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class GroupDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String MaxGroupOwnable;
    private String key;
    
    public GroupDto() {
    	COUNT++;
    }

    /**
     * How many of a particular kind of item
     * a player can pack into one slot.
     * <code>null</code> if not defined.
     * 
     * @return Max group ownable.
     */
    public String getMaxGroupOwnable() {
        return MaxGroupOwnable;
    }

    /**
     * @return Key.
     */
    public String getKey() {
        return key;
    }
    
    @Override
    public String toString() {
    	String retVal = "";
    	
    	retVal += "[" + this.getClass().getSimpleName();
    	
    	Field[] fields = this.getClass().getDeclaredFields();
    	for (Field f : fields) {
    		if (Modifier.isStatic(f.getModifiers())) {
    			continue;
    		}
    		
    		try {
				retVal += " " + f.getName() + "=" + f.get(this);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// won't happen inside the class under reflection, I hope
			}
    	}
    	
    	retVal += "]";
    	
    	return retVal;
    }
}
