<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Order"%>
<%@page import="model.bean.User"%>


<%
	ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
	ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
%>


<div
	style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
	<div style="width: 90%; max-width: 600px;">
		<h1>Ordini</h1>

		<ul class="collapsible">
			<li>
				<div class="collapsible-header">
					<i class="material-icons">date_range </i>Filtra per data
				</div>
				<div class="collapsible-body" style="background-color: #fff;">
					<div>
						<form action="${pageContext.request.contextPath}/admin/dashboard/ordersByDate">
							<div class="wrap-row" style="align-items: center;">
								<div style="margin-left: 10px">
									<label>Asd</label> <input type="date" id="startDate" name="startDate">
								</div>
								<div style="margin-left: 10px">
									<label>Asd</label> <input type="date" id="endDate" name="endDate">
								</div>
								<input type="submit" class="btn" value="Cerca"
									style="margin-left: 20px;"></input>

							</div>

						</form>
					</div>
				</div>

			</li>
			<li>
				<div class="collapsible-header">
					<i class="material-icons">person </i>Filtra per utente
				</div>
				<div class="collapsible-body" style="background-color: #fff;">
					<div>
						<form  action="${pageContext.request.contextPath}/admin/dashboard/ordersByUser">
							<div class="input-field col s12">
								<select name="idUser">
									<option value="" disabled selected>Filtra per utente</option>
									<%for(int i = 0; i< users.size(); i++){ %>
										<option value="<%=users.get(i).getId()%>"><%=users.get(i).getEmail() %></option>
									<%} %>
									
								</select> <label>Seleziona l'utente</label>
							</div>
							<input type="submit" class="btn" value="Cerca"
								style="margin-left: 20px;"></input>


						</form>
					</div>
				</div>

			</li>

		</ul>


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
					for (int i = orders.size() - 1; i >= 0; i--) {
						Order o = orders.get(i);
				%>
				<tr>
					<td><%=o.getId()%></td>
					<td><%=o.getDate().getDate() + "/" + o.getDate().getMonth() + "/" + o.getDate().getYear()%></td>
					<td>
						<%
							if (o.getOrderState() == 1)
									out.print("<span class='nomargin order-pending'>pending</span>");
								if (o.getOrderState() == 2)
									out.print("<span class='nomargin order-sent'>sent</span>");
								if (o.getOrderState() == 3)
									out.print("<span class='nomargin order-fulfilled'>fulfilled</span>");
								if (o.getOrderState() == 4)
									out.print("<span class='nomargin order-deleted'>deleted</span>");
						%>
					</td>
					<td>
						<div style="display: flex; flex-direction: column;">
							<a
								href="${pageContext.request.contextPath}/order/details?id=<%=o.getId()%>">Mostra
								dettagli</a> <a
								href="${pageContext.request.contextPath}/orders/update?id=<%=o.getId()%>">Modifica</a>
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


<script>
	document.addEventListener('DOMContentLoaded', function() {
		var elems = document.querySelectorAll('.collapsible');
		var instances = M.Collapsible.init(elems, {});

		var elems = document.querySelectorAll('select');
		var instances = M.FormSelect.init(elems, {});
		
		document.getElementById("startDate").valueAsDate = new Date();
		document.getElementById("endDate").valueAsDate = new Date();

	});
</script>
