<#if sessionContext.loggedIn?? && sessionContext.loggedIn> 
	You must <a href="/market-time/logout">logout</a> first...
<#else> 
	<#include "registration-form.ftl">
</#if>
