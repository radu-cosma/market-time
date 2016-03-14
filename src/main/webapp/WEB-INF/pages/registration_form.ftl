<form name="register" action="register" method="POST">
	<div id="registration-container">
		<table>
			<tr>
				<td><label class="login"><@spring.message 'USERNAME.LABEL'/></label></td>
				<td><label class="login"><@spring.message 'PASSWORD.LABEL'/></label></td>
				<td><label class="login"><@spring.message 'REPEAT.PASSWORD.LABEL'/></label></td>
			</tr>
			<tr>
				<td><input class="login rounded" name="username" type="text" placeholder="<@spring.message 'USERNAME.PLACEHOLDER'/>"/></td>
				<td><input class="login rounded" name="password" type="password" placeholder="<@spring.message 'PASSWORD.PLACEHOLDER'/>"/></td>
				<td><input class="login rounded" name="repeatPassword" type="password" placeholder="<@spring.message 'PASSWORD.PLACEHOLDER'/>"/></td>
				<td><button class="standard-button login rounded" id="login-button"><@spring.message 'REGISTER.BUTTON'/></button></td>
			</tr>
		</table>
	</div>
</form>
<p>Not a member? <a href="/market-time/register">Register</a></p>
<#if !sessionContext.loggedIn && errorMessage?? && errorMessage != ''> 
	<p><strong><@spring.message '${errorMessage}.LABEL'/></strong></p>
</#if>