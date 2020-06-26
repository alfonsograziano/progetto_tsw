<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Shipping"%>

<%
	ArrayList<Shipping> shipping_types = (ArrayList<Shipping>) request.getAttribute("shipping_types");
%>


<div
	style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
	<div style="width: 90%; max-width: 600px;">
		<h1>Tipi di Spedizione</h1>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Days</th>
					<th>Price</th>
					<th>Actions</th>
				<tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < shipping_types.size(); i++) {
				%>
				<tr>
					<td><%=shipping_types.get(i).getId()%></td>
					<td><%=shipping_types.get(i).getName()%></td>
					<td><%=shipping_types.get(i).getDays()%></td>
					<td><%=shipping_types.get(i).getPrice()%></td>

					<td>
						<div style="display: inline-block;">
							<form method="post"
								action="${pageContext.request.contextPath}/shipping/delete">
								<input type="hidden" name="id"
									value="<%=shipping_types.get(i).getId()%>">
								<button type='submit'>
									<i class="material-icons tiny" style="color: #455a64;">delete</i>
								</button>

							</form>
							<form method="get"
								action="${pageContext.request.contextPath}/shipping/update">
								<input type="hidden" name="id"
									value="<%=shipping_types.get(i).getId()%>">
								<button type='submit'>
									<i class="material-icons tiny" style="color: #455a64;">edit</i>
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

		<a style="margin-top: 30px;"
			href="${pageContext.request.contextPath}/shipping/add"
			class="waves-effect waves-light btn"><i
			class="material-icons right">add</i>Aggiungi tipo di spedizione</a> 
	</div>
</div>
