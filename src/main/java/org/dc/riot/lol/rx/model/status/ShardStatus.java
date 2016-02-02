package org.dc.riot.lol.rx.model.status;

/**
 * Server data object.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ShardStatus {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String region_tag;
    private String[] locales;
    private String name;
    private String hostname;
    private String slug;
    private Service[] services;

    public ShardStatus() {
    	COUNT++;
    }

    /**
     * @return region tag (e.g. 'na1') or <code>null</code>.
     */
    public String getRegionTag() {
        return region_tag;
    }

    /**
     * @return The locales.
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
     * @return The hostname.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @return The slug.
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @return The services.
     */
    public Service[] getServices() {
        return services;
    }
}
