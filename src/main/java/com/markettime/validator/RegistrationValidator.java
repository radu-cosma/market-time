package com.markettime.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.markettime.model.dto.RegistrationDto;

/**
 *
 * @author Radu Cosma
 *
 */
public class RegistrationValidator implements ConstraintValidator<RegistrationValid, RegistrationDto> {

	@Override
	public void initialize(RegistrationValid registrationValid) {
	}

	@Override
	public boolean isValid(RegistrationDto registrationDto, ConstraintValidatorContext context) {
		if (!isEmailValid(registrationDto.getEmail())) {
			replaceDefaultConstraintViolation(context, "INVALID.EMAIL");
			return false;
		}
		if (!isPasswordValid(registrationDto.getPassword())) {
			replaceDefaultConstraintViolation(context, "WEAK.PASSWORD");
			return false;
		}
		if (!registrationDto.getPassword().equals(registrationDto.getRepeatPassword())) {
			replaceDefaultConstraintViolation(context, "PASSWORDS.MUST.MATCH");
			return false;
		}
		return true;
	}

	private boolean isEmailValid(String email) {
		return true;
	}

	private boolean isPasswordValid(String password) {
		return true;
	}

	private void replaceDefaultConstraintViolation(ConstraintValidatorContext context, String errorMessage) {
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(errorMessage).addConstraintViolation();
	}
}
