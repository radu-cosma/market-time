<div class="modal fade" id="user-login" role="dialog">
	<div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Existing User</h4>
           	</div>
            <div class="modal-body">
	        	<div id="modal-header">
    	            <p>Have a MarketTime Account?</p>
                    <p>Sign in to manage your products.</p>
                    <br>
                </div>
                <label id="general-error-message" class="error-message hidden""></label>
                <div id="email-div">
	             	<@createInputSection 'email' 'EMAIL'/>
	            </div>
	            <div id="password-div">
	             	<@createInputSection 'password' 'PASSWORD' 'password'/>
	            </div>
	             	<div class="checkbox">
	               		<label><input type="checkbox"> Remember me</label>
	             	</div>
					<p>Not a member? <a href="/market-time/register">Register</a></p>
	               	<button id="login-button" type="submit" class="btn btn-default">Submit</button>
               	<br>
               	<br>
			</div>
	    </div>
	</div>
</div>

<#macro createInputSection fieldName fieldKey fieldType='text'>
    <div class="form-group">
		<label class=""><@spring.message '${fieldKey}.LABEL'/></label>
		<input class="form-control" id="${fieldName}" type="${fieldType}" placeholder="<@spring.message '${fieldKey}.PLACEHOLDER'/>"/>
		<label id="${fieldName}-error-message" class="error-message hidden"></label>
	</div>
</#macro>