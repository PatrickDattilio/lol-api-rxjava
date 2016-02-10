package org.dc.riot.lol.rx;

class MissingFieldReport {
	
	private String[] missingFields;
	
	MissingFieldReport(String... missingFields) {
		this.missingFields = missingFields;
	}
	
	@Override
	public String toString() {
		String retVal = "";
		int i = 0;
		for (String s : missingFields) {
			retVal += s;
			i++;
			
			if (i < missingFields.length) {
				retVal += ", ";
			}
		}
		
		return retVal;
	}

}
