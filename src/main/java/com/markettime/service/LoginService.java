package com.markettime.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.context.UserContext;
import com.markettime.exception.AuthenticationException;
import com.markettime.model.dto.request.LoginRequestDto;
import com.markettime.model.entity.UserEntity;
import com.markettime.model.entity.UserSessionEntity;
import com.markettime.repository.UserRepository;
import com.markettime.repository.UserSessionRepository;
import com.markettime.util.DateUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private UserContext userContext;

    /**
     *
     * @param loginDto
     * @return
     */
    public String login(LoginRequestDto loginDto) {
        UserEntity userEntity = userRepository.find(loginDto.getEmail());
        if (userEntity == null || !userEntity.getPassword().equals(loginDto.getPassword())) {
            throw new AuthenticationException("LOGIN.FAILED");
        } else {
            userContext.setLoggedIn(true);
            userContext.setUserId(userEntity.getId());
            userContext.setEmail(userEntity.getEmail());
            String uuid = createUserSession(userEntity);
            userContext.setUuid(uuid);
            return uuid;
        }
    }

    private String createUserSession(UserEntity userEntity) {
        Date currentDate = DateUtil.getCurrentDate();
        String uuid = generateUuid();
        UserSessionEntity sessionEntity = new UserSessionEntity();
        sessionEntity.setActive(Boolean.TRUE);
        sessionEntity.setCreationTime(currentDate);
        sessionEntity.setLastAccess(currentDate);
        sessionEntity.setUuid(uuid);
        sessionEntity.setUser(userEntity);
        userSessionRepository.persist(sessionEntity);
        return uuid;
    }

    private String generateUuid() {
        return UUID.randomUUID().toString();
    }

}
