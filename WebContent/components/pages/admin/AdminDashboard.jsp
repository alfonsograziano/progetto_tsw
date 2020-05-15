<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>Insert title here</title>

</head>
<body>
	<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin == null) || (admin == false)) {
			response.sendRedirect(request.getContextPath()+"/login");
		}
	%>
	<jsp:include page="VNav.jsp" />	
	
	
	<div style="width:100%; display:flex; flex-direction:column; justify-content:center; align-items:center;">
		<h1>Benvenuto admin</h1>
	<form action="${pageContext.request.contextPath}/logout">
		<button type='submit'
						class='col s12'>Logout</button>
	</form>
	
	</div>


</body>
</html>