package org.dc.riot.lol.rx.model.champion;

/**
 * This object contains champion data.<br>
 * <br>
 * If looking for stats on champions and details like that
 * check out {@link org.dc.riot.lol.rx.model.staticdata.ChampionDto ChampionDto}
 * in the Static Data package.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ChampDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private Boolean active;
	private Boolean botEnabled;
	private Boolean botMmEnabled;
	private Boolean freeToPlay;
	private Long id;
	private Boolean	rankedPlayEnabled;
	
	public ChampDto() {
		COUNT++;
	}

	/**
	 * @return Indicates if the champion is active.
	 */
	public boolean isActive() {
		if (active == null) {
			return false;
		}

		return active.booleanValue();
	}
	
	/**
	 * @return Bot enabled flag (for custom games).
	 */
	public boolean isBotEnabled() {
		if (botEnabled == null) {
			return false;
		}

		return botEnabled.booleanValue();
	}
	
	/**
	 * @return Bot Match Made enabled flag (for Co-op vs. AI games).
	 */
	public boolean isBotMmEnabled() {
		if (botMmEnabled == null) {
			return false;
		}

		return botMmEnabled.booleanValue();
	}
	
	/**
	 * Free to play champions are rotated periodically.
	 * 
	 * @return Indicates if the champion is free to play.
	 */
	public boolean isFreeToPlay() {
		if (freeToPlay == null) {
			return false;
		}

		return freeToPlay.booleanValue();
	}
	
	/**
	 * For static information correlating to champion IDs,
	 * please refer to the LoL Static Data API.
	 * 
	 * @return Champion ID or <code>-1</code> if not
	 * defined.
	 */
	public long getId() {
		if (id == null) {
			return -1;
		}

		return id.intValue();
	}
	
	/**
	 * @return Ranked play enabled flag.
	 */
	public boolean isRankedPlayEnabled() {
		if (rankedPlayEnabled == null) {
			return false;
		}

		return rankedPlayEnabled.booleanValue();
	}
}
