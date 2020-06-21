<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Order"%>
<%@page import="model.bean.Product"%>
<%@page import="model.bean.Contains"%>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<jsp:include page="../shop/Header.jsp" />




<%
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	Order order = (Order) request.getAttribute("order");
	ArrayList<Contains> contains = (ArrayList<Contains>) request.getAttribute("contains");
%>

<div class="container">
	<h3>
		Dettagli Ordine n:#<%=order.getId()%></h3>

	<div>
		<h5>Prodotti acquistati</h5>
		<div>
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<!-- <th>Description</th>  -->
						<th>SinglePrice</th>
						<th>Quantity</th>
						<th>TotalPrice</th>
					<tr>
				</thead>
				<tbody>
					<%
						for (int i = products.size() - 1; i >= 0; i--) {
					%>
					<tr>
						<td><%=products.get(i).getName()%></td>
						<!--<td><%=products.get(i).getDescription()%></td>  -->
						<td><%=products.get(i).getPrice()%></td>
						<td><%=contains.get(i).getQuantity()%></td>
						<td><%=contains.get(i).getPrice()%></td>


						<td>
					</tr>

					<%
						}
					%>


				</tbody>
			</table>
		</div>

	</div>

	<div>
		<h5>Informazioni</h5>
		<p class="nomargin">
			indirizzo di spedizione:<%=order.getAddress() + ", " + order.getCity() + ", " + order.getZipCode() + ", " + order.getState()%>
		</p>
		<p class="nomargin">
			dettagli ordine:<%=order.getDetails()%>
		</p>
		<p class="nomargin">
			tracking:<%=order.getTrack_id()%>
		</p>
		<p class="nomargin">
			prezzo spedizione:<%=order.getShippingPrice()%>
		</p>
		<p class="nomargin">
			codice pagamento:<%=order.getPaymentCode()%>
		</p>
	</div>


</div>

<div style="margin-top: 50px;"></div>
<jsp:include page="../shop/Footer.jsp" />






