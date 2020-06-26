<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<script type="text/javascript" src="../components/pages/admin/js/validation/validaAddShipping.js"></script>





	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>

		<h4>Aggiungi una nuova spedizione...</h4>
		<form class="col s12" method="get"
			style="width: 100%; max-width: 500px;" name="invio">
			<div class='input-field col s12'>
				<input class='validate' type='text' name='name' id='name' /> <label
					for='email'>Nome della spedizione</label>
			</div>

			<div class="input-field col s12">
				<input class='validate' type="number" step="1.00" name='days' id='days' /> <label
					for='password'>Numero di Giorni</label>
			</div>
			<div class="input-field col s12">
				<input class='validate' type="number" step="0.01" name='price' id='price' /> <label
					for='password'>Prezzo</label>
			</div>

			<button type='submit' name='btn_login'
				class='col s12 btn btn-large waves-effect indigo' onclick=valida()>Aggiungi</button>
		</form>
	</div>