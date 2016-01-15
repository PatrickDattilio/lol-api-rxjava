package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class MasteryPage {


    private Mastery[] masteries;
    private long id;
    private String name;
    private boolean current;

    /**
     * @return The masteries
     */
    public Mastery[] getMasteries() {
        return masteries;
    }

    /**
     * @param masteries The masteries
     */
    public void setMasteries(Mastery[] masteries) {
        this.masteries = masteries;
    }

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
