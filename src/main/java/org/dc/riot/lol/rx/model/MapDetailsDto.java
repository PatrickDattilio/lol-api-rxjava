package org.dc.riot.lol.rx.model;

/**
 * This object contains map detail data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MapDetailsDto {
    private ImageDto image;
    private long mapId;
    private String mapName;
    private long[] unpurchaseableItemList;

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public long[] getUnpurchaseableItemList() {
        return unpurchaseableItemList;
    }

    public void setUnpurchaseableItemList(long[] unpurchaseableItemList) {
        this.unpurchaseableItemList = unpurchaseableItemList;
    }
}
