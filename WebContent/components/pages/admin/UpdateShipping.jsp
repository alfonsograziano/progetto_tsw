<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<script type="text/javascript" src="../components/pages/admin/js/validation/validaUpdateShipping.js"></script>
<%@page import="model.bean.Shipping"%>
	<%
		Shipping shipp = (Shipping) request.getAttribute("shipp");
	%>



	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>

		<h4>Modifica una spedizione...</h4>
		<form class="col s12" method="get"
			style="width: 100%; max-width: 500px;" name="invio">
			<div class='input-field col s12'>
				<input class='validate' type='text' value='<%=shipp.getId() %>' name='id' id='id' /> <label
					for='email'>ID della spedizione</label>
			</div>
			<div class='input-field col s12'>
				<input class='validate' type='text' value='<%=shipp.getName() %>' name='name' id='name' /> <label
					for='email'>Nome della spedizione</label>
			</div>

			<div class="input-field col s12">
				<input class='validate' type='number' value='<%=shipp.getDays() %>' step="1.00" name='days' id='days' /> <label
					for='email'>Giorni della spedizione</label>
			</div>
			
			<div class="input-field col s12">
				<input class='validate' type='number' value='<%=shipp.getPrice() %>' step="0.01" name='price' id='price' /> <label
					for='email'>Prezzo</label>
			</div>

			
		</form>
		<p id="val" style="color: red"></p>
		<button type='submit' name='btn_login'
				class='col s12 btn btn-large waves-effect indigo' onclick=valida()>Modifica</button>
	</div>