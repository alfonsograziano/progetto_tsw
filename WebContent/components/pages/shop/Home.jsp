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

	<div
		style="display: flex; flex-direction: row; flex-wrap: wrap; width: 100%;">
		<%
			for (int i = 0; i < products.size(); i++) {
		%>
		<script>
		console.log("Index:<%=i%>")
		</script>
		<jsp:include page="../../shared/ProductCard.jsp">
			<jsp:param name="image" value="${pageContext.request.contextPath}/assets/img/products/mouse.jpg" />
		
			<jsp:param name="title" value="<%=products.get(i).getName()%>" />
			<jsp:param name="price" value="<%=products.get(i).getPrice()%>" />
		</jsp:include>
		<%
			}
		%>
	</div>

	<jsp:include page="Footer.jsp" />

</body>
</html>