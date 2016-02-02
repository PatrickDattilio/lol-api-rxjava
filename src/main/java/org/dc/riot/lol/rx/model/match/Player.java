package org.dc.riot.lol.rx.model.match;

/**
 * This object contains match player information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Player {
	private static long COUNT = 0;
	public static long getCount() {
		return COUNT;
	}

	private String matchHistoryUri;
	private int profileIcon;
	private long summonerId;
	private String summonerName;
	
	public Player() {
		COUNT++;
	}

	/**
	 * @return Match history URI.
	 */
	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}

	/**
	 * @return Profile icon ID.
	 */
	public int getProfileIcon() {
		return profileIcon;
	}

	/**
	 * @return Summoner ID.
	 */
	public long getSummonerId() {
		return summonerId;
	}

	/**
	 * @return 	Summoner name.
	 */
	public String getSummonerName() {
		return summonerName;
	}
}
