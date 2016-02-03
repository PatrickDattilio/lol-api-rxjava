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

    private long id;
    private String name;
    private int num;
    
    public SkinDto() {
    	COUNT++;
    }

    /**
     * @return ID.
     */
    public long getId() {
        return id;
    }

    /**
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Number (i.e. skin index).
     */
    public int getNum() {
        return num;
    }
}
