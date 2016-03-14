<html>
<head></head>
<body>
	<#if sessionContext.loggedIn?? && sessionContext.loggedIn> 
		<p>You must <a href="/market-time/logout">logout</a> first!</p>
	<#else> 
		<#include "registration_form.ftl">
	</#if>
</body>
</html>