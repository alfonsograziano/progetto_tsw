<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div
	style="width: 100%; height: 100%; display: flex; flex-direction: column; align-items: center; margin-top:30px;">
	<h1>Benvenuto admin</h1>
	

	<div class="wrap-row" >
		<div class="box">
			<jsp:include page="./Products.jsp" />
		</div>

		<div class="box">
			<jsp:include page="./OrderList.jsp" />
		</div>

		<div class="box">
			<jsp:include page="./Category.jsp" />
		</div>
	</div>
	
	
<form action="${pageContext.request.contextPath}/logout">
		<button type='submit' class='btn'>Logout</button>
	</form>
</div>

<style>
.box {
	border-radius: 20px;
	background-color: white;
	max-width: 400px;
	padding: 20px;
	margin: 20px;
	box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
}

h1 {
	margin-top: 0px;
	font-size:40px;
	margin-bottom:10px;
}
</style>