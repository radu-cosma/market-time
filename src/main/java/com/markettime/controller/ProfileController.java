package com.markettime.controller;

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

    @Autowired
    private ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getProfile() {

        GetProfileResponseDto profile = profileService.getProfile();

        return new ModelAndView("profile", "profile", profile);
    }

}
