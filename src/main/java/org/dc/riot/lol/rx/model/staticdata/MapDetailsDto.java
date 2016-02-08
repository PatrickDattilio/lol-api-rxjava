package org.dc.riot.lol.rx.model.staticdata;

/**
 * This object contains map detail data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MapDetailsDto {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private ImageDto image;
    private long mapId;
    private String mapName;
    private long[] unpurchaseableItemList;
    
    public MapDetailsDto() {
    	COUNT++;
    }

    /**
     * @return Image data.
     */
    public ImageDto getImage() {
        return image;
    }

    /**
     * @return Map ID.
     */
    public long getMapId() {
        return mapId;
    }

    /**
     * @return Map name.
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * @return List of items (IDs) that cannot be
     * purchased on this map.
     */
    public long[] getUnpurchaseableItemList() {
        return unpurchaseableItemList;
    }
}
