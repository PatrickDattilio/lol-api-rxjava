package org.dc.riot.lol.rx.model.staticdata;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * This object contains item gold data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class GoldDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Integer base;
    private Boolean purchasable;
    private Integer sell;
    private Integer total;
    
    public GoldDto() {
    	COUNT++;
    }

    /**
     * Implementation note: Total Biscuit of Rejuvenation
     * breaks this contract.
     * 
     * @return Base cost. Should be <code>0</code>
     * if {@link #isPurchasable()} is <code>false</code>.
     */
    public int getBase() {
    	if (base == null) {
    		return 0;
    	}

        return base.intValue();
    }

    /**
     * @return Is purchasable.
     */
    public boolean isPurchasable() {
    	if (purchasable == null) {
    		return false;
    	}

        return purchasable.booleanValue();
    }

    /**
     * Implementation note: Total Biscuit of Rejuvenation
     * breaks this contract.
     * 
     * @return Sell price. Should be <code>0</code>
     * if {@link #isPurchasable()} is <code>false</code>.
     */
    public int getSell() {
    	if (sell == null) {
    		return 0;
    	}

        return sell.intValue();
    }

    /**
     * Implementation note: Total Biscuit of Rejuvenation
     * breaks this contract.
     * 
     * @return Total cost. Should be <code>0</code>
     * if {@link #isPurchasable()} is <code>false</code>.
     */
    public int getTotal() {
    	if (total == null) {
    		return 0;
    	}

        return total.intValue();
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