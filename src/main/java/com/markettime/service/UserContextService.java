package com.markettime.service;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.context.UserContext;
import com.markettime.model.entity.UserEntity;
import com.markettime.model.entity.UserSessionEntity;
import com.markettime.repository.UserSessionRepository;
import com.markettime.util.DateUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class UserContextService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextService.class);

    private static final int SESSION_LIFETIME_SECONDS = 3600;
    private static final int SESSION_LIFETIME_MILLIS = SESSION_LIFETIME_SECONDS * 1000;
    private static final String UUID_COOKIE_NAME = "uuid";

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private UserContext userContext;

    @Autowired
    private UserSessionRepository userSessionRepository;

    /**
     *
     * @param request
     */
    public void initializeUserContext(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies).filter(cookie -> UUID_COOKIE_NAME.equals(cookie.getName()))
                    .forEach(this::processUuidCookie);
        }
    }

    private void processUuidCookie(Cookie cookie) {
        String uuid = cookie.getValue();
        UserSessionEntity userSessionEntity = userSessionRepository.findActive(uuid);
        Date currentDate = DateUtil.getCurrentDate();
        if (userSessionEntity != null) {
            if (isSessionValid(userSessionEntity, currentDate)) {
                UserEntity userEntity = userSessionEntity.getUser();
                renewUserSession(userSessionEntity, currentDate);
                updateCookie(cookie, cookie.getValue(), cookie.getPath(), SESSION_LIFETIME_SECONDS);
                userContext.setUserId(userEntity.getId());
                userContext.setLoggedIn(Boolean.TRUE);
                userContext.setEmail(userEntity.getEmail());
            } else {
                LOGGER.debug("Invalid session: lastAccess={}, currentTime={}", userSessionEntity.getLastAccess(),
                        currentDate);
                userSessionEntity.setActive(Boolean.FALSE);
                updateCookie(cookie, "", "/", 0);
            }
        } else {
            updateCookie(cookie, "", "/", 0);
        }
    }

    private boolean isSessionValid(UserSessionEntity userSessionEntity, Date currentDate) {
        return currentDate.getTime() - userSessionEntity.getLastAccess().getTime() < SESSION_LIFETIME_MILLIS;
    }

    private void renewUserSession(UserSessionEntity userSessionEntity, Date currentDate) {
        userSessionEntity.setLastAccess(currentDate);
    }

    private void updateCookie(Cookie cookie, String value, String path, int maxAge) {
        cookie.setMaxAge(maxAge);
        cookie.setValue(value);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
}
