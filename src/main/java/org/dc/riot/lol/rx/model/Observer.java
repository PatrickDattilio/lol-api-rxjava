package org.dc.riot.lol.rx.model;

/**
 * Current game observers
 * 
 * @author Dc
 * @since 1.0.0
 */
public class Observer {
    private String encryptionKey;

    public Observer() { }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

}
