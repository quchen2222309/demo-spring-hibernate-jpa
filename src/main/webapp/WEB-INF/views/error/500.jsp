<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML>
<html>
	<head>
		<title>SDC_WebTemplate_Error</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<meta http-equiv="Cache-Control" content="no-store" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<link href="${ctx}/resources/bootstrap/2.3.2/css/bootstrap.min.css" type="text/css" rel="stylesheet" />		
		<link href="${ctx}/resources/bootstrap/2.3.2/css/bootstrap-docs.css" type="text/css" rel="stylesheet" />
		<link href="${ctx}/resources/google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
		<script src="${ctx}/resources/google-code-prettify/prettify.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="bs-docs-example">
		<p>异常时间：${date}</p>
		<p>异常类：${class}</p>
		<p>异常信息：${message}</p>
		</div>
		<pre class="prettyprint">${stackMessage}</pre>
	</body>
</html>