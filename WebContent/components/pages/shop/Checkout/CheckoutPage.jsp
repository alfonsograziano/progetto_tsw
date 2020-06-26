<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../HeaderData.jsp"></jsp:include>
<title></title>
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Product"%>
	<%@page import="model.dao.ShippingModelDS"%>
	<%@page import="model.bean.User"%>
	<%@page import="model.bean.ChoosenProduct"%>
	<%@page import="model.bean.Shipping"%>

	<%
		ArrayList<ChoosenProduct> cart = (ArrayList<ChoosenProduct>) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<ChoosenProduct>();
		}

		double total = 0.0;
		double iva = 0;
		for (int i = 0; i < cart.size(); i++) {
			total += cart.get(i).getProduct().getPrice() * cart.get(i).getQuantity();
			iva += ((cart.get(i).getProduct().getPrice() * cart.get(i).getProduct().getIva()) / 100)*cart.get(i).getQuantity();
		}

		int shipping_type_id = -1;
		ShippingModelDS shippingModel = new ShippingModelDS();
		Shipping shipping = new Shipping();
		if (request.getSession().getAttribute("shipping_type_id") != null) {
			shipping_type_id = (int) request.getSession().getAttribute("shipping_type_id");
			shipping = shippingModel.getById(shipping_type_id);
		} else {
			//TODO: implementa pagina d'errore se non imposti la spedizione!
			response.sendRedirect("localhost:8080/BetterHome/cart");
		}

		total += shipping.getPrice();
		System.out.println(iva);
		Double total_iva = total + iva;
	%>

	<jsp:include page="../Header.jsp" />
	<%
		User user = (User) request.getAttribute("user");
		System.out.println(user);
	%>

		<div class="checkout-content" style="margin-bottom: 100px;">
			<div class="wrap-row" style="justify-content:center;">
							<div>
					<h3>Dati di fatturazione</h3>
					<form>
						<h5 class="checkout-form-header">Informazioni personali</h5>
						<div class="checkout-form-section">
							<div class="row">
								<div class="input-field col s6">
									<input id="name" type="text" class="validate" disabled
										value="<%=user.getName()%>"> <label for="name">Nome</label>
								</div>
								<div class="input-field col s6">
									<input id="surname" type="text" class="validate" disabled
										value="<%=user.getSurname()%>"> <label for="surname">Cognome</label>
								</div>

							</div>
							<div class="row">
								<div class="input-field">
									<input id="email" type="text" class="validate" disabled
										value="<%=user.getEmail()%>"> <label for="email">Email</label>
								</div>
							</div>
						</div>
						<h5 class="checkout-form-header">Dati di spedizione</h5>
						<div class="checkout-form-section">
							<div class="input-field col s6">
								<input id="state" type="text" class="validate"> <label
									for="state">Stato</label>
							</div>
							<div class="input-field col s6">
								<input id="city" type="text" class="validate"> <label
									for="city">Città</label>
							</div>
							<div class="input-field col s6">
								<input id="zip_code" type="text" class="validate"> <label
									for="zip_code">ZIP Code</label>
							</div>
							<div class="input-field col s6">
								<input id="address" type="text" class="validate"> <label
									for="address">Indirizzo</label>
							</div>
						</div>

						<h5 class="checkout-form-header">Vuoi comunicarci qualcosa?</h5>
						<div class="checkout-form-section">
							<div class="input-field col s12">
								<textarea id="details" class="materialize-textarea"></textarea>
								<label for="details">Dettagli ordine (opzionale)</label>
							</div>
						</div>
					</form>

				</div>
			
				<div class="order">
					<h3>Riepilogo ordine</h3>
					<h5 class="checkout-form-header">Prodotti</h5>
					<div class="checkout-form-section">
						<table>
							<thead>
								<tr>
									<th>Prodotto</th>
									<th>Subtotale</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (int i = 0; i < cart.size(); i++) {
										Product p = cart.get(i).getProduct();
								%>
								<tr>
									<td><%=p.getName()%><b>&nbsp;X<%=cart.get(i).getQuantity()%></b></td>
									<td><%=p.getPrice()%>&euro;</td>
								</tr>
								<%
									}
								%>

								<tr>
									<td><b>Spedizione </b><%=shipping.getName()%></td>
									<td><%=shipping.getPrice()%>&euro;</td>
								</tr>

							</tbody>
						</table>
						<div class="wrap-row"
							style="justify-content: space-around; align-items: center;">
							<p>
								Tasse:
								<%=String.format("%.2f", iva)%>&euro;</p>
								<br/>
							<p>
								Totale <b id="total_iva"><%=String.format("%.2f", total_iva)%></b>&euro;
							</p>
							<div id="payment-wrapper">
								<a class="waves-effect waves-light btn amber lighten-3"
									id="payment-button" style="color: black; margin: 20px;"
									onClick="openGateway()"><i class="material-icons left"
									style="color: #357ac0;">payment</i><b>Paga ora e conferma
										ordine</b></a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

	<jsp:include page="../Footer.jsp" />

	<script>
	
		function openGateway() {
			if (validateInput()) {
				const payWindow = window
						.open("./gateway", "Ratting",
								"width=600, height=700,left=150,top=200,toolbar=0,status=0,")
				payWindow.onbeforeunload = function() {
					const token = window.token
					if (typeof token !== "undefined") {
						$("#payment-wrapper")
								.html(
										"<h5 style='margin-bottom:0px;'>Pagamento completato</h5><p  style='margin-top:0px;'>Codice pagamento: "
												+ token + "</p>")
							
						console.log("Richiamo il post")
						var data ={
							state: $("#state").val(),
							city: $("#city").val(),
							address: $("#address").val(),
							zip_code: $("#zip_code").val(),
							details: $("#details").val(),
							payment_id: token
						}
						console.log($.post("<%=request.getContextPath()%>/order/add",
								data, function() {
									alert("Ordine completato...");
								}))

					} else {
						alert("Pagamento non riuscito...")
					}
				}
			} else {
				alert("Attenzione, sono presenti dei campi non validi")
			}
		}

		function validateInput() {
			var errors = 0
			var not_null = [ "#email", "#state", "#city", "#zip_code",
					"#address" ]
			not_null.forEach(function(item) {
				if ($(item).val() === "") {
					$(item).css("border", "solid 1px red");
					errors++
				} else {
					$(item).css("border", "");
				}
			})
			if (errors > 0) {
				return false
			}
			return true
		}
	</script>

</body>
</html>