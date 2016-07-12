package com.markettime.context;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Radu Cosma
 *
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestContext {

    private String returnToViewName;
    private String modelObjectName;
    private Object modelObject;

    public String getReturnToViewName() {
        return returnToViewName;
    }

    public void setReturnToViewName(String returnToViewName) {
        this.returnToViewName = returnToViewName;
    }

    public String getModelObjectName() {
        return modelObjectName;
    }

    public void setModelObjectName(String modelObjectName) {
        this.modelObjectName = modelObjectName;
    }

    public Object getModelObject() {
        return modelObject;
    }

    public void setModelObject(Object modelObject) {
        this.modelObject = modelObject;
    }

}
