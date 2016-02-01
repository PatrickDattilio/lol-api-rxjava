package org.dc.riot.lol.rx.model;

/**
 * Featured game observers
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Observer {

    private String encryptionKey;

    /**
     * @return Key used to decrypt the spectator grid game data for playback 
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

}
