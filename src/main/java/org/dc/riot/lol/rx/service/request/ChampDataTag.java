package org.dc.riot.lol.rx.service.request;

/**
 * Used by {@link org.dc.riotapi.service.RiotApi.StaticData}
 * Created by Dc on 10/20/15.
 */
public enum ChampDataTag {
    ALL, ALLYTIPS, ALTIMAGES, BLURB, ENEMYTIPS, IMAGE, INFO, LORE, PARTYPE, PASSIVE, RECOMMENDED, SKINS, SPELLS, STATS, TAGS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

