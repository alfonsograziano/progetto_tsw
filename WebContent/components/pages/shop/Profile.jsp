<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title></title>

</head>
<body>


	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Order"%>

	<jsp:include page="Header.jsp" />
	
	<div class="container">
		<h3>Riepilogo ordini</h3>
	<%
		ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
	%>
	
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
			
			<form method="get" action="${pageContext.request.contextPath}/order">
				<input type="hidden" value="<%=o.getId() %>" name="id" />
				<button type="submit" class="waves-effect waves-light btn  blue-grey lighten-5" style="margin:20px; color:black;">Vedi dettagli</button>
			</form>
			
		</div>
		<br/>
	<%} %>
	</div>
	


	<jsp:include page="Footer.jsp" />
	
</body>
</html>