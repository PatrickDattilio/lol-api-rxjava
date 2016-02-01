package org.dc.riot.lol.rx.model.league;

import org.dc.riot.lol.rx.model.QueueType;
import org.dc.riot.lol.rx.model.Tier;

/**
 * This object contains league information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class LeagueDto {
    private String name;
    private LeagueEntryDto[] entries;
    private QueueType queue;
    private Tier tier;
    private String participantId;

    /**
     * @return This name is an internal place-holder name only. Display and
     * localization of names in the game client are handled client-side.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The requested league entries.
     */
    public LeagueEntryDto[] getEntries() {
    	if (entries == null) {
    		return new LeagueEntryDto[0];
    	}

        return entries;
    }

    /**
     * @return The league's queue type.
     * (Legal values: RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5)
     */
    public QueueType getQueue() {
        return queue;
    }

    /**
     * @return 	The league's tier. (Legal values:
     * CHALLENGER, MASTER, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE)
     */
    public Tier getTier() {
        return tier;
    }

    /**
     * Specifies the relevant participant that is a member of this
     * league (i.e., a requested summoner ID, a requested team ID,
     * or the ID of a team to which one of the requested summoners belongs).
     * Only present when full league is requested so that participant's entry
     * can be identified. Not present when individual entry is requested.
     *
     * @return Some kind of relevant ID based on context or <code>null</code>
     */
    public String getParticipantId() {
        return participantId;
    }
}