<form name="login" action="login" method="POST">
	<div id="login-container">
		<table>
			<@createRow 'email' 'EMAIL'/>
			<@createRow 'password' 'PASSWORD'/>
			<tr>
				<td><button class="" id="login-button"><@spring.message 'LOGIN.BUTTON'/></button></td>
			</tr>
		</table>
	</div>
</form>
<p>Not a member? <a href="/market-time/register">Register</a></p>
<#if !sessionContext.loggedIn && errorMessage?? && errorMessage != ''> 
	<p><strong><@spring.message '${errorMessage}.LABEL'/></strong></p>
</#if>

<#macro createRow fieldName messageKeyPrefix>
	<tr>
		<td><label class=""><@spring.message '${messageKeyPrefix}.LABEL'/></label></td>
		<td><input class="" name="${fieldName}" type="text" placeholder="<@spring.message '${messageKeyPrefix}.PLACEHOLDER'/>"/></td>
		<#if validationErrors?? && validationErrors["${fieldName}"]??>
			<td><label class=""><@spring.message '${validationErrors["${fieldName}"]}'/></label></td>
		</#if>
	</tr>  
</#macro>