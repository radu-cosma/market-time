package com.markettime.web.servlet.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.markettime.context.UserContext;
import com.markettime.exception.ApplicationException;

/**
 *
 * @author Radu Cosma
 *
 */
public class CustomFreeMarkerViewResolver extends FreeMarkerViewResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFreeMarkerViewResolver.class);
    private static final String ERROR_404_VIEW = "error404";

    private PagesConfig pagesConfig;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserContext userContext;

    @PostConstruct
    private void readPagesConfig() {
        System.out.println("CustomFreeMarkerViewResolver.postConstruct");
        InputStream is = getClass().getClassLoader().getResourceAsStream("pages.json");
        // @formatter:off
        String json = new BufferedReader(new InputStreamReader(is)).lines()
                .map(String::trim)
                .filter(line -> !line.startsWith("#"))
                .collect(Collectors.joining("\n"));
        // @formatter:on
        try {
            pagesConfig = new ObjectMapper().readValue(json, PagesConfig.class);
            prepareViews();
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }

    private void prepareViews() {
        final List<String> defaultCssResources = pagesConfig.getDefaultCssResources();
        final List<String> defaultJsResources = pagesConfig.getDefaultJsResources();
        pagesConfig.getViews().forEach(viewConfig -> {
            viewConfig.getCssResources().addAll(0, defaultCssResources);
            viewConfig.getJsResources().addAll(0, defaultJsResources);
        });
    }

    /**
     * Add custom attributes to the view
     */
    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {

        ViewConfig viewConfig = getViewConfig(viewName);

        Map<String, Object> attributesMap = getAttributesMap();
        attributesMap.put("sections", viewConfig.getSections());
        attributesMap.put("cssResources", viewConfig.getCssResources());
        attributesMap.put("jsResources", viewConfig.getJsResources());
        attributesMap.put("baseURL", getBaseURL());
        attributesMap.put("userContext", userContext);

        return super.buildView("layout");
    }

    private ViewConfig getViewConfig(String viewName) {
        ViewConfig bestMatch = getBestMatch(viewName);
        if (bestMatch == null) {
            LOGGER.error(String.format("No config was found for view with name '%s'", viewName));
            bestMatch = getBestMatch(ERROR_404_VIEW);
        }
        return bestMatch;
    }

    private ViewConfig getBestMatch(String viewName) {
        if (viewName == null) {
            throw new IllegalArgumentException("viewName cannot be null");
        }
        // @formatter:off
        return pagesConfig.getViews().stream()
                .filter(view -> view.getCriteria().getName().equals(viewName))
                .filter(view -> view.getCriteria().isLoggedIn() == null || view.getCriteria().isLoggedIn().equals(userContext.isLoggedIn()))
                .findFirst().orElse(null);
        // @formatter:on
    }

    private String getBaseURL() {
        return URI.create(request.getRequestURL().toString()).resolve(request.getContextPath()).toString();
    }

}
