package com.markettime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.markettime.context.SessionContext;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
public class DashboardController {

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String getDashboard() {
        if (!sessionContext.isLoggedIn()) {
            return "redirect:home";
        }
        return "dashboard";
    }
}
