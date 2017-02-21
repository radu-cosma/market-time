<#include "commons.ftl">

<section class="content-header">
      <h1><@spring.message 'SETTINGS.PAGE.TITLE'/></h1>
      <ol class="breadcrumb">
        <li><a href="/market-time/dashboard"><i class="fa fa-dashboard"></i><@spring.message 'NAV.HOME'/></a></li>
        <li class="active"><@spring.message 'SETTINGS.NAV.PAGE'/></li>
      </ol>
</section>

<section class="content">
	<div class="box box-success">
    	<div class="box-header with-border"></div>
    	<div class="row">
        	<div class="col-md-offset-1 col-md-10 col-xs-12 ">
				 <ul class="settings-list">
		            <li>	
		            	<div class="settings-details">
		            		<div class="row details-style">
	        	            	<div class="market-img">
	        	            		<img class="img-responsive img-style" src="images/wish-logo.png" alt="" />
	                            </div>
	                            <div class="col-2"> 
	                            <p>
	                            <a href="https://merchant.wish.com/" target="_blank">wish.com</a> 
	                            </p>
	                            <input type="checkbox" name="message" value=""/> Set this market as default
	                            </div>   
					        </div>
                            <form>
					            <div class="row form-style">
				                    <div class="col-sm-4 col-md-4 text-center">
				                        <@createInputSection 'username/email address' /> 
				                    </div>
				                    <div class="col-sm-4 col-md-4 text-center">
				                        <@createInputSection 'password' />
				                    </div>
				                    <div class="col-xs-6 col-sm-2 col-md-1">
				                        <button type="submit" class="btn save-btn">Save</button>            
				                    </div>
				                    <div class="col-xs-6 col-sm-2 col-md-3">
				                        <button type="submit" class="btn remove-btn">Remove</button>            
				                    </div>    
					            </div>
					        </form>
                   		</div> 
		            </li>
		        </ul>
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