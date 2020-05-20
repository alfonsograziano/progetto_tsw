<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>Insert title here</title>

</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.ChoosenProduct"%>
	<%@page import="model.bean.Shipping"%>

	<%ArrayList<ChoosenProduct> cart = (ArrayList<ChoosenProduct>) request.getSession().getAttribute("cart"); 
	double total=0;
	
	ArrayList<Shipping> shippingTypes = (ArrayList<Shipping>) request.getAttribute("shipping_types");
	if (shippingTypes == null) {
		shippingTypes = new ArrayList<Shipping>();
	}
	
	int shipping_type_id = -1;
	if(request.getSession().getAttribute("shipping_type_id") != null){
		shipping_type_id = (int) request.getSession().getAttribute("shipping_type_id");
	}
	
	%>
	
	<jsp:include page="Header.jsp" />


	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center; margin-bottom:300px;">
		<div style="width:90%; max-width:600px;">
		<h1>Carrello</h1>
		<table>
			<thead>
				<tr>
					<th>Quantity</th>
					<th>Name</th>
					<th>Price</th>
					<th>Actions</th>
				<tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < cart.size(); i++) {
						total = total + (cart.get(i).getProduct().getPrice()*cart.get(i).getQuantity());
						
				%>
					<tr>
						<td><%=cart.get(i).getQuantity()%></td>
						<td><%=cart.get(i).getProduct().getName()%></td>
						<td><%=cart.get(i).getProduct().getPrice()%></td>
						<td>
							<div style="display: inline-block;">

								<form method="post"
									action="${pageContext.request.contextPath}/cart/delete-one">
									<input type="hidden" name="id"
										value="<%=cart.get(i).getProduct().getId()%>">
									<button type='submit'>
										<i class="material-icons tiny" style="color: #455a64;">exposure_neg_1</i>
									</button>

								</form>
								<form method="post"
									action="${pageContext.request.contextPath}/cart/delete-all">
									<input type="hidden" name="id"
										value="<%=cart.get(i).getProduct().getId()%>">
									<button type='submit'>
										<i class="material-icons tiny" style="color: #455a64;">delete</i>
									</button>

								</form>
								<form method="post"
									action="${pageContext.request.contextPath}/cart/add-one">
									<input type="hidden" name="id"
										value="<%=cart.get(i).getProduct().getId()%>">
									<button type='submit'>
										<i class="material-icons tiny" style="color: #455a64;">exposure_plus_1</i>
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
		
		
		<div class="shippingtype">
			<h5 class="checkout-form-header">Seleziona spedizione</h5>
				<div class="checkout-form-section wrap-row">
					<%for(int i = 0; i < shippingTypes.size(); i++){ 
						String className ="";
						if(shipping_type_id == shippingTypes.get(i).getId())
							className= "selected";
						else
							className="";
					%>
						
						<div class="shipping-container <%=className %>" id="<%=shippingTypes.get(i).getId()%>" onClick="setShippingType(<%=shippingTypes.get(i).getId()%>)">
							<p class="nomargin"><b><%=shippingTypes.get(i).getName()%></b></p>
							<p class="nomargin">Giorni di consegna: <b><%=shippingTypes.get(i).getDays()%></b></p>
							<p class="nomargin">Prezzo <%=shippingTypes.get(i).getPrice()%>&euro;</p>
							
						</div>
					<%} %>
				</div>
			</div>
		
		<h3>Totale</h3>
		<p><%=total%></p>
		<a style="margin-top:30px;"
			href="${pageContext.request.contextPath}/checkout" 
			class="waves-effect waves-light btn"><i class="material-icons right">check</i>Procedi all'acquisto</a>

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