<section class="content-header">
    <h1><@spring.message 'PROFILE.HEADER.TITLE'/></h1>
    <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAV.HOME'/></a></li>
        <li class="active"><@spring.message 'NAV.MY.PROFILE'/></li>
    </ol>
</section>

<section class="content">
    <div class="box box-success">
        <div class="box-header with-border"> </div>
        <div class="container">
            <div class="col-md-1 "> </div>
            <div class="my-profile-tab-container col-md-8 tab-content">
            	<label id="general-error-message" class="error-message hidden"></label>
	   			<label id="success-message" class="success-message hidden"></label>
                <ul class="nav nav-tabs">
                    <li id="profile-tab" class="active"><a data-toggle="tab" href="#profile"><@spring.message 'PROFILE.PROFILE.TAB.TITLE'/></a></li>
                    <li id="email-password-tab"><a data-toggle="tab" href="#emailpassword"><@spring.message 'PROFILE.EMAIL.PASSWORD.TAB.TITLE'/></a></li>
                </ul>
            	<div id="profile" class="tab-pane active">
                    <div class="panel-body">
	                    <@customerProfileInfo />
                        <@customerProfileForm />
                    </div>
                </div>
                <div id="emailpassword" class="tab-pane fade">
                    <div class="panel-body">
                        <@customerEmailInfo />
                        <@customerEmailForm />
                    	<div class="panel-separator"></div>
                        <@customerPasswordInfo />
                        <@customerPasswordForm />
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<#macro customerProfileInfo>
	<div id="customer-profile-info" class="form-horizontal">
	    <@createInfoSection 'first-name' />
	    <@createInfoSection 'last-name' />
	    <@createInfoSection 'company-name' />
	    <@createInfoSection 'company-address' />
	    <@createInfoSection 'company-phone' />
	    <@createEditButton 'edit-profile' />
	</div>
</#macro>

<#macro customerProfileForm>
	<div id="customer-profile-form" class="form-horizontal hidden">
	    <form role="form" autocomplete="off">
	        <@createInputSection 'first-name' />
	        <@createInputSection 'last-name' />
	        <@createInputSection 'company-name' />
	        <@createInputSection 'company-address' />
	        <@createInputSection 'company-phone' />
	        <@createInputSection 'profile-current-password' 'password' />
	        <@createSaveAndCancelButtons 'profile' />
	    </form>
    </div>
</#macro>

<#macro customerEmailInfo>
	<div id="customer-email-info" class="form-horizontal">
        <@createInfoSection 'email' />
        <@createEditButton 'edit-email' />
    </div>
</#macro>

<#macro customerEmailForm>
	<div id="customer-email-form" class="form-horizontal hidden">
	    <form role="form" autocomplete="off">
	        <@createInputSection 'email' />
	        <@createInputSection 'confirm-email' />
	        <@createInputSection 'email-current-password' 'password' />
	        <@createSaveAndCancelButtons 'email' />
	    </form>
	</div>
</#macro>

<#macro customerPasswordInfo>
	<div id="customer-password-info" class="form-horizontal">
	    <@createInfoSection 'password' />
	    <@createEditButton 'edit-password' />
	</div>
</#macro>

<#macro customerPasswordForm>
	<div id="customer-password-form" class="form-horizontal hidden">
        <form role="form" autocomplete="off">
            <@createInputSection 'password-current-password' 'password' />  
            <@createInputSection 'new-password' 'password' />  
            <@createInputSection 'confirm-password' 'password' />  
            <@createSaveAndCancelButtons 'password' />
        </form>
    </div>
</#macro>

<#macro createInfoSection fieldId>
	<#local fieldName = buildName(fieldId) >
	<#local fieldKey = buildKey(fieldId) >
	<#if profile??>
		<@'<#assign fieldValue = ${"profile." + "${fieldName}"}!"">'?interpret />
	</#if>
	<div class="form-group">
        <label class="control-label col-sm-4"><@spring.message 'PROFILE.${fieldKey}.LABEL'/></label>
        <div class="col-sm-8">
            <span id="${fieldId}-info" class="col-md-8 columns-view"><#if fieldValue??>${fieldValue}</#if></span>
        </div>
    </div>
</#macro>

<#macro createInputSection fieldId fieldType="text" >
	<#local fieldName = buildName(fieldId) >
	<#local fieldKey = buildKey(fieldId) >
	<#if profile??>
		<@'<#assign fieldValue = ${"profile." + "${fieldName}"}!"">'?interpret />
	</#if>
	<div class="form-group">
        <label class="control-label col-sm-4" for="${fieldId}"><@spring.message 'PROFILE.${fieldKey}.LABEL'/>*</label>
        <div class="col-sm-8">
            <input type="${fieldType}" class="form-control" id="${fieldId}" name="${fieldName}" <#if fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> placeholder="<@spring.message 'PROFILE.${fieldKey}.PLACEHOLDER'/>" >
        	<div class="tooltip-wrapper">
        		<span id="${fieldId}-tooltip" class="error-tooltip"></span>
        	</div>
        </div>
    </div>
</#macro>

<#macro createEditButton buttonId >
	<#local buttonKey = buildKey(buttonId) >
	<div class="form-group">
        <div class="col-sm-offset-4 col-sm-8">
            <a id="${buttonId}-button" class="btn btn-default"><@spring.message 'PROFILE.${buttonKey}.BUTTON'/></a>
        </div>
    </div>
</#macro>

<#macro createSaveAndCancelButtons what>
	<div class="form-group">
        <div class="col-sm-offset-4 col-sm-8">
            <button id="update-${what}-button" type="submit" class="btn btn-default">
            	<span><@spring.message 'PROFILE.SAVE.BUTTON'/></span>
            	<div id="update-${what}-spinner" class="loading hidden"></div>
            </button>
            <a id="cancel-${what}-button"><@spring.message 'PROFILE.CANCEL.BUTTON'/></a>
        </div>
    </div>
</#macro>

<#function buildName fieldId>
  	<#return fieldId?replace('-', ' ')?capitalize?replace(' ', '')?uncap_first >
</#function>

<#function buildKey fieldId>
  	<#return fieldId?replace('-', '.')?upper_case >
</#function>