<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
			<div class="section"></div>
		
		<h4>Aggiungi un nuovo prodotto...</h4>
		<form class="col s12" method="post" style="width:100%; max-width:500px;"
			action="${pageContext.request.contextPath}/product/add">
			<div class='input-field col s12'>
				<input class='validate' type='text' name='name' id='name' /> <label
					for='email'>Nome del prodotto</label>
			</div>

			<div class="input-field col s12">
				<textarea name='description' id="description"
					class="materialize-textarea"></textarea>
				<label for="textarea1">Descrizione del prodotto</label>
			</div>

			<div class='input-field col s12'>
				<input type="number" step="0.01" name='price' id="'price'">
				<label for='password'>Prezzo</label>
			</div>

			<button type='submit' name='btn_login'
				class='col s12 btn btn-large waves-effect indigo'>Aggiungi</button>
		</form>
	</div>

