package org.dc.riot.lol.rx.model;

/**
 * Server data object
 * Created by Dc on 9/19/15.
 */
public class ShardStatus {

    private String regionTag;
    private String[] locales;
    private String name;
    private String hostname;
    private String slug;
    private Service[] services;

    /**
     * @return The regionTag
     */
    public String getRegionTag() {
        return regionTag;
    }

    /**
     * @param regionTag The region_tag
     */
    public void setRegionTag(String regionTag) {
        this.regionTag = regionTag;
    }

    /**
     * @return The locales
     */
    public String[] getLocales() {
        return locales;
    }

    /**
     * @param locales The locales
     */
    public void setLocales(String[] locales) {
        this.locales = locales;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname The hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @param slug The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }
}
