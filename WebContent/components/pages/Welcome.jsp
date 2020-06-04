<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Benvenuto</title>
	<jsp:include page="./HeaderData.jsp"></jsp:include>
	
</head>
<body>
	<div class="section"></div>
	<div style="display:flex; justify-content:center; align-items:center; flex-direction:column;">
		<h1>Benvenuto!</h1>
		<h5>Grazie per esserti registrato</h5>
		
		<form method="post" action="${pageContext.request.contextPath}/">
			<button type="submit" name='btn_login' style="margin-top:30px;"
							class='col s12 btn btn-large waves-effect indigo'>VAI ALLA HOME</button>
		</form>	
	</div>
	
</body>
</html>