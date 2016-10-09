package com.markettime.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RequestContext requestContext;

    @Autowired
    private RegistrationService registrationService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getRegistration() {

        LOGGER.info("started getRegistration[]");

        String viewName = "register";
        LOGGER.info("completed getRegistration; returned: {}", viewName);
        return viewName;
    }

    /**
     *
     * @param registrationRequestDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public View register(@ModelAttribute @Valid RegistrationRequestDto registrationRequestDto,
            BindingResult bindingResult) {

        LOGGER.info("started register[registrationRequestDto: {}]", registrationRequestDto);

        requestContext.setReturnToViewName("register");
        requestContext.setModelObjectName("registration");
        requestContext.setModelObject(registrationRequestDto);
        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        registrationService.registerUser(registrationRequestDto);
        LOGGER.info("completed register; returned: {}", registrationRequestDto);
        return simpleRedirect("home");
    }

}
