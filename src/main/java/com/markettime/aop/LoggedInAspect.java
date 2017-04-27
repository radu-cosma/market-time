package com.markettime.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.markettime.context.UserContext;
import com.markettime.exception.AuthenticationException;
import com.markettime.exception.NotLoggedInException;

/**
 *
 * @author Radu Cosma
 *
 */
@Aspect
@Order(2)
@Component
public class LoggedInAspect {

    @Autowired
    private UserContext userContext;

    @Pointcut("@annotation(com.markettime.aop.LoggedIn)")
    public void anyMethodAnnotatedWithLoggedIn() {
    }

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void anyMethodFromAnyTypeAnnotatedWithController() {
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void anyMethodFromAnyTypeAnnotatedWithRestController() {
    }

    @Around("anyMethodAnnotatedWithLoggedIn() && anyMethodFromAnyTypeAnnotatedWithController()")
    public Object loggedInAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (userContext.isLoggedIn()) {
            return proceedingJoinPoint.proceed();
        } else {
            throw new NotLoggedInException(
                    String.format("Cannot acces %s while not logged in.", proceedingJoinPoint.getSignature()));
        }
    }

    @Around("anyMethodAnnotatedWithLoggedIn() && anyMethodFromAnyTypeAnnotatedWithRestController()")
    public Object restLoggedInAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (userContext.isLoggedIn()) {
            return proceedingJoinPoint.proceed();
        } else {
            throw new AuthenticationException("NOT.LOGGED.IN");
        }
    }

}
