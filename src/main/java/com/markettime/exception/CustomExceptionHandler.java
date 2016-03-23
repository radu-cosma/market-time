package com.markettime.exception;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.markettime.context.SessionContext;

/**
 *
 * @author Radu Cosma
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    private static final String DOT_DELIMITER = ".";
    private static final String UPPERCASE_REGEX = "(?=\\p{Upper})";

    @Autowired
    private SessionContext sessionContext;

    @ExceptionHandler(value = ValidationErrorsException.class)
    public ModelAndView handleValidationException(HttpServletRequest request, ValidationErrorsException e) {
        ModelAndView modelAndView = new ModelAndView();
        // @formatter:off
        Map<String, String> validationErrors = e.getErrors().stream()
                .filter(error -> error instanceof FieldError)
                .map(error -> (FieldError) error)
                .collect(Collectors.toMap(FieldError::getField, fieldError ->  buildErrorCodeMessageKey(fieldError)));
        // @formatter:on
        modelAndView.addObject("validationErrors", validationErrors);
        modelAndView.addObject("sessionContext", sessionContext);
        if (e.getViewName() != null) {
            modelAndView.setViewName(e.getViewName());
        }
        return modelAndView;
    }

    @ExceptionHandler(value = ApplicationException.class)
    public String handleApplicationException(HttpServletRequest request, ApplicationException e) {
        LOGGER.error(e.getMessage());
        return "error500";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception e) {
        LOGGER.error(e.getMessage());
        return "error500";
    }

    private String buildErrorCodeMessageKey(FieldError fieldError) {
        String objectName = fieldError.getObjectName();
        if (objectName.endsWith("Dto")) {
            objectName = objectName.substring(0, objectName.length() - 3);
        }
        return splitAndCapitalize(String.format("%s.%s%s", objectName, fieldError.getField(), fieldError.getCode()));
    }

    private String splitAndCapitalize(String s) {
        return Arrays.stream(s.split(UPPERCASE_REGEX)).map(str -> str.toUpperCase())
                .collect(Collectors.joining(DOT_DELIMITER));
    }
}
