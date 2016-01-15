package org.dc.riot.lol.rx.model;

/**
 * @author Dc
 * @since 1.0.0
 */
public class MasteryPagesDto {
    private long summonerId;
    private MasteryPage[] pages;

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public MasteryPage[] getPages() {
        return pages;
    }

    public void setPages(MasteryPage[] pages) {
        this.pages = pages;
    }
}
