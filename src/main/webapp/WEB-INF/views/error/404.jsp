<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML>
<html>
<head>
	<title>SDC_WebTemplate_404</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<link href="${ctx}/resources/css/error.css" rel="stylesheet" type="text/css">

<style>
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Audiowide', cursive, arial, helvetica, sans-serif;
	background:
		url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAUElEQVQYV2NkYGAwBuKzQAwDID4IoIgxIikAMZE1oRiArBDdZBSNMIXoJiFbDZYDKcSmCOYimDuNSVKIzRNYrUYOFuQgweoZbIoxgoeoAAcAEckW11HVTfcAAAAASUVORK5CYII=)
		repeat;
	background-color: #212121;
	color: white;
	font-size: 18px;
	padding-bottom: 20px;
}

.error-code {
	font-family: 'Creepster', cursive, arial, helvetica, sans-serif;
	font-size: 200px;
	color: white;
	color: rgba(255, 255, 255, 0.98);
	width: 50%;
	text-align: right;
	margin-top: 5%;
	text-shadow: 5px 5px hsl(0, 0%, 25%);
	float: left;
}

.not-found {
	width: 47%;
	float: right;
	margin-top: 5%;
	font-size: 50px;
	color: white;
	text-shadow: 2px 2px 5px hsl(0, 0%, 61%);
	padding-top: 70px;
}

.clear {
	float: none;
	clear: both;
}

.content {
	text-align: center;
	line-height: 30px;
}

input[type=text] {
	border: hsl(247, 89%, 72%) solid 1px;
	outline: none;
	padding: 5px 3px;
	font-size: 16px;
	border-radius: 8px;
}

a {
	text-decoration: none;
	color: #9ECDFF;
	text-shadow: 0px 0px 2px white;
}

a:hover {
	color: white;
}
</style>
</head>
<body>

	<p class="error-code">404</p>
	<p class="not-found">
		Not<br>Found
	</p>
	<div class="clear"></div>
	<div class="content">
		Page not found, make sure you enter the URL. <br>
		<a href="${ctx}/">Home</a>
	</div>


</body>
</html>