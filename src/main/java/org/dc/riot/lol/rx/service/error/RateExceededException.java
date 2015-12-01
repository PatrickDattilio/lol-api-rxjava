package org.dc.riot.lol.rx.service.error;

/**
 * Happens on a 429 HTTP response
 * @author Dc
 * @since 9/26/15
 */
public class RateExceededException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2640411543274108218L;

	public RateExceededException(String s) {
    }

    public RateExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateExceededException(Throwable cause) {
        super(cause);
    }

    public RateExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RateExceededException() {
    }
}
