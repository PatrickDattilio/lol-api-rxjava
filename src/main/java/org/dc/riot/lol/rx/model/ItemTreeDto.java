package org.dc.riot.lol.rx.model;

/**
 * This object contains item tree data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ItemTreeDto {
    private String header;
    private String[] tags;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
