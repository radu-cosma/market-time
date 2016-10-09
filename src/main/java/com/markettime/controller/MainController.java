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
public class MainController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserContext userContext;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRoot() {

        LOGGER.info("started getRoot[]");

        String viewName = "redirect:home";

        if (userContext.isLoggedIn()) {
            viewName = "redirect:dashboard";
        }
        LOGGER.info("completed getRoot; returned: {}", viewName);
        return viewName;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String getHome() {

        LOGGER.info("started getHome[]");

        String viewName = "home";

        if (userContext.isLoggedIn()) {
            viewName = "redirect:dashboard";
        }
        LOGGER.info("completed getHome; returned: {}", viewName);
        return viewName;
    }

}
