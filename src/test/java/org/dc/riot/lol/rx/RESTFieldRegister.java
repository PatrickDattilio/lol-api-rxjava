package org.dc.riot.lol.rx;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;

public class RESTFieldRegister {
	private HashMap<String, ArrayList<String>> seenFields = new HashMap<>();
	
	public void registerInstance(Object o) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = o.getClass();
		ArrayList<String> knownFields = seenFields.get(clazz.getName());
		if (knownFields == null) {
			knownFields = new ArrayList<>();
			seenFields.put(clazz.getName(), knownFields);
		}

		for (Field f : clazz.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}

			f.setAccessible(true);
			if (f.get(o) != null) {
				if (!knownFields.contains(f.getName())) {
					knownFields.add(f.getName());
				}
			}
		}
	}
	
	/**
	 * Check if all fields have been accounted for.
	 * 
	 * @param clazz class object to test
	 * @return <code>null</code> if all fields are accounted for
	 * (i.e. success) or the name of the offending field if failed.
	 */
	public MissingFieldReport testClass(Class<?> clazz) {
		return testClass(clazz, (String[]) null);
	}
	
	/**
	 * Check if all fields have been accounted for.
	 * 
	 * @param clazz class object to test
	 * @param exceptions list of fields that are allowed to never be found
	 * @return <code>null</code> if all fields are accounted for
	 * (i.e. success) or the name of the offending field if failed.
	 */
	public MissingFieldReport testClass(Class<?> clazz, String... exceptions) {
		ArrayList<String> fields = seenFields.get(clazz.getName());
		if (fields == null) {
			return new MissingFieldReport("Class not registered");
		}

		ArrayList<String> missingFields = new ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}

			String fieldName = f.getName();
			boolean isException = false;
			if (exceptions != null) {
				for (String e : exceptions) {
					if (fieldName.equals(e)) {
						isException = true;
						break;
					}
				}
			}

			if (!isException && !fields.contains(fieldName)) {
				missingFields.add(fieldName);
			}
		}
		
		if (missingFields.isEmpty()) {
			return null;
		} else {
			return new MissingFieldReport(missingFields.toArray(new String[missingFields.size()]));
		}
	}
	
	@Override
	public String toString() {
		String retVal = "";
		
		String[] clazzes = seenFields.keySet().toArray(new String[seenFields.size()]);
		for (int i=0; i<clazzes.length; i++) {
			String clazz = clazzes[i];
			retVal += clazz + " -> ";
			
			ArrayList<String> fields = seenFields.get(clazz);
			for (int j=0; j<fields.size(); j++) {
				String fieldName = fields.get(j);
				retVal += fieldName;
				if (j < fields.size() - 1) {
					retVal += ",";
				}
			}
			
			if (i < clazzes.length - 1) {
				retVal += "\n\t";
			}
		}
		
		return retVal;
	}
}
