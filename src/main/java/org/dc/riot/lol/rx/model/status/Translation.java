package org.dc.riot.lol.rx.model.status;

/**
 * Used by the Status API.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Translation {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}

    private String content;
    private String updatedAt;
    private String locale;
    
    public Translation() {
    	COUNT++;
    }

    /**
     * @return The locale.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @return Last update time.
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return The content.
     */
    public String getContent() {
        return content;
    }
}
