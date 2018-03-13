<%@ include file = "UserHeaderAfterLogin.jsp" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <!-- Bootstrap core CSS -->
    <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="Bootstrap/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="Bootstrap/css/freelancer.min.css" rel="stylesheet">

  </head>

  <body id="page-top">
<form method="post">

    <!-- Header -->
    <header class="masthead">
      <div class="container">
        <img class="img-fluid" src="Bootstrap/images/logo.png" height="300px" width="300px" alt="">
        <div class="intro-text">
          <span class="name">LET'S MEET & EXPLORE</span>
          <hr class="star-light">
          <span class="skills">Web Developer - Graphic Artist - User Experience Designer</span>
        </div>
      </div>
    </header>

    <!-- Portfolio Grid Section -->
    <section id="portfolio">
      <div class="container">
        <h2 class="text-center">Portfolio</h2>
        <hr class="star-primary">
        <div class="row">
          <div class="col-sm-6 portfolio-item">
            <a class="portfolio-link" href="PortfolioDetailsServlet?param=ml" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x">Machine Learning</i>
                </div>
              </div>
              <img class="img-fluid" src="Bootstrap/images/machine-learning.png" height="200px" width="300px" alt="">
            </a>
          </div>
          <div class="col-sm-6 portfolio-item">
            <a class="portfolio-link" href="PortfolioDetailsServlet?param=bda" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x">Big Data Analytics</i>
                </div>
              </div>
              <img class="img-fluid" src="Bootstrap/images/big-data.png" height="200px" width="300px" alt="">
            </a>
          </div>
          <div class="col-sm-6 portfolio-item">
            <a class="portfolio-link" href="PortfolioDetailsServlet?param=cc" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x">Cloud Computing</i>
                </div>
              </div>
              <img class="img-fluid" src="Bootstrap/images/cloud-computing.png" height="200px" width="300px" alt="">
            </a>
          </div>
          <div class="col-sm-6 portfolio-item">
            <a class="portfolio-link" href="PortfolioDetailsServlet?param=sd" data-toggle="modal">
              <div class="caption">
                <div class="caption-content">
                  <i class="fa fa-search-plus fa-3x">Software Development</i>
                </div>
              </div>
              <img class="img-fluid" src="Bootstrap/images/software-development.png" height="200px" width="300px" alt="">
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top d-lg-none">
      <a class="btn btn-primary js-scroll-trigger" href="#page-top">
        <i class="fa fa-chevron-up"></i>
      </a>
    </div>



    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/freelancer.min.js"></script>
</form>
  </body>

</html>
