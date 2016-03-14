<form name="login" action="login" method="POST">
	<div id="login-container">
		<table>
			<tr>
				<td><label class="login"><@spring.message 'USERNAME.LABEL'/></label></td>
				<td><label class="login"><@spring.message 'PASSWORD.LABEL'/></label></td>
			</tr>
			<tr>
				<td><input class="login rounded" name="username" type="text" placeholder="<@spring.message 'USERNAME.PLACEHOLDER'/>"/></td>
				<td><input class="login rounded" name="password" type="password" placeholder="<@spring.message 'PASSWORD.PLACEHOLDER'/>"/></td>
				<td><button class="standard-button login rounded" id="login-button"><@spring.message 'LOGIN.BUTTON'/></button></td>
			</tr>
		</table>
	</div>
</form>
<p>Not a member? <a href="/market-time/register">Register</a></p>
<#if !sessionContext.loggedIn && errorMessage?? && errorMessage != ''> 
	<p><strong><@spring.message '${errorMessage}.LABEL'/></strong></p>
</#if>