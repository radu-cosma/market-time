package com.markettime.exception;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.markettime.context.SessionContext;
import com.markettime.service.SessionContextService;
import com.markettime.util.ValidationUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private SessionContextService sessionContextService;

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ValidationErrorsException.class)
    public ModelAndView handleValidationErrorsException(HttpServletRequest request, ValidationErrorsException e) {
        ModelAndView modelAndView = new ModelAndView();
        populateModel(modelAndView, request);
        modelAndView.addObject("sessionContext", sessionContext);
        modelAndView.addObject("validationErrors", ValidationUtil.extractValidationErrors(e.getErrors()));
        if (e.getViewName() != null) {
            modelAndView.setViewName(e.getViewName());
        } else {
            modelAndView.setViewName(getOriginalViewName(request));
        }
        return modelAndView;
    }

    private void populateModel(ModelAndView modelAndView, HttpServletRequest request) {
        Object dto = request.getAttribute("dto");
        Arrays.stream(dto.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                modelAndView.addObject(field.getName(), field.get(dto));
            } catch (Exception e) {
                LOGGER.warn("Could not add field with name '{}' to the model", field.getName());
            }
        });
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(HttpServletRequest request, ApplicationException e) {
        LOGGER.error("An exception occured!", e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sessionContext", sessionContext);
        modelAndView.addObject("generalError", e.getMessage());
        modelAndView.setViewName(getOriginalViewName(request));
        return modelAndView;
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException(HttpServletRequest request, NoHandlerFoundException e) {
        LOGGER.error("An exception occured!", e);
        sessionContextService.initializeSessionContext(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sessionContext", sessionContext);
        modelAndView.setViewName("error404");
        return modelAndView;
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception e) {
        LOGGER.error("An exception occured!", e);
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sessionContext", sessionContext);
        modelAndView.setViewName("error500");
        return modelAndView;
    }

    private String getOriginalViewName(HttpServletRequest request) {
        return request.getServletPath().substring(1);
    }
}
