package com.markettime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.exception.ApplicationException;
import com.markettime.model.dto.request.RegistrationRequestDto;
import com.markettime.model.entity.CompanyEntity;
import com.markettime.model.entity.UserEntity;
import com.markettime.repository.CompanyRepository;
import com.markettime.repository.UserRepository;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public void registerUser(RegistrationRequestDto registrationRequestDto) {
        UserEntity user = userRepository.find(registrationRequestDto.getEmail());
        if (user != null) {
            throw new ApplicationException(String.format("A user with email=%s already exists in the database!",
                    registrationRequestDto.getEmail()));
        } else {
            CompanyEntity companyEntity = createCompany(registrationRequestDto);
            createUser(registrationRequestDto, companyEntity);
        }
    }

    private CompanyEntity createCompany(RegistrationRequestDto registrationRequestDto) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(registrationRequestDto.getCompanyName());
        companyEntity.setAddress(registrationRequestDto.getCompanyAddress());
        companyEntity.setPhone(registrationRequestDto.getCompanyPhone());
        companyRepository.persist(companyEntity);
        return companyEntity;
    }

    private UserEntity createUser(RegistrationRequestDto registrationRequestDto, CompanyEntity companyEntity) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(registrationRequestDto.getFirstName());
        userEntity.setLastName(registrationRequestDto.getLastName());
        userEntity.setEmail(registrationRequestDto.getEmail());
        userEntity.setPassword(registrationRequestDto.getPassword());
        userEntity.setCompany(companyEntity);
        userRepository.persist(userEntity);
        return userEntity;
    }
}
