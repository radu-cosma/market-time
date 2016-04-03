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
public class MainController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRoot() {
        return "redirect:home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome() {
        return "home";
    }
}
