package com.markettime.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.markettime.aop.LoggedIn;
import com.markettime.exception.ValidationErrorsException;
import com.markettime.model.dto.request.AddProductImageDto;
import com.markettime.model.dto.request.RemoveProductImageDto;
import com.markettime.service.ProductService;

/**
 *
 * @author Radu Cosma
 *
 */
@RestController
@RequestMapping(value = "/rest/products")
public class RestProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestProductController.class);

    @Autowired
    private ProductService productService;

    /**
     *
     * @param addProductImageDto
     * @param bindingResult
     * @return
     */
    @LoggedIn
    @RequestMapping(value = "addImage", method = RequestMethod.POST)
    public Object addProductImage(@Valid @RequestBody AddProductImageDto addProductImageDto,
            BindingResult bindingResult) {
        LOGGER.info("started addProductImage[addProductImageDto: {}]", addProductImageDto);

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }

        productService.cacheImage(addProductImageDto);

        LOGGER.info("completed addProductImage; returned: []");
        return null;
    }

    /**
     *
     * @param removeProductImageDto
     * @param bindingResult
     * @return
     */
    @LoggedIn
    @RequestMapping(value = "removeImage", method = RequestMethod.POST)
    public Object removeProductImage(@Valid @RequestBody RemoveProductImageDto removeProductImageDto,
            BindingResult bindingResult) {
        LOGGER.info("started removeProductImage[removeProductImageDto: {}]", removeProductImageDto);

        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }

        productService.uncacheImage(removeProductImageDto);

        LOGGER.info("completed removeProductImage; returned: []");
        return null;
    }

    /**
     *
     * @return
     */
    @LoggedIn
    @RequestMapping(value = "getImageTypes", method = RequestMethod.GET)
    public Object getImageTypes() {
        LOGGER.info("started getImageTypes[]");

        List<String> imageTypes = productService.getImageTypes();

        LOGGER.info("completed getImageTypes; returned: {}", imageTypes);
        return imageTypes;
    }

}
