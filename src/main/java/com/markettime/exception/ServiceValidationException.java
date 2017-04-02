package com.markettime.exception;

/**
 *
 * @author Radu Cosma
 *
 */
public class ServiceValidationException extends RuntimeException {

    private static final long serialVersionUID = -1243045893900546864L;

    public ServiceValidationException() {

    }

    public ServiceValidationException(String message) {
        super(message);
    }

    public ServiceValidationException(Throwable t) {
        super(t);
    }
}
