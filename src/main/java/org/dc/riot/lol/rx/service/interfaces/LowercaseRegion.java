package org.dc.riot.lol.rx.service.interfaces;

import org.dc.riot.lol.rx.service.Region;

/**
 * Easy region code lowercasing from {@link Region}
 * 
 * @author Dc
 * @since 1.0.0
 */
final class LowercaseRegion {
	
	private Region region;

	LowercaseRegion(Region region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		if (region == null) {
			return "null";
		} else {
			return region.toString().toLowerCase();
		}
	}

}
