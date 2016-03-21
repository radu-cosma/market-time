package com.markettime.web.servlet.view;

import java.util.List;

/**
 *
 * @author Radu Cosma
 *
 */
public class ViewConfig {

    private String viewName;
    private String headerName;
    private String footerName;
    private String layoutName;
    private List<String> cssResources;
    private List<String> jsResources;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getFooterName() {
        return footerName;
    }

    public void setFooterName(String footerName) {
        this.footerName = footerName;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public List<String> getCssResources() {
        return cssResources;
    }

    public void setCssResources(List<String> cssResources) {
        this.cssResources = cssResources;
    }

    public List<String> getJsResources() {
        return jsResources;
    }

    public void setJsResources(List<String> jsResources) {
        this.jsResources = jsResources;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ViewConfig [viewName=").append(viewName).append(", headerName=").append(headerName)
                .append(", footerName=").append(footerName).append(", layoutName=").append(layoutName)
                .append(", cssResources=").append(cssResources).append(", jsResources=").append(jsResources)
                .append("]");
        return builder.toString();
    }

}
