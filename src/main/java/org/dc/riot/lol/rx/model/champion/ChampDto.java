package org.dc.riot.lol.rx.model.champion;

/**
 * This object contains champion data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private boolean active;
	private boolean botEnabled;
	private boolean botMmEnabled;
	private boolean freeToPlay;
	private long id;
	private boolean	rankedPlayEnabled;
	
	public ChampDto() {
		COUNT++;
	}

	/**
	 * @return Indicates if the champion is active.
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * @return Bot enabled flag (for custom games).
	 */
	public boolean isBotEnabled() {
		return botEnabled;
	}
	
	/**
	 * @return Bot Match Made enabled flag (for Co-op vs. AI games).
	 */
	public boolean isBotMmEnabled() {
		return botMmEnabled;
	}
	
	/**
	 * @return Indicates if the champion is free to play. Free to play champions are rotated periodically.
	 */
	public boolean isFreeToPlay() {
		return freeToPlay;
	}
	
	/**
	 * @return Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return Ranked play enabled flag.
	 */
	public boolean isRankedPlayEnabled() {
		return rankedPlayEnabled;
	}
}
