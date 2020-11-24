<%--
    Document   : Home
    Created on : 24 Nov 2020, 06:21:45
    Author     : Mark Crowe <https://github.com/markcrowe-com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.markcrowe.wordpress.web.WordPressRestServlet.Actions"%>
<%@page import="com.markcrowe.wordpress.web.WordPressRestServlet.RequestParameterNames"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WordPress API Wrapper</title>
    </head>
    <body>
        <h1>WordPress API Wrapper</h1>
		<form action="QServlet">
            <input type="submit" name="action" value="${Actions.GetWordPressPosts}">
			<input type="submit" name="action" value="${Actions.GetCreatePage}">
		</form>
    </body>
</html>
