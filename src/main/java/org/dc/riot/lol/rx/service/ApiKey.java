package org.dc.riot.lol.rx.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Scanner;

/**
 * Primary entry point for using this service. Once an API key has been created
 * an {@link org.dc.riot.lol.rx.service.interfaces.ApiFactory ApiFactory} can
 * be created to generate HTTP network accessors to the LoL API.
 * 
 * @author Dc
 * @since 1.0
 */
public class ApiKey {
	// TODO add some kind of file encryption (RSA most likely, though symmetric encryption should be enough)
	
	private static final String DEVELOPMENT = "DEV";
	private static final String PRODUCTION = "PROD";

    private final String key;
    private final RateRule[] rules;
    
    private EnumMap<Region, TicketBucket> buckets = new EnumMap<>(Region.class);
    
    public ApiKey(String key, RateRule... rules) {
    	this.key = key;
    	this.rules = rules;
    }

    public RateRule[] getRules() {
    	return rules;
    }
    
    public TicketBucket getTicketBucket(Region region) {
    	TicketBucket tb = buckets.get(region);
    	if (tb == null) {
    		tb = new TicketBucket(rules);
    		buckets.put(region, tb);
    	}
    	
    	return tb;
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
     * @throws FileNotFoundException 
     */
    public static ApiKey[] loadApiKeys() throws FileNotFoundException {
    	return loadApiKeys(new File("./API_KEY"));
    }
    
    /**
     * Read API keys in the given file. This method exists as a convenience for
     * developers to load keys without command line or checking in API keys to
     * source control
     * @param file API key file to read
     * @return list of {@link ApiKey} found in the specified file
     * @throws FileNotFoundException 
     */
    public static ApiKey[] loadApiKeys(File file) throws FileNotFoundException {
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
