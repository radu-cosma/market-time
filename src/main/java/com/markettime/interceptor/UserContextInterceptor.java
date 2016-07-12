package com.markettime.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.markettime.service.UserContextService;

/**
 *
 * @author Radu Cosma
 *
 */
public class UserContextInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserContextService userContextService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        userContextService.initializeUserContext(request);
        return true;
    }

}
