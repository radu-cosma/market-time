package com.markettime.web.servlet.view;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Radu Cosma
 *
 */
public class ViewConfig {

    private ViewCriteria criteria;
    private Map<String, String> sections;
    private List<String> cssResources;
    private List<String> jsResources;

    public ViewCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(ViewCriteria criteria) {
        this.criteria = criteria;
    }

    public Map<String, String> getSections() {
        return sections;
    }

    public void setSections(Map<String, String> sections) {
        this.sections = sections;
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
        builder.append("ViewConfig [criteria=").append(criteria).append(", sections=").append(sections)
                .append(", cssResources=").append(cssResources).append(", jsResources=").append(jsResources)
                .append("]");
        return builder.toString();
    }

}
