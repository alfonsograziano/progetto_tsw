<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@page import="model.bean.ShippingInfo"%>
	
	<%
		ShippingInfo update =(ShippingInfo) request.getAttribute("update");
	%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<jsp:include page="../shop/Header.jsp" />






	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>

		<h4>Modifica un indirizzo di spedizione...</h4>
		<form action="${pageContext.request.contextPath}/shippingInfo/update" class="col s12" method="get"
			style="width: 100%; max-width: 500px;" name="invio">
			
			<div class='input-field col s12'>
				<input class='validate' type='text' name='id' id='id'value="<%=update.getId()%>" readonly /> <label
					for='email'>ID della spedizione</label>
			</div>

			<div class='input-field col s12'>
				<input class='validate' type='text' name='address' id='address'value="<%=update.getAddress()%>" /> <label
					for='email'>Indirizzo della spedizione</label>
			</div>

			<div class="input-field col s12">
				<input class='validate' type='text' name='state' id='state' value="<%=update.getState()%>" /> <label
					for='email'>Stato di spedizione</label>
			</div>
			
			<div class="input-field col s12">
				<input class='validate' type='text' name='zipCode' id='zipCode' value="<%=update.getZipCode()%>" /> <label
					for='email'>ZipCode</label>
			</div>
			
			<div class="input-field col s12">
				<input class='validate' type='text' name='city' id='city' value="<%=update.getCity()%>" /> <label
					for='email'>City</label>
			</div>

			<button type="submit" name='btn_login' class='col s12 btn btn-large waves-effect indigo'>UPDATE</button>
			
			
			
			
			
			
		</form>
	</div>
						<jsp:include page="../shop/Footer.jsp" />
	