package org.dc.riot.lol.rx.model;

/**
 * This object contains item group data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class GroupDto {
    private String MaxGroupOwnable;
    private String key;

    public String getMaxGroupOwnable() {
        return MaxGroupOwnable;
    }

    public void setMaxGroupOwnable(String maxGroupOwnable) {
        MaxGroupOwnable = maxGroupOwnable;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
