package com.markettime.service;

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

	@Autowired
	private UserRepository userDao;

	@Autowired
	private CompanyRepository companyDao;

	public void registerUser(RegistrationDto registrationDto) {
		CompanyEntity company = createCompany(registrationDto);
		createUser(registrationDto, company);
	}

	private CompanyEntity createCompany(RegistrationDto registrationDto) {
		CompanyEntity company = new CompanyEntity();
		company.setName(registrationDto.getCompanyName());
		company.setAddress(registrationDto.getCompanyAddress());
		company.setPhone(registrationDto.getCompanyPhone());
		companyDao.persist(company);
		return company;
	}

	private UserEntity createUser(RegistrationDto registrationDto, CompanyEntity company) {
		UserEntity user = new UserEntity();
		user.setFirstName(registrationDto.getFirstName());
		user.setLastName(registrationDto.getLastName());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
		user.setCompany(company);
		userDao.persist(user);
		return user;
	}
}
