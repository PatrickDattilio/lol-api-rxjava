package org.dc.riot.lol.rx.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    
    /**
     * Gets a list of {@link Region}s excluding the given {@link Region}s.
     * Tolerant of repeated inputs as well as <code>null</code> items.
     * 
     * @param excludedRegions {@link Region}s to exclude
     * @return list of all {@link Region}s excluding the given list
     */
    public static Region[] getExcluding(Region... excludedRegions) {
    	if (excludedRegions == null || excludedRegions.length == 0) {
    		return Region.values();
    	}
    	
    	excludedRegions = removeDuplicates(excludedRegions);
    	
    	int excludedLength = 0;
    	for (Region r : excludedRegions) {
    		if (r != null) {
    			excludedLength++;
    		}
    	}

    	int outputLength = Region.values().length - excludedLength;
    	if (outputLength < 1) {
    		return new Region[0];
    	}
    	
    	Region[] outputRegions = new Region[outputLength];

    	int i = 0;
    	for (Region r : Region.values()) {
    		boolean excluded = r == null || contains(excludedRegions, r);  		
    		if (!excluded) {
    			outputRegions[i] = r;
    			i++;
    		}
    	}
    	
    	return outputRegions;
    }
    
    private static Region[] removeDuplicates(Region[] regions) {
    	Set<Region> alreadyPresent = new HashSet<>();
    	Region[] whitelist = new Region[regions.length];
    	int i=0;
    	
    	for (Region r : regions) {
    		if (alreadyPresent.add(r)) {
    			whitelist[i++] = r;
    		}
    	}
    	
    	return Arrays.copyOf(whitelist, i);
    }
    
    private static boolean contains(Region[] regions, Region r) {
    	for (Region re : regions) {
    		if (re == r) {
    			return true;
    		}
    	}
    	
    	return false;
    }
}
