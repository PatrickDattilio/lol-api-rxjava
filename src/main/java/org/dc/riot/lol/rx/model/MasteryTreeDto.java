package org.dc.riot.lol.rx.model;

/**
 * This object contains mastery tree data. i.e. mastery pages
 * Created by Dc on 10/2/15.
 */
public class MasteryTreeDto {
    private MasteryTreeListDto[] Defense;
    private MasteryTreeListDto[] Offense;
    private MasteryTreeListDto[] Utility;

    public MasteryTreeListDto[] getDefense() {
        return Defense;
    }

    public void setDefense(MasteryTreeListDto[] defense) {
        Defense = defense;
    }

    public MasteryTreeListDto[] getOffense() {
        return Offense;
    }

    public void setOffense(MasteryTreeListDto[] offense) {
        Offense = offense;
    }

    public MasteryTreeListDto[] getUtility() {
        return Utility;
    }

    public void setUtility(MasteryTreeListDto[] utility) {
        Utility = utility;
    }
}
