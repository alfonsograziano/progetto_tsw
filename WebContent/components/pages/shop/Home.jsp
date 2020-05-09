<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>BetterHome</title>
		
		<!-- Compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
		
		<!-- Compiled and minified JavaScript -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
		        
	</head>
	<body>
	
		<jsp:include page="Header.jsp" />	
		
		<!--<jsp:include page="ProductView.jsp" /> -->
		<div style="display:flex; flex-direction:row; flex-wrap: wrap; width:100%;">
			<% for(int i = 0; i <= 5; i++){ %>
				<jsp:include page="../../shared/ProductCard.jsp">
					<jsp:param name="title" value="Mouse pezzotto" />
					<jsp:param name="price" value="14,37$" />
				</jsp:include>
			<% } %>
		</div>
			
		<jsp:include page="Footer.jsp" />	
	
	</body>
</html>