<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>

<title>Admin BetterHome</title>
</head>
<body>

	<style>
html, body {
	height: 100%;
}

.admin-container {
	height: 100%;
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
}

.main {
	width: 100%;
	overflow-y: scroll;
	padding-bottom: 100px;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.05);
}
</style>

	<div class="admin-container">

		<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin == null) || (admin == false)) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
			String pageName = (String) request.getAttribute("pageName");
			if (pageName == null || pageName.isEmpty()) {
				pageName = "";
			}
		%>
		<jsp:include page="VNav.jsp" />

		<div class="main">
			<jsp:include page="<%=pageName%>" />

		</div>

	</div>

	<p style="position:fixed; bottom:20px; right:40px; color:gray;">Copyright - BetterHome 2020</p>

</body>
</html>