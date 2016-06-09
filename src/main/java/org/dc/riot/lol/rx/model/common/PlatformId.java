package org.dc.riot.lol.rx.model.common;

import org.dc.riot.lol.rx.service.Region;
import org.dc.riot.lol.rx.service.Regions;

/**
 * Platform IDs.
 * 
 * @author Dc
 * @since 1.0.0
 */
public enum PlatformId {
    NA1, EUW1, EUNE1, LA1, LA2, BR1, KR, OC1, RU, TR1;
	
	public Region toRegion() {
		try {
			return Regions.getRegions()[this.ordinal()];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

    public static PlatformId from(Region region) {
    	for (PlatformId pid : PlatformId.values()) {
    		Region r = pid.toRegion();
    		if (r.equals(region)) {
    			return pid;
    		}
    	}

		return null;
    }
}
