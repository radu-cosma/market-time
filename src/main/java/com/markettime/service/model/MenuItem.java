package com.markettime.service.model;

import java.util.List;

/**
 *
 * @author Radu Cosma
 *
 */
public class MenuItem {

    private String titleKey;
    private String url;
    private String iconClass;
    private boolean active;
    private List<MenuItem> subMenuItems;

    public MenuItem() {
    }

    public MenuItem(String titleKey, String url, String iconClass, List<MenuItem> subMenuItems) {
        this.titleKey = titleKey;
        this.url = url;
        this.iconClass = iconClass;
        this.subMenuItems = subMenuItems;
    }

    public String getTitleKey() {
        return titleKey;
    }

    public void setTitleKey(String titleKey) {
        this.titleKey = titleKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<MenuItem> getSubMenuItems() {
        return subMenuItems;
    }

    public void setSubMenuItems(List<MenuItem> subMenuItems) {
        this.subMenuItems = subMenuItems;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MenuItem [titleKey=").append(titleKey).append(", url=").append(url).append(", iconClass=")
                .append(iconClass).append(", active=").append(active).append(", subMenuItems=").append(subMenuItems)
                .append("]");
        return builder.toString();
    }

}
