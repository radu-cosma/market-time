package com.markettime.web.servlet.view;

/**
 *
 * @author Radu Cosma
 *
 */
public class ViewCriteria {

    private String name;
    private Boolean loggedIn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ViewCriteria [name=").append(name).append(", loggedIn=").append(loggedIn).append("]");
        return builder.toString();
    }

}
