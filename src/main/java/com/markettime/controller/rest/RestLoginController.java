package com.markettime.controller.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markettime.model.dto.request.LoginRequestDto;
import com.markettime.model.dto.response.LoginResponseDto;
import com.markettime.service.LoginService;
import com.markettime.util.ValidationUtil;

/**
 *
 * @author Dana Onisa
 *
 */
@RestController
@RequestMapping(value = "/rest/login")
public class RestLoginController {

    private static final String UUID_COOKIE_NAME = "uuid";
    private static final String LOGIN_FAILED = "LOGIN.FAILED";

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
    public LoginResponseDto login(HttpServletResponse response, @Valid @RequestBody LoginRequestDto loginRequestDto,
            BindingResult bindingResult) {

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        if (bindingResult.hasErrors()) {
            loginResponseDto.setLoggedIn(false);
            loginResponseDto.setValidationErrors(ValidationUtil.extractValidationErrors(bindingResult.getAllErrors()));
            return loginResponseDto;
        }

        String uuid = loginService.login(loginRequestDto);
        if (uuid != null) {
            loginResponseDto.setLoggedIn(true);
            createCookie(response, UUID_COOKIE_NAME, uuid);
            return loginResponseDto;
        }

        loginResponseDto.setLoggedIn(false);
        loginResponseDto.setGeneralError(LOGIN_FAILED);

        return loginResponseDto;
    }

    private void createCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(600);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}