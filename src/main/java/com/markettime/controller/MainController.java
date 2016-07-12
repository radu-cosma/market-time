package com.markettime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.markettime.context.UserContext;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private UserContext userContext;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRoot() {
        if (userContext.isLoggedIn()) {
            return "redirect:dashboard";
        }
        return "redirect:home";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String getHome() {
        if (userContext.isLoggedIn()) {
            return "redirect:dashboard";
        }
        return "home";
    }
}
