package com.markettime.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.markettime.model.dto.request.RegistrationRequestDto;

/**
 *
 * @author Radu Cosma
 *
 */
public class RegistrationValidator implements ConstraintValidator<RegistrationValid, RegistrationRequestDto> {

    @Override
    public void initialize(RegistrationValid registrationValid) {
    }

    @Override
    public boolean isValid(RegistrationRequestDto registrationDto, ConstraintValidatorContext context) {
        if (!isEmailValid(registrationDto.getEmail())) {
            replaceDefaultConstraintViolation(context, "email", "Invalid");
            return false;
        }
        if (!isPasswordValid(registrationDto.getPassword())) {
            replaceDefaultConstraintViolation(context, "password", "TooWeak");
            return false;
        }
        if (!registrationDto.getPassword().equals(registrationDto.getRepeatPassword())) {
            replaceDefaultConstraintViolation(context, "password", "MustMatch");
            replaceDefaultConstraintViolation(context, "repeatPassword", "MustMatch");
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

    private void replaceDefaultConstraintViolation(ConstraintValidatorContext context, String field,
            String errorMessage) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(field).addConstraintViolation();
    }
}
