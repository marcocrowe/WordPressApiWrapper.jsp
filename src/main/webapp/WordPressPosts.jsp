<%--
    Document   : WordPressPosts
    Created on : 24 Nov 2020, 06:30:01
    Author     : Mark Crowe <https://github.com/markcrowe-com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.markcrowe.wordpress.WordPressPost"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WordPress API Wrapper</title>
    </head>
    <body>
        <h1>WordPress API Wrapper</h1>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Slug</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach var="wordPressPost" items="${wordPressPosts}">
					<tr>
						<td>${wordPressPost.id}</td>
						<td>${wordPressPost.slug}</td>
						<td>${wordPressPost.date}</td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</body>
</html>
