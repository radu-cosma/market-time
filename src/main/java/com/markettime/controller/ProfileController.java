package com.markettime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.markettime.model.dto.response.GetProfileResponseDto;
import com.markettime.service.ProfileService;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping(path = "profile")
public class ProfileController extends BaseController {

    private Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileService profileService;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getProfile() {
        LOGGER.info("started getProfile[]");

        GetProfileResponseDto profile = profileService.getProfile();

        LOGGER.info("completed getProfile; returned: {}", profile);
        return new ModelAndView("profile", "profile", profile);
    }

}
