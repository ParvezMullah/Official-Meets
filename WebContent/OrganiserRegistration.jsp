<%@ include file = "UserHeaderBeforeLogin.jsp" %>
<br><br><br><br><br><br>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		 <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">-->
		<title>Registration Form</title>
	<script src="Validations.js">
	</script>
		
	</head>
	<body>
		<div class="container bg-success text-white" align="center">
		    <h1 class="display-4">Registration Form</h1>
			<div class="col-lg-12 well">
					<form action="OrganiserControllerServlet" method="post" enctype="multipart/form-data">
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
								<label>Email Address</label>
								<input type="email" name="emailId" placeholder="Enter Email Address Here.." class="form-control" required>
								</div>	
								
								<div class="row">
									<div class="col-sm-6 from group">
										<label>Password</label>
										<input type="password" name="Password" id="Password"  placeholder="Enter Password Here.." class="form-control" onchange='validatePassword();' required>
										<span id="msg1"></span>
									</div>
									<div class="col-sm-6 from group">
									<label>Confirm Password</label>
									<input type="password" name="confirmPassword" id="confirmPassword" placeholder="Enter Same Password Here.." class="form-control" onchange='confirmvalidatePassword();' required>
									<span id="msg"></span>
									</div>
								</div>
			
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>First Name</label>
										<input type="text" name="firstName" id="firstName" onchange='validateFName()' placeholder="Enter First Name Here.." class="form-control" required>
										<span id="fname"></span>
									</div>
									<div class="col-sm-6 form-group">
										<label>Last Name</label>
										<input type="text" name="lastName" id="lastName"  placeholder="Enter Last Name Here.." class="form-control" onchange='validateLName();' required>
										<span id="lname"></span>
									</div>
								</div>					
								
								<div class="row">		
									<div class="col-sm-6 form-group">
										<label>Organization</label>
										<input type="text" name="organizationName" placeholder="Enter Organization Name Here.." class="form-control">
									</div>	
									<div class="col-sm-6 form-group">
										<label>Contact Number</label>
										<input type="number" name="contactNumber"  id="contactNumber" onchange='validateMobile()' placeholder="Enter Organization Contact Number Here.." class="form-control" required>
										<span id="contactMessage"></span>
									</div>
								</div>						
							<div class="form-group">
								<label>Designation</label>
								<input type="text" name="Designation" placeholder="Enter Your Designation Here.." class="form-control" required>
							</div>	
								
							<div >
				                <label for="file">Profile Picture</label>
				                <input type="file" class="btn btn-default" id="file" name="profilePicture" accept=".png, .jpeg, .jpg">
				                <!--  <small class="form-text text-muted" id="fileHelp">Max 3mb size</small>-->
				            </div></br>
							<button type="Submit" class="btn btn-lg btn-success" id="submit">Sign Up</button>
							Already Member?<a class="btn btn-primary" href="OrganiserLogin.jsp"><i class="fa fa-user"></i> Login</a>					
						</div>
						
						</div>
					</form> 
			</div>
		</div>		
	</body>
</html>