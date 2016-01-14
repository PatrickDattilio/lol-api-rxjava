package org.dc.riot.lol.rx.service.request;

/**
 * Used by {@link org.dc.riot.lol.rx.service.RiotApi.StaticData RiotApi.StaticData}
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum ChampDataTag {
    ALL,
    ALLYTIPS,
    ALTIMAGES,
    BLURB,
    ENEMYTIPS,
    IMAGE,
    INFO,
    LORE,
    PARTYPE,
    PASSIVE,
    RECOMMENDED,
    SKINS,
    SPELLS,
    STATS,
    TAGS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

