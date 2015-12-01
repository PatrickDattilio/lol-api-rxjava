package org.dc.riot.lol.rx.model;

import java.util.Map;

/**
 * This object contains rune list data.
 * Created by Dc on 10/2/15.
 */
public class RuneListDto {
    private BasicDataDto basic;
    private Map<String, RuneDto> data;
    private String type;
    private String version;

    public BasicDataDto getBasic() {
        return basic;
    }

    public void setBasic(BasicDataDto basic) {
        this.basic = basic;
    }

    public Map<String, RuneDto> getData() {
        return data;
    }

    public void setData(Map<String, RuneDto> data) {
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
