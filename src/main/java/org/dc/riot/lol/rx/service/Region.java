package org.dc.riot.lol.rx.service;

/**
 * All Riot LoL API regions.
 * 
 * @author Dc
 * @since 1.0.0
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

    private Region(String text) {
        this.text = text;
    }

    /**
     * @return realm code (e.g. NORTH_AMERICA = 'NA')
     */
    @Override
    public String toString() {
        return text;
    }

    /**
     * @param regionCode e.g. 'NA'
     * @return the {@link Region} corresponding to the input code,
     * or <code>null</code> if one is not found
     */
    public static Region from(String regionCode) {
        for (Region r : Region.values()) {
            if (r.text.equals(regionCode)) {
                return r;
            }
        }

        return null;
    }
}
