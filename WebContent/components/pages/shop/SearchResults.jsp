<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>BetterHome</title>
<jsp:include page="../HeaderData.jsp"></jsp:include>
</head>
<body>


	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Product"%>
	<%@page import="model.bean.Category"%>
	<%
		ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("search");
	%>
	<jsp:include page="Header.jsp" />


	<div class="container">
		<h1>Risultati della ricerca</h1>
		
		<div class="wrap-row">
		<% if(products.size() >0){
			for (int i = 0; i < products.size(); i++) {

				String image = request.getContextPath() + "/assets/img/image-not-found.jpg";
				if (products.get(i).getImages().size() > 0) {
					image = request.getContextPath() + "/getPicture?id=" + products.get(i).getImages().get(0).getId();
				}
		%>

		<jsp:include page="../../shared/ProductCard.jsp">
			<jsp:param name="id" value="<%=products.get(i).getId()%>" />
			<jsp:param name="title" value="<%=products.get(i).getName()%>" />
			<jsp:param name="price" value="<%=products.get(i).getPrice()%>" />
			<jsp:param name="image" value='<%=image%>' />

		</jsp:include>
		<%
			}
		}else{
		%>
					<h3>Spiacente, la tua ricerca non ha prodotto risultati.</h3>
		<%} %>
		</div>
		<div style="height:150px;"></div>
		


	</div>




	<jsp:include page="Footer.jsp" />
	
</body>
</html>