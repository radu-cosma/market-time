<!DOCTYPE html>
<html>
	<head>
		<title>Market Time</title>
	  	<meta charset="utf-8"/>
	  	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	  	<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="${baseURL}/style/layout.css"/>
		<#list cssResources as cssResource>
 			<link rel="stylesheet" href="${baseURL}/style/${cssResource}.css"/>	
 		</#list>
	</head>
	<body>
		<div id="header-container">
			<#if headerName??>
				<#include "${headerName}.ftl">
			</#if>
		</div>
		<div id="view-container">
			<#if viewName??> 
				<#include "${viewName}.ftl">
			</#if>
		</div>
		<div id="footer-container">
			<#if footerName??> 
				<#include "${footerName}.ftl">
			</#if>
		</div>
		<#list jsResources as jsResource>
			<script src="${baseURL}/script/${jsResource}.js"></script>
 		</#list>
	</body>
</html>