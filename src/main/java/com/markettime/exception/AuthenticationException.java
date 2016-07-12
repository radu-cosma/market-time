package com.markettime.exception;

/**
 *
 * @author Radu Cosma
 *
 */
public class AuthenticationException extends ApplicationException {

    private static final long serialVersionUID = -6216203213553485205L;

    public AuthenticationException() {

    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }
}
