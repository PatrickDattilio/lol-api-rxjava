package org.dc.riot.lol.rx.service.error;

/**
 * @author Dc
 * @since 9/27/15
 */
public class ForbiddenException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6333780024538054650L;

	public ForbiddenException(String forbidden) {
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(Throwable cause) {
        super(cause);
    }

    public ForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ForbiddenException() {
    }
}
