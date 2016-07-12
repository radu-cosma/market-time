package com.markettime.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

/**
 *
 * @author Radu Cosma
 *
 */
public class ValidationErrorsException extends RuntimeException {

    private static final long serialVersionUID = 4000021457223671758L;

    private List<ObjectError> errors;

    public ValidationErrorsException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

}
