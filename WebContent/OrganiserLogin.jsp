<%@ include file = "UserHeaderBeforeLogin.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Organizor Login</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
<title>Insert title here</title>
</head>
	<body>
		<!-- Top content -->
	        <div class="top-content">
	        	
	            <div class="inner-bg">
	                <div class="container">
	                    
	                    <div class="row">
	                        <div class="col-sm-6 col-sm-offset-3 form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<center><h3>Login to our site</h3>
	                            		<p>Enter your username and password to log on:</p></center>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-key"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="OrganiserLoginServlet" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username">Email Id</label>
				                        	<input type="email" name="emailId" placeholder="Username..." class="form-username form-control"  required>
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        	<input type="password" name="Password"  placeholder="Password..." class="form-password form-control" name="Password" required>
				                        </div>
				                        <button type="submit" class="btn">Sign in!</button>
								<div align="right">	<a href="OrganiserRegistration.jsp">Create An Account</a> </div>
				                    </form>
			                    </div>
	                        </div>
	                    </div>
	                   
	                </div>
	            </div>
	            
	        </div>
	
	
	        <!-- Javascript -->
	        <script src="assets/js/jquery-1.11.1.min.js"></script>
	        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
	        <script src="assets/js/jquery.backstretch.min.js"></script>
	        <script src="assets/js/scripts.js"></script>
	        
	        <!--[if lt IE 10]>
	            <script src="assets/js/placeholder.js"></script>
	        <![endif]-->
	
	    
	</body>
</html>