package org.dc.riot.lol.rx.service.error;

public class InvalidVersionException extends RuntimeException {

	private static final long serialVersionUID = 8428076567491029385L;

	public InvalidVersionException() { }

	public InvalidVersionException(String message) {
		super(message);
	}

	public InvalidVersionException(Throwable cause) {
		super(cause);
	}

	public InvalidVersionException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidVersionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
