package com.markettime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private UserContext userContext;

    /**
     *
     * @return
     */
    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String getDashboard() {

        LOGGER.info("started getDashboard[]");

        String viewName = "dashboard";

        if (!userContext.isLoggedIn()) {
            viewName = "redirect:home";
        }
        LOGGER.info("completed getDashboard; returned: {}", viewName);
        return viewName;
    }
}
