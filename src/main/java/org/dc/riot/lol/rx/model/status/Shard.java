package org.dc.riot.lol.rx.model.status;

/**
 * Server status listing
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Shard {
    private String hostname;
    private String[] locales;
    private String name;
    private String region_tag;
    private String slug;

    public String getHostname() {
        return hostname;
    }

    public String[] getLocales() {
        return locales;
    }

    public String getName() {
        return name;
    }

    /**
     * @return region tag (e.g. 'na1') or <code>null</code>
     */
    public String getRegionTag() {
        return region_tag;
    }

    public String getSlug() {
        return slug;
    }
}