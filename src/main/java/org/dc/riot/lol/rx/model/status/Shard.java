package org.dc.riot.lol.rx.model.status;

/**
 * Server status listing.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Shard {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String hostname;
    private String[] locales;
    private String name;
    private String region_tag;
    private String slug;
    
    public Shard() {
    	COUNT++;
    }

    /**
     * @return The hostname.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @return List of locale strings.
     */
    public String[] getLocales() {
        return locales;
    }

    /**
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return region tag (e.g. 'na1') or <code>null</code>.
     */
    public String getRegionTag() {
        return region_tag;
    }

    /**
     * @return The slug.
     */
    public String getSlug() {
        return slug;
    }
}