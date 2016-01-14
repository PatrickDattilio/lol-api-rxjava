package org.dc.riot.lol.rx.model;

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

    public Message[] getUpdates() {
        return updates;
    }

    public void setUpdates(Message[] updates) {
        this.updates = updates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
