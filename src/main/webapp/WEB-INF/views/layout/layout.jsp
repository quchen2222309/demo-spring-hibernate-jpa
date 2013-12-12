<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<title>科学数据公共服务-自助数据库管理平台<sitemesh:title /></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" href="${ctx }/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx }/resources/css/my.css">
<link rel="stylesheet"
	href="${ctx }/resources/css/bootstrap-theme.min.css">
<script src="${ctx }/resources/js/jquery/1.10.2/jquery.min.js"></script>
<script src="${ctx }/resources/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<sitemesh:head />
</head>

<body>
	<!-- 页头 -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<%@ include file="/WEB-INF/views/layout/header.jsp"%>
			</div>
		</div>
		<!-- 导航条 -->
		<%@ include file="/WEB-INF/views/layout/nav.jsp"%>
		<!-- 内容 -->
		<div class="row" style="height:500px;margin-top:100px">
			<!--左侧导航-->
			<div class="col-md-3">
				<%@ include file="/WEB-INF/views/layout/left.jsp"%>
			</div>
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">${location }</div>
						<div class="panel-body">
							<sitemesh:body />
						</div>
				</div>
			</div>
		</div>
		<!-- 页尾 -->
		<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
	</div>

</body>
</html>