<%@page import="java.text.DecimalFormat"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%
    DecimalFormat dcf = new DecimalFormat("###.##");
    double balance = (Double)request.getSession().getAttribute("balance");
    %>
     /* Add a style for the input fields */
/*        input {
            width: 100%;
            padding: 10px;
            margin: 5px 0 15px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            font-family: 'Poppins';  Change the font-family as needed 
        }*/
</style>
 <script>
    // Function to update total price based on quantity
    function updateTotalPrice() {
        // Get the quantity input and total price element
        var quantityInput = document.getElementById('quantity');
        var totalPriceElement = document.getElementById('totalPrice');
        var payNowLink = document.getElementById('payNowLink'); // Get the Pay Now link

        // Get the quantity value and convert it to a number
        var quantity = parseInt(quantityInput.value, 10);

        // Get the price value (replace this with the actual price)
        var price = parseFloat('${price}');

        // Calculate the total price
        var totalPrice = quantity * price;

        // Update the total price element with the calculated value
        totalPriceElement.textContent = 'Total Price: ' + totalPrice;

        // Update the Pay Now link's href with the quantity value
         payNowLink.href = "order-now?productId=${productId}&productName=${productName}&uid=<%= request.getSession().getAttribute("userId") %>&cartId=${cartId}&price=" + encodeURIComponent(totalPrice) + "&quantity=" + quantity;
    }

    // Add event listener to quantity input
    document.getElementById('quantity').addEventListener('input', updateTotalPrice);
</script>

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
        
        
           <div class="parent"style="margin-top: 65px;">
    
    <div class="row">
        <div class="column">
            <div class="c_us" >
                   <h1>Order Details</h1>
                   
                   <div class="container my-3"style="height:234px;" >
     <div class="product-details" >
                <p>Product Name: ${productName}</p>
                 <p>Category: ${category}</p>
                <p>Item Price: ${price} </p>
                  <lable>Quantity:</lable>
               <input type="number" id="quantity" placeholder="quantity" value="${quantity}" min="1" oninput="updateTotalPrice()">
                <p id="totalPrice">Total Price: ${price}</p>
            </div>
                   </div>
        
    </div>
                
        </div>
        <div class="column">
          
              <div class="c_us" >
        <h1>Payment</h1>
        <div class="order-details" style="height:239px;">
         
          <form style="font-family: 'Poppins', sans-serif;">
    
    <input type="text" placeholder="Credit/Debit Card No" required>
    <input type="text" placeholder="CVV" required>
    <input type="text" placeholder="Expire Date" required>
</form>
        <a href="order-now?productId=${productId}&productName=${productName}&price=${price}&quantity=1&uid=<%= request.getSession().getAttribute("userId") %>&cartId=${cartId}" style="display: block; text-align: right; text-decoration: none;">
  <button style="background-color: blue; color: white; padding: 10px 20px; border: none; cursor: pointer;">Pay Now</button>
</a>
        <p class="available" style="text-align: right; margin-top:12px;">Available Balance: ${balance} </p>

         
           
            <!-- Add more product details as needed -->
        </div>
    </div> 
        </div>
</div>
           </div>

   
   
</body>
</html>
