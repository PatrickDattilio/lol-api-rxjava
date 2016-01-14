package org.dc.riot.lol.rx.model;

/**
 * This object contains champion recommended block item data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class BlockItemDto {
    private int count;
    private int id;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
