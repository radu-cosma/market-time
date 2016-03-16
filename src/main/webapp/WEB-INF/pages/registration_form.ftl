<form name="register" action="register" method="POST">
	<div id="registration-container">
		<table>
			<tr>
				<td><label class=""><@spring.message 'REGISTRATION.FIRST.NAME.LABEL'/></label></td>
				<td><input class="" name="firstName" type="text" placeholder="<@spring.message 'REGISTRATION.FIRST.NAME.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><label class=""><@spring.message 'REGISTRATION.LAST.NAME.LABEL'/></label></td>
				<td><input class="" name="lastName" type="text" placeholder="<@spring.message 'REGISTRATION.LAST.NAME.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><label class=""><@spring.message 'REGISTRATION.EMAIL.LABEL'/></label></td>
				<td><input class="" name="email" type="text" placeholder="<@spring.message 'REGISTRATION.EMAIL.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><label class=""><@spring.message 'REGISTRATION.PASSWORD.LABEL'/></label></td>
				<td><input class="" name="password" type="password" placeholder="<@spring.message 'REGISTRATION.PASSWORD.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><label class=""><@spring.message 'REGISTRATION.REPEAT.PASSWORD.LABEL'/></label></td>
				<td><input class="" name="repeatPassword" type="password" placeholder="<@spring.message 'REGISTRATION.PASSWORD.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><label class=""><@spring.message 'REGISTRATION.COMPANY.NAME.LABEL'/></label></td>
				<td><input class="" name="companyName" type="text" placeholder="<@spring.message 'REGISTRATION.COMPANY.NAME.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><label class="login"><@spring.message 'REGISTRATION.COMPANY.ADDRESS.LABEL'/></label></td>
				<td><input class="login rounded" name="companyAddress" type="text" placeholder="<@spring.message 'REGISTRATION.COMPANY.ADDRESS.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><label class="login"><@spring.message 'REGISTRATION.COMPANY.PHONE.LABEL'/></label></td>
				<td><input class="login rounded" name="companyPhone" type="text" placeholder="<@spring.message 'REGISTRATION.COMPANY.PHONE.PLACEHOLDER'/>"/></td>
			</tr>
			<tr>
				<td><button class="" id="login-button"><@spring.message 'REGISTRATION.REGISTER.BUTTON'/></button></td>
			</tr>
		</table>
	</div>
</form>
<#if !sessionContext.loggedIn && errorMessage?? && errorMessage != ''> 
	<p><strong><@spring.message '${errorMessage}.LABEL'/></strong></p>
</#if>