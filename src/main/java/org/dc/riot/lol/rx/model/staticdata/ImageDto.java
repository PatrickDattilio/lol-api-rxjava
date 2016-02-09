package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains image data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class ImageDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String full;
    private String group;
    private String sprite;
    private Integer h;
    private Integer w;
    private Integer x;
    private Integer y;
    
    public ImageDto() {
    	COUNT++;
    }

    /**
     * @return Full.
     */
    public String getFull() {
        return full;
    }

    /**
     * @return Group.
     */
    public String getGroup() {
        return group;
    }

    /**
     * @return Sprite data. Base64 image data?
     */
    public String getSprite() {
        return sprite;
    }

    /**
     * @return Height or <code>-1</code> if not defined.
     */
    public int getH() {
    	if (h == null) {
    		return -1;
    	}

        return h.intValue();
    }

    /**
     * @return Width or <code>-1</code> if not defined.
     */
    public int getW() {
    	if (w == null) {
    		return -1;
    	}

        return w.intValue();
    }

    /**
     * @return X coordinate or <code>-1</code> if not defined.
     */
    public int getX() {
    	if (x == null) {
    		return -1;
    	}

        return x.intValue();
    }

    /**
     * @return Y coordinate or <code>-1</code> if not defined.
     */
    public int getY() {
    	if (y == null) {
    		return -1;
    	}

        return y.intValue();
    }
}