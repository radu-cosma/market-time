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
@RequestMapping(value = "products")
public class ProductController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getAddProduct() {
        return "add-product";
    }
}
