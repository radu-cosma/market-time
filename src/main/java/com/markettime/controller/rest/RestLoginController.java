package com.markettime.controller.rest;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markettime.model.dto.request.LoginRequestDto;
import com.markettime.model.dto.response.LoginResponseDto;
import com.markettime.service.LoginService;

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
    private static final String DOT_DELIMITER = ".";
    private static final String UPPERCASE_REGEX = "(?=\\p{Upper})";

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    public LoginResponseDto login(HttpServletResponse response, @Valid @RequestBody LoginRequestDto loginRequestDto,
            BindingResult bindingResult) {

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        if (bindingResult.hasErrors()) {
            loginResponseDto.setLoggedIn(false);
            // @formatter:off
            loginResponseDto.setValidationErrors(bindingResult.getAllErrors().stream()
                    .filter(error -> error instanceof FieldError)
                    .map(error -> (FieldError) error)
                    .collect(Collectors.toMap(FieldError::getField, fieldError ->  buildErrorCodeMessageKey(fieldError))));
            // @formatter:on
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

    private String buildErrorCodeMessageKey(FieldError fieldError) {
        String objectName = fieldError.getObjectName();
        if (objectName.endsWith("Dto")) {
            objectName = objectName.substring(0, objectName.length() - 3);
        }
        return splitAndCapitalize(String.format("%s.%s%s", objectName, fieldError.getField(), fieldError.getCode()));
    }

    private String splitAndCapitalize(String s) {
        return Arrays.stream(s.split(UPPERCASE_REGEX)).map(str -> str.toUpperCase())
                .collect(Collectors.joining(DOT_DELIMITER));
    }

}