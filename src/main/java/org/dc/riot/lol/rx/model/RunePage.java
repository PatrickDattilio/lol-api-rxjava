package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class RunePage {
    private long id;
    private Slot[] slots;
    private String name;
    private boolean current;

    /**
     * @return The id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return The slots
     */
    public Slot[] getSlots() {
    	if (slots == null) {
    		return new Slot[0];
    	}

        return slots;
    }

    /**
     * @param slots The slots
     */
    public void setSlots(Slot[] slots) {
        this.slots = slots;
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
     * @return The current
     */
    public boolean isCurrent() {
        return current;
    }

    /**
     * @param current The current
     */
    public void setCurrent(boolean current) {
        this.current = current;
    }
}
