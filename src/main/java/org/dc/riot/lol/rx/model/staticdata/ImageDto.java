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
    private int h;
    private int w;
    private int x;
    private int y;
    
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
     * @return Height.
     */
    public int getH() {
        return h;
    }

    /**
     * @return Width.
     */
    public int getW() {
        return w;
    }

    /**
     * @return X coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y coordinate.
     */
    public int getY() {
        return y;
    }
}