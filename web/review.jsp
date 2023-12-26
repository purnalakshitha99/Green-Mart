<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/stylesheet.css" />
    <link rel="stylesheet" href="css/review.css" />
    <link rel="shortcut icon" href="images/Green.jpg" />
     <script src="https://kit.fontawesome.com/80224b9ef7.js" crossorigin="anonymous"></script></head>
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
    <title>GREEN Supermarket</title>
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
        <div class="c_us" padding="20px">
            <h1>Review Form</h1>
            <form>
                <input type="text" placeholder="Your Name">
                <textarea placeholder="Your Message"></textarea>
                <button type="submit">Submit</button>

            </form>
         </div>
        <section id="clients">
      <!--heading---------------->
      <div class="client-heading">
        <h3>What Our Client's Say</h3>
      </div>
      <!--box-container---------->
      <div class="client-box-container">
        <!--box------------->
        <div class="client-box">
          <!--==profile===-->
          <div class="client-profile">
            <!--text-->
            <div class="profile-text">
              <strong>James Mcavoy</strong>
            </div>
          </div>
          <!--==comments===-->
          <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Fugiat ea
            id, itaque architecto atque mollitia aperiam voluptatem consequatur
            incidunt sed placeat, harum recusandae quaerat at hic labore eius
            laborum quas!
          </p>
        </div>
        <!--box------------->
        <div class="client-box">
          <!--==profile===-->
          <div class="client-profile">
            <!--text-->
            <div class="profile-text">
              <strong>Adward Mcavoy</strong>
            </div>
          </div>
          <!--==comments===-->
          <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Fugiat ea
            id, itaque architecto atque mollitia aperiam voluptatem consequatur
            incidunt sed placeat, harum recusandae quaerat at hic labore eius
            laborum quas!
          </p>
        </div>
        <!--box------------->
        <div class="client-box">
          <!--==profile===-->
          <div class="client-profile">
            <!--text-->
            <div class="profile-text">
              <strong>Ava Alex</strong>
            </div>
          </div>
          <!--==comments===-->
          <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Fugiat ea
            id, itaque architecto atque mollitia aperiam voluptatem consequatur
            incidunt sed placeat, harum recusandae quaerat at hic labore eius
            laborum quas!
          </p>
        </div>
      </div>
    </section>
    </body>
</html>
