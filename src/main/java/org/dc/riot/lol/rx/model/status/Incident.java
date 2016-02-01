package org.dc.riot.lol.rx.model.status;

/**
 * Used by the Status API.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Incident {
    private boolean active;
    private String createdAt;
    private long id;
    private Message[] updates;

    /**
     * @return The updates
     */
    public Message[] getUpdates() {
        return updates;
    }

    /**
     * @return The ID
     */
    public long getId() {
        return id;
    }

    /**
     * @return The creation time
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return Is active
     */
    public boolean isActive() {
        return active;
    }
}