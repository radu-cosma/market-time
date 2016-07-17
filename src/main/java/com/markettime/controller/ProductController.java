package com.markettime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping(value = "products")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getAddProduct() {
        return "add-product";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getUnpublishedProducts(@RequestParam("status") String productStatus) {
        LOGGER.info("product status: {}", productStatus);
        return "products";
    }
}
