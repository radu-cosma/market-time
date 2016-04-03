package com.markettime.web.servlet.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.markettime.exception.ApplicationException;

/**
 *
 * @author Radu Cosma
 *
 */
public class CustomFreeMarkerViewResolver extends FreeMarkerViewResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFreeMarkerViewResolver.class);
    private static final String ERROR_404_VIEW = "error404";

    @Autowired
    private HttpServletRequest request;

    /**
     * Add custom attributes to the view
     */
    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {

        ViewConfig viewConfig = getViewConfig(viewName);

        Map<String, Object> attributesMap = getAttributesMap();
        attributesMap.put("headerName", viewConfig.getHeaderName());
        attributesMap.put("viewName", viewConfig.getViewName());
        attributesMap.put("footerName", viewConfig.getFooterName());
        attributesMap.put("cssResources", viewConfig.getCssResources());
        attributesMap.put("jsResources", viewConfig.getJsResources());
        attributesMap.put("baseURL", getBaseURL());

        return super.buildView(viewConfig.getLayoutName());
    }

    private ViewConfig getViewConfig(String viewName) {
        PagesConfig pagesConfig = readPagesConfig();
        ViewConfig viewConfig = pagesConfig.getViews().get(viewName);
        if (viewConfig == null) {
            LOGGER.error(String.format("No config was found for view with name '%s'", viewName));
            viewConfig = pagesConfig.getViews().get(ERROR_404_VIEW);
        }
        viewConfig.getCssResources().addAll(0, pagesConfig.getDefaultCssResources());
        viewConfig.getJsResources().addAll(0, pagesConfig.getDefaultJsResources());
        return viewConfig;
    }

    private PagesConfig readPagesConfig() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("pages.json");
        String json = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        try {
            return new ObjectMapper().readValue(json, PagesConfig.class);
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }

    private String getBaseURL() {
        return URI.create(request.getRequestURL().toString()).resolve(request.getContextPath()).toString();
    }

}
