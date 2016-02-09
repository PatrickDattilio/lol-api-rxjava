package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains champion skin data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class SkinDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private Long id;
    private String name;
    private Integer num;
    
    public SkinDto() {
    	COUNT++;
    }

    /**
     * @return ID or <code>-1</code> if not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id.longValue();
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Number (i.e. skin index) or
     * <code>-1</code> if not defined.
     */
    public int getNum() {
    	if (num == null) {
    		return -1;
    	}

        return num.intValue();
    }
}
