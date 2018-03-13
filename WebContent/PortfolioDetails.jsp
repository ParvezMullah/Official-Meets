<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "UserHeaderAfterLogin.jsp" %>
<html>
<head>
<!-- <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="Bootstrap/css/font-awesome-ie7.css" rel="stylesheet">
<link href="Bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="Bootstrap/css/boot-business.css" rel="stylesheet">
<link href="Bootstrap/fonts/font-awesome.min.css" rel="stylesheet">
-->
</head>
<body>
<form method="post" action="PortfolioDetailsServlet">
<div class="content">
<br><br><br><br>
      <div class="container">
        <div class="page-header">
          <h1>Meetings for ${category}</h1>
        </div>
        <!-- for each meeting-->
        <c:forEach var="tempEvent" items="${EVENTS_LIST }">
        <c:url var="tempLink" value="PortfolioDetailsServlet">
        <c:param name="eventId" value="${tempEvent.getEventId()}" />
        </c:url>
        <div class="row bottom-space">
          <div>
            <div class="circle">
              <span class="event-date">${tempEvent.getDate() }</span>
            </div>
          </div>
          <div class="span9">
            <h4><a href="PortfolioDetailsServlet?option=${tempEvent.getEventId() }">${tempEvent.getTitle() }</a></h4>
            <p>
              ${tempEvent.getDescription()}
            </p>
          </div>
        </div>
        </c:forEach>
      </div>
    <div>
    </div>
    </div>
    </form>
 </body>
 </html>
 <%@ include file = "Portfolio.jsp" %>