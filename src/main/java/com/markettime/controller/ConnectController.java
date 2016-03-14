package com.markettime.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping(value = "/connect")
public class ConnectController extends BaseController {

    @RequestMapping(method = RequestMethod.POST)
    public View connect(HttpServletRequest request, HttpServletResponse response) {
        return simpleRedirect("home");
    }
}
