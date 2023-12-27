<%-- 
    Document   : cartCheckout
    Created on : Dec 26, 2023, 9:33:33 PM
    Author     : Chamith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.uniquedeveloper.registration.DbCon"%>
<%@page import="com.uniquedeveloper.registration.ProductDao"%>
<%@page import="com.uniquedeveloper.registration.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>

<%
    DecimalFormat dcf = new DecimalFormat("###.##");
    List<Cart> cartProduct = (List<Cart>) request.getSession().getAttribute("cartProduct");
    double balance = (Double)request.getSession().getAttribute("balance");
    %>


<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/stylesheet.css" />
    
    <link rel="stylesheet" href="css/review.css" />
    <link rel="stylesheet" href="css/checkout.css" />
    <link rel="shortcut icon" href="images/Green.jpg" />
    <script src="https://kit.fontawesome.com/80224b9ef7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <title>GREEN Supermarket</title>
    <style>
* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>


</head>
<body>
  <nav class="navigation" style="background-color:D2E3C8;   padding: 3px;     max-width: 100%;">
      <div>
      <a href="index.jsp">  <img src="new/logo.png" style="width:200px; height: 100px;" alt="Logo"></a>
      </div>
      <!--menu-btn---->
      <input type="checkbox" class="menu-btn" id="menu-btn" />
      <label for="menu-btn" class="menu-icon">
        <span class="nav-icon"></span>
      </label>
      <!--menu-------->
<ul class="menu" style="margin-top: 30px; ">
    <li style="font-size: 10px;"><a href="index.jsp" class="active">Home</a></li>
    <li style="font-size: 10px;"><a href="product.jsp">Products</a></li>
    <li style="font-size: 20px;"><a href="about.jsp">About</a></li>
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
        
        <div class="parent"style="margin-top: 65px;">
    
    <div class="row">
        <div class="column">
               <div class="c_us">
                   <h1>Order Details</h1>
    	<div class="container my-3"style="height:234px;" >

		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					
				</tr>
			</thead>
			<tbody>
				<%
				
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%= dcf.format(c.getPrice())%></td>
					<td>
						<form action="check-out" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								
                                                                 <input type="hidden" name="userId" value="<%= request.getSession().getAttribute("userId") %>">
                                                                  <input type="hidden" name="productId" value="<%=c.getId()%>">
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
								
							</div>
							
						</form>
					</td>
					

				</tr>

				<%
				}%>
			</tbody>
		</table>
	</div>
           
        
    </div>
                
        </div>
        <div class="column">
          
              <div class="c_us" >
        <h1>Payment</h1>
        <div class="order-details">
         
            <form>
               
                <input type="text" placeholder="Credit/Debit Card No">
                <input type="text" placeholder="CVV">
                <input type="text" placeholder="Expire Date">
                

            </form>
                 <div class="text-right">
           <a id="payNowLink" href="CartOrderServlet">
    <button class="btn btn-primary">Pay Now</button>
    <br>
    </a>
     <p style='margin-top: 22px;'>Available Balance : ${balance}</p>

                 </div>
         
           
            <!-- Add more product details as needed -->
        </div>
    </div> 
        </div>
</div>
     
        </div>

   
   
</body>
</html>
