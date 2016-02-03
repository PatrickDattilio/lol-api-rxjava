package org.dc.riot.lol.rx.model.champion;

/**
 * This object contains champion data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampListDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}
	
	private ChampDto[] champions;
	
	public ChampListDto() {
		COUNT++;
	}
    
	/**
	 * @return The collection of champion information.
	 */
	public ChampDto[] getChampions() {
		if (champions == null) {
			return new ChampDto[0];
		}

		return champions;
	}
}
