<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.ShippingInfo"%>
	<%
		ArrayList<ShippingInfo> ship = (ArrayList<ShippingInfo>) request.getAttribute("shipInfo");
	%>

<title>spedizioni utente</title>
<jsp:include page="../HeaderData.jsp"></jsp:include>
	<jsp:include page="../shop/Header.jsp" />


<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div style="width: 90%; max-width: 600px;">
		
					<h1>indirizzi</h1>
					<table>
				<thead>
					<tr>
						<th>id</th>
						<th>Address</th>
						<th>State</th>
						<th>ZipCode</th>
						<th>City</th>
						
					<tr>
				</thead>
				<tbody>
	
						<%
						for (int i = 0; i < ship.size(); i++) {
						%>
							<tr>
							<td><%=ship.get(i).getId()%></td>
							<td><%=ship.get(i).getAddress()%></td>
							<td><%=ship.get(i).getState()%></td>
							<td><%=ship.get(i).getZipCode()%></td>
							<td><%=ship.get(i).getCity()%></td>
							
							<td>
							<div style="display: inline-block;">

								<form method="post" action="${pageContext.request.contextPath}/shippingInfo/delete">
										<input type="hidden" name="id" value="<%=ship.get(i).getId()%>">
									<button type='submit'>
										<i class="tiny material-icons tiny" style="color: #455a64;">delete</i>
									</button>

								</form>
								
								<form method="post" action="${pageContext.request.contextPath}/shippingInfo/update">
										<input type="hidden" name="id2" value="<%=ship.get(0).getId()%>">
									<button type='submit'>
										  <i class="tiny material-icons" style="color: #455a64;">build</i>
									</button>

								</form>

							</div>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			
			</div>
			<a style="margin-top: 30px;"
				href="${pageContext.request.contextPath}/components/pages/user/AddShippingInfo.jsp"
				class="waves-effect waves-light btn"><i
				class="material-icons right">add</i>Aggiungi indirizzo spedizione</a> 				
	</div>
	
						<jsp:include page="../shop/Footer.jsp" />
	
							
							