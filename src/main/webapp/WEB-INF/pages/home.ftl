<html>
<head></head>
<body>
	<#if sessionContext.loggedIn?? && sessionContext.loggedIn> 
		<#include "logged_in.ftl">
	<#else> 
		<#include "logged_out.ftl">
	</#if>
</body>
</html>