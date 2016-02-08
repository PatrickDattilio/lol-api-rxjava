package org.dc.riot.lol.rx;

import java.lang.reflect.Field;
import java.util.HashMap;

public class RESTFieldRegister {
	private HashMap<Class<?>, Field[]> seenFields = new HashMap<>();
	
	public void registerInstance(Object o) {
		Class<?> clazz = o.getClass();
		Field[] knownFields = seenFields.get(clazz);
		for (Field f : clazz.getFields()) {
			// TODO implement
		}
	}
}
