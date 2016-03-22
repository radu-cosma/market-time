package com.markettime.web.servlet.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 *
 * @author Radu Cosma
 *
 */
public class CustomFreeMarkerViewResolver extends FreeMarkerViewResolver {

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

        return super.buildView(viewConfig.getLayoutName());
    }

    private ViewConfig getViewConfig(String viewName) {
        PagesConfig pagesConfig = readPagesConfig(viewName);
        ViewConfig viewConfig = pagesConfig.getViews().get(viewName);
        if (viewConfig == null) {
            throw new RuntimeException(String.format("No config was found for view with name '%s'", viewName));
        } else {
            viewConfig.getCssResources().addAll(0, pagesConfig.getDefaultCssResources());
            viewConfig.getJsResources().addAll(0, pagesConfig.getDefaultJsResources());
        }
        return viewConfig;
    }

    private PagesConfig readPagesConfig(String viewName) {
        PagesConfig pagesConfig = new PagesConfig();
        List<String> defaultCssResources = new ArrayList<>();
        defaultCssResources.add("bootstrap");
        defaultCssResources.add("bootstrap-theme");
        pagesConfig.setDefaultCssResources(defaultCssResources);
        List<String> defaultJsResources = new ArrayList<>();
        defaultJsResources.add("bootstrap");
        pagesConfig.setDefaultJsResources(defaultJsResources);
        ViewConfig viewConfig = new ViewConfig();
        viewConfig.setLayoutName("layout");
        viewConfig.setViewName(viewName);
        viewConfig.setHeaderName("header");
        viewConfig.setFooterName("footer");
        List<String> cssResources = new ArrayList<>();
        cssResources.add("style");
        cssResources.add("layout");
        cssResources.add("header");
        viewConfig.setCssResources(cssResources);
        List<String> jsResources = new ArrayList<>();
        jsResources.add("script");
        viewConfig.setJsResources(jsResources);
        Map<String, ViewConfig> views = new HashMap<>();
        views.put(viewName, viewConfig);
        pagesConfig.setViews(views);
        return pagesConfig;
    }
}
