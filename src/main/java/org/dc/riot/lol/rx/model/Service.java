package org.dc.riot.lol.rx.model;

/**
 * Used by the Status API
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Service {
    private Incident[] incidents;
    private String status;
    private String name;
    private String slug;

    /**
     * @return The incidents
     */
    public Incident[] getIncidents() {
        return incidents;
    }

    /**
     * @param incidents The incidents
     */
    public void setIncidents(Incident[] incidents) {
        this.incidents = incidents;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
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

}
