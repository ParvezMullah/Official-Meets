<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <%@ page import="java.util.* ,pack_Organiser.* " %> -->
<%@ include file = "OrganiserHeader.jsp" %>
<br><br><br><br><br>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">-->
	
	<title>Your Events List</title>
	<link type="text/css" rel="stylesheet" href="assets/css/style.css">
	</head>
	<%--
	
		<%
		List<Event> theEvents=(List<Event>) request.getAttribute("EVENTS_LIST") ;
	%>
	
	 --%>
	<body>
	<form method="post">
		<div align="center" id="wrapper">
			<div id="header">
				<h2>Events organised by you:</h2>
			</div>
		</div>
		
		<div align="center" id="container">
			<div id="content">
			<!-- Put a new button -->
			<input type="button" class="btn btn-lg btn-success" value="Add Event" onclick="window.location.href='Add-Event-Form.jsp'; return false;"><br><br>
				<table>
					<tr>
						<th> Event Title </th>
						<th> Event Venue </th>
						<th> Event Date </th>
						<th> Event Time </th>
						<th>  Update	</th>
						<th>  Delete	</th>
						<th>  Status	</th>
						
					</tr>				
						
						<%--
						
							<%
					for(Event tempEvent : theEvents) {%>
					<tr>
						<td> <%= tempEvent.getTitle() %></td>
						<td> <%= tempEvent.getVenue() %></td>
						<td> <%= tempEvent.getDate() %></td>
						<td> <%= tempEvent.getTime() %></td>
						<td><a href="" class="btn btn-primary">Update</a></td>
					</tr>
					<% } %>	
					
						 --%>
 
					
				
				<c:forEach var="tempEvent" items="${EVENTS_LIST}" >
					
					<c:url var="tempLink" value="EventControllerServlet">
						<c:param name="command" value="LOAD">  </c:param>
						<c:param name="eventId" value="${tempEvent.getEventId() }"></c:param>
					</c:url>
					
					<c:url var="deleteLink" value="EventControllerServlet">
						<c:param name="command" value="DELETE">  </c:param>
						<c:param name="eventId" value="${tempEvent.getEventId() }"></c:param>
					</c:url>
					
					<c:url var="statusLink" value="EventControllerServlet">
						<c:param name="command" value="STATUS">  </c:param>
						<c:param name="eventId" value="${tempEvent.getEventId() }"></c:param>
					</c:url>
					
					<tr>
						<td>${tempEvent.getTitle()}</td>
						<td>${tempEvent.getVenue()}</td>
						<td>${tempEvent.getDate()}</td>
						<td>${tempEvent.getTime()}</td>
						 <td>
						 	<a href="${tempLink}" class="btn btn-success">Update</a>
						 </td>
						 <td>
						 	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this meetup?'))) return false" class="btn btn-danger">Delete</a>
						 </td>
						 <td>
						 	<a href="${statusLink}" class="btn btn-success">Status</a>
						 </td>
					</tr> 
				</c:forEach>
				</table>
			</div>
		</div>
		</form>
	</body>
</html>