package org.dc.riot.lol.rx.model.currentgame;

/**
 * Current game participant
 * 
 * @author Dc
 * @since 1.0.0
 */
public class CurrentGameParticipant {
    private boolean bot;
    private long championId;
    private Mastery[] masteries;
    private long profileIconId;
    private Rune[] runes;
    private long spell1Id;
    private long spell2Id;
    private long summonerId;
    private String summonerName;
    private long teamId;

    /**
     * @return Flag indicating whether or not
     * this participant is a bot.
     */
    public boolean isBot() {
        return bot;
    }

    /**
     * @return The ID of the champion played
     * by this participant.
     */
    public long getChampionId() {
        return championId;
    }

    /**
     * @return The masteries used by this participant.
     */
    public Mastery[] getMasteries() {
    	if (masteries == null) {
    		return new Mastery[0];
    	}

        return masteries;
    }

    /**
     * @return The ID of the profile icon used
     * by this participant.
     */
    public long getProfileIconId() {
        return profileIconId;
    }

    /**
     * @return The runes used by this participant.
     */
    public Rune[] getRunes() {
    	if (runes == null) {
    		return new Rune[0];
    	}

        return runes;
    }

    /**
     * @return The ID of the first summoner spell used
     * by this participant.
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
     * @return The summoner ID of this participant.
     */
    public long getSummonerId() {
        return summonerId;
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