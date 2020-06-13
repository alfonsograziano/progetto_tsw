<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Order"%>
	<jsp:include page="../HeaderData.jsp"></jsp:include>
	


	<%
		Order order = (Order) request.getAttribute("order");
	%>

	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div style="width: 90%; max-width: 600px;">
			<h1>Dettagli Ordine</h1>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Data</th>
						<th>Iva</th>
						<th>City</th>
						<th>Address</th>
						<th>State</th>
						<th>zipCode</th>
						<th>Details</th>
						<th>TrackId</th>
						<th>ShippingPrice</th>
						<th>PaymentCode</th>
						<th>OrderState</th>
						
						
						
					<tr>
				</thead>
				<tbody>
					<tr>
						<td><%=order.getId()%></td>
						<td><%=order.getDate().getDate()+"/"+order.getDate().getMonth()+"/"+order.getDate().getYear() %></td>
						<td><%=order.getIva()%></td>
						<td><%=order.getCity()%></td>
						<td><%=order.getAddress()%></td>
						<td><%=order.getState()%></td>
						<td><%=order.getZipCode()%></td>
						<td><%=order.getDetails()%></td>
						<td><%=order.getTrack_id()%></td>
						<td><%=order.getShippingPrice()%></td>
						<td><%=order.getPaymentCode()%></td>					
						<td>
						<%
							if(order.getOrderState() == 1) out.print("<span class='nomargin order-pending'>pending</span>");
							if(order.getOrderState() == 2) out.print("<span class='nomargin order-sent'>sent</span>");
							if(order.getOrderState() == 3) out.print("<span class='nomargin order-fulfilled'>fulfilled</span>");
							if(order.getOrderState() == 4) out.print("<span class='nomargin order-deleted'>deleted</span>");
						%>
						</td>
					</tr>
				</tbody>
			</table>
		
		</div>
	</div>