package org.dc.riot.lol.rx.model;

import java.util.Map;

/**
 * This object contains summoner spell list data.
 * Created by Dc on 10/3/15.
 */
public class SummonerSpellListDto {
    private Map<String, SummonerSpellDto> data;
    private String type;
    private String version;

    public Map<String, SummonerSpellDto> getData() {
        return data;
    }

    public void setData(Map<String, SummonerSpellDto> data) {
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
