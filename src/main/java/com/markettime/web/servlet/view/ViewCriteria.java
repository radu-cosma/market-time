package com.markettime.web.servlet.view;

import com.markettime.model.entity.UserRole;

/**
 *
 * @author Radu Cosma
 *
 */
public class ViewCriteria {

    private String name;
    private Boolean loggedIn;
    private UserRole userRole;

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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ViewCriteria [name=").append(name).append(", loggedIn=").append(loggedIn).append("]");
        return builder.toString();
    }

}
