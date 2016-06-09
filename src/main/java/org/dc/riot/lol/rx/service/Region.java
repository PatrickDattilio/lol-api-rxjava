package org.dc.riot.lol.rx.service;

/**
 * All Riot LoL API regions.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Region {

    private final String name;
    private final String code;

    Region(String name, String code) {
    	this.name = name;
    	this.code = code;
    }
    
    public String getCode() {
    	return code;
    }
    
    public String getName() {
    	return name;
    }
    
    /**
     * @return realm code (e.g. NORTH_AMERICA = 'NA')
     */
    @Override
    public String toString() {
        return code;
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (obj instanceof Region) {
    		Region reg = (Region) obj;
    		return this.code.equals(reg.code) &&
    				this.name.equals(reg.name);
    	} else {
    		return super.equals(obj);
    	}
    }

    /**
     * @param regionCode e.g. 'NA'
     * @return the {@link Region} corresponding to the input code,
     * or <code>null</code> if one is not found
     */
    public static Region from(String regionCode) {
        for (Region r : Regions.getRegions()) {
            if (r.code.equals(regionCode)) {
                return r;
            }
        }

        return null;
    }
}
