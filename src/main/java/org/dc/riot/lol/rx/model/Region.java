package org.dc.riot.lol.rx.model;

/**
 * Region enumeration all operations expect upper case
 * Created by Dan on 8/28/15.
 */
public enum Region {

    NORTH_AMERICA("NA"),
    EUROPE_WEST("EUW"),
    EUROPE_NORTHEAST("EUNE"),
    LATIN_AMERICA_NORTH("LAN"),
    LATIN_AMERICA_SOUTH("LAS"),
    BRAZIL("BR"),
    KOREA("KR"),
    OCEANIC("OCE"),
    RUSSIA("RU"),
    TURKEY("TR"),
    PUBLIC_BETA_ENVIRONMENT("PBE");

    private final String text;

    Region(String text) {
        this.text = text;
    }

    /**
     * @return realm code (e.g. NORTH_AMERICA = 'NA')
     */
    @Override
    public String toString() {
        return text;
    }

    public static Region from(String regionCode) {
        for (Region r : Region.values()) {
            if (r.text.equals(regionCode)) {
                return r;
            }
        }

        return null;
    }
}
