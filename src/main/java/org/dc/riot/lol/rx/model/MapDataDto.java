package org.dc.riot.lol.rx.model;

import java.util.Map;

/**
 * Contains data about the map
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MapDataDto {
    private Map<String, MapDetailsDto> data;
    private String type;
    private String version;

    public Map<String, MapDetailsDto> getData() {
        return data;
    }

    public void setData(Map<String, MapDetailsDto> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
