package org.dc.riot.lol.rx.model;

import java.util.List;

/**
 * @author Dc
 * @since 1.0.0
 */
public class MasteryPagesDto {
    private long summonerId;
    private List<MasteryPage> pages;

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public List<MasteryPage> getPages() {
        return pages;
    }

    public void setPages(List<MasteryPage> pages) {
        this.pages = pages;
    }
}
