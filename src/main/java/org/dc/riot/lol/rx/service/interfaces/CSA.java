package org.dc.riot.lol.rx.service.interfaces;

/**
 * CSA means Comma Separated Array
 * 
 * @author Dc
 * @since 1.0.0
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
			return null;
		}
	}
	
	static class Long extends CSA<java.lang.Long> {
		Long(java.lang.Long... ls) {
			super(ls);
		}

		Long(long... primvs) {
			if (primvs != null) {
				array = new java.lang.Long[primvs.length];
				for (int i=0; i<primvs.length; i++) {
					array[i] = new java.lang.Long(primvs[i]);
				}
			} else {
				array = null;
			}
		}
	}
}