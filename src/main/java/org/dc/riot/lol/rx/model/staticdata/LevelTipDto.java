package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion level tip data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class LevelTipDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String[] effect;
    private String[] label;
    
    public LevelTipDto() {
    	COUNT++;
    }

    /**
     * @return Effect information.
     */
    public String[] getEffect() {
    	if (effect == null) {
    		return new String[0];
    	}

        return effect;
    }

    /**
     * @return Labels.
     */
    public String[] getLabel() {
    	if (label == null) {
    		return new String[0];
    	}
    	
        return label;
    }
}