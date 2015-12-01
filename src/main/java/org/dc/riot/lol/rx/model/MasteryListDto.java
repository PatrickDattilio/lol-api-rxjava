package org.dc.riot.lol.rx.model;

import java.util.Map;

/**
 * This object contains mastery list data.
 * Created by Dc on 10/2/15.
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
