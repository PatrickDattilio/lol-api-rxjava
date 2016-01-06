package org.dc.riot.lol.rx.model;

import org.dc.riot.lol.rx.service.Region;

/**
 * Old platform ID used by some of the older APIs
 * Created by Dc on 9/2/15.
 */
public enum PlatformId {
    NA1, EUW1, EUNE1, LA1, LA2, BR1, KR, OC1, RU, TR1;

    public static PlatformId from(Region region) {
        switch (region) {
            case NORTH_AMERICA:
                return NA1;
            case EUROPE_WEST:
                return EUW1;
            case EUROPE_NORTHEAST:
                return EUNE1;
            case LATIN_AMERICA_NORTH:
                return LA1;
            case LATIN_AMERICA_SOUTH:
                return LA2;
            case BRAZIL:
                return BR1;
            case KOREA:
                return KR;
            case OCEANIC:
                return OC1;
            case RUSSIA:
                return RU;
            case TURKEY:
                return TR1;
            default:
                return null;
        }
    }
}
