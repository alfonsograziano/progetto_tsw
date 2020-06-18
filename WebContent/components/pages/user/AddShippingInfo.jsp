<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<script type="text/javascript"src="components/pages/user/js/validation/validaShipping.js"></script>
<jsp:include page="../shop/Header.jsp" />


<title>Insert title here</title>
</head>
<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>
		
				<h4>Aggiungi un nuovo indirizzo spedizione...</h4>
		
		<form method="get" name="invio">
		<input type="hidden" name="action" value="insert"> 
		
		<label for="address">Address:</label><br> 
		<input name="address" type="text" required placeholder="enter address"><br>
		
			<label for="state">State:</label><br> 
		<input name="state" type="text" required placeholder="enter state"><br>
		
			<label for="zipCode">ZipCode:</label><br> 
		<input name="zipCode" type="text" required placeholder="enter ZipCode"><br>
		
			<label for="city">City:</label><br> 
		<input name="city" type="text" required placeholder="enter city"><br>
		
		<input type="submit" class='col s12 btn btn-large waves-effect indigo' value="Add" onclick="valida()">
		<input type="reset" class='col s12 btn btn-large waves-effect indigo' value="Reset">
	</form>
</div>
	<jsp:include page="../shop/Footer.jsp" />

</html>


