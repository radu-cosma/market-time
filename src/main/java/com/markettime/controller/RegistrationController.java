package com.markettime.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.markettime.context.RequestContext;
import com.markettime.exception.ValidationErrorsException;
import com.markettime.model.dto.request.RegistrationRequestDto;
import com.markettime.service.RegistrationService;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping("register")
public class RegistrationController extends BaseController {

    @Autowired
    private RequestContext requestContext;

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistration() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public View register(@ModelAttribute @Valid RegistrationRequestDto registrationRequestDto,
            BindingResult bindingResult) {

        requestContext.setReturnToViewName("register");
        requestContext.setModelObjectName("registration");
        requestContext.setModelObject(registrationRequestDto);
        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        registrationService.registerUser(registrationRequestDto);
        return simpleRedirect("home");
    }

}
