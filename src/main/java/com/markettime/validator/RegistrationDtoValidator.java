package com.markettime.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.markettime.model.dto.RegistrationDto;

/**
 *
 * @author Radu Cosma
 *
 */
@Component
public class RegistrationDtoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RegistrationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistrationDto registrationDto = (RegistrationDto) target;
		if (registrationDto.getPassword() != registrationDto.getRepeatPassword()) {
			errors.reject("PASSWORDS.MUST.MATCH");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "FIRST.NAME.NOT.EMPTY");
	}

}
