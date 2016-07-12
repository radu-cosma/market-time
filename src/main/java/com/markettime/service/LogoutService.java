package com.markettime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.context.UserContext;
import com.markettime.model.entity.UserSessionEntity;
import com.markettime.repository.UserSessionRepository;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class LogoutService {

    @Autowired
    private UserContext userContext;

    @Autowired
    private UserSessionRepository userSessionRepository;

    public void logout(String uuid) {
        invalidateSession(uuid);
        invalidateUserContext();
    }

    private void invalidateSession(String uuid) {
        UserSessionEntity userSessionEntity = userSessionRepository.find(uuid);
        userSessionEntity.setActive(Boolean.FALSE);
    }

    private void invalidateUserContext() {
        userContext.setUserId(null);
        userContext.setLoggedIn(false);
        userContext.setEmail(null);
        userContext.setUuid(null);
    }
}
