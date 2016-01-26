package org.dc.riot.lol.rx.model;

/**
 * Current game participant
 * 
 * @author Dc
 * @since 1.0.0
 */
public class CurrentGameParticipant {
    private boolean bot;
    private long championId;
    private MasteryMetaDto[] masteries;
    private long profileIconId;
    private RuneMetaDto[] runes;
    private long spell1Id;
    private long spell2Id;
    private long summonerId;
    private String summonerName;
    private long teamId;

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public MasteryMetaDto[] getMasteries() {
        return masteries;
    }

    public void setMasteries(MasteryMetaDto[] masteries) {
        this.masteries = masteries;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public RuneMetaDto[] getRunes() {
        return runes;
    }

    public void setRunes(RuneMetaDto[] runes) {
        this.runes = runes;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(long spell1Id) {
        this.spell1Id = spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(long spell2Id) {
        this.spell2Id = spell2Id;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
