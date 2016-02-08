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

    private Long id;
    private RuneSlotDto[] slots;
    private String name;
    private Boolean current;
    
    public RunePageDto() {
    	COUNT++;
    }

    /**
     * @return Rune page ID or <code>-1</code>
     * if not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id.longValue();
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
     * @return Indicates if the page is the current page
     * or <code>false</code> if not defined.
     */
    public boolean isCurrent() {
    	if (current == null) {
    		return false;
    	}

        return current.booleanValue();
    }
}
