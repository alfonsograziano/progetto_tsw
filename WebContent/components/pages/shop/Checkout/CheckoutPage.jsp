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
	<%@page import="model.bean.User"%>
	
	<% %>

	<jsp:include page="../Header.jsp" />
	<%
		User user = (User) request.getAttribute("user");
		System.out.println(user);
	%>

	<div class="container">
		<div class="checkout-header"></div>
		<div class="checkout-content">
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
							<tr>
								<td>Test<b>&nbsp;X1</b></td>
								<td>15,90E</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div>
				<h3>Dati di fatturazione</h3>
				<form>
					<h5 class="checkout-form-header">Informazioni personali</h5>
					<div class="checkout-form-section">
						<div class="row">
							<div class="input-field col s6">
								<input id="name" type="text" class="validate" value="<%=user.getName()%>"> <label
									for="name">Nome</label>
							</div>
							<div class="input-field col s6">
								<input id="surname" type="text" class="validate" value="<%=user.getSurname()%>"> <label
									for="surname">Cognome</label>
							</div>

						</div>
						<div class="row">
							<div class="input-field">
								<input id="email" type="text" class="validate" disabled value="<%=user.getEmail()%>"> <label
									for="email">Email</label>
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
							<label for="details">Dettagli ordine</label>
						</div>
					</div>
				</form>

			</div>
			<div id="payment-wrapper">
				<a class="waves-effect waves-light btn amber lighten-3"
					id="payment-button" style="color: black; margin: 20px;"
					onClick="openGateway()"><i class="material-icons left"
					style="color: #357ac0;">payment</i><b>Paga ora</b></a>
			</div>
		</div>
	</div>

	<jsp:include page="../Footer.jsp" />

	<script>
		const openGateway = ()=>{
			const payWindow = window.open("./gateway","Ratting","width=600, height=700,left=150,top=200,toolbar=0,status=0,")
			payWindow.onbeforeunload = function(){ 
				const token = window.token
				if(typeof token !== "undefined"){
					$("#payment-wrapper").html("<h5 style='margin-bottom:0px;'>Pagamento completato</h5><p  style='margin-top:0px;'>Codice pagamento: "+token+"</p>")
				}else{
					alert("Pagamento non riuscito...")
				}
			}
		}
	</script>

</body>
</html>