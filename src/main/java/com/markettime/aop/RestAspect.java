package com.markettime.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.markettime.exception.ValidationErrorsException;
import com.markettime.model.dto.response.RestResponseDto;
import com.markettime.util.ValidationUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@Aspect
@Order(1)
@Component
public class RestAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAspect.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void anyMethodFromAnyTypeAnnotatedWithRestController() {
    }

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod() {
    }

    @Around("anyMethodFromAnyTypeAnnotatedWithRestController() && anyPublicMethod()")
    public Object restAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        RestResponseDto restResponseDto = new RestResponseDto();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
            restResponseDto.setResult(result);
        } catch (ValidationErrorsException e) {
            LOGGER.error("Input validation failed!", e);
            restResponseDto.setValidationErrors(ValidationUtil.extractValidationErrors(e.getErrors()));
        } catch (Exception e) {
            LOGGER.error("An exception occurred!", e);
            restResponseDto.setGeneralError(
                    "Oops! It seems we're having some issues... Please refresh the page and try again.");
        }
        return restResponseDto;
    }

}
