package com.markettime.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.markettime.context.SessionContext;
import com.markettime.model.Session;
import com.markettime.service.SessionService;

/**
 * 
 * @author Radu Cosma
 * 
 */
public class SessionContextInterceptor extends HandlerInterceptorAdapter {

    private static final String UUID_COOKIE_NAME = "uuid";

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private SessionService sessionService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookiez = request.getCookies();
        if (cookiez != null) {
            for (Cookie cookie : cookiez) {
                if (UUID_COOKIE_NAME.equals(cookie.getName())) {
                    Session session = sessionService.getUpdatedSession(cookie.getValue());
                    if (session != null) {
                        sessionContext.setLoggedIn(true);
                        sessionContext.setUsername(session.getUsername());
                        sessionContext.setSession(session);
                        renewCookie(cookie);
                    }
                }
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        sessionContext.destroySession();
        modelAndView.addObject("sessionContext", sessionContext);
    }

    private void renewCookie(Cookie cookie) {
        cookie.setMaxAge(600);
    }
}
