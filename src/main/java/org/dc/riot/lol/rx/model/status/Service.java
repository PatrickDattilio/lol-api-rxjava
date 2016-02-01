package org.dc.riot.lol.rx.model.status;

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
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The slug
     */
    public String getSlug() {
        return slug;
    }
}
