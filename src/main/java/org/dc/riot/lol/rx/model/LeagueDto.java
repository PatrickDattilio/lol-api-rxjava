package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class LeagueDto {
    private String name;
    private LeagueEntryDto[] entries;
    private QueueType queue;
    private Tier tier;
    private String participantId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LeagueEntryDto[] getEntries() {
    	if (entries == null) {
    		return new LeagueEntryDto[0];
    	}

        return entries;
    }

    public void setEntries(LeagueEntryDto[] entries) {
        this.entries = entries;
    }

    public QueueType getQueue() {
        return queue;
    }

    public void setQueue(QueueType queue) {
        this.queue = queue;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    /**
     * Specifies the relevant participant that is a member of this
     * league (i.e., a requested summoner ID, a requested team ID,
     * or the ID of a team to which one of the requested summoners belongs).
     * Only present when full league is requested so that participant's entry
     * can be identified. Not present when individual entry is requested.
     *
     * @return some kind of relevant ID based on context or <code>null</code>
     */
    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }
}
