package org.dc.riot.lol.rx.model;

/**
 * This object contains mastery tree item data
 * Created by Dc on 10/2/15.
 */
public class MasteryTreeItemDto {
    private long masteryId;
    private String prereq;

    public long getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(long masteryId) {
        this.masteryId = masteryId;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }
}
