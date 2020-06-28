<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>Profilo</title>

</head>
<body>


	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Order"%>
	<%@page import="model.bean.User"%>



	<jsp:include page="Header.jsp" />
	<%
		ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
		User user = (User) request.getAttribute("user");
		request.setAttribute("user_id", user.getId());
		
		
	%>
	<div
		style="display: flex; flex-direction: column; align-items: center; justify-content: center; margin-top: 30px;">

		<i class="large  material-icons">person_pin</i>

		<h4 class="nomargin">
			<%
				out.print(user.getName());
			%>
			<%
				out.print(user.getSurname());
			%>
		</h4>
		<h6 class="nomargin">
			email:
			<%
			out.print(user.getEmail());
		%>
		</h6>
	</div>

	<div class="container" style="margin-top: 20px;">


		<div class="center">

			<a style="margin: 20px;"
				href="${pageContext.request.contextPath}/GetUserOrders"
				class="waves-effect waves-light btn">Mostra tutti gli ordini</a> 
				
				
				<!-- <a
				style="margin: 20px;"
				href="${pageContext.request.contextPath}/ShowShippingInfo"
				class="waves-effect waves-light btn">Mostra indirizzi spedizione</a>  -->


		</div>
		<p class="nomargin">Hai bisogno di assistenza?</p>
		<p class="nomargin">
			<b>Contattaci su Whatsapp premendo sul pulsante</b>
		</p>
		<a href="${pageContext.request.contextPath}/logout">Logout</a>

		<div style="margin-bottom: 50px;"></div>

	</div>





	<jsp:include page="Footer.jsp" />

</body>
</html>