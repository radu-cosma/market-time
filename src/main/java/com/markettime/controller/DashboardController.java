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
public class DashboardController {

    @Autowired
    private UserContext userContext;

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String getDashboard() {
        if (!userContext.isLoggedIn()) {
            return "redirect:home";
        }
        return "dashboard";
    }
}
