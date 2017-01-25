package com.markettime.controller;

import static com.markettime.util.Constants.ADD_PRODUCT_SUCCESS_MESSAGE_KEY;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.markettime.context.RequestContext;
import com.markettime.exception.ValidationErrorsException;
import com.markettime.model.dto.request.AddProductRequestDto;
import com.markettime.service.ProductService;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping(value = "products")
public class ProductController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private RequestContext requestContext;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String getAddProduct() {
        productService.prepareCache();
        return "add-product";
    }

    /**
     *
     * @param addProductRequestDto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public View addProduct(@ModelAttribute @Valid AddProductRequestDto addProductRequestDto,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        LOGGER.info("addProduct: {}", addProductRequestDto);

        requestContext.setReturnToViewName("add-product");
        requestContext.setModelObjectName("addProduct");
        requestContext.setModelObject(addProductRequestDto);
        if (bindingResult.hasErrors()) {
            throw new ValidationErrorsException(bindingResult.getAllErrors());
        }
        productService.addProduct(addProductRequestDto);
        redirectAttributes.addFlashAttribute("successMessage", ADD_PRODUCT_SUCCESS_MESSAGE_KEY);
        return simpleRedirect("add");
    }

    /**
     * Converts empty strings into null when a form is submitted .
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
