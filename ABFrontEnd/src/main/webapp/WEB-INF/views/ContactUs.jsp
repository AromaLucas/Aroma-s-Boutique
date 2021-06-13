<%@include file="Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

body {
  background: url('resources/images/cnt1.jpg') no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  background-size: cover;
  -o-background-size: cover;
}

.center {
 position: absolute;
 top:20;
 background: rgb(0, 0, 0); /* Fallback color */
 background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
 color: #f1f1f1;
 width: 100%;
 padding: 50px;
}

.fa {
  padding: 20px;
  font-size: 30px;
  width: 75px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
  border-radius: 100%;
}

.fa:hover {
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}


.fa-instagram {
	background: #f09433; 
	background: -moz-linear-gradient(45deg, #f09433 0%, #e6683c 25%, #dc2743 50%, #cc2366 75%, #bc1888 100%); 
	background: -webkit-linear-gradient(45deg, #f09433 0%,#e6683c 25%,#dc2743 50%,#cc2366 75%,#bc1888 100%); 
	background: linear-gradient(45deg, #f09433 0%,#e6683c 25%,#dc2743 50%,#cc2366 75%,#bc1888 100%); 
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f09433', endColorstr='#bc1888',GradientType=1 );
	color: white;
}

.fa-whatsapp {
  background: #00e600;
  color: white;
}



</style>
</head>
<body>
<div class='center'>
<h2>Our Social media links</h2>

<!-- Add font awesome icons -->
<a href="#" class="fa fa-facebook"></a>
<a href="#" class="fa fa-instagram"></a>
<a href="#" class="fa fa-whatsapp"></a>
      
<h3> For more details or queries contact us at : 12345678</h3>
<h3> Or mail us at : 1234@gmail.com</h3>
<h3>Our customer services will be available 24/7...</h3>
</div>
</body>
</html> 