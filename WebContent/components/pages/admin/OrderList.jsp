><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>Insert title here</title>

</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Order"%>

	<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin == null) || (admin == false)) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	%>
	<%
		ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
	%>

	<jsp:include page="VNav.jsp" />


	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div style="width: 90%; max-width: 600px;">
			<h1>Ordini</h1>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Data</th>
						<th>State</th>
						<th>Actions</th>
					<tr>
				</thead>
				<tbody>
					<%
					for(int i =  orders.size()-1; i >= 0; i--){
							Order o = orders.get(i);
					%>
					<tr>
						<td><%=o.getId()%></td>
						<td><%=o.getDate().getDate()+"/"+o.getDate().getMonth()+"/"+o.getDate().getYear() %></td>
						<td>
						<%
							if(o.getOrderState() == 1) out.print("<span class='nomargin order-pending'>pending</span>");
							if(o.getOrderState() == 2) out.print("<span class='nomargin order-sent'>sent</span>");
							if(o.getOrderState() == 3) out.print("<span class='nomargin order-fulfilled'>fulfilled</span>");
							if(o.getOrderState() == 4) out.print("<span class='nomargin order-deleted'>deleted</span>");
						%>
						</td>
						<td>
							<div style="display:flex; flex-direction:column;">
								<a href="${pageContext.request.contextPath}/order/details?id=<%=o.getId()%>">Mostra dettagli</a>
								<a href="${pageContext.request.contextPath}/orders/update?id=<%=o.getId()%>">Modifica</a>
							</div>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

		
		</div>
	</div>


</body>
</html>