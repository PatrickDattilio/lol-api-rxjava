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
     * @return Locales.
     */
    public String[] getLocales() {
    	if (locales == null) {
    		return new String[0];
    	}

        return locales;
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Host name.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @return Slug.
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @return Services.
     */
    public Service[] getServices() {
    	if (services == null) {
    		return new Service[0];
    	}

        return services;
    }
}
