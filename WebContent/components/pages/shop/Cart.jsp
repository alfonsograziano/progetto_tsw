<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>Carrello</title>
<script src="/BetterHome/components/pages/shop/js/ajax.js"></script>

</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.ChoosenProduct"%>
	<%@page import="model.bean.Shipping"%>
	<%@page import="java.text.DecimalFormat"%>
	<%@page import="java.math.RoundingMode"%>

	<%
		ArrayList<ChoosenProduct> cart = (ArrayList<ChoosenProduct>) request.getSession().getAttribute("cart");
		double total = 0;

		ArrayList<Shipping> shippingTypes = (ArrayList<Shipping>) request.getAttribute("shipping_types");
		if (shippingTypes == null) {
			shippingTypes = new ArrayList<Shipping>();
		}

		int shipping_type_id = -1;
		if (request.getSession().getAttribute("shipping_type_id") != null) {
			shipping_type_id = (int) request.getSession().getAttribute("shipping_type_id");
		}
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
	%>

	<jsp:include page="Header.jsp" />


	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center; margin-bottom: 300px;">
		<div style="width: 90%; max-width: 600px;">
			<h1>Carrello</h1>
			<%
				if (cart.size() > 0) {
			%>
			<table>
				<thead>
					<tr>
						<th>Quantity</th>
						<th>Image</th>
						<th>Name</th>
						<th>Unit Price</th>
						<th>Actions</th>
						<th>Price</th>
					<tr>
				</thead>
				<tbody id="table1">
					<%
						for (int i = 0; i < cart.size(); i++) {
								double price = cart.get(i).getProduct().getPrice() + ((cart.get(i).getProduct().getPrice() * cart.get(i).getProduct().getIva()) / 100);
								double productTotal = (price * cart.get(i).getQuantity());
								total = total + productTotal;
					%>
					<tr id="<%=cart.get(i).getProduct().getId()%>">
						<td id="q<%=cart.get(i).getProduct().getId()%>"><%=cart.get(i).getQuantity()%></td>
						<td><img
							src="${pageContext.request.contextPath}/getPicture?id=<%=cart.get(i).getProduct().getImages().get(0).getId()%>"
							id="main-product-image" class="product-image-thumbnail" /></td>
						<td><%=cart.get(i).getProduct().getName()%></td>
						<td><%=df.format(price)%>&#8364;</td>
						<td>
							<div class="wrap-row">

								<button id="subButton" type='submit' class="transparent-btn"
									onclick="deleteOne(<%=cart.get(i).getProduct().getId()%>, <%=cart.get(i).getProduct().getPrice()%>)">
									<i class="material-icons tiny" style="color: #455a64;">exposure_neg_1</i>
								</button>

								<button type='submit' class="transparent-btn"
									onclick="deleteAll(<%=cart.get(i).getProduct().getId()%>)">
									<i class="material-icons tiny" style="color: #455a64;">delete</i>
								</button>


								<button id="addButton" type='submit' class="transparent-btn"
									onclick="addOne(<%=cart.get(i).getProduct().getId()%>, <%=cart.get(i).getProduct().getPrice()%>)">
									<i class="material-icons tiny" style="color: #455a64;">exposure_plus_1</i>
								</button>


							</div>
						</td>
						<td><b id="p<%=cart.get(i).getProduct().getId()%>"><%=df.format(productTotal)%></b><b>&#8364;</b></td>

					</tr>
					<%
						}
					%>
				</tbody>
			</table>


			<div class="shippingtype">
				<h5 class="checkout-form-header">Seleziona spedizione</h5>
				<div class="checkout-form-section wrap-row">
					<%
						for (int i = 0; i < shippingTypes.size(); i++) {
								String className = "";
								if (shipping_type_id == shippingTypes.get(i).getId())
									className = "selected";
								else
									className = "";
					%>

					<div class="shipping-container <%=className%>"
						id="<%=shippingTypes.get(i).getId()%>"
						onClick="setShippingType(<%=shippingTypes.get(i).getId()%>)">
						<p class="nomargin">
							<b><%=shippingTypes.get(i).getName()%></b>
						</p>
						<p class="nomargin">
							Giorni di consegna: <b><%=shippingTypes.get(i).getDays()%></b>
						</p>
						<p class="nomargin">
							Prezzo
							<%=shippingTypes.get(i).getPrice()%>&euro;
						</p>

					</div>
					<%
						}
					%>
				</div>
			</div>

			<h3>Totale</h3>
			<h4><b id="total"><%=df.format(total)%></b><b>&#8364;</b></h4>
			<%
				if (shipping_type_id > 0) {
			%>
			<a style="margin-top: 30px;"
				href="${pageContext.request.contextPath}/checkout"
				class="waves-effect waves-light btn"><i
				class="material-icons right">check</i>Procedi all'acquisto</a>
			<%
				} else {
			%>
			<h5>Non puoi ancora completare l'ordine</h5>
			<p class="nomargin">Assicurati di selezionare un tipo di
				spedizione.</p>
			<%
				}
			%>
		</div>
		<%
			} else {
		%>
		<h3>Non hai elementi nel carrello</h3>
		<button
			onClick="window.location='${pageContext.request.contextPath}/home'"
			class="btn btn-large">Torna allo shop</button>
		<%
			}
		%>

	</div>
	</div>

	<jsp:include page="Footer.jsp" />


	<script>
		function setShippingType(id){
			console.log("Avviato coso su "+id)
			let params = {shipping_type_id:id}
			console.log(params)
			console.log($.post('http://localhost:8080/BetterHome/cart/setshippingtype', params, function(response){ 
			      window.location.reload() //da cambiare, ovviamente
			      
			}))
		}
	</script>
</body>
</html>