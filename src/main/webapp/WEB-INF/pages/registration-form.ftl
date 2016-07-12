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
             			<br>
           			</div>  
        		</div>
      		</div> 
   		</div>  
   		
   		<#if generalErrorMessage??>
   			<label class="error-message">${generalErrorMessage}</label>
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
	           			<label><input type="checkbox"> Yes, I would like to receive informations, discounts from MartTime</label>
	         		</div>
	       			<button type="submit" class="btn btn-default">Submit</button>
	    		</div>
	  		</div> 
  		</form>
	</div>
</div>  

<#macro createInputSection fieldId fieldType='text'>
	<#assign hasError=false/>
	<#if validationErrors?? && validationErrors["${fieldId}"]??>
		<#assign hasError=true/>
	</#if>
	<#local fieldName = buildName(fieldId) >
	<#local fieldKey = buildKey(fieldId) >
	<#if registration??>
		<@'<#assign fieldValue = ${"registration." + "${fieldId}"}!"">'?interpret />
	</#if>
	<div class="form-group">
		<label><@spring.message 'REGISTRATION.${fieldKey}.LABEL'/></label>
		<div>
			<input value="<#if !hasError && fieldValue??>${fieldValue}</#if>" class="form-control <#if hasError>has-error</#if>" name="${fieldName}" id="${fieldId}" type="${fieldType}" placeholder="<@spring.message 'REGISTRATION.${fieldKey}.PLACEHOLDER'/>">
			<div class="tooltip-wrapper">
	    		<span class="error-tooltip"></span>
	    	</div>
    	</div>
		<#if hasError>
			<td><label class="error-message"><@spring.message '${validationErrors["${fieldId}"]}'/></label></td>
		</#if>
	</div>    
</#macro>

<#function buildName fieldId>
  	<#return fieldId?replace('-', ' ')?capitalize?replace(' ', '')?uncap_first >
</#function>

<#function buildKey fieldId>
  	<#return fieldId?replace('-', '.')?upper_case >
</#function>