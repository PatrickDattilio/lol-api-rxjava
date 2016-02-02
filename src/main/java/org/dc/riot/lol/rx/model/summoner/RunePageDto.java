package org.dc.riot.lol.rx.model.summoner;

/**
 * This object contains rune page information.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class RunePageDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private long id;
    private RuneSlotDto[] slots;
    private String name;
    private boolean current;
    
    public RunePageDto() {
    	COUNT++;
    }

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
