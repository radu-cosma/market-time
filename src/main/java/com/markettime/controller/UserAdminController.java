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
@RequestMapping("users")
public class UserAdminController extends BaseController {

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUsers() {
        return "users";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String getUserDetails() {
        return "user-details";
    }

}
