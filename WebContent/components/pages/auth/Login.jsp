<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>
	<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin != null) && (admin == true)) {
			  String redirectURL =  request.getContextPath()+"/admin/dashboard";
			    response.sendRedirect(redirectURL);
		}
	%>
	<div class="section"></div>
	<div style="display:flex; justify-content:center; align-items:center; flex-direction:column;">

		<img class="responsive-img" style="width: 250px;"
			src="https://i.imgur.com/ax0NCsK.gif" />
		<div class="section"></div>

		<h5 class="indigo-text">Please, login into your account</h5>
		<div class="section"></div>

		<div class="container" style="display:flex; justify-content:center; align-items:center; flex-direction:column;">
			<div class="z-depth-1 grey lighten-4 row"
				style="display: inline-block; padding: 0px 48px 0px 48px; border: 1px solid #EEE;">

				<form class="col s12" method="post" action="${pageContext.request.contextPath}/login">
					<div class='row'>
						<div class='col s12'></div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='email' name='email' id='email' />
							<label for='email'>Enter your email</label>
						</div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='password' name='password'
								id='password' /> <label for='password'>Enter your
								password</label>
						</div>
					</div>

					<br />
					<div class='row'>
						<button type='submit' name='btn_login'
							class='col s12 btn btn-large waves-effect indigo'>Login</button>
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>