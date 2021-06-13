<%@include file="Menu.jsp" %>
<style type="text/css">
body {
  background: url('resources/images/generalHome.jpg') no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  background-size: cover;
  -o-background-size: cover;
}


h3{
color: black;
font-style:italic;

}
</style>
 
<c:if test="${sessionScope.loggedIn}"> 
<c:if test="${sessionScope.role=='ROLE_USER'}">
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Login Success!</strong> 
  </div>
<h3 align="center">UserHome</h3>
</c:if>
</c:if>


<c:if test="${sessionScope.loggedIn}"> 
<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
<div class="alert alert-success alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Login Success!</strong> 
  </div>
<h3 align="center">AdminHome</h3>
</c:if>
</c:if>
<div class="content">
<h3 align="center">Welcome to Aroma's Boutique!!</h3>
</div>
<div class="container-fluid">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="<c:url value="/resources/images/c1.jpg"/>" alt="" style="width:100%; height:500px;">
        <div class="carousel-caption">
          <h3>Lips</h3>
          <h4>Lipsticks, Lipsbalms and so much more..</h4>
        </div>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/c2.jpg"/>" alt="" style="width:100%; height:500px;">
        <div class="carousel-caption">
          <h3>Face</h3>
          <h4>Foundations, Blushes, Shades, etc.</h4>
        </div>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/c3.jpg"/>" alt="" style="width:100%; height:500px;">
        <div class="carousel-caption">
          <h3>Eyes</h3>
          <h4>Eye Shadows, Kajal, Mascara  and more.</h4>
        </div>
      </div>
      
      <div class="item">
        <img src="<c:url value="/resources/images/c4.jpg"/>" alt="" style="width:100%; height:500px;">
        <div class="carousel-caption">
          <h3>Nails</h3>
          <h4>Nail polishes, Manicure, Pedicure  and more.</h4>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  </div>
  
  <c:if test="${!sessionScope.loggedIn}">
  <div class="container">
  <h2>Login to enjoy shopping with our wide range of products in each category..</h2>
  </div>
  </c:if>
  
</body>
</html>
	
	