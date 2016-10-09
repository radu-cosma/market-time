package com.markettime.controller.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markettime.exception.ValidationErrorsException;
import com.markettime.model.dto.request.LoginRequestDto;
import com.markettime.model.dto.response.LoginResponseDto;
import com.markettime.service.LoginService;
import com.markettime.util.Constants;

/**
 *
 * @author Dana Onisa
 *
 */
@RestController
@RequestMapping(value = "/rest/login")
public class RestLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestLoginController.class);

    private static final String UUID_COOKIE_NAME = "uuid";

    @Autowired
    private LoginService loginService;

    /**
     *
     * @param response
     * @param loginRequestDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Object login(HttpServletResponse response, @Valid @RequestBody LoginRequestDto loginRequestDto,
            BindingResult bindingResult) {

        LOGGER.info("started login[loginRequestDto: {}]", loginRequestDto);

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        String uuid = loginService.login(loginRequestDto);
        createCookie(response, UUID_COOKIE_NAME, uuid);

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setLoggedIn(true);
        LOGGER.info("completed login; returned: {}", loginResponseDto);
        return loginResponseDto;
    }

    private void createCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(Constants.SESSION_LIFETIME_SECONDS);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}