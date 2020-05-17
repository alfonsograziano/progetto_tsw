<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>

<title>Elimina Spedizione</title>
</head>
<body>
	<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin == null) || (admin == false)) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	%>
	<jsp:include page="VNav.jsp" />
	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>

		<h4>Elimina una spedizione...</h4>
		<form class="col s12" method="post"
			style="width: 100%; max-width: 500px;"
			action="${pageContext.request.contextPath}/shipping/delete">
			
			<div class="input-field col s12">
				<input class='validate' type='text' name='id' id='id' /> <label
					for='email'>ID del tipo di spedizione</label>
			</div>

			<button type='submit' name='btn_login'
				class='col s12 btn btn-large waves-effect indigo'>Elimina</button>
		</form>
	</div>

</body>
</html>