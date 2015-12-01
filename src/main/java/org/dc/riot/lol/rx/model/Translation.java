package org.dc.riot.lol.rx.model;

/**
 * Used by the Status API
 * Created by Dc on 9/19/15.
 */
public class Translation {
    private String content;
    private String updatedAt;
    private String locale;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
