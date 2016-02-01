package org.dc.riot.lol.rx.model;

import java.util.Map;

import org.dc.riot.lol.rx.model.summoner.MasteryDto;

/**
 * This object contains mastery list data.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class MasteryListDto {
    private Map<String, MasteryDto> data;
    private MasteryTreeDto tree;
    private String type;
    private String version;

    /**
     * @return Map with keys being the Mastery ID values
     */
    public Map<String, MasteryDto> getData() {
        return data;
    }

    public void setData(Map<String, MasteryDto> data) {
        this.data = data;
    }

    public MasteryTreeDto getTree() {
        return tree;
    }

    public void setTree(MasteryTreeDto tree) {
        this.tree = tree;
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
