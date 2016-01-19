package org.dc.riot.lol.rx.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dc
 * @since 1.0.0
 */
public class ChampionListDto {
    private Map<String, ChampionDto> data = new HashMap<>();
    private String format;
    private Map<String, String> keys = new HashMap<>();
    private String type;
    private String version;
    
    public Map<String, ChampionDto> getData() {
        return data;
    }

    public void setData(Map<String, ChampionDto> data) {
        this.data = data;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Map<String, String> getKeys() {
        return keys;
    }

    public void setKeys(Map<String, String> keys) {
        this.keys = keys;
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
