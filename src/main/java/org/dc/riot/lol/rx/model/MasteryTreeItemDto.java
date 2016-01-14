package org.dc.riot.lol.rx.model;

/**
 * This object contains mastery tree item data
 * 
 * @author Dc
 * @since 1.0.0
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
