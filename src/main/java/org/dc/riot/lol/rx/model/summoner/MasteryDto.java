package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains mastery data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryDto {
    private long id;
    private int rank;

    /**
     * @return Mastery ID. For static information correlating to masteries, please refer to the LoL Static Data API.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Mastery rank (i.e., the number of points put into this mastery).
     */
    public int getRank() {
        return rank;
    }
}
