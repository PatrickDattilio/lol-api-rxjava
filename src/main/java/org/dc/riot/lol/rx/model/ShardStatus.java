package org.dc.riot.lol.rx.model;

/**
 * Server data object
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ShardStatus {

    private String region_tag;
    private String[] locales;
    private String name;
    private String hostname;
    private String slug;
    private Service[] services;

    /**
     * @return region tag (e.g. 'na1') or <code>null</code>
     */
    public String getRegion_tag() {
        return region_tag;
    }

    /**
     * @param regionTag the region_tag
     */
    public void setRegion_tag(String regionTag) {
        this.region_tag = regionTag;
    }

    /**
     * @return the locales
     */
    public String[] getLocales() {
        return locales;
    }

    /**
     * @param locales the locales
     */
    public void setLocales(String[] locales) {
        this.locales = locales;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname the hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return the slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @param slug the slug
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
