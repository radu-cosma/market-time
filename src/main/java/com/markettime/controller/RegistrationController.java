package com.markettime.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.markettime.exception.ValidationErrorsException;
import com.markettime.model.dto.RegistrationDto;
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
    private RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistration() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public View register(HttpServletRequest request, @ModelAttribute @Valid RegistrationDto registrationDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            request.setAttribute("dto", registrationDto);
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        registrationService.registerUser(registrationDto);
        return simpleRedirect("home");
    }

}
