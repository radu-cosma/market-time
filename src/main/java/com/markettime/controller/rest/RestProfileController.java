package com.markettime.controller.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markettime.aop.LoggedIn;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(RestProfileController.class);

    @Autowired
    private ProfileService profileService;

    /**
     *
     * @param updateProfileRequestDto
     * @param bindingResult
     */
    @LoggedIn
    @RequestMapping(path = "updateProfile", method = RequestMethod.POST)
    public Object updateProfile(@Valid @RequestBody UpdateProfileRequestDto updateProfileRequestDto,
            BindingResult bindingResult) {

        LOGGER.info("started updateProfile[updateProfileRequestDto: {}]", updateProfileRequestDto);

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        profileService.updateProfile(updateProfileRequestDto);
        LOGGER.info("completed updateProfile; returned: []");
        return null;
    }

    /**
     *
     * @param updateEmailRequestDto
     * @param bindingResult
     */
    @LoggedIn
    @RequestMapping(path = "updateEmail", method = RequestMethod.POST)
    public Object updateEmail(@Valid @RequestBody UpdateEmailRequestDto updateEmailRequestDto,
            BindingResult bindingResult) {

        LOGGER.info("started updateEmail[updateEmailRequestDto: {}]", updateEmailRequestDto);

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        profileService.updateEmail(updateEmailRequestDto);
        LOGGER.info("completed updateEmail; returned: []");
        return null;
    }

    /**
     *
     * @param updatePasswordRequestDto
     * @param bindingResult
     */
    @LoggedIn
    @RequestMapping(path = "updatePassword", method = RequestMethod.POST)
    public Object updatePassword(@Valid @RequestBody UpdatePasswordRequestDto updatePasswordRequestDto,
            BindingResult bindingResult) {

        LOGGER.info("started updatePassword[updatePasswordRequestDto: {}]", updatePasswordRequestDto);

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        profileService.updatePassword(updatePasswordRequestDto);
        LOGGER.info("completed updatePassword, returned: []");
        return null;
    }
}
