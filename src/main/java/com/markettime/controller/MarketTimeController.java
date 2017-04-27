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
public class MarketTimeController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketTimeController.class);

    @Autowired
    private UserContext userContext;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRoot() {
        String nextView = "home";
        if (userContext.isLoggedIn()) {
            switch (userContext.getUserRole()) {
                case REGULAR_USER:
                    nextView = "redirect:dashboard";
                    break;
                case ADMIN:
                    nextView = "redirect:users";
                    break;
                default:
                    LOGGER.error("Unexpected user role: {}", userContext.getUserRole());
                    break;
            }
        }
        return nextView;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String getHome() {
        String nextView = "home";
        if (userContext.isLoggedIn()) {
            switch (userContext.getUserRole()) {
                case REGULAR_USER:
                    nextView = "dashboard";
                    break;
                case ADMIN:
                    nextView = "users";
                    break;
                default:
                    LOGGER.error("Unexpected user role: {}", userContext.getUserRole());
                    break;
            }
        }
        return nextView;
    }

}
