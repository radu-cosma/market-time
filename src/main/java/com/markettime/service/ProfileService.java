package com.markettime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.aop.LoggedIn;
import com.markettime.context.UserContext;
import com.markettime.exception.AuthenticationException;
import com.markettime.model.dto.request.UpdateEmailRequestDto;
import com.markettime.model.dto.request.UpdatePasswordRequestDto;
import com.markettime.model.dto.request.UpdateProfileRequestDto;
import com.markettime.model.dto.response.GetProfileResponseDto;
import com.markettime.model.entity.UserEntity;
import com.markettime.repository.UserRepository;
import com.markettime.util.BeanMapperUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class ProfileService {

    private static final String PASSWORD_MASK = "********";

    @Autowired
    private UserContext userContext;

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @return
     */
    @LoggedIn
    public GetProfileResponseDto getProfile() {
        UserEntity userEntity = userRepository.find(userContext.getUserId());
        return buildGetProfileResponseDto(userEntity);
    }

    /**
     *
     * @param updateProfileRequestDto
     */
    @LoggedIn
    public void updateProfile(UpdateProfileRequestDto updateProfileRequestDto) {
        UserEntity userEntity = userRepository.find(userContext.getUserId());
        checkPassword(userEntity, updateProfileRequestDto.getProfileCurrentPassword());
        BeanMapperUtil.map(updateProfileRequestDto, userEntity);
    }

    /**
     *
     * @param updateEmailRequestDto
     */
    @LoggedIn
    public void updateEmail(UpdateEmailRequestDto updateEmailRequestDto) {
        UserEntity userEntity = userRepository.find(userContext.getUserId());
        checkPassword(userEntity, updateEmailRequestDto.getEmailCurrentPassword());
        userEntity.setEmail(updateEmailRequestDto.getEmail());
    }

    /**
     *
     * @param updatePasswordRequestDto
     */
    @LoggedIn
    public void updatePassword(UpdatePasswordRequestDto updatePasswordRequestDto) {
        UserEntity userEntity = userRepository.find(userContext.getUserId());
        checkPassword(userEntity, updatePasswordRequestDto.getPasswordCurrentPassword());
        userEntity.setPassword(updatePasswordRequestDto.getNewPassword());
    }

    private GetProfileResponseDto buildGetProfileResponseDto(UserEntity userEntity) {
        GetProfileResponseDto getProfileResponseDto = BeanMapperUtil.map(userEntity, GetProfileResponseDto.class);
        getProfileResponseDto.setPassword(PASSWORD_MASK);
        return getProfileResponseDto;
    }

    private void checkPassword(UserEntity userEntity, String currentPassword) {
        if (!userEntity.getPassword().equals(currentPassword)) {
            throw new AuthenticationException("INVALID.PASSWORD");
        }
    }

}
