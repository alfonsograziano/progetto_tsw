<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title></title>
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Product"%>

	<jsp:include page="Header.jsp" />
	<%
		ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
	%>

	<div class="container">
	<h3>Prodotti in evidenza</h3>
		<div class="wrap-row">
			<%
				for (int i = 0; i < products.size(); i++) {
			%>
			<jsp:include page="../../shared/ProductCard.jsp">
				<jsp:param name="title" value="<%=products.get(i).getName()%>" />
				<jsp:param name="price" value="<%=products.get(i).getPrice()%>" />
			</jsp:include>
			<%
				}
			%>
		</div>

	</div>

	<jsp:include page="Footer.jsp" />

</body>
</html>