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
     * E.g. http://ddragon.leagueoflegends.com/cdn
     * 
     * @return Base CDN URL.
     */
    public String getCdn() {
        return cdn;
    }

    /**
     * Usually just the current patch (e.g. 6.3.1)
     * 
     * @return Latest changed version of Dragon Magic's CSS file.
     */
    public String getCss() {
        return css;
    }

    /**
     * Usually just the current patch (e.g. 6.3.1)
     * 
     * @return Latest changed version of Dragon Magic.
     */
    public String getDd() {
        return dd;
    }

    /**
     * Usually just the current patch (e.g. 6.3.1)
     * 
     * @return Default language (locale e.g. en_US for NA) for this realm.
     */
    public String getL() {
        return l;
    }

    /**
     * Usually just the current patch (e.g. 6.3.1)
     * 
     * @return Legacy script mode for IE6 or older.
     */
    public String getLg() {
        return lg;
    }

    /**
     * Usually just the current patch (e.g. 6.3.1)
     * <pre>
     "item": "6.3.1",
     "rune": "6.3.1",
     "mastery": "6.3.1",
     "summoner": "6.3.1",
     "champion": "6.3.1",
     "profileicon": "6.3.1",
     "map": "6.3.1",
     "language": "6.3.1"
    </pre>
     * 
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