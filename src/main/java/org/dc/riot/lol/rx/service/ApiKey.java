package org.dc.riot.lol.rx.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controlled access to API keys. This allows users to have a file named API_KEY in their root
 * directory and load it without checking the API key into any source control. This class mainly exists
 * to ensure unit tests have access to valid API keys, though client source code may find this class
 * useful as well.
 * TODO add some kind of file encryption (RSA most likely, though symmetric encryption should be enough)
 * @author Dc
 * @since 1.0
 */
public class ApiKey {
	
	private static final String DEVELOPMENT = "DEV";
	private static final String PRODUCTION = "PROD";

    private final String key;
    private final RateRule[] rules;
    
    public ApiKey(String key, RateRule... rules) {
    	this.key = key;
    	this.rules = rules;
    }

    public RateRule[] getRules() {
    	return rules;
    }

    @Override
    public String toString() {
        return key;
    }

    /**
     * Read API keys in the file ./API_KEY. This method exists as a convenience for
     * developers to load keys without command line or checking in API keys to
     * source control
     * @return list of {@link ApiKey} found in the API_KEY file
     */
    public static ApiKey[] loadApiKeys() {
    	return loadApiKeys(new File("./API_KEY"));
    }
    
    /**
     * Read API keys in the given file. This method exists as a convenience for
     * developers to load keys without command line or checking in API keys to
     * source control
     * @param file API key file to read
     * @return list of {@link ApiKey} found in the specified file
     */
    public static ApiKey[] loadApiKeys(File file) {
        ArrayList<ApiKey> keys = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)));
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
                String keyDetails = scanner.nextLine().trim();
                RateRule[] rules = null;
                if (DEVELOPMENT.equals(keyDetails)) {
                	rules = RateRule.getDevelopmentRates();
                } else if (PRODUCTION.equals(keyDetails)) {
                	rules = RateRule.getProductionRates();
                } else {
                	rules = parseRules(keyDetails, scanner);
                }
                
                keys.add(new ApiKey(key, rules));
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
    
    private static RateRule[] parseRules(String keyDetails, Scanner scanner) {
    	ArrayList<RateRule> parsedRules = new ArrayList<>();
    	parsedRules.add(RateRule.from(keyDetails));
    	
    	while (scanner.hasNextLine()) {
    		String line = scanner.nextLine().trim();
    		if ("".equals(line) ||
    				line.startsWith("#")) {
    			break;
    		} else {
				parsedRules.add(RateRule.from(line));
    		}
    	}
    	
    	return parsedRules.toArray(new RateRule[parsedRules.size()]);
    }
}
