package org.dc.riot.lol.rx.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controlled access to API keys. This allows users to have a file named API_KEY in their root
 * directory and load it without checking the API key into any source. This class mainly exists
 * to ensure unit tests have access to valid API keys, though client source code may find this class
 * useful as well.
 * TODO add some kind of file encryption (RSA most likely, though symmetric encryption should be enough)
 * @author Dc
 * @since 10/23/15
 */
public class ApiKey {

    public enum KeyType {
        /**
         * Development key with rages specified by Riot Games
         */
        DEVELOPMENT,

        /**
         * Production key with rates specified by Riot Games
         */
        PRODUCTION,

        /**
         * Custom rate key, with usually much higher rate limits than PRODUCTION
         */
        CUSTOM
    }

    private final String key;
    private final KeyType type;

    private ApiKey(String key, KeyType type) {
        this.key = key;
        this.type = type;
    }

    public boolean isDevelopmentKey() {
        return type == KeyType.DEVELOPMENT;
    }

    public KeyType getKeyType() {
        return type;
    }

    @Override
    public String toString() {
        return key;
    }

    public static ApiKey[] getApiKeys() {
        ArrayList<ApiKey> keys = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedInputStream(new FileInputStream(new File("./API_KEY"))));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if ("".equals(line.trim())) {
                    // skip over empty lines
                    continue;
                } else if (line.startsWith("#")) {
                    // skip over comments
                    continue;
                }

                String key = line.trim();
                boolean isDev = Boolean.valueOf(scanner.nextLine().trim());
                KeyType type;
                if (isDev) {
                    type = KeyType.DEVELOPMENT;
                } else {
                    type = KeyType.PRODUCTION;
                }

                keys.add(new ApiKey(key, type));
            }
        } catch (FileNotFoundException e) {
            // eat this exception
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return keys.toArray(new ApiKey[keys.size()]);
    }
}
