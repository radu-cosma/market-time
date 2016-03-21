package com.markettime.exception;

import java.util.ArrayList;
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
    private String viewName;

    public ValidationErrorsException() {
        errors = new ArrayList<>();
    }

    public ValidationErrorsException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public ValidationErrorsException(List<ObjectError> errors, String viewName) {
        this.errors = errors;
        this.viewName = viewName;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

}
