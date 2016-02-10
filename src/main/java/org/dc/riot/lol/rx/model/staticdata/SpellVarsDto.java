package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains spell vars data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SpellVarsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private double[] coeff;
    private String dyn;
    private String key;
    private String link;
    private String ranksWith;
    
    public SpellVarsDto() {
    	COUNT++;
    }

    /**
     * @return Coeff data.
     */
    public double[] getCoeff() {
    	if (coeff == null) {
    		return new double[0];
    	}

        return coeff;
    }

    /**
     * @return Dyn.
     */
    public String getDyn() {
        return dyn;
    }

    /**
     * @return Key.
     */
    public String getKey() {
        return key;
    }

    /**
     * @return Link.
     */
    public String getLink() {
        return link;
    }

    /**
     * @return Ranks with.
     */
    public String getRanksWith() {
        return ranksWith;
    }
}
