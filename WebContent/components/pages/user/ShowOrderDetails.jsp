<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Order"%>
<%@page import="model.bean.Product"%>
<%@page import="model.bean.Contains"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.RoundingMode"%>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<jsp:include page="../shop/Header.jsp" />




<%
	ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	Order order = (Order) request.getAttribute("order");
	ArrayList<Contains> contains = (ArrayList<Contains>) request.getAttribute("contains");
	DecimalFormat df = new DecimalFormat("#.##");
	df.setRoundingMode(RoundingMode.CEILING);
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
						double price = products.get(i).getPrice() + ((products.get(i).getPrice() * products.get(i).getIva()) / 100);
					%>
					<tr>
						<td><%=products.get(i).getName()%></td>
						<!--<td><%=products.get(i).getDescription()%></td>  -->
						<td><%=df.format(price)%>&#8364;</td>
						<td><%=contains.get(i).getQuantity()%></td>
						<td><%=df.format(price*contains.get(i).getQuantity())%>&#8364;</td>


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






