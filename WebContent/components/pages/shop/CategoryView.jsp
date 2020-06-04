<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>Categorie</title>
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Product"%>
	<%@page import="model.bean.Category"%>

	<jsp:include page="Header.jsp" />
	<%
		ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
		ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
	%>

	<div class="container header-section" >
		<div class="row">
			<div class="col 4 grey lighten-5">
				<h4>Categorie</h4>
				<div style="display: flex; flex-direction: column;">
					<%
						for (int i = 0; i < categories.size(); i++) {
					%>
					<a
						href="${pageContext.request.contextPath}/shop/category?id=<%=categories.get(i).getId()%>"
						style="margin: 5px;"><%=categories.get(i).getName()%></a>
					<%
						}
					%>
				</div>

			</div>
			<div class="col 7">
				<h3>
					<%
						for (int i = 0; i < categories.size(); i++) {
							if (categories.get(i).getId().equals(request.getAttribute("id"))) {
								out.print(categories.get(i).getName());

							}
						}
					%>
				</h3>
				<div class="wrap-row">
					<%
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
					%>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="Footer.jsp" />

</body>
</html>