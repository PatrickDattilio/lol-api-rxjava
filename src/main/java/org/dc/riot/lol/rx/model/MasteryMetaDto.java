package org.dc.riot.lol.rx.model;

/**
 * Basic mastery meta data class. This class is referred to as
 * a 'Mastery' object on the official Riot API documentation.
 * However, the supplied fields is more akin to a metadata object
 * than the full {@link MasteryDto}.
 * 
 * @author Dc
 * @since 1.0.0
 * @see org.dc.riot.lol.rx.service.RiotApi.CurrentGame RiotApi.CurrentGame
 * @see CurrentGameInfo
 */
public class MasteryMetaDto {
    private int rank;
    private long id;

    public MasteryMetaDto() { }

    /**
     * @return the number of points the player has put
     * into this mastery
     */
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Mastery ID. For static information correlating to masteries, please refer to the LoL Static Data API.
     * 
     * @return the id for this mastery
     * @see org.dc.riot.ol.rx.service.RiotApi.StaticData RiotApi.StaticData
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
