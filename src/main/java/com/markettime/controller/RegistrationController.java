package com.markettime.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.markettime.model.User;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping("register")
public class RegistrationController extends BaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String getRegistrationPage() {
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public View register(HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes, @ModelAttribute User user) {

		return simpleRedirect("home");

	}

}
