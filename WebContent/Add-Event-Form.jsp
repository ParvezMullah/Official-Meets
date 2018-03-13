<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file = "OrganiserHeader.jsp" %>
    <br><br><br><br>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		 <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">-->
		<title>New Event</title>
		<script src="Validations.js">
		</script>
	</head>
	<body>
	<% if (session.getAttribute("emailId") == null) { 
		response.sendRedirect("index.jsp");
	}
    %>
		<div class="" align="center">
		<h1 class="bg-faded text-muted">Add Meetup</h1>
			<div class="col-lg-12 well container bg-primary text-white" style="background-color:#6CB9B6">
				 <form method="post" action="EventControllerServlet?email="<%session.getAttribute("emailId"); %> enctype="multipart/form-data">
				 <input type="hidden" name="command" value="ADD">
			    	<div class="row">
			    		<div class="col-sm-12">
			    			<div class="form-group">
								<label>Title</label>
								<input type="text" name="Title" placeholder="Enter Title  Here.." class="form-control" required>
							</div>
							<div class="form-group">
								<label>Description</label>
								<textarea rows="4" class="form-control" name="Description" required> </textarea>
							</div>
							
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label>Date</label>
										<input type="date" name="Date" id="Date" onchange='validateDate()' class="form-control" required>
										<span id="date"></span>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label>Time</label>
										<input type="text" name="Time" placeholder="Enter The Timming Here.." class="form-control" required>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label>Select the Category</label><br/>
										<select name="Category" class="text-success" required>
											<option value="0">--Select Category--</option>
										  <option value="Machine Learning">Machine Learning</option>
										  <option value="Cloud">Cloud</option>
										  <option value="Big Data">Big Data</option>
										  <option value="Software Development">Software Development</option>
										</select>
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label>Fees</label>
										<input type="text" name="Fees" placeholder="Mention Fees Here If Any.." class="form-control">
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label>Other Descriptive info</label>
								<input type="text" name="otherInfo" placeholder="Enter Other Descriptive info Here.." class="form-control">
							</div>
							<div class="form-group">
								<label>Venue</label>
								<input type="text" name="Venue" placeholder="Enter The Venue Here.." class="form-control">
							</div>
							
							<div >
				                <label for="file">Picture</label>
				                <input type="file" class="btn btn-default" id="file" name="Picture" accept=".png, .jpeg, .jpg">
				                <small class="form-text text-muted" id="fileHelp">Max 3mb size</small>
				            </div>
			    		</div>
			    	</div>
			    	<input class="btn btn-danger btn-lg btn-block" type="submit" id="submit" value="Add Meetup">
			    </form>
			</div>
		   
		</div>
	</body>
</html>