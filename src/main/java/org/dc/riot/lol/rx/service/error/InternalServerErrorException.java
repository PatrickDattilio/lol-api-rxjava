package org.dc.riot.lol.rx.service.error;

/**
 * Happens on a 503 HTTP response
 * @author Dc
 * @since 9/26/15
 */
public class InternalServerErrorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3573818590272285928L;

	public InternalServerErrorException() {
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }

    public InternalServerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
