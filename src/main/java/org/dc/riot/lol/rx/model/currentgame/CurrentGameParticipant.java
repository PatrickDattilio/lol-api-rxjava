package org.dc.riot.lol.rx.model.currentgame;

import org.dc.riot.lol.rx.model.common.Mastery;
import org.dc.riot.lol.rx.model.common.Rune;

/**
 * Current game participant.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class CurrentGameParticipant {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Boolean bot;
    private Long championId;
    private Mastery[] masteries;
    private Long profileIconId;
    private Rune[] runes;
    private Long spell1Id;
    private Long spell2Id;
    private Long summonerId;
    private String summonerName;
    private Long teamId;
    
    public CurrentGameParticipant() {
    	COUNT++;
    }

    /**
     * @return Flag indicating whether or not
     * this participant is a bot.
     */
    public boolean isBot() {
    	if (bot == null) {
    		return false;
    	}

        return bot.booleanValue();
    }

    /**
     * @return The ID of the champion played
     * by this participant.
     */
    public long getChampionId() {
    	if (championId == null) {
    		return -1;
    	}

        return championId.longValue();
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
    	if (profileIconId == null) {
    		return -1;
    	}

        return profileIconId.longValue();
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
    	if (spell1Id == null) {
    		return -1;
    	}

        return spell1Id.longValue();
    }

    /**
     * @return The ID of the second summoner spell
     * used by this participant.
     */
    public long getSpell2Id() {
    	if (spell2Id == null) {
    		return -1;
    	}

        return spell2Id.longValue();
    }

    /**
     * @return The summoner ID of this participant.
     */
    public long getSummonerId() {
    	if (summonerId == null) {
    		return -1;
    	}

        return summonerId.longValue();
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
    	if (teamId == null) {
    		return -1;
    	}

        return teamId.longValue();
    }
}