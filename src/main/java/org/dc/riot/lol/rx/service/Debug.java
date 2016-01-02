package org.dc.riot.lol.rx.service;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Debug implements Interceptor {
	
	private static final Debug INSTANCE = new Debug();
	
	public static Debug getInstance() {
		return INSTANCE;
	}

	private boolean debug = false;
	private PrintStream outputStream = System.out;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.sss");
	
	private Debug() { }
	
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	public void setOutputStream(PrintStream ps) {
		outputStream = ps;
	}
	
	public void println(long l) {
		println(new Long(l));
	}
	
	public void println(int i) {
		println(new Integer(i));
	}
	
	public void println(Object o) {
		if (o == null) {
			outputStream.println();
		} else {
			outputStream.println("[DEBUG " + sdf.format(new Date(System.currentTimeMillis())) + "] " + o);
		}
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
		if (debug) {
			println(request.url());
		}
		
		return chain.proceed(request);
	}

}
