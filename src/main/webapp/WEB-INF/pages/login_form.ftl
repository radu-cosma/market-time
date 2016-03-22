<div class="modal fade" id="user-login" role="dialog">
	<div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Existing User</h4>
           	</div>
            <div class="modal-body">
	        	<div>
    	            <p>Have a MarketTime Account?</p>
                    <p>Sign in to manage your products.</p>
                    <br>
                </div>
                <form name="login" action="login" method="POST">
	             	<@createFieldSection 'email' 'EMAIL' 'text'/>
	             	<@createFieldSection 'passwprd' 'PASSWORD' 'password'/>
	             	<div class="checkbox">
	               		<label><input type="checkbox"> Remember me</label>
	             	</div>
					<p>Not a member? <a href="/market-time/register">Register</a></p>
	               	<button type="submit" class="btn btn-default">Submit</button>
               	</form>
               	<br>
               	<br>
			</div>
	    </div>
	</div>
</div>

<#if !sessionContext.loggedIn && errorMessage?? && errorMessage != ''> 
	<p><strong><@spring.message '${errorMessage}.LABEL'/></strong></p>
</#if>

<#macro createFieldSection fieldName fieldKey fieldType>
    <div class="form-group">
		<label class=""><@spring.message '${fieldKey}.LABEL'/></label>
		<input class="form-control" name="${fieldName}" type="${fieldType}" placeholder="<@spring.message '${fieldKey}.PLACEHOLDER'/>"/>
		<#if validationErrors?? && validationErrors["${fieldName}"]??>
			<label class=""><@spring.message '${validationErrors["${fieldName}"]}'/></label>
		</#if>
	</div>
</#macro>