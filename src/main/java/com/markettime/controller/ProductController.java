package com.markettime.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.markettime.model.dto.ProductDto;

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
    public ModelAndView getUnpublishedProducts(@RequestParam("status") String productStatus) {
        LOGGER.info("product status: {}", productStatus);
        return new ModelAndView("products", "products", createProductsList());
    }

    private List<ProductDto> createProductsList() {
        List<ProductDto> products = new ArrayList<>();
        ProductDto product = new ProductDto();
        product.setName("product 1");
        product.setDescription("description 1");
        product.setTags("tags 1");
        product.setShipping("shipping 1");
        product.setShippingTime("shipping time 1");
        product.setColor("color 1");
        product.setSize("size 1");
        product.setInventory("inventory 1");
        product.setPrice("price 1");
        product.setBrand("brand 1");
        product.setLandingPageUrl("landing page url 1");
        product.setUpc("upc 1");
        products.add(product);

        product = new ProductDto();
        product.setName("product 2");
        product.setDescription("description 2");
        product.setTags("tags 2");
        product.setShipping("shipping 2");
        product.setShippingTime("shipping time 2");
        product.setColor("color 2");
        product.setSize("size 2");
        product.setInventory("inventory 2");
        product.setPrice("price 2");
        product.setBrand("brand 2");
        product.setLandingPageUrl("landing page url 2");
        product.setUpc("upc 2");
        products.add(product);

        product = new ProductDto();
        product.setName("product 3");
        product.setDescription("description 3");
        product.setTags("tags 3");
        product.setShipping("shipping 3");
        product.setShippingTime("shipping time 3");
        product.setColor("color 3");
        product.setInventory("inventory 3");
        product.setPrice("price 3");
        product.setBrand("brand 3");
        product.setLandingPageUrl("landing page url 3");
        product.setUpc("upc 3");
        products.add(product);
        return products;
    }

}
