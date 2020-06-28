<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<script type="text/javascript" src="../components/pages/admin/js/validation/validaUpdateCategory.js"></script>





<div
	style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
	<div class="section"></div>



		<h4>Modifica una categoria...</h4>
		<form class="col s12" method="get"
			style="width: 100%; max-width: 500px;"
			 name="invio">
			<div class='input-field col s12'>
				<input class='validate' type='text' name='name' id='name' /> <label
					for='email'>Nome della categoria</label>
			</div>
		<div class="input-field col s12">
			<input class='validate' type='text' name='id' id='id' /> <label
				for='email'>Vecchio slug</label>
		</div>
		<div class="input-field col s12">
			<input class='validate' type='text' name='newId' id='newId' /> <label
				for='email'>Nuovo slug (se lo si vuole cambiare)</label>
		</div>


		
			
		</form>
		<p id="val" style="color: red"></p>
		<button type='submit' name='btn_login'
				class='col s12 btn btn-large waves-effect indigo' onclick=valida()>Modifica</button>

</div>
