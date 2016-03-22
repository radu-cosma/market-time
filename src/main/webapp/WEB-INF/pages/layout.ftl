<!DOCTYPE html>
<html>
	<head>
		<title>Market Time</title>
	  	<meta charset="utf-8">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
	 	<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<link rel="stylesheet" href="style/layout.css">	
 		<#list cssResources as cssResource>
 			<link rel="stylesheet" href="style/${cssResource}.css">	
 		</#list>
 		<#list jsResources as jsResource>
			<script src="script/${jsResource}.js"></script>
 		</#list>
	</head>
	<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
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
	</body>
</html>