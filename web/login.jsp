<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>

<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <input type="hidden" id="status" value="<%=request.getAttribute("status")%>">

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Login</h2>
					
						<form method="post" action="login" class="register-form"
							id="register-form">
							
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="username" name="username" id="username" placeholder="Your username" />
							</div>
                                                   
							
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="password" name="password" id="re_pass"
									placeholder="Your password" />
							</div>
							<div class="form-group">
								<input type="checkbox" name="agree-term" id="agree-term"
									class="agree-term" /> <label for="agree-term"
									class="label-agree-term"><span><span></span></span>Remember Me </label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Login" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="new/logo.png" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create Account</a>
					</div>
				</div>
			</div>
		</section>
	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
        <script src="new/ssn.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
    var status=document.getElementById("status").value;
    if(status === "failed"){
        swal("Sorry","Wrong username or password","failed");
    }
</script>      
</body>
</html>