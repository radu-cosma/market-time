package com.markettime.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CompanyRepository companyRepository;

	public void registerUser(RegistrationDto registrationDto) {
		UserEntity user = userRepository.findByEmail(registrationDto.getEmail());
		if (user != null) {
			LOGGER.error(
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
