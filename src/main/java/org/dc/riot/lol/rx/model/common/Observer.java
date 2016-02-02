package org.dc.riot.lol.rx.model.common;

/**
 * Featured game observers.
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Observer {
	private static long COUNT = 0;
	public static long getInstanceCount() {
		return COUNT;
	}
	
    private String encryptionKey;
    
    public Observer() {
    	COUNT++;
    }

    /**
     * @return Key used to decrypt the spectator grid game data for playback 
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

}
