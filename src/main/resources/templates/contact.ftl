<#include "commons.ftl">

<div id="contact-container">
	<div class="contact-container-background">
		<div class="details-container container-fluid">
		    <div class="row">		    
		        <div class="col-xs-12 col-md-8 col-md-offset-2">
		            <div class="contact-title md-title">
		                <@spring.message 'CONTACT.US.TITTLE'/>
		            </div>
		        </div>		        
		        <div id="details-contact" class="col-xs-12 col-md-8 col-md-offset-2">
		        	<div class="col-md-2 col-xs-1">
			            <p><span class="contact-icon glyphicon glyphicon-map-marker">      
		            </div>
		            <div class="address-contact contact-message col-md-4 col-xs-10">
			            <p>Cluj-Napoca, RO</p>
			            <p>Eroilor</p>
			            <p>Postal code: 400129</p>      
		            </div>
		            <div class="contact-message col-md-6 col-xs-12">
			            <p><span class="glyphicon glyphicon-phone"></span> 0040 747123123</p>
		                <p>&nbsp; &nbsp; &nbsp; 0040 747123123</p>
			            <p><span class="glyphicon glyphicon-envelope"></span> office@markettime.com</p>      
		            </div>
		        </div>	       		        
		        <div class="contact-form col-md-4 col-md-offset-2 col-xs-12">
			        <form>
				    	<div class="form-group">
                            <@createInputSection 'name' /> 
				            <@createInputSection 'email' />
				            <textarea class="form-control" id="comment" name="comment" placeholder="comment" rows="10"></textarea>
				            <div class="textarea-tooltip tooltip-wrapper">
				                <span id="comment-tooltip" class="error-tooltip"></span>
				            </div>
				            <button type="submit" id="contact-btn"class="contact-btn btn stylish-btn"><@spring.message 'CONTACT.US.SEND.BUTTON'/></button> 
				        </div>
			        </form>
		        </div> 
		        <div class="contact-map col-md-4 col-xs-12">
		        	<div id="google-map"/>
		    	</div>   	
		        <div class="media">      
		    		<img class="media-icon" src="/market-time/images/skype-icon.svg">
		    		<img class="media-icon" src="/market-time/images/linkedin-icon.svg">  		
		    		<img class="media-icon" src="/market-time/images/facebook-icon.svg">
		    	</div>
		    </div>
	    </div>
    </div>
</div>

<#macro createInputSection fieldId>
    <#local fieldName = buildName(fieldId) >
    <#local fieldKey = buildKey(fieldId) >
    <#assign hasError=false/>
    <#if validationErrors?? && validationErrors["${fieldName}"]??>
        <#assign hasError=true/>
    </#if>  
        <div>
            <input <#if !hasError && fieldValue?? && fieldValue != "">value="${fieldValue}"</#if> class="form-control <#if hasError>has-error</#if>" name="${fieldName}" id="${fieldId}" type="text" placeholder="${fieldName}">
            <div class="tooltip-wrapper">
                <span id="${fieldId}-tooltip" class="error-tooltip"><#if hasError><@spring.message '${validationErrors["${fieldName}"]}'/></#if></span>
            </div>
        </div>   
</#macro>
