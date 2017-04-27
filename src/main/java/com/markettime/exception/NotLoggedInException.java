package com.markettime.exception;

/**
 *
 * @author Radu Cosma
 *
 */
public class NotLoggedInException extends AuthenticationException {

    private static final long serialVersionUID = -4750492014375379873L;

    public NotLoggedInException() {

    }

    public NotLoggedInException(String message) {
        super(message);
    }

    public NotLoggedInException(Throwable cause) {
        super(cause);
    }
}
