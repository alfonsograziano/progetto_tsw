<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
<<<<<<< HEAD
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<script type="text/javascript" src="../components/pages/admin/js/validation/validaUpdateCategory.js"></script>
=======
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> refs/remotes/origin/master

<div
	style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
	<div class="section"></div>

<<<<<<< HEAD
<<<<<<< HEAD
		<h4>Modifica una categoria...</h4>
		<form class="col s12" method="get"
			style="width: 100%; max-width: 500px;"
			 name="invio">
			<div class='input-field col s12'>
				<input class='validate' type='text' name='name' id='name' /> <label
					for='email'>Nome della categoria</label>
			</div>
=======
	<h4>Modifica una categoria...</h4>
	<form class="col s12" method="post"
		style="width: 100%; max-width: 500px;"
		action="${pageContext.request.contextPath}/category/update">
		<div class='input-field col s12'>
			<input class='validate' type='text' name='name' id='name' /> <label
				for='email'>Nome della categoria</label>
		</div>
>>>>>>> refs/remotes/origin/master
=======
	<h4>Modifica una categoria...</h4>
	<form class="col s12" method="post"
		style="width: 100%; max-width: 500px;"
		action="${pageContext.request.contextPath}/category/update">
		<div class='input-field col s12'>
			<input class='validate' type='text' name='name' id='name' /> <label
				for='email'>Nome della categoria</label>
		</div>
>>>>>>> refs/remotes/origin/master

		<div class="input-field col s12">
			<input class='validate' type='text' name='id' id='id' /> <label
				for='email'>Vecchio slug</label>
		</div>

<<<<<<< HEAD
<<<<<<< HEAD
			<button type='submit' name='btn_login'
				class='col s12 btn btn-large waves-effect indigo' onclick=valida()>Modifica</button>
		</form>
	</div>
=======
		<div class="input-field col s12">
			<input class='validate' type='text' name='newId' id='newId' /> <label
				for='email'>Nuovo slug (se lo si vuole cambiare)</label>
		</div>
>>>>>>> refs/remotes/origin/master
=======
		<div class="input-field col s12">
			<input class='validate' type='text' name='newId' id='newId' /> <label
				for='email'>Nuovo slug (se lo si vuole cambiare)</label>
		</div>
>>>>>>> refs/remotes/origin/master

		<button type='submit' name='btn_login'
			class='col s12 btn btn-large waves-effect indigo'>Modifica</button>
	</form>
</div>
