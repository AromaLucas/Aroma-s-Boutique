<%@include file="Menu.jsp" %>

<style type="text/css">
body {
 background-color:silver;
}
</style>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	
	<div style="background-color:green">
		<h2 align="center">Cart</h2>
	</div>
	
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${listCartItems}" var="Cart">
                	<form action="<c:url value="/updateCartItem/${Cart.cartId}"/>" method="get">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<c:url value="/resources/images/${Cart.productId}.jpg"/>" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${Cart.productName}</a></h4>
                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="text" class="form-control" name="quantity" id="quantity" value="${Cart.quantity}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${Cart.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${Cart.price * Cart.quantity}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <button type="submit" class="btn btn-primary">
                            <span class="glyphicon glyphicon-update"></span> update 
                        </button>
                        <a href="<c:url value="/deleteCartItem/${Cart.cartId}"/>" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </a>
                        </td>
                     </tr>
                     </form>
                	</c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong>${total_Amount}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>${total_Amount/50}</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>INR. ${total_Amount+ (total_Amount/50)}/-</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="<c:url value="/Products"/>" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </a></td>
                        <td>
                         <a href="<c:url value="/confirmOrder"/>" class="btn btn-default">
                            Order Confirm <span class="glyphicon glyphicon-play"></span>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>