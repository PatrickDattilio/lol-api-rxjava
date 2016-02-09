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
     * @return Incidents or <code>-1</code> if not defined.
     */
    public Incident[] getIncidents() {
    	if (incidents == null) {
    		return new Incident[0];
    	}

        return incidents;
    }

    /**
     * @return Status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Slug.
     */
    public String getSlug() {
        return slug;
    }
}
