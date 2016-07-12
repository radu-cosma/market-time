package com.markettime.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markettime.exception.ValidationErrorsException;
import com.markettime.model.dto.request.UpdateEmailRequestDto;
import com.markettime.model.dto.request.UpdatePasswordRequestDto;
import com.markettime.model.dto.request.UpdateProfileRequestDto;
import com.markettime.service.ProfileService;

/**
 *
 * @author Radu Cosma
 *
 */
@RestController
@RequestMapping(value = "/rest/profile")
public class RestProfileController {

    @Autowired
    private ProfileService profileService;

    /**
     *
     * @param updateProfileRequestDto
     * @param bindingResult
     */
    @RequestMapping(path = "updateProfile", method = RequestMethod.POST)
    public Object updateProfile(@Valid @RequestBody UpdateProfileRequestDto updateProfileRequestDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        profileService.updateProfile(updateProfileRequestDto);
        return null;
    }

    /**
     *
     * @param updateEmailRequestDto
     * @param bindingResult
     */
    @RequestMapping(path = "updateEmail", method = RequestMethod.POST)
    public Object updateEmail(@Valid @RequestBody UpdateEmailRequestDto updateEmailRequestDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        profileService.updateEmail(updateEmailRequestDto);
        return null;
    }

    /**
     *
     * @param updatePasswordRequestDto
     * @param bindingResult
     */
    @RequestMapping(path = "updatePassword", method = RequestMethod.POST)
    public Object updatePassword(@Valid @RequestBody UpdatePasswordRequestDto updatePasswordRequestDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        profileService.updatePassword(updatePasswordRequestDto);
        return null;
    }
}
