package org.dc.riot.lol.rx.model;

/**
 * This object contains mastery tree list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryTreeListDto {
    private MasteryTreeItemDto[] masteryTreeItems;

    public MasteryTreeItemDto[] getMasteryTreeItems() {
        return masteryTreeItems;
    }

    public void setMasteryTreeItems(MasteryTreeItemDto[] masteryTreeItems) {
        this.masteryTreeItems = masteryTreeItems;
    }
}
