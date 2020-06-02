<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>

<jsp:include page="../HeaderData.jsp"></jsp:include>

<meta charset="utf-8">
<title>Page Not Found :(</title>
<style>
html, body {
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.03);
}

h1 {
	margin: 0 10px;
	font-size: 50px;
	text-align: center;
}

h1 span {
	color: #bbb;
}

p {
	margin: 1em 0;
}

.box {
	padding: 30px;
	background-color: white;
	max-width:400px;
	border-radius:20px;
	margin-bottom:200px;
}
</style>
</head>
<body>
	<jsp:include page="../shop/Header.jsp" />

	<div
		style="display:flex; justify-content: center; align-items: center; margin-top:100px;">
		<div class="container box">
			<h1>
				Pagina non trovata <span>:(</span>
			</h1>
			<p>Non riusciamo a trovare la pagina che stai cercando</p>
			<p>Abbiamo tante pagine nel nostro sito, dai un'occhiata!</p>

			<a href="${pageContext.request.contextPath}/home" class="btn">TORNA
				ALLA HOME</a>
		</div>

	</div>

	<jsp:include page="../shop/Footer.jsp" />
<script>
let host = "http://localhost:8080" + "${pageContext.request.contextPath}"
$( document ).ready(function() {
	console.log(window.location.href)
	if(window.location.href===host+"/"){
		window.location = 	host+"/home"
	}
});

</script>
</body>
</html>
