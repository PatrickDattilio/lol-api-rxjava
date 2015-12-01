package org.dc.riot.lol.rx.service;

public class CommaSeparatedArray {
	
	private String[] array;
	
	public CommaSeparatedArray(String... s) {
		this.array = s;
	}
	
	public CommaSeparatedArray(long... l) {
		if (l != null) {
			String[] array = new String[l.length];
			for (int i=0; i<l.length; i++) {
				array[i] = String.valueOf(l[i]);
			}

			this.array = array;
		}
	}
	
	@Override
	public String toString() {
		if (array != null && array.length > 0) {
			String value = array[0];
			for (int i=1; i<array.length; i++) {
				value += "," + array[i];
			}
			
			return value;
		} else {
			return "";
		}
	}

}
