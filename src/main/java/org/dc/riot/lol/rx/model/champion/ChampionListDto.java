package org.dc.riot.lol.rx.model.champion;

/**
 * @author Dc
 * @since 1.0.0
 */
public class ChampionListDto {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}
	
	private ChampionDto[] champions;
	
	public ChampionListDto() {
		COUNT++;
	}
    
	/**
	 * @return The collection of champion information.
	 */
	public ChampionDto[] getChampions() {
		return champions;
	}
}
