package org.dc.riot.lol.rx.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * All Riot LoL API regions.
 * 
 * @author Dc
 * @since 1.0.2
 */
public class Regions {

	private static final Region[] REGIONS = {
			new Region("North America", "NA"),
			new Region("Europe West", "EUW"),
			new Region("Europe Northeast", "EUNE"),
			new Region("Latin America North", "LAN"),
			new Region("Latin America South", "LAS"),
			new Region("Brazil", "BR"),
			new Region("Korea", "KR"),
			new Region("Oceanic", "OCE"),
			new Region("Russia", "RU"),
			new Region("Turkey", "TR"),
			new Region("Public Beta Environment", "PBE")
	};
	
	public static Region[] getRegions() {
		Region[] regions = new Region[REGIONS.length];
		System.arraycopy(REGIONS, 0, regions, 0, regions.length);
		return regions;
	}
	
	public static Region getByCode(String code) {
		for (Region r : REGIONS) {
			if (r.getCode().equals(code)) {
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
    	Region[] regions = Regions.getRegions();

    	if (excludedRegions == null || excludedRegions.length == 0) {
    		return regions;
    	}
    	
    	excludedRegions = removeDuplicates(excludedRegions);
    	
    	int excludedLength = 0;
    	for (Region r : excludedRegions) {
    		if (r != null) {
    			excludedLength++;
    		}
    	}

    	int outputLength = regions.length - excludedLength;
    	if (outputLength < 1) {
    		return new Region[0];
    	}
    	
    	Region[] outputRegions = new Region[outputLength];

    	int i = 0;
    	for (Region r : regions) {
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
    		if (re.equals(r)) {
    			return true;
    		}
    	}
    	
    	return false;
    }
}
