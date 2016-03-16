package com.markettime.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	// @Autowired
	// @Qualifier("registrationDtoValidator")
	// private Validator validator;
	//
	// @InitBinder
	// private void initBinder(WebDataBinder binder) {
	// binder.setValidator(validator);
	// }

	@RequestMapping(method = RequestMethod.GET)
	public String getRegistrationPage() {
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public View register(RedirectAttributes redirectAttributes, @ModelAttribute @Valid RegistrationDto registrationDto,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			for (ObjectError e : bindingResult.getAllErrors()) {
				System.out.println(e.getObjectName());
				System.out.println(e.getCode());
			}
			return simpleRedirect("registration");
		} else {
			registrationService.registerUser(registrationDto);
			return simpleRedirect("home");
		}

	}

}
