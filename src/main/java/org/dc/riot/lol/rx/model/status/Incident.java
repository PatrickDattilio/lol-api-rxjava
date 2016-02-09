package org.dc.riot.lol.rx.model.status;

/**
 * Used by the Status API.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Incident {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Boolean active;
    private String createdAt;
    private Long id;
    private Message[] updates;

    public Incident() {
    	COUNT++;
    }
    
    /**
     * @return The updates.
     */
    public Message[] getUpdates() {
        return updates;
    }

    /**
     * @return The ID or <code>-1</code> if not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id.longValue();
    }

    /**
     * @return The creation time.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return Is active or <code>false</code> if not defined.
     */
    public boolean isActive() {
    	if (active == null) {
    		return false;
    	}

        return active.booleanValue();
    }
}