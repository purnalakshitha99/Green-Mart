
<%@page import="com.uniquedeveloper.registration.DbCon"%>
<%@page import="com.uniquedeveloper.registration.ProductDao"%>
<%@page import="com.uniquedeveloper.registration.Product"%>
<%@page import="com.uniquedeveloper.registration.Cart"%>
<%@page import="com.uniquedeveloper.registration.User"%>
<%@page import="com.uniquedeveloper.registration.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth=(User)request.getSession().getAttribute("auth");
if(auth!=null){
request.setAttribute("person",auth);
    }
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/stylesheet.css" />
    <link rel="shortcut icon" href="images/Green.jpg" />
    <link
      rel="stylesheet"
      href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
      integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
      crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
      rel="stylesheet"
    />
    	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>Products</title>
  </head>
  <body>
    <nav class="navigation">
        <a href="index.html" class="logo"> <span>GREEN&nbsp;</span>Supermarket </a>
      <!--menu-btn---->
      <input type="checkbox" class="menu-btn" id="menu-btn" />
      <label for="menu-btn" class="menu-icon">
        <span class="nav-icon"></span>
      </label>
      <!--menu-------->
      <ul class="menu">
        <li><a href="index.jsp" class="active">Home</a></li>
        <li><a href="product.jsp">Products</a></li>
        <li><a href="about.jsp">About</a></li>
        <li><a href="review.jsp">Review</a></li>
        <li><a href="order.jsp">Order</a></li>
        <li><a href="Logout">Logout</a></li>
        
      </ul>
      <!--right-nav-(cart-like)-->
      <div class="right-nav">
        <!--cart----->
        <a href="cart.jsp" class="cart">
          <i class="fas fa-shopping-cart"></i>
          <span>${cart_list.size()}</span>
        </a>
      </div>
    </nav>
      <div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-4 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="<%=p.getImage() %>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="price">Price: RS.<%=p.getPrice()%></h6>
						<h6 class="category">Category: <%=p.getCategory() %></h6>
			 <div class="mt-3 d-flex justify-content-between">
                            <form action="addToCart" method="post" id="addToCartForm">
                                 <input type="hidden" name="userId" value="<%= request.getSession().getAttribute("userId") %>">
                                 <input type="hidden" name="productId" value="<%= p.getId() %>">
                                 <input type="hidden" name="quantity" id="quantityInput" value="1" min="1"> <!-- Quantity input -->
                                  <button type="submit" class="btn btn-dark">Add to Cart</button>
                            </form>

<!-- Buy Now Form (if needed) -->
                            <form action="check-out" method="post" id="buyNowForm">
                                <input type="hidden" name="userId" value="<%= request.getSession().getAttribute("userId") %>">
                                <input type="hidden" name="productId" value="<%=p.getId()%>">
                                 <input type="hidden" name="cartId" value="90000">
                                <input type="hidden" name="quantity" id="buyNowQuantity" value="1">
                                 <button type="submit" class="btn btn-primary">Buy Now</button>
                            </form>

                      
                        
                        </div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>
                        
                         
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>