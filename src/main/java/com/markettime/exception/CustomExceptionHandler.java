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
import org.springframework.web.servlet.NoHandlerFoundException;

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

    @ExceptionHandler(ValidationErrorsException.class)
    public ModelAndView handleValidationErrorsException(HttpServletRequest request, ValidationErrorsException e) {
        ModelAndView modelAndView = new ModelAndView();
        populateModel(modelAndView, request);
        // @formatter:off
        Map<String, String> validationErrors = e.getErrors().stream()
                .filter(error -> error instanceof FieldError)
                .map(error -> (FieldError) error)
                .collect(Collectors.toMap(FieldError::getField, fieldError -> buildErrorCodeMessageKey(fieldError)));
        // @formatter:on
        modelAndView.addObject("sessionContext", sessionContext);
        modelAndView.addObject("validationErrors", validationErrors);
        if (e.getViewName() != null) {
            modelAndView.setViewName(e.getViewName());
        } else {
            modelAndView.setViewName(getOriginalViewName(request));
        }
        return modelAndView;
    }

    private void populateModel(ModelAndView modelAndView, HttpServletRequest request) {
        Object dto = request.getAttribute("dto");
        Arrays.stream(dto.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                modelAndView.addObject(field.getName(), field.get(dto));
            } catch (Exception e) {
                LOGGER.warn("Could not add field with name '{}' to the model", field.getName());
            }
        });
    }

    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(HttpServletRequest request, ApplicationException e) {
        LOGGER.error("An exception occured!", e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sessionContext", sessionContext);
        modelAndView.addObject("generalError", e.getMessage());
        modelAndView.setViewName(getOriginalViewName(request));
        return modelAndView;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(NoHandlerFoundException e) {
        LOGGER.error("An exception occured!", e);
        return "error404";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception e) {
        LOGGER.error("An exception occured!", e);
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

    private String getOriginalViewName(HttpServletRequest request) {
        return request.getServletPath().substring(1);
    }
}
