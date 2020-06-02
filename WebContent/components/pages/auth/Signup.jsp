<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
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
<script type="text/javascript"
	src="components/pages/auth/js/validation/validaSignup.js"></script>
=======
<head><jsp:include page="../HeaderData.jsp"></jsp:include>

>>>>>>> refs/remotes/origin/master
</head>
<body>
	<jsp:include page="../shop/Header.jsp" />

	<div class="section"></div>
	<div
		style="display: flex; justify-content: center; align-items: center; flex-direction: column;">

		<div class="section"></div>

		<h5 class="indigo-text">Benvenuto, registrati!</h5>
		<div class="section"></div>

		<div class="container"
			style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
			<div class="z-depth-1 grey lighten-4 row"
				style="padding: 0px 48px 0px 48px; border: 1px solid #EEE;">

<<<<<<< HEAD
				<form class="col s12" method="get" name="invio">
=======
				<form class="col s12" method="post"
					action="${pageContext.request.contextPath}/signup">
>>>>>>> refs/remotes/origin/master
					<div class='row'>
						<div class='col s12'></div>
					</div>

					<div class='row'>
						<div class='input-field col s6'>
							<input class='validate' type='text' name='name' id='name' /> <label
								for='name'>Nome</label>
						</div>
						<div class='input-field col s6'>
							<input class='validate' type='text' name='surname' id='surname' />
							<label for='name'>Cognome</label>
						</div>
					</div>


					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='email' name='email' id='email' />
							<label for='email'>Email</label>
						</div>
					</div>

					<div class='row'>
						<div class='input-field col s12'>
							<input class='validate' type='password' name='password'
								id='password' /> <label for='password'>Password</label>
						</div>
					</div>

					<br />
					<div class='row'>
						<button type='submit'
							class='col s12 btn btn-large waves-effect indigo' onclick="valida()">Registrati</button>
					</div>
				</form>
			</div>
			Hai già un account? <a href="${pageContext.request.contextPath}/login">Accedi</a>
		</div>

	</div>

</body>
</html>