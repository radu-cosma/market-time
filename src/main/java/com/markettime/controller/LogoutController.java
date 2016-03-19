package com.markettime.controller;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.markettime.service.LogoutService;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping("logout")
public class LogoutController extends BaseController {

	private static final String UUID_COOKIE_NAME = "uuid";

	@Autowired
	private LogoutService logoutService;

	@RequestMapping(method = RequestMethod.GET)
	public View logout(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			Arrays.stream(cookies).filter(cookie -> UUID_COOKIE_NAME.equals(cookie.getName())).forEach(cookie -> {
				logoutService.logout(cookie.getValue());
				cookie.setMaxAge(0);
			});
		}

		return simpleRedirect("home");
	}
}
