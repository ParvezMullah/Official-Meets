<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file = "OrganiserHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="assets/css/style.css">
<title>Meeting Status</title>
</head>
<body>
<% if (session.getAttribute("emailId") == null) { 
		response.sendRedirect("index.jsp");
	}
    %>
    <!-- for each meeting-->
    <div align="center" style="margin-top:100px" id="container">
			<div id="content">
    		<h2 style="color:green">People Coming for Your Meeting:</h2>
    		<table>
    		<th>Name</th>
    		<th>Contact</th>
        <c:forEach var="tempEvent" items="${THE_GSTATUS }">
        <tr><td>${tempEvent.key }</td>
        <td>${tempEvent.value }</td>
        </tr>
        </c:forEach>
        </table>
        <br>
        <h2 style="color:green">People Interested for Your Meeting:</h2>
    		<table>
    		<th>Name</th>
    		<th>Contact</th>
        <c:forEach var="tempEvent" items="${THE_ISTATUS }">
        <tr><td>${tempEvent.key }</td>
        <td>${tempEvent.value }</td>
        </tr>
        </c:forEach>
        </table>
        </div>
        </div>
</body>
</html>