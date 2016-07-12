package com.markettime.util;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

/**
 *
 * @author Radu Cosma
 *
 */
public class BeanMapperUtil {

    private BeanMapperUtil() {
    }

    private static Mapper getMapper() {
        return DozerBeanMapperSingletonWrapper.getInstance();
    }

    /**
     * Maps the source's fields to the corresponding destination's fields.
     *
     * @param source
     * @param destination
     * @return
     */
    public static <T, U> void map(final T source, final U destination) {
        getMapper().map(source, destination);
    }

    /**
     * Converts an existing instance of type T to a new instance of type U.
     *
     * @param source
     * @param destinationType
     * @return
     */
    public static <T, U> U map(final T source, final Class<U> destinationType) {
        return getMapper().map(source, destinationType);
    }

}
