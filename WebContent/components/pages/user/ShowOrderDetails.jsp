<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Order"%>
	<%@page import="model.bean.Product"%>
	<%@page import="model.bean.Contains"%>
	<jsp:include page="../HeaderData.jsp"></jsp:include>
		<jsp:include page="../shop/Header.jsp" />
	
	


	<%
		ArrayList<Product> products= (ArrayList<Product>) request.getAttribute("products");
		Order order = (Order) request.getAttribute("order");
		ArrayList<Contains> contains= (ArrayList<Contains>) request.getAttribute("contains");
	%>

	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div style="width: 90%; max-width: 600px;">
			<h1>Dettagli Ordine</h1>
			<h6 class="order-header">Ordine n:#<%=order.getId() %></h6>
				<div>
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>SinglePrice</th>
						<th>Quantity</th>
						<th>TotalPrice</th>
						
						
						
						
						
					<tr>
				</thead>
				<tbody>
				<%for(int i =  products.size()-1; i >= 0; i--){%>
					<tr>
						<td><%=products.get(i).getName()%></td>
						<td><%=products.get(i).getDescription()%></td>
						<td><%=products.get(i).getPrice()%></td>	
						<td><%=contains.get(i).getQuantity()%></td>	
						<td><%=contains.get(i).getPrice()%></td>	
						
									
						<td>
					</tr>
														<%} %>
					
				</tbody>
			</table>
			</div>
			
							<p class="nomargin">indirizzo di spedizione:<%=order.getAddress()+","+order.getCity()+","+order.getZipCode()+","
							+order.getState()%> </p>
							<p class="nomargin">dettagli ordine:<%=order.getDetails()%> </p>
							<p class="nomargin">tracking:<%=order.getTrack_id()%> </p>
							<p class="nomargin">prezzo spedizione:<%=order.getShippingPrice()%> </p>
							<p class="nomargin">codice pagamento:<%=order.getPaymentCode()%> </p>
		</div>
		<div>
		</div>
	</div>
		</div>
		
	</div>
	
	
	
	
	