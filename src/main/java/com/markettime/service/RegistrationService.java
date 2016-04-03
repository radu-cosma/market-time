package com.markettime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.exception.ApplicationException;
import com.markettime.model.dto.RegistrationDto;
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

    public void registerUser(RegistrationDto registrationDto) {
        UserEntity user = userRepository.find(registrationDto.getEmail());
        if (user != null) {
            throw new ApplicationException(
                    String.format("A user with email=%s already exists in the database!", registrationDto.getEmail()));
        } else {
            CompanyEntity company = createCompany(registrationDto);
            createUser(registrationDto, company);
        }
    }

    private CompanyEntity createCompany(RegistrationDto registrationDto) {
        CompanyEntity company = new CompanyEntity();
        company.setName(registrationDto.getCompanyName());
        company.setAddress(registrationDto.getCompanyAddress());
        company.setPhone(registrationDto.getCompanyPhone());
        companyRepository.persist(company);
        return company;
    }

    private UserEntity createUser(RegistrationDto registrationDto, CompanyEntity company) {
        UserEntity user = new UserEntity();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setCompany(company);
        userRepository.persist(user);
        return user;
    }
}
