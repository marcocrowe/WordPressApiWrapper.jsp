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
		<form action="WordPressPost" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th><label for="id">Id</label></th>
					<td><input type="text" name="id" id="id" value="${wordPressPost.id}"/></td>
				</tr>
				<tr>
					<th><label for="slug">Slug</label></th>
					<td><input type="text" name="slug" id="slug" value="${wordPressPost.slug}"/></td>
				</tr>
				<tr>
					<th><label for="date">Date</label></th>
					<td><input type="date" name="date" id="date" value="${wordPressPost.date}"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>
