package org.dc.riot.lol.rx.model;

/**
 * This object contains mastery tree list data.
 * Created by Dc on 10/2/15.
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
