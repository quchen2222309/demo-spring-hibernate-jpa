<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/myTagLib" prefix="p"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<div class="page-block" style="margin-top:15px">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>用户ID</th>
					<th>用户名</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ page.content}" var="c">
					<tr>
						<td>${ c.id}</td>
						<td>${ c.name}</td>
						<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<p:pager page="${ page}" url="${url}" />
		</div>
	</div>
</body>
</html>
