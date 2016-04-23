package com.markettime.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.markettime.context.SessionContext;
import com.markettime.service.SessionContextService;

/**
 *
 * @author Radu Cosma
 *
 */
public class SessionContextInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private SessionContextService sessionContextService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        sessionContextService.initializeSessionContext(request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("sessionContext", sessionContext);
    }

}
