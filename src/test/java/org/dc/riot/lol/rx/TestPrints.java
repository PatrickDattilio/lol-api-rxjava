package org.dc.riot.lol.rx;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestPrints {
	
	private static final TestPrints INSTANCE = new TestPrints();
	
	public static TestPrints getInstance() {
		return INSTANCE;
	}

	private PrintStream outputStream = System.out;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.sss");
	
	private TestPrints() { }
	
	public void setOutputStream(PrintStream ps) {
		outputStream = ps;
	}
	
	public void println(long l) {
		println(new Long(l));
	}
	
	public void println(String tag, long l) {
		println(tag, new Long(l));
	}
	
	public void println(int i) {
		println(new Integer(i));
	}

	public void println(String tag, int i) {
		println(tag, new Integer(i));
	}
	
	public void println(Object o) {
		if (o == null) {
			outputStream.println();
		} else {
			outputStream.println("[DEBUG " + sdf.format(new Date(System.currentTimeMillis())) + "] " + o);
		}
	}
	
	public void println(String tag, Object o) {
		outputStream.println("[" + tag + " " + sdf.format(new Date(System.currentTimeMillis())) + "] " + o);
	}
}
