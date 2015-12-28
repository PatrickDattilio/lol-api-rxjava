package org.dc.riot.lol.rx.service.error;

import java.util.List;
import java.util.Map;

public class HttpException extends RuntimeException {

	private static final long serialVersionUID = 3459542909713569750L;
	private int code;
	private Map<String, List<String>> headers;

	public HttpException(int code, Map<String,List<String>> headers) {
		this.code = code;
		this.headers = headers;
	}

	public HttpException(int code, Map<String,List<String>> headers, String message) {
		super(message);
		this.code = code;
		this.headers = headers;
	}

	public HttpException(int code, Map<String,List<String>> headers, Throwable cause) {
		super(cause);
		this.code = code;
		this.headers = headers;
	}

	public HttpException(int code, Map<String,List<String>> headers, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.headers = headers;
	}

	public HttpException(int code, Map<String,List<String>> headers, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
		this.headers = headers;
	}
	
	public int getCode() {
		return code;
	}
	
	public Map<String, List<String>> getHeaders() {
		return headers;
	}

}
