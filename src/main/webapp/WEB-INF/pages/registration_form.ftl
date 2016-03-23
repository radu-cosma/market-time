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

		<form name="register" action="register" method="POST">
	  		<div class="row"> 
	      		<div class="col-sm-5 reg-form"> 
	       			<div class="reg-form1">
	         			<@createInputSection 'firstName' 'FIRST.NAME'/>    
						<@createInputSection 'lastName' 'LAST.NAME'/>
	         			<@createInputSection 'email' 'EMAIL' 'email'/>
						<@createInputSection 'password' 'PASSWORD' 'password'/>
						<@createInputSection 'repeatPassword' 'REPEAT.PASSWORD' 'password'/>
	         		</div>    
	       		</div> 
	      		<div class="col-sm-5">
		        	<div class="reg-form2">
						<@createInputSection 'companyName' 'COMPANY.NAME'/>
						<@createInputSection 'companyAddress' 'COMPANY.ADDRESS'/>
						<@createInputSection 'companyPhone' 'COMPANY.PHONE'/>
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

<#macro createInputSection fieldName fieldKey fieldType='text'>
	<div class="form-group">
		<label class=""><@spring.message 'REGISTRATION.${fieldKey}.LABEL'/></label>
		<input class="form-control" name="${fieldName}" id="${fieldName}" type="${fieldType}" placeholder="<@spring.message 'REGISTRATION.${fieldKey}.PLACEHOLDER'/>">
		<#if validationErrors?? && validationErrors["${fieldName}"]??>
			<td><label class=""><@spring.message '${validationErrors["${fieldName}"]}'/></label></td>
		</#if>
	</div>    
</#macro>