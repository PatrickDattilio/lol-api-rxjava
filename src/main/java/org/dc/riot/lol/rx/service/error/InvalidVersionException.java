package org.dc.riot.lol.rx.service.error;

/**
 * Thrown when the {@link org.dc.riotapi.service.RiotApiFactory} is called with an invalid version.
 * @author Dc
 * @since 9/30/15
 */
public class InvalidVersionException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5498594050115465286L;

	public InvalidVersionException() {
    }

    public InvalidVersionException(String message) {
        super(message);
    }

    public InvalidVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVersionException(Throwable cause) {
        super(cause);
    }

    public InvalidVersionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
