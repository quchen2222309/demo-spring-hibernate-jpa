<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	<ul class="nav nav-pills nav-stacked">
		<li <c:if test="${location=='我的用户' }">class="active"</c:if>><a href="${ctx }/dbUser/userInfo">我的数据库空间</a></li>
		<li <c:if test="${location=='创建申请' }">class="active"</c:if>><a href="${ctx }/application/create">新的空间申请</a></li>
		<li <c:if test="${location=='申请列表' }">class="active"</c:if>><a href="${ctx }/application/list">空间申请状态</a></li>
	</ul>
