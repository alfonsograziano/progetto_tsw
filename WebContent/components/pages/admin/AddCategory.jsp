<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<script type="text/javascript" src="../components/pages/admin/js/validation/validaAddCategory.js"></script>





	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>

		<h4>Aggiungi una nuova categoria...</h4>
		<form class="col s12" 
			style="width: 100%; max-width: 500px;"
			 name="invio">
			<div class='input-field col s12'>
				<input class='validate' type='text' name='name' id='name' /> <label
					for='email'>Nome della categoria</label>
			</div>

			<div class="input-field col s12">
				<input class='validate' type='text' name='id' id='id' /> <label
					for='email'>Slug della categoria</label>
			</div>

		</form>
		<p id="val" style="color: red"></p>
		<button name='btn_login'
				class='col s12 btn btn-large waves-effect indigo' onclick="valida()">Aggiungi</button>
	</div>


</body>
</html>




