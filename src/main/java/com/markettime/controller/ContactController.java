package com.markettime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.markettime.model.dto.request.MessageDto;

/**
 *
 * @author Dana Onisa
 *
 */
@Controller
@RequestMapping("contact")
public class ContactController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void sendEmail(@ModelAttribute MessageDto messageDto) {
        System.out.println(messageDto);
    }
}
