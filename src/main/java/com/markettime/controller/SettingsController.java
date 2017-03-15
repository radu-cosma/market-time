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
@RequestMapping("settings")
public class SettingsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getSettings() {
        return "settings";
    }
}
