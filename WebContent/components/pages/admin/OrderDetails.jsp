><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Order"%>
<%@page import="model.bean.Product"%>
<%@page import="model.bean.ChoosenProduct"%>
<%@page import="model.bean.User"%>


<%
	Order order = (Order) request.getAttribute("order");
	User user = (User) request.getAttribute("user");
%>




<div
	style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
	<div style="width: 90%; max-width: 600px;">
		<h1>
			Ordine #<%=order.getId()%></h1>
		<div class="wrap-row">
			<div>
				<h5>Informazioni</h5>
				<h6>
					Stato ordine:
					<%=order.getStringOrderState()%></h6>
				<p class="nomargin">
					Creato il
					<%=order.getDate().getDate() + "/" + order.getDate().getMonth() + "/" + order.getDate().getYear()
					+ " " + order.getDate().getHours() + ":" + order.getDate().getMinutes()%></p>
				<p class="nomargin">
					Dettagli:
					<%=order.getDetails()%></p>
				<p class="nomargin">
					Codice di tracciamento:
					<%=order.getTrack_id()%></p>
			</div>

			<div style="margin-left: 20px;">
				<h5>Dati personali utente</h5>
				<p class="nomargin">
					Email:
					<%=user.getEmail()%></p>
				<p class="nomargin">
					Nome:
					<%=user.getName()%></p>
				<p class="nomargin">
					Cognome:
					<%=user.getSurname()%></p>

				<h5>Spedizione</h5>
				<p class="nomargin">
					Stato:
					<%=order.getState()%></p>
				<p class="nomargin">
					Città:
					<%=order.getCity()%></p>
				<p class="nomargin">
					CAP:
					<%=order.getZipCode()%></p>
				<p class="nomargin">
					Indirizzo:
					<%=order.getAddress()%></p>
			</div>

		</div>



		<h3>Prodotti acquistati</h3>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>Nome</th>
					<th>Quantità</th>
					<th>Prezzo</th>
				<tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < order.getProducts().size(); i++) {
						ChoosenProduct p = order.getProducts().get(i);
				%>
				<tr>
					<td><%=p.getProduct().getId()%></td>
					<td><%=p.getProduct().getName()%></td>
					<td><%=p.getQuantity()%></td>
					<td><%=p.getProduct().getPrice()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>


	</div>
</div>
