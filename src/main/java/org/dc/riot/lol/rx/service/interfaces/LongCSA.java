package org.dc.riot.lol.rx.service.interfaces;

public class LongCSA extends CSA<Long> {

	public LongCSA(Long... ts) {
		super(ts);
	}
	
	public LongCSA(long... primvs) {
		array = new Long[primvs.length];
		for (int i=0; i<primvs.length; i++) {
			array[i] = new Long(primvs[i]);
		}
	}

}
