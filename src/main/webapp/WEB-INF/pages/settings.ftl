<#include "commons.ftl">

<section class="content-header">
      <h1><@spring.message 'SETTINGS.PAGE.TITLE'/></h1>
      <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAVIGATION.HOME'/></a></li>
        <li class="active"><@spring.message 'NAVIGATION.SETTINGS'/></li>
      </ol>
</section>

<section class="content">
	<div class="box box-success">
    	<div class="box-header with-border"></div>
    	<div class="row">
        	<div class="col-md-offset-1 col-md-10 col-xs-12 ">
        	     <@createMarketSettings formMarketId='wish' marketSrcImg='images/wish-logo.png' marketAltImg='wish' marketUrl='https://merchant.wish.com/' marketName='wish.com' hasMessageSuccess=true/>
                 <@createMarketSettings formMarketId='amazon' marketSrcImg='images/wish-logo.png' marketAltImg='amazon' marketUrl='https://merchant.wish.com/' marketName='amazon.com' hasMessageError=true/> 
                 <@createMarketSettings formMarketId='ebay' marketSrcImg='images/wish-logo.png' marketAltImg='ebay' marketUrl='https://merchant.wish.com/' marketName='ebay.com' hasMessageSuccess=false hasMessageError=false/>   
	        </div>
        </div>
	</div>
</section>

<#macro createInputSection fieldId>
    <#local fieldName = buildName(fieldId) >
    <#local fieldKey = buildKey(fieldId) >
    <#assign hasError=false/>
    <#if validationErrors?? && validationErrors["${fieldName}"]??>
        <#assign hasError=true/>
    </#if>  
    <div class="form-group">
        <div>
            <input <#if !hasError && fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> class="form-control <#if hasError>has-error</#if>" name="${fieldName}" id="${fieldId}" type="text" placeholder="${fieldName}">
            <div class="tooltip-wrapper">
                <span id="${fieldId}-tooltip" class="error-tooltip"><#if hasError><@spring.message '${validationErrors["${fieldName}"]}'/></#if></span>
            </div>
        </div>
    </div>    
</#macro>

<#macro createMarketSettings formMarketId marketSrcImg marketAltImg marketUrl marketName hasMessageSuccess=false hasMessageError=false>
    <div class="panel settings-details">
        <div>
            <#if hasMessageSuccess><i class="fa fa-check message-success" aria-hidden="true"> Login data successfully saved.</i></#if>  
            <#if hasMessageError><i class="fa fa-exclamation message-error" aria-hidden="true"> Login data not valid.</i></#if>
        </div>
        <div class="panel-heading market">
            <aside  class="market-img">
                <img class="img-responsive img-style" src="${marketSrcImg}" alt="${marketAltImg}" />
            </aside>
            <div class="market-settings">
                <p>
                <a class="market-url" href="${marketUrl}" target="_blank">${marketName}</a> 
                </p>
                <input class="check" type="checkbox" name="check as default " value="default"/> <@spring.message 'SETTINGS.CHECK.DEFAULT'/>
            </div>
            <aside class="collapse-btn">
               <p><span class="details glyphicon-mob pull-right clickable"><@spring.message 'SETTINGS.COLLAPSE.LINK'/> <i class="glyphicon glyphicon-chevron-down"></i></span></p>
            </aside>
        </div>
        <div class="panel-collapse collapse">
            <div class="settings-form">
                <form id='${formMarketId}'>
                    <div class="row form-style">
                        <div class="col-sm-4 col-md-4 text-center">
                            <@createInputSection 'email' /> 
                        </div>
                        <div class="col-sm-4 col-md-4 text-center">
                            <@createInputSection 'password' />
                        </div>
                        <div class="col-xs-6 col-sm-2 col-md-2">
                            <button type="submit" class="btn form-btn blue""><@spring.message 'SETTINGS.SAVE.BUTTON'/></button>            
                        </div>
                        <div class="col-xs-6 col-sm-2 col-md-2">
                            <button type="submit" class="btn form-btn delete-btn display-btn"><@spring.message 'SETTINGS.REMOVE.BUTTON'/></button>        
                        </div> 
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>
