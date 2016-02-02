package org.dc.riot.lol.rx.model.featuredgame;

/**
 * Featured game participant information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class FeaturedGameParticipant {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

	private boolean bot;
	private long championId;
	private long profileIconId;
	private long spell1Id;
	private long spell2Id;
	private String summonerName;
	private long teamId;
	
	public FeaturedGameParticipant() {
		COUNT++;
	}

	/**
	 * @return Flag indicating whether or not this
	 * participant is a bot.
	 */
	public boolean isBot() {
		return bot;
	}

	/**
	 * @return The ID of the champion played by
	 * this participant.
	 */
	public long getChampionId() {
		return championId;
	}

	/**
	 * @return The ID of the profile icon used by
	 * this participant.
	 */
	public long getProfileIconId() {
		return profileIconId;
	}
	
	/**
	 * @return The ID of the first summoner spell
	 * used by this participant.
	 */
	public long getSpell1Id() {
		return spell1Id;
	}
	
	/**
	 * @return The ID of the second summoner spell
	 * used by this participant.
	 */
	public long getSpell2Id() {
		return spell2Id;
	}
	
	/**
	 * @return The summoner name of this participant.
	 */
	public String getSummonerName() {
		return summonerName;
	}
	
	/**
	 * @return The team ID of this participant,
	 * indicating the participant's team.
	 */
	public long getTeamId() {
		return teamId;
	}
}