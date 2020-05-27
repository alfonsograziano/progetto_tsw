<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>

		<h4>Modifica una spedizione...</h4>
		<form class="col s12" method="post"
			style="width: 100%; max-width: 500px;"
			action="${pageContext.request.contextPath}/shipping/update">
			<div class='input-field col s12'>
				<input class='validate' type='text' name='id' id='id' /> <label
					for='email'>ID della spedizione</label>
			</div>
			<div class='input-field col s12'>
				<input class='validate' type='text' name='name' id='name' /> <label
					for='email'>Nome della spedizione</label>
			</div>

			<div class="input-field col s12">
				<input class='validate' type='number' name='days' id='days' /> <label
					for='email'>Giorni della spedizione</label>
			</div>
			
			<div class="input-field col s12">
				<input class='validate' type='text' name='price' id='price' /> <label
					for='email'>Prezzo</label>
			</div>

			<button type='submit' name='btn_login'
				class='col s12 btn btn-large waves-effect indigo'>Modifica</button>
		</form>
	</div>
