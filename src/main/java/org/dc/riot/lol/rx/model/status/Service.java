package org.dc.riot.lol.rx.model.status;

/**
 * Used by the Status API.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Service {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Incident[] incidents;
    private String status;
    private String name;
    private String slug;
    
    public Service() {
    	COUNT++;
    }

    /**
     * @return The incidents.
     */
    public Incident[] getIncidents() {
        return incidents;
    }

    /**
     * @return The status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The slug.
     */
    public String getSlug() {
        return slug;
    }
}
