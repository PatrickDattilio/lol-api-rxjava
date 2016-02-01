package org.dc.riot.lol.rx.model.summoner;

/**
 * @author Dc
 * @since 1.0.0
 */
public class RunePageDto {
    private long id;
    private RuneSlotDto[] slots;
    private String name;
    private boolean current;

    /**
     * @return Rune page ID.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Collection of rune slots associated with the rune page.
     */
    public RuneSlotDto[] getSlots() {
    	if (slots == null) {
    		return new RuneSlotDto[0];
    	}

        return slots;
    }

    /**
     * @return Rune page name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Indicates if the page is the current page.
     */
    public boolean isCurrent() {
        return current;
    }
}
