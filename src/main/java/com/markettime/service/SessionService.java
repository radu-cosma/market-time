package com.markettime.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.markettime.model.Session;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
public class SessionService {

    private static final int SESSION_LIFETIME = 600 * 1000;

    private static Map<String, Session> SESSIONS;

    static {
        SESSIONS = new HashMap<String, Session>();
    }

    public String createSession(String username, char[] passwordChars) {
        String uuid = generateUuid();
        SESSIONS.put(uuid, new Session(username, passwordChars, uuid, System.currentTimeMillis()));

        return uuid;
    }

    public Session getUpdatedSession(String uuid) {
        Session session = SESSIONS.get(uuid);
        if (session != null) {
            long time = System.currentTimeMillis();
            if (isSessionValid(session, time)) {
                renew(session, time);
            } else {
                SESSIONS.remove(uuid);
                return null;
            }
        }
        return session;
    }

    public void removeSession(String uuid) {
        SESSIONS.remove(uuid);
    }

    private boolean isSessionValid(Session session, long time) {
        if (time - session.getLastAccess() < SESSION_LIFETIME) {
            session.setLastAccess(time);
        } else {
            return false;
        }
        return true;
    }

    private void renew(Session session, long time) {
        session.setLastAccess(time);
    }

    private String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
