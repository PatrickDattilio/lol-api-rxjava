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

	private Boolean bot;	// Flag indicating whether or not this participant is a bot
	private Long championId;	// The ID of the champion played by this participant
	private Long profileIconId;	// The ID of the profile icon used by this participant
	private Long spell1Id;	// The ID of the first summoner spell used by this participant
	private Long spell2Id;	// The ID of the second summoner spell used by this participant
	private String summonerName;	// The summoner name of this participant
	private Long teamId;	// The team ID of this participant, indicating the participant's team

	public FeaturedGameParticipant() {
		COUNT++;
	}

	/**
	 * @return Flag indicating whether or not this
	 * participant is a bot or
	 * <code>false</code> if not defined.
	 */
	public boolean isBot() {
		if (bot == null) {
			return false;
		}

		return bot.booleanValue();
	}

	/**
	 * @return The ID of the champion played by
	 * this participant or
	 * <code>-1</code> if not defined.
	 */
	public long getChampionId() {
		if (championId == null) {
			return -1;
		}

		return championId.longValue();
	}

	/**
	 * Implementation note: <code>0</code> is a
	 * valid icon ID. It happens to be this little
	 * guy:<br>
	 * <br>
	 * <img src="http://sk2.op.gg/images/profile_icons/profileIcon1.jpg" alt="Old fashioned blue siege minion.">
	 * 
	 * @return The ID of the profile icon used by
	 * this participant or
	 * <code>-1</code> if not defined.
	 */
	public long getProfileIconId() {
		if (profileIconId == null) {
			return -1;
		}

		return profileIconId.longValue();
	}
	
	/**
	 * @return The ID of the first summoner spell
	 * used by this participant or
	 * <code>-1</code> if not defined.
	 */
	public long getSpell1Id() {
		if (spell1Id == null) {
			return -1;
		}

		return spell1Id.longValue();
	}
	
	/**
	 * @return The ID of the second summoner spell
	 * used by this participant or
	 * <code>-1</code> if not defined.
	 */
	public long getSpell2Id() {
		if (spell2Id == null) {
			return -1;
		}

		return spell2Id.longValue();
	}
	
	/**
	 * @return The summoner name of this participant.
	 */
	public String getSummonerName() {
		return summonerName;
	}
	
	/**
	 * @return The team ID of this participant,
	 * indicating the participant's team or
	 * <code>-1</code> if not defined.
	 */
	public long getTeamId() {
		if (teamId == null) {
			return -1;
		}

		return teamId.longValue();
	}
}