package com.markettime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
public class MainController extends BaseController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public View getRoot() {
		return simpleRedirect("home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}
}
