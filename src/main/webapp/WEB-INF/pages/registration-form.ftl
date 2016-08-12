<div class="container-fluid">
   	<div class="cont-style">
      	<h2 class="text-center">Sign Up to MarketTime</h2> 

  		<div class="row">     
     		<div class="col-sm-11">
        		<div>
        			<h4 class="form-title">New User</h4>
           			<div>
             			<p>Get easy access to your products</p>
             			<br>
           			</div>  
        		</div>
      		</div> 
   		</div>  
   		<#if generalErrorMessage??>
   			<div class="row">
	   			<div class="col-xs-10 col-sm-10 col-md-10">
					<div id="general-error-message" class="error-message alert alert-danger hidden">
						<a href="#" class="close-message close">&times;</a>
						<strong>!</strong>${generalErrorMessage}
					</div>
				</div>
			</div>
   		</#if>
		<form name="register" action="register" method="POST">
	  		<div class="row"> 
	      		<div class="col-sm-5 reg-form"> 
	       			<div class="reg-form1">
	         			<@createInputSection 'first-name' />    
						<@createInputSection 'last-name' />
	         			<@createInputSection 'email' />
						<@createInputSection 'password' 'password'/>
						<@createInputSection 'confirm-password' 'password'/>
	         		</div>    
	       		</div> 
	      		<div class="col-sm-5">
		        	<div class="reg-form2">
						<@createInputSection 'company-name' />
						<@createInputSection 'company-address' />
						<@createInputSection 'company-phone' />
		          	</div>  
		    	</div> 
		    </div>
	    	<div class="row">   
	    		<div class="col-sm-11">
	         		<div class="checkbox">
	           			<label><input type="checkbox"> Yes, I would like to receive informations, discounts from MarkettTime</label>
	         		</div>
	       			<button type="submit" class="btn btn-default">Submit</button>
	    		</div>
	  		</div> 
  		</form>
	</div>
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

<#function buildName fieldId>
  	<#return fieldId?replace('-', ' ')?capitalize?replace(' ', '')?uncap_first >
</#function>

<#function buildKey fieldId>
  	<#return fieldId?replace('-', '.')?upper_case >
</#function>