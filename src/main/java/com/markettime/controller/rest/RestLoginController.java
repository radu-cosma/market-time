package com.markettime.controller.rest;

import java.util.Arrays;
import java.util.Map;
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

import com.markettime.model.dto.LoginDto;
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

    /*
     * @RequestMapping(method = RequestMethod.GET) public String login(HttpServletResponse response) {
     * createCookie(response, "COOKIEZZZZZ", "yummy"); return "Hello!"; }
     */

    @RequestMapping(method = RequestMethod.POST)
    public LoginResponse login(HttpServletResponse response, @Valid @RequestBody LoginDto loginDto,
            BindingResult bindingResult) {

        LoginResponse loginResponse = new LoginResponse();
        if (bindingResult.hasErrors()) {
            loginResponse.setLoggedIn(false);
            // @formatter:off
            loginResponse.setValidationErrors(bindingResult.getAllErrors().stream()
                    .filter(error -> error instanceof FieldError)
                    .map(error -> (FieldError) error)
                    .collect(Collectors.toMap(FieldError::getField, fieldError ->  buildErrorCodeMessageKey(fieldError))));
            // @formatter:on
            return loginResponse;
        }

        String uuid = loginService.login(loginDto);
        if (uuid != null) {
            loginResponse.setLoggedIn(true);
            createCookie(response, UUID_COOKIE_NAME, uuid);
            return loginResponse;
        }

        loginResponse.setLoggedIn(false);
        loginResponse.setGeneralError(LOGIN_FAILED);

        return loginResponse;
    }

    private void createCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(600);
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

    private class LoginResponse {
        private Map<String, String> validationErrors;
        private String generalError;
        private boolean loggedIn;

        public Map<String, String> getValidationErrors() {
            return validationErrors;
        }

        public void setValidationErrors(Map<String, String> validationErrors) {
            this.validationErrors = validationErrors;
        }

        public String getGeneralError() {
            return generalError;
        }

        public void setGeneralError(String generalError) {
            this.generalError = generalError;
        }

        public boolean isLoggedIn() {
            return loggedIn;
        }

        public void setLoggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
        }

        @Override
        public String toString() {
            return "LoginResponse [validationErrors=" + validationErrors + ", generalError=" + generalError
                    + ", loggedIn=" + loggedIn + "]";
        }
    }
}