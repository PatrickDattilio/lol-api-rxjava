package org.dc.riot.lol.rx.service.error;

/**
 * Happens on a 500 HTTP response
 * @author Dc
 * @since 9/26/15
 */
public class ServiceUnavailableException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3343767153729673762L;

	public ServiceUnavailableException() {
    }

    public ServiceUnavailableException(String message) {
        super(message);
    }

    public ServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUnavailableException(Throwable cause) {
        super(cause);
    }

    public ServiceUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
