package com.markettime.controller;

import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Radu Cosma
 *
 */
public class BaseController {

    protected RedirectView simpleRedirect(String view) {
        RedirectView redirectView = new RedirectView(view);
        redirectView.setExposeModelAttributes(false);
        return redirectView;
    }

}
