<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
  <c:when test="${sessionScope.userName != null}">
    <%@ include file = "UserHeaderAfterLogin.jsp" %>
  </c:when>
  <c:when test="${sessionScope.userName == null }">
    <%@ include file = "UserHeaderBeforeLogin.jsp" %>
  </c:when>
</c:choose>
<br><br><br><br>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
window.onload=function(){
	//alert("on load");
	var h2id=document.getElementById("eventid").innerHTML;
	$.ajax({
		url:'ResumeStateServlet',
		data:{eid:h2id},
		type:'get',
		cache:false,
		success:function(data){
			//alert(data);
			if($.trim(data)=='nullSession'){
			document.getElementById("Going").disabled = true;
	        	document.getElementById("Interested").disabled = true;
				}
			else if($.trim(data)=='Going'){
				document.getElementById("Going").checked = true;
				document.getElementById("Going").disabled = true;
	        		document.getElementById("Interested").disabled = true;
			}
			else if($.trim(data)=='Interested'){
				document.getElementById("Interested").checked = true;
				document.getElementById("Going").disabled = true;
	        		document.getElementById("Interested").disabled = true;
			}
		},
		error:function(){
			alert('error');
		}
	});
}


function updateTable(tblname)
{
	var h2id=document.getElementById("eventid").innerHTML;
	$.ajax({
        url:'UpdateTableServlet',
        data:{eid:h2id, tableName:tblname},
        type:'get',
        cache:false,
        success:function(data){
        	document.getElementById("Going").disabled = true;
        	document.getElementById("Interested").disabled = true;
        	alert("You are "+tblname+" in this meeting!!");
        	//alert(data);
           //$('#somediv').text(responseText); 
        },
        error:function(){
          alert('error');
        }
     }
);
}

</script>
</head>
<body>
<form method="post">
<div class="content">
 	<div class="container">
 	<c:forEach items="${eventDetails}" var="event">
        <div class="page-header row">
			<div class="col-lg-8">
			<h2 style="display:none" id="eventid">${event.getEventId()}</h2>
				<h2> ${event.getTitle()}</h2>
			</div>
			<div class="col-lg-4">
				<h4><label class="radio-inline label label-success"><input type="radio" id="Going" onclick="updateTable(this.id)" name="rdUserPref">Going</label>&nbsp;&nbsp;&nbsp;
				<label class="radio-inline label label-primary"><input type="radio" id="Interested" onclick="updateTable(this.id)" name="rdUserPref">Interested</label></h4>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6">
				 <!--  <img class="img-responsive" src="Bootstrap/images/logo.png" alt="No Image Available" width="400px" height="350px">-->
				 <img class="img-responsive" alt="No Image Available" src="data:image/jpeg;base64,${event.getBase64Image()}" width="550px" height="350px"s/>
			</div>
			<div class="col-lg-6">
				<h3><span class="glyphicon glyphicon-map-marker"></span>Venue:</h3> ${event.getVenue() }<br>
				<h3><span class="glyphicon glyphicon-calendar"></span>Date:</h3> ${event.getDate() }<br>
				<h3><span class="glyphicon glyphicon-time"></span>Time:</h3> ${event.getTime() }<br>
				<h3><span class="glyphicon glyphicon-user"></span>People Going:</h3> ${event.getGoingCount() }<br>
				<h3><span class="glyphicon glyphicon-user"></span>People Interested:</h3> ${event.getInterestedCount() }<br>
			</div>
		</div>
		
		<div class="row col-lg-12">
    			<h3>Description</h3>
    			<p>${event.getDescription() }</p>
  		</div>
  		<br><br><br><br>
  		</c:forEach>
  		
			<h3>About Organizer</h3>
		<div class="row">
			<div class="col-lg-6">
				<h3><span class="glyphicon glyphicon-user"></span>Name:</h3> ${organiserDetails.firstName } ${organiserDetails.lastName }<br>
				<h3><span class="glyphicon glyphicon-envelope"></span>Email:</h3>${organiserDetails.emailId }<br>
				<h3><span class="glyphicon glyphicon-earphone"></span>Contact:</h3> ${organiserDetails.contactNumber }<br>
			</div>
			<div class="col-lg-6">
				<h3><span class="glyphicon glyphicon-bank"></span>Organisation name:</h3> ${organiserDetails.organizationName }<br>
				<h3><span class="glyphicon glyphicon-education"></span>Designation:</h3> ${organiserDetails.getDesignation() }
			</div>
		</div>
	</div>
</div>
</form>
</body>
</html>
<%@ include file = "Portfolio.jsp" %>