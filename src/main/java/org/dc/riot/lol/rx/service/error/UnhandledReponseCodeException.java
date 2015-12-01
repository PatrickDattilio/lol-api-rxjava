package org.dc.riot.lol.rx.service.error;

/**
 * @author Dc
 * @since 9/29/15
 */
public class UnhandledReponseCodeException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5046953092500686389L;

	public UnhandledReponseCodeException() {
    }

    public UnhandledReponseCodeException(String message) {
        super(message);
    }

    public UnhandledReponseCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnhandledReponseCodeException(Throwable cause) {
        super(cause);
    }

    public UnhandledReponseCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
