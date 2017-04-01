package com.markettime.controller;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutController.class);

    private static final String UUID_COOKIE_NAME = "uuid";

    @Autowired
    private LogoutService logoutService;

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public View logout(HttpServletRequest request) {

        LOGGER.info("started logout[]");

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            Arrays.stream(cookies).filter(cookie -> UUID_COOKIE_NAME.equals(cookie.getName())).forEach(cookie -> {
                logoutService.logout(cookie.getValue());
                cookie.setMaxAge(0);
                cookie.setValue("");
                cookie.setPath("/");
            });
        }

        String viewName = "home";
        LOGGER.info("completed logout; returned: {}", viewName);
        return simpleRedirect(viewName);
    }
}
