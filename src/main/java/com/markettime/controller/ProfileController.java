package com.markettime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
public class ProfileController {

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String getProfile() {
        return "profile";
    }
}
