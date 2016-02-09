package org.dc.riot.lol.rx;

public class TestPojo {
	private Integer someInt = null;
	private Long someLong = null;
	private Double someDouble = null;
	private String someString = null;
	private Object someObject = null;

	public Integer getSomeInt() {
		if (someInt == null) {
			return new Integer(-1);
		}

		return someInt;
	}

	public Long getSomeLong() {
		if (someLong == null) {
			return new Long(-1);
		}

		return someLong;
	}

	public Double getSomeDouble() {
		if (someDouble == null) {
			return new Double(-1);
		}

		return someDouble;
	}
	
	public String getSomeString() {
		return someString;
	}
	
	public Object getSomeObject() {
		return someObject;
	}
	
	public TestPojo withInteger(Integer someInt) {
		this.someInt = someInt;
		return this;
	}
	
	public TestPojo withLong(Long someLong) {
		this.someLong = someLong;
		return this;
	}
	
	public TestPojo withDouble(Double someDouble) {
		this.someDouble = someDouble;
		return this;
	}
	
	public TestPojo withString(String someString) {
		this.someString = someString;
		return this;
	}
	
	public TestPojo withObject(Object someObject) {
		this.someObject = someObject;
		return this;
	}
}
