package com.markettime.exception;

/**
 *
 * @author Radu Cosma
 *
 */
public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = -1509670596562597041L;

    public ApplicationException() {

    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

}
