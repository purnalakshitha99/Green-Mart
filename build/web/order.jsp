<%@page import="java.text.DecimalFormat"%>
<%@page import="com.uniquedeveloper.registration.OrderDao"%>
<%@page import="com.uniquedeveloper.registration.DbCon"%>
<%@page import="com.uniquedeveloper.registration.ProductDao"%>
<%@page import="com.uniquedeveloper.registration.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	DecimalFormat dcf = new DecimalFormat("#.###");
	request.setAttribute("dcf", dcf);
	User auth = (User) request.getSession().getAttribute("auth");
	List<Order> orders = null;
	if (auth != null) {
	    request.setAttribute("person", auth);
	   
	}
         OrderDao orderDao  = new OrderDao(DbCon.getConnection());
         String userIdString = (String) request.getSession().getAttribute("userId");
            int userId = Integer.parseInt(userIdString);
	orders = orderDao.userOrders(userId);
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	
	%>
<!DOCTYPE html>
<html>
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
<title>E-Commerce Cart</title>
</head>
<body>
	<nav class="navigation" style="background-color:#D2E3C8;   padding: 3px;     max-width: 100%;">
      <div>
      <a href="index.jsp">  <img src="new/logo.png" style="width:200px; height: 100px;" alt="Logo"></a>
      </div>
      <!--menu-btn---->
      <input type="checkbox" class="menu-btn" id="menu-btn" />
      <label for="menu-btn" class="menu-icon">
        <span class="nav-icon"></span>
      </label>
      <!--menu-------->
<ul class="menu" style="margin-top: 30px; margin-left: -8px; ">
    <li style="font-size: 10px;"><a href="index.jsp" >Home</a></li>
    <li style="font-size: 20px;"><a href="product.jsp">Products</a></li>
    <li style="font-size: 20px;"><a href="aboutus.jsp">About</a></li>
    <li style="font-size: 20px;"><a href="review.jsp">Review</a></li>
    <li style="font-size: 20px;"><a href="order.jsp">Order</a></li>
    <li style="font-size: 20px;"><a href="Logout">Logout</a></li>
</ul>
      <!--right-nav-(cart-like)-->
      <div class="right-nav" style="margin-top: 25px;">
        <!--cart----->
        <a href="cart.jsp" class="cart">
          <i class="fas fa-shopping-cart"></i>
          <span>${cart_list.size()}</span>
        </a>
      </div>
    </nav>
	<div class="container">
		<div class="card-header my-3" style="font-size: 20px; font-weight: bold; background: #B2C8BA; height: 51px" >All Orders</div>
                <table class="table table-light" style="border-radius: 30px; box-shadow: 0 5px 10px rgba(0,0,0,0.2); height: 50px">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
						<td><%=o.getCategory() %></td>
						<td><%=o.getQunatity() %></td>
						<td><%=dcf.format(o.getPrice()) %></td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%=o.getOrderId()%>">Cancel Order</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
