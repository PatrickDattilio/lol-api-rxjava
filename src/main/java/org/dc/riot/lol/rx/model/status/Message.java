package org.dc.riot.lol.rx.model.status;

/**
 * Used by the Status API.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Message {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String author;
    private String content;
    private String createdAt;
    private Long id;
    private Severity severity;
    private Translation[] translations;
    private String updatedAt;
    
    public Message() {
    	COUNT++;
    }

    /**
     * @return The author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return The content.
     */
    public String getContent() {
        return content;
    }

    /**
     * @return The creation time.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return The ID or <code>-1</code> if
     * not defined.
     */
    public long getId() {
    	if (id == null) {
    		return -1;
    	}

        return id.longValue();
    }

    /**
     * @return The severity.
     */
    public Severity getSeverity() {
        return severity;
    }

    /**
     * @return Translations or empty if not defined.
     */
    public Translation[] getTranslations() {
    	if (translations == null) {
    		return new Translation[0];
    	}

        return translations;
    }

    /**
     * @return Last updated time.
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Severities.
     * 
     * @author Dc
     * @since 1.0.0
     */
    public enum Severity {
        Info, Alert, Error
    }
}
