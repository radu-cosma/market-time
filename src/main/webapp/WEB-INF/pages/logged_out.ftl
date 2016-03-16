<form name="login" action="login" method="POST">
	<div id="login-container">
		<table>
			<tr>
				<td><label class=""><@spring.message 'EMAIL.LABEL'/></label></td>
				<td><label class=""><@spring.message 'PASSWORD.LABEL'/></label></td>
			</tr>
			<tr>
				<td><input class="" name="email" type="text" placeholder="<@spring.message 'EMAIL.PLACEHOLDER'/>"/></td>
				<td><input class="" name="password" type="password" placeholder="<@spring.message 'PASSWORD.PLACEHOLDER'/>"/></td>
				<td><button class="" id="login-button"><@spring.message 'LOGIN.BUTTON'/></button></td>
			</tr>
		</table>
	</div>
</form>
<p>Not a member? <a href="/market-time/register">Register</a></p>
<#if !sessionContext.loggedIn && errorMessage?? && errorMessage != ''> 
	<p><strong><@spring.message '${errorMessage}.LABEL'/></strong></p>
</#if>