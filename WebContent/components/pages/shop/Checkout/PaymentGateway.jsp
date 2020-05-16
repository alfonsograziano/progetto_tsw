<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="width: 100%;">
<head>
<jsp:include page="../../HeaderData.jsp"></jsp:include>

<title>Insert title here</title>
</head>
<body style="width: 100%; background-color: rgba(0, 0, 0, 0.05);">
<%@ page isELIgnored="false"%>
	<script>
		const generatePaymentToken = ()=>{
			const token = Math.random().toString(36).substr(2)+Math.random().toString(36).substr(2);
			window.opener["token"] = token
			window.close();
		}
	</script>


	<div
		style="display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div
			style="width: 80%; max-width: 300px; margin-top: 30px; background-color: white; padding: 20px;">
			
			<img src="${pageContext.request.contextPath}/assets/img/paypal.png"
			style=" width: 100%; padding:10px;"/>

		
			<form class="col s12">
				<div class="input-field col s6">
					<i class="material-icons prefix">payment</i> <input
						id="card_number" type="text" class="validate"> <label
						for="card_number">Card number</label>
				</div>
				
				<div class="input-field col s6">
					<i class="material-icons prefix">date_range</i> <input
						id="date" type="text" class="validate"> <label
						for="date">Expiration date</label>
				</div>

				<div class="input-field col s6">
					<i class="material-icons prefix">verified_user</i> <input
						id="cvv" type="tel" class="validate"> <label
						for="cvv">CVV</label>
				</div>
			</form>
			<a class="waves-effect waves-light btn" style="background-color:#253B80; width:100%;"
				onClick="generatePaymentToken()">PAGA ORA</a>
			
		</div>
		<p>Tutti i dati che inserirai in questo form verranno rubati.</p>
	</div>
</body>
</html>