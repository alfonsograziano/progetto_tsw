<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../HeaderData.jsp"></jsp:include>
<title></title>
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Product"%>

	<jsp:include page="../Header.jsp" />
	<%
		
	%>

	<div class="container center">
		<div style="margin-top:100px;"></div>
	
		<h3>Checkout non ammesso</h3>
		<p>Per poter effettuare il checkout devi prima registra un account</p>
		
		<a class="waves-effect waves-light btn-large indigo" href="${pageContext.request.contextPath}/signup">Registrati ora</a>
		<p>oppure</p>
		<a class="waves-effect waves-light btn indigo" href="${pageContext.request.contextPath}/login">Accedi</a>
		
	</div>
	
	<div style="margin-top:100px;"></div>

	<jsp:include page="../Footer.jsp" />



</body>
</html>