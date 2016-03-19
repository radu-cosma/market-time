package com.markettime.interceptor;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.markettime.context.SessionContext;
import com.markettime.model.entity.UserEntity;
import com.markettime.model.entity.UserSessionEntity;
import com.markettime.repository.UserSessionRepository;
import com.markettime.util.DateUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@Transactional
public class SessionContextInterceptor extends HandlerInterceptorAdapter {

    private static final int SESSION_LIFETIME_SECONDS = 600;
    private static final int SESSION_LIFETIME_MILLIS = SESSION_LIFETIME_SECONDS * 1000;
    private static final String UUID_COOKIE_NAME = "uuid";

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private SessionContext sessionContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies).filter(cookie -> UUID_COOKIE_NAME.equals(cookie.getName())).forEach(cookie -> {
                String uuid = cookie.getValue();
                UserSessionEntity userSessionEntity = userSessionRepository.find(uuid);
                Date currentDate = DateUtil.getCurrentDate();
                if (userSessionEntity != null) {
                    if (isSessionValid(userSessionEntity, currentDate)) {
                        UserEntity userEntity = userSessionEntity.getUser();
                        renewUserSession(userSessionEntity, currentDate);
                        updateCookie(cookie, SESSION_LIFETIME_SECONDS);
                        sessionContext.setLoggedIn(Boolean.TRUE);
                        sessionContext.setEmail(userEntity.getEmail());
                    } else {
                        userSessionEntity.setActive(Boolean.FALSE);
                        updateCookie(cookie, 0);
                    }
                } else {
                    updateCookie(cookie, 0);
                }
            });
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("sessionContext", sessionContext);
    }

    private boolean isSessionValid(UserSessionEntity userSessionEntity, Date currentDate) {
        return currentDate.getTime() - userSessionEntity.getLastAccess().getTime() < SESSION_LIFETIME_MILLIS;
    }

    private void renewUserSession(UserSessionEntity userSessionEntity, Date currentDate) {
        userSessionEntity.setLastAccess(currentDate);
    }

    private void updateCookie(Cookie cookie, int maxAge) {
        cookie.setMaxAge(maxAge);
    }
}
