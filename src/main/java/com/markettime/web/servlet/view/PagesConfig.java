package com.markettime.web.servlet.view;

import java.util.List;

/**
 *
 * @author Radu Cosma
 *
 */
public class PagesConfig {

    private List<String> defaultCssResources;
    private List<String> defaultJsResources;
    private List<ViewConfig> views;

    public List<String> getDefaultCssResources() {
        return defaultCssResources;
    }

    public void setDefaultCssResources(List<String> defaultCssResources) {
        this.defaultCssResources = defaultCssResources;
    }

    public List<String> getDefaultJsResources() {
        return defaultJsResources;
    }

    public void setDefaultJsResources(List<String> defaultJsResources) {
        this.defaultJsResources = defaultJsResources;
    }

    public List<ViewConfig> getViews() {
        return views;
    }

    public void setViews(List<ViewConfig> views) {
        this.views = views;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PagesConfig [defaultCssResources=").append(defaultCssResources).append(", defaultJsResources=")
                .append(defaultJsResources).append(", views=").append(views).append("]");
        return builder.toString();
    }

}
