package org.dc.riot.lol.rx.model.match;

/**
 * This object contains match player information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Player {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private String matchHistoryUri;
	private Integer profileIcon;
	private Long summonerId;
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
	 * Implementation note: <code>0</code> is a valid
	 * icon ID.
	 * 
	 * @return Profile icon ID or <code>-1</code>
	 * if not defined.
	 */
	public int getProfileIcon() {
		if (profileIcon == null) {
			return -1;
		}

		return profileIcon;
	}

	/**
	 * @return Summoner ID or <code>-1</code>
	 * if not defined.
	 */
	public long getSummonerId() {
		if (summonerId == null) {
			return -1;
		}

		return summonerId;
	}

	/**
	 * @return 	Summoner name.
	 */
	public String getSummonerName() {
		return summonerName;
	}
}
