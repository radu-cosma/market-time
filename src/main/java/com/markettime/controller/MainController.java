package com.markettime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import com.markettime.context.SessionContext;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
public class MainController extends BaseController {

	@Autowired
	private SessionContext sessionContext;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public View getDefault() {
		return simpleRedirect("home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() {
		return "home";
	}
}
