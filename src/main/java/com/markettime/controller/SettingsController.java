package com.markettime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.markettime.aop.LoggedIn;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping("settings")
public class SettingsController {

    /**
     *
     * @return
     */
    @LoggedIn
    @RequestMapping(method = RequestMethod.GET)
    public String getSettings() {
        return "settings";
    }
}
