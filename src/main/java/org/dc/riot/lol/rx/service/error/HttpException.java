package org.dc.riot.lol.rx.service.error;

import java.util.List;
import java.util.Map;

/**
 * Exception class wrapping HTTP error codes.
 * 
 * @author Dc
 * @since 1.0
 * @see {@link #getCode()}
 * @see {@link #getHeaders()}
 */
public class HttpException extends Exception {
	private static final long serialVersionUID = 9125763118458524121L;
	private int code;
	private Map<String, List<String>> headers;

	public HttpException(int code, Map<String, List<String>> headers) {
		super();
		this.code = code;
		this.headers = headers;
	}

	public HttpException(String message, int code, Map<String, List<String>> headers) {
		super(message);
		this.code = code;
		this.headers = headers;
	}

	public HttpException(Throwable cause, int code, Map<String, List<String>> headers) {
		super(cause);
		this.code = code;
		this.headers = headers;
	}

	public HttpException(String message, Throwable cause, int code, Map<String, List<String>> headers) {
		super(message, cause);
		this.code = code;
		this.headers = headers;
	}

	public HttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, Map<String, List<String>> headers) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
		this.headers = headers;
	}

	/**
	 * @return the response code of the HTTP response that
	 * caused this exception
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the headers of the HTTP response that
	 * caused this exception
	 */
	public Map<String, List<String>> getHeaders() {
		return headers;
	}

}
