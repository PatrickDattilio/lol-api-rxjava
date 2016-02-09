package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains meta data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MetaDataDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Boolean isRune;
    private String tier;
    private String type;
    
    public MetaDataDto() {
    	COUNT++;
    }

    /**
     * @return Is rune or <code>false</code> if not defined.
     */
    public boolean isRune() {
    	if (isRune == null) {
    		return false;
    	}

        return isRune.booleanValue();
    }

    /**
     * @return Item tier.
     */
    public String getTier() {
        return tier;
    }

    /**
     * @return Type.
     */
    public String getType() {
        return type;
    }
}