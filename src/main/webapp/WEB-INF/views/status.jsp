<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Project List</h1>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>description</th>
				<th>homepage</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${projectList}" var="project">
				<tr>
					<td>${project.id}</td>
					<td>${project.name}</td>
					<td>${project.description}</td>
					<td>${project.homepage}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
