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
@RequestMapping(value = "messages")
public class MessagesController {

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getOrders() {
        return "messages";
    }
}
