package com.markettime.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 *
 * @author Radu Cosma
 *
 */
public class ValidationUtil {

    private static final String DOT_DELIMITER = ".";
    private static final String UPPERCASE_REGEX = "(?=\\p{Upper})";

    private ValidationUtil() {

    }

    /**
     *
     * @param errors
     * @return
     */
    public static Map<String, String> extractValidationErrors(List<ObjectError> errors) {
        // @formatter:off
        return errors.stream()
                .filter(error -> error instanceof FieldError)
                .map(error -> (FieldError) error)
                .collect(Collectors.toMap(FieldError::getField, fieldError ->  buildErrorCodeMessageKey(fieldError)));
        // @formatter:on
    }

    private static String buildErrorCodeMessageKey(FieldError fieldError) {
        String objectName = fieldError.getObjectName();
        if (objectName.endsWith("RequestDto")) {
            objectName = objectName.substring(0, objectName.length() - 10);
        }
        return splitAndCapitalize(
                String.format("%s.%s%s", objectName, fieldError.getField(), fieldError.getDefaultMessage()));
    }

    private static String splitAndCapitalize(String s) {
        return Arrays.stream(s.split(UPPERCASE_REGEX)).map(str -> str.toUpperCase())
                .collect(Collectors.joining(DOT_DELIMITER));
    }
}
