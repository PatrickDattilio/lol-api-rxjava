package org.dc.riot.lol.rx.model.staticdata;

import java.util.Map;

/**
 * This object contains realm data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RealmDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String cdn;
    private String css;
    private String dd;
    private String l;
    private String lg;
    private Map<String, String> n;
    private Integer profileiconmax;
    private String store;
    private String v;
    
    public RealmDto() {
    	COUNT++;
    }

    /**
     * @return Base CDN URL.
     */
    public String getCdn() {
        return cdn;
    }

    /**
     * @return Latest changed version of Dragon Magic's CSS file.
     */
    public String getCss() {
        return css;
    }

    /**
     * @return Latest changed version of Dragon Magic.
     */
    public String getDd() {
        return dd;
    }

    /**
     * @return Default language for this realm.
     */
    public String getL() {
        return l;
    }

    /**
     * @return Legacy script mode for IE6 or older.
     */
    public String getLg() {
        return lg;
    }

    /**
     * @return Latest changed version for each data type listed.
     */
    public Map<String, String> getN() {
        return n;
    }

    /**
     * Special behavior number identifying the largest
     * profileicon ID that can be used under 500.
     * Any profileicon that is requested between this
     * number and 500 should be mapped to 0.

     * @return Profile icon max ID or <code>500</code> if
     * not defined.
     */
    public int getProfileiconmax() {
    	if (profileiconmax == null) {
    		return 500;
    	}

        return profileiconmax;
    }

    /**
     * Implementation note: might be <code>null</code>.
     * 
     * @return Additional api data drawn from other sources
     * that may be related to data dragon functionality
     */
    public String getStore() {
        return store;
    }

    /**
     * @return Current version of this file for this realm
     */
    public String getV() {
        return v;
    }
}