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
		Order o = orders.get(orders.size() - 1);
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


		<h5 class="nomargin">Ultimo ordine</h5>

		<h6 class="order-header">
			Ordine n:#<%=o.getId()%></h6>
		<div class="order-section" style="align-items: center;">
			<div>
				<p class="nomargin">
					Effettuato il <b><%=o.getDate().getDate() + "/" + o.getDate().getMonth() + "/" + o.getDate().getYear()%></b>
				</p>
				<p class="nomargin">
					Stato:
					<%
					if (o.getOrderState() == 1)
						out.print("<span class='nomargin order-pending'>pending</span>");
					if (o.getOrderState() == 2)
						out.print("<span class='nomargin order-sent'>sent</span>");
					if (o.getOrderState() == 3)
						out.print("<span class='nomargin order-fulfilled'>fulfilled</span>");
					if (o.getOrderState() == 4)
						out.print("<span class='nomargin order-deleted'>deleted</span>");
				%>
				</p>
				<%
					if (o.getTrack_id() != null) {
				%>
				<p class="nomargin">
					Codice di spedizione:<%=o.getTrack_id()%>
				</p>
				<%
					}
				%>
			</div>
			<%
				if (o.getOrderState() != 4) { //if aggiunto perchè se stampo i dettagli di un ordine deleted, crasha a causa di puntatori null
			%>
			<form method="get" action="${pageContext.request.contextPath}/order">
				<input type="hidden" value="<%=o.getId()%>" name="id" />
				<button type="submit"
					class="waves-effect waves-light btn  blue-grey lighten-5"
					style="margin: 20px; color: black;">Vedi dettagli</button>
			</form>
			<%
				}
			%>
		</div>
		<br />


		<div class="wrap-row">

			<a style="margin: 20px;"
				href="${pageContext.request.contextPath}/GetUserOrders"
				class="waves-effect waves-light btn">Mostra tutti gli ordini</a> <a
				style="margin: 20px;"
				href="${pageContext.request.contextPath}/ShowShippingInfo"
				class="waves-effect waves-light btn">Mostra indirizzi spedizione</a>


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