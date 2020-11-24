<%--
    Document   : WordPressPosts
    Created on : 24 Nov 2020, 06:30:01
    Author     : Mark Crowe <https://github.com/markcrowe-com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.markcrowe.wordpress.WordPressPost"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WordPress API Wrapper</title>
    </head>
    <body>
        <h1>WordPress API Wrapper</h1>
		<table>
			<tr>
				<th>Id</th>
				<td>${wordPressPost.id}</td>
			</tr>
			<tr>
				<th>Slug</th>
				<td>${wordPressPost.slug}</td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${wordPressPost.date}</td>
			</tr>
		</table>
	</body>
</html>
