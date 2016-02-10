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
    private Long mapId;
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
     * @return Map ID or <code>-1</code> if not defined.
     */
    public long getMapId() {
    	if (mapId == null) {
    		return -1;
    	}

        return mapId.longValue();
    }

    /**
     * @return Map name.
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * Implementation note: may be deprecated.
     * 
     * @return List of items (IDs) that cannot be
     * purchased on this map.
     */
    public long[] getUnpurchaseableItemList() {
    	if (unpurchaseableItemList == null) {
    		return new long[0];
    	}

        return unpurchaseableItemList;
    }
}
