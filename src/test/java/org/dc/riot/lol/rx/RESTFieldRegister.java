package org.dc.riot.lol.rx;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;

public class RESTFieldRegister {
	private HashMap<Class<?>, ArrayList<String>> seenFields = new HashMap<>();
	
	public void registerInstance(Object o) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = o.getClass();
		ArrayList<String> knownFields = seenFields.get(clazz);
		if (knownFields == null) {
			knownFields = new ArrayList<>();
			seenFields.put(clazz, knownFields);
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
	 * @return Whether all fields have been accounted for.
	 */
	public boolean testClass(Class<?> clazz) {
		ArrayList<String> fields = seenFields.get(clazz);
		if (fields == null) {
			return false;
		}

		for (Field f : clazz.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}

			String fieldName = f.getName();
			if (!fields.contains(fieldName)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		String retVal = "";
		
		Class<?>[] clazzes = seenFields.keySet().toArray(new Class<?>[seenFields.size()]);
		for (int i=0; i<clazzes.length; i++) {
			Class<?> clazz = clazzes[i];
			retVal += clazz.getSimpleName() + " -> ";
			
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
