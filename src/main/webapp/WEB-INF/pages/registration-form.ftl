<#include "commons.ftl">

<div class="container-fluid reg-container">
    <div class="row">     
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <div class="md-title">
                Sign Up to MarketTime
                <br>
                New User
            </div>
            <div class="xs-title">
		        Get easy access to your products
            </div> 
        </div> 
    </div>  
    <#if generalErrorMessage??>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-1">
                <div id="general-error-message" class="error-message alert alert-danger hidden">
                    <a href="#" class="close-message close">&times;</a>
                    <strong>!</strong>${generalErrorMessage}
                </div>
            </div>
        </div>
    </#if>
    <form name="register" action="register" method="POST">
        <div class="row"> 
            <div class="col-md-5 col-md-offset-1 col-sm-6">
                <@createInputSection 'first-name' />    
                <@createInputSection 'last-name' />
                <@createInputSection 'password' 'password'/>
                <@createInputSection 'confirm-password' 'password'/>    
            </div> 
            <div class="col-md-5 col-sm-6">
                <@createInputSection 'email' />
                <@createInputSection 'company-name' />
                <@createInputSection 'company-address' />
                <@createInputSection 'company-phone' />  
            </div> 
        </div>
        <div class="row">   
            <div class="col-xs-12 col-md-10 col-md-offset-1">
                <div class="checkbox">
                    <label><input type="checkbox"> Yes, I would like to receive informations, discounts from MarkettTime</label>
                </div>
                <button id="login-button" type="submit" class="stylish-pz-p-btn btn button-default">Submit</button>
            </div>
        </div> 
    </form>
</div>  

<#macro createInputSection fieldId fieldType='text'>
    <#local fieldName = buildName(fieldId) >
    <#local fieldKey = buildKey(fieldId) >
    <#assign hasError=false/>
    <#if validationErrors?? && validationErrors["${fieldName}"]??>
        <#assign hasError=true/>
    </#if>
    <#if registration??>
        <@'<#assign fieldValue = ${"registration." + "${fieldName}"}!"">'?interpret />
    </#if>
    <div class="form-group">
        <label><@spring.message 'REGISTRATION.${fieldKey}.LABEL'/></label>
        <div>
            <input <#if !hasError && fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> class="form-control <#if hasError>has-error</#if>" name="${fieldName}" id="${fieldId}" type="${fieldType}" placeholder="<@spring.message 'REGISTRATION.${fieldKey}.PLACEHOLDER'/>">
            <div class="tooltip-wrapper">
                <span id="${fieldId}-tooltip" class="error-tooltip"><#if hasError><@spring.message '${validationErrors["${fieldName}"]}'/></#if></span>
            </div>
        </div>
    </div>    
</#macro>
