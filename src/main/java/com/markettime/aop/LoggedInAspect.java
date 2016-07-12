package com.markettime.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.markettime.context.UserContext;
import com.markettime.exception.AuthenticationException;

/**
 *
 * @author Radu Cosma
 *
 */
@Aspect
@Component
public class LoggedInAspect {

    @Autowired
    private UserContext userContext;

    @Around("@annotation(com.markettime.aop.LoggedIn)")
    public Object loggedInAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (userContext.isLoggedIn()) {
            return proceedingJoinPoint.proceed();
        } else {
            throw new AuthenticationException("NOT.LOGGED.IN");
        }
    }

}
