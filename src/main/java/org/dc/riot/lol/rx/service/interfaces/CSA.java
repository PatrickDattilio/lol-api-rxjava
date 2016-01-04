package org.dc.riot.lol.rx.service.interfaces;

/**
 * CSA means Comma Separated Array
 * @author Dc
 * @since 1.0
 *
 * @param <T>
 */
class CSA<T> {
	
	protected T[] array;
	
	@SafeVarargs
	CSA(T... ts) {
		this.array = ts;
	}

	@Override
	public String toString() {
		if (array != null && array.length > 0) {
			String value = array[0].toString();
			for (int i=1; i<array.length; i++) {
				value += "," + array[i];
			}
			
			return value;
		} else {
			return "";
		}
	}
}