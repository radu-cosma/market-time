package com.markettime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.context.SessionContext;
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
    private SessionContext sessionContext;

    @Autowired
    private UserSessionRepository userSessionRepository;

    public void logout(String uuid) {
        invalidateSession(uuid);
        invalidateSessionContext();
    }

    private void invalidateSession(String uuid) {
        UserSessionEntity userSessionEntity = userSessionRepository.find(uuid);
        userSessionEntity.setActive(Boolean.FALSE);
    }

    private void invalidateSessionContext() {
        sessionContext.setLoggedIn(false);
        sessionContext.setEmail(null);
        sessionContext.setUuid(null);
    }
}
