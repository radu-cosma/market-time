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
        	<div class="col-md-offset-1 col-md-10 col-xs-12">
        	     <@createMarketSettings marketId='wish' marketSrcImg='images/wish-logo.png' marketAltImg='wish' marketUrl='https://merchant.wish.com/' marketName='wish.com' hasSuccessMessage=true/>
                 <@createMarketSettings marketId='amazon' marketSrcImg='images/wish-logo.png' marketAltImg='amazon' marketUrl='https://merchant.wish.com/' marketName='amazon.com' hasErrorMessage=true/> 
                 <@createMarketSettings marketId='ebay' marketSrcImg='images/wish-logo.png' marketAltImg='ebay' marketUrl='https://merchant.wish.com/' marketName='ebay.com' hasSuccessMessage=false hasErrorMessage=false/>   
	        </div>
        </div>
	</div>
</section>

<#macro createInputSection fieldId placeholder fieldType="text">
    <#local fieldName = buildName(fieldId) >
    <div class="form-group">
        <input class="form-control" id="${fieldId}" type="${fieldType}" placeholder="${placeholder}" readonly>
        <div class="tooltip-wrapper">
            <span id="${fieldId}-tooltip" class="error-tooltip"></span>
        </div>
    </div>    
</#macro>

<#macro createMarketSettings marketId marketSrcImg marketAltImg marketUrl marketName hasSuccessMessage=false hasErrorMessage=false>
    <#local emailPlaceholder><@spring.messageArgs 'SETTINGS.EMAIL.PLACEHOLDER', [marketId]/></#local>
    <#local passwordPlaceholder><@spring.messageArgs 'SETTINGS.PASSWORD.PLACEHOLDER', [marketId]/></#local>
    <div class="panel settings-details">
        <div>
            <#if hasSuccessMessage><span class="fa fa-check success-message"> Login data successfully saved.</span></#if>  
            <#if hasErrorMessage><span class="fa fa-exclamation error-message"> Login data not valid.</span></#if>
        </div>
        <div class="panel-heading market">
            <aside  class="market-img">
                <img class="img-responsive img-style" src="${marketSrcImg}" alt="${marketAltImg}" />
            </aside>
            <div class="market-settings">
                <p><a class="market-url" href="${marketUrl}" target="_blank">${marketName}</a></p>
                <input class="check" type="checkbox" name="check as default" value="default"/> <@spring.message 'SETTINGS.CHECK.DEFAULT'/>
            </div>
            <aside class="collapse-btn">
               <p><span class="details glyphicon-mob pull-right clickable"><@spring.message 'SETTINGS.COLLAPSE.LINK'/> <i class="glyphicon glyphicon-chevron-down"></i></span></p>
            </aside>
        </div>
        <div class="panel-collapse collapse">
            <div class="settings-form">
                <form id='${marketId}'>
                    <div class="row form-style">
                        <div class="col-sm-4 col-md-4 text-center">
                            <@createInputSection fieldId='${marketId}-email' placeholder='${emailPlaceholder}'/> 
                        </div>
                        <div class="col-sm-4 col-md-4 text-center">
                            <@createInputSection fieldId='${marketId}-password' placeholder='${passwordPlaceholder}' fieldType='password' />
                        </div>
                        <div class="col-xs-6 col-sm-2 col-md-2">
                            <button type="submit" class="btn form-btn blue""><@spring.message 'SETTINGS.SAVE.BUTTON'/></button>            
                        </div>
                        <div class="col-xs-6 col-sm-2 col-md-2">
                            <a class="btn form-btn delete-btn display-btn"><@spring.message 'SETTINGS.REMOVE.BUTTON'/></a>        
                        </div> 
                    </div>
                </form>
            </div>
        </div>
    </div>
</#macro>

