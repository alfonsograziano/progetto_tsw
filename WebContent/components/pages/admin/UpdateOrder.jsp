><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Order"%>
<%
	Order order = (Order) request.getAttribute("order");
%>

<div
	style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
	<div style="width: 90%; max-width: 600px;">
		<h1>
			Ordine #<%=order.getId()%></h1>

		<div>
			<h4>Modifica codice di tracciamento</h4>
			<form method="post"
				action="${pageContext.request.contextPath}/orders/updateTrackingCode"
				class="wrap-row" style="align-items: center;">
				<div class="input-field">
					<input type="hidden" value="<%=order.getId()%>" name="order_id" />
					<input id="tracking_id" type="text" class="validate"
						name="tracking_id" value="<%=order.getTrack_id()%>"> <label
						for="tracking_id">Codice di tracciamento</label>
				</div>
				<button style="margin-left: 10px;" type="submit"
					class="waves-effect waves-light btn">Aggiorna codice</button>
			</form>
		</div>

		<div>
			<h4>Modifica stato ordine</h4>
			<form method="post"
				action="${pageContext.request.contextPath}/orders/updateOrderState"
				style="align-items: center;">
				<input type="hidden" value="<%=order.getId()%>" name="order_id" />
				<p class="nomargin">
					Stato:
					<%
					if (order.getOrderState() == 1)
						out.print("<span class='nomargin order-pending'>pending</span>");
					if (order.getOrderState() == 2)
						out.print("<span class='nomargin order-sent'>sent</span>");
					if (order.getOrderState() == 3)
						out.print("<span class='nomargin order-fulfilled'>fulfilled</span>");
					if (order.getOrderState() == 4)
						out.print("<span class='nomargin order-deleted'>deleted</span>");
				%>
				</p>

				<div class="wrap-row" style="align-items: center;">
					<div class="input-field">
						<select class="browser-default" name="order_state"
							id="order_state">
							<option value="1"
								<%if (order.getOrderState() == 1)
				out.print("selected");%>>Pending</option>
							<option value="2"
								<%if (order.getOrderState() == 2)
				out.print("selected");%>>Sent</option>
							<option value="3"
								<%if (order.getOrderState() == 3)
				out.print("selected");%>>Fulfilled</option>
							<option value="4"
								<%if (order.getOrderState() == 4)
				out.print("selected");%>>Deleted</option>
						</select>
					</div>

					<button style="margin-left: 10px;" type="submit"
						class="waves-effect waves-light btn">Aggiorna stato</button>
				</div>

			</form>
		</div>
	</div>
</div>
