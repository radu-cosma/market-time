<form name="register" action="register" method="POST">
	<div id="registration-container">
		<table>
			<@createRow 'firstName' 'FIRST.NAME'/>
			<@createRow 'lastName' 'LAST.NAME'/>
			<@createRow 'email' 'EMAIL'/>
			<@createRow 'password' 'PASSWORD'/>
			<@createRow 'repeatPassword' 'REPEAT.PASSWORD'/>
			<@createRow 'companyName' 'COMPANY.NAME'/>
			<@createRow 'companyAddress' 'COMPANY.ADDRESS'/>
			<@createRow 'companyPhone' 'COMPANY.PHONE'/>
			<tr>
				<td><button class="" id="login-button"><@spring.message 'REGISTRATION.REGISTER.BUTTON'/></button></td>
			</tr>
		</table>
	</div>
</form>
<#if !sessionContext.loggedIn && errorMessage?? && errorMessage != ''> 
	<p><strong><@spring.message '${errorMessage}.LABEL'/></strong></p>
</#if>

<#macro createRow fieldName fieldKey>
	<tr>
		<td><label class=""><@spring.message 'REGISTRATION.${fieldKey}.LABEL'/></label></td>
		<td><input class="" name="${fieldName}" type="text" placeholder="<@spring.message 'REGISTRATION.${fieldKey}.PLACEHOLDER'/>"/></td>
		<#if validationErrors?? && validationErrors["${fieldName}"]??>
			<td><label class=""><@spring.message '${validationErrors["${fieldName}"]}'/></label></td>
		</#if>
	</tr>  
</#macro>