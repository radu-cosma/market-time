package com.markettime.web.servlet.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        PagesConfig pagesConfig = readPagesConfig();
        ViewConfig viewConfig = pagesConfig.getViews().get(viewName);
        if (viewConfig == null) {
            throw new RuntimeException(String.format("No config was found for view with name '%s'", viewName));
        } else {
            viewConfig.getCssResources().addAll(0, pagesConfig.getDefaultCssResources());
            viewConfig.getJsResources().addAll(0, pagesConfig.getDefaultJsResources());
        }
        return viewConfig;
    }

    private PagesConfig readPagesConfig() {
    	InputStream is = getClass().getClassLoader().getResourceAsStream("pages.json");
        String json = new BufferedReader(new InputStreamReader(is)).lines()
        		   .parallel().collect(Collectors.joining("\n"));
        try {
			return new ObjectMapper().readValue(json, PagesConfig.class);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
