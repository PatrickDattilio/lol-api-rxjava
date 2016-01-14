package org.dc.riot.lol.rx.model;

import java.util.Map;

/**
 * Language Strings data. Various language data (insert 26 languages meme here).
 * 
 * @author Dc
 * @since 1.0.0
 */
public class LanguageStringsDto {
    private Map<String, String> data;
    private String type;
    private String version;

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
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
