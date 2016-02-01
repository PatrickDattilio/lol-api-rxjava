package org.dc.riot.lol.rx.model.status;

/**
 * Used by the Status API
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Message {

    private String author;
    private String content;
    private String createdAt;
    private long id;
    private Severity severity;
    private Translation[] translations;
    private String updatedAt;

    /**
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return The content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return The creation time
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The ID
     */
    public long getId() {
        return id;
    }

    /**
     * @return The severity
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
     * @return Translations
     */
    public Translation[] getTranslations() {
        return translations;
    }

    /**
     * @return Last updated time
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    public enum Severity {
        Info, Alert, Error
    }
}
