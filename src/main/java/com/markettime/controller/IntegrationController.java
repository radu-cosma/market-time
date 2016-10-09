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
@RequestMapping("integration")
public class IntegrationController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String getIntegration() {
        return "integration";
    }

}
