package com.markettime.util;

/**
 *
 * @author Radu Cosma
 *
 */
public class Constants {

    private Constants() {

    }

    public static final int SESSION_LIFETIME_SECONDS = 3600;
    public static final int SESSION_LIFETIME_MILLIS = SESSION_LIFETIME_SECONDS * 1000;

    /**
     * validation
     */

    public static final String VALIDATION_NOT_NULL = "NotNull";
    public static final String VALIDATION_NOT_EMPTY = "NotEmpty";
    public static final String VALIDATION_SIZE = "Size";
    public static final String VALIDATION_PATTERN = "Pattern";
    public static final String VALIDATION_MIN = "Min";

    /**
     * message keys
     */

    public static final String ADD_PRODUCT_SUCCESS_MESSAGE_KEY = "ADD.PRODUCT.SUCCESS.MESSAGE";

}
