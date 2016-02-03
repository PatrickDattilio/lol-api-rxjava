package org.dc.riot.lol.rx.model.staticdata;

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

    private int base;
    private boolean purchasable;
    private int sell;
    private int total;
    
    public GoldDto() {
    	COUNT++;
    }

    /**
     * @return Base cost. Should be <code>0</code>
     * if {@link #isPurchasable()} is <code>false</code>.
     */
    public int getBase() {
        return base;
    }

    /**
     * @return Is purchasable.
     */
    public boolean isPurchasable() {
        return purchasable;
    }

    /**
     * @return Sell price. Should be <code>0</code>
     * if {@link #isPurchasable()} is <code>false</code>.
     */
    public int getSell() {
        return sell;
    }

    /**
     * @return Total cost. Should be <code>0</code>
     * if {@link #isPurchasable()} is <code>false</code>.
     */
    public int getTotal() {
        return total;
    }
}