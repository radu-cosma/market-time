package com.markettime.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.markettime.model.dto.LoginDto;
import com.markettime.service.LoginService;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

	private static final String UUID_COOKIE_NAME = "uuid";

	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public View login(HttpServletResponse response, RedirectAttributes redirectAttributes,
			@ModelAttribute LoginDto loginDto) {

		String uuid = loginService.login(loginDto);
		if (uuid != null) {
			createCookie(response, UUID_COOKIE_NAME, uuid);
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "LOGIN.FAILED");
		}
		return simpleRedirect("home");
	}

	private void createCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(600);
		response.addCookie(cookie);
	}
}
