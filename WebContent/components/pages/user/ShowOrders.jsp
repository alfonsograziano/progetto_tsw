<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Order"%>
	<jsp:include page="../HeaderData.jsp"></jsp:include>
	<jsp:include page="../shop/Header.jsp" />
	
	


	<%
		ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
	%>

		<div class="container" style="align-items:center">
	
	
		<h3>Riepilogo ordini</h3>
	
	
	<%for(int i =  orders.size()-1; i >= 0; i--){
		Order o = orders.get(i);%>
		<h6 class="order-header">Ordine n:#<%=o.getId() %></h6>
		<div class="order-section" style="align-items:center;">
			<div>
				<p class="nomargin">Effettuato il <b><%=o.getDate().getDate()+"/"+o.getDate().getMonth()+"/"+o.getDate().getYear() %></b></p> 
				<p class="nomargin">Stato: 
					<%
						if(o.getOrderState() == 1) out.print("<span class='nomargin order-pending'>pending</span>");
						if(o.getOrderState() == 2) out.print("<span class='nomargin order-sent'>sent</span>");
						if(o.getOrderState() == 3) out.print("<span class='nomargin order-fulfilled'>fulfilled</span>");
						if(o.getOrderState() == 4) out.print("<span class='nomargin order-deleted'>deleted</span>");
					%>
				</p>
				<%if(o.getTrack_id()!= null){ %>
					<p class="nomargin">Codice di spedizione:<%=o.getTrack_id() %> </p>
				<%} %>
			</div>
			<%if(o.getOrderState() != 4){ //if aggiunto perchè se stampo i dettagli di un ordine deleted, crasha a causa di puntatori null%>
			<form method="get" action="${pageContext.request.contextPath}/order">
				<input type="hidden" value="<%=o.getId() %>" name="id" />
				<button type="submit" class="waves-effect waves-light btn  blue-grey lighten-5" style="margin:20px; color:black;">Vedi dettagli</button>
			</form>
			<%} %>
		</div>
		<br/>
	<%} %>
	</div>
	<div>
				<a style="margin-top: 30px;"
				href="${pageContext.request.contextPath}/implementare"
				class="waves-effect waves-light btn">richiedi cancellazione ordine</a> 

	
	</div>
	<jsp:include page="../shop/Footer.jsp" />
	