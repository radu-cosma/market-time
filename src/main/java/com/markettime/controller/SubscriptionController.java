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
@RequestMapping("subscribe")
public class SubscriptionController extends BaseController {

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getSubscription() {
        return "subscription";
    }

}
