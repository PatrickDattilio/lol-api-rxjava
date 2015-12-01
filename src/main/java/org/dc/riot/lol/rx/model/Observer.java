package org.dc.riot.lol.rx.model;

/**
 * Current game observers
 * Created by Dan on 9/2/15.
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
