package com.markettime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getContact() {
        return "contact";
    }

    /**
     *
     * @param messageDto
     */
    @RequestMapping(method = RequestMethod.POST)
    public void sendEmail(@ModelAttribute MessageDto messageDto) {
        LOGGER.info("started sendEmail[messageDto: {}]", messageDto);
    }
}
