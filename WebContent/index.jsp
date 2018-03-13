<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
  <c:when test="${sessionScope.userName != null}">
    <%@ include file = "UserHeaderAfterLogin.jsp" %>
  </c:when>
  <c:when test="${sessionScope.userName == null }">
    <%@ include file = "UserHeaderBeforeLogin.jsp" %>
  </c:when>
</c:choose>
<%@ include file = "UserHeaderBeforeLogin.jsp"%>
<html>
<head>
	<style type="text/css">
		.h1,
		.h2 {
		  font-family: inherit;
		  font-weight: 700;
		  line-height: 1.1;
		  color: inherit;
}
	</style>
</head>
<body>
<form method="get">
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
    <div align="center">
    	<h3 class="h1">What do you love?</h3>
    	<h4 class="h2">Do more of it with Meetup</h4>
	    <iframe width="560" height="315" src="https://www.youtube.com/embed/m4nUM8qEToM" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen>
	    </iframe>
	</div>
   </form>
</body>
</html>