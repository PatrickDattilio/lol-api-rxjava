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
    private String created_at;
    private String id;
    private Severity severity;
    private Translation[] translations;
    private String updated_at;
    
    public Message() {
    	COUNT++;
    }

    /**
     * Sometimes explicitly defined as <code>null</code> in JSON
     * response.
     * 
     * @return Author or <code>null</code>.
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
     * @return The creation time or <code>null</code> if not defined.
     */
    public String getCreatedAt() {
        return created_at;
    }

    /**
     * Changed in 1.0.1 to return a String instead of a Long.
     * 
     * @return The ID.
     */
    public String getId() {
    	return id;
    }

    /**
     * @return Severity or <code>null</code> if not defined.
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
     * @return Last updated time or <code>null</code>
     * if not defined.
     */
    public String getUpdatedAt() {
        return updated_at;
    }

    /**
     * Severities.
     * 
     * @author Dc
     * @since 1.0.0
     */
    public enum Severity {
        Info, info, Alert, alert, Error, error
    }
}
