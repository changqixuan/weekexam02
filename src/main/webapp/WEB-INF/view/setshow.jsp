<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resource/css/list.css">
<link rel="stylesheet" type="text/css" href="/resource/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>百分比</td>
		</tr>
		<c:forEach items="${set}" var="l">
			<tr>
				<td>${l.id}</td>
				<td>${l.name}</td>
				<td>${l.price}</td>
				<td>${l.bfb}</td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<a href="${pageContext.request.contextPath}/zsetshow?page=${page-1<=1?1:page-1}"><input type="button" value="上一页" class="btn btn-success"></a>
		<a href="${pageContext.request.contextPath}/zsetshow?page=${page+1>=pages?pages:page+1}"><input type="button" value="下一页" class="btn btn-success"></a>
	</center>
</body>
</html>