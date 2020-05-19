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
	<%@page import="model.bean.Category"%>

	<jsp:include page="Header.jsp" />
	<%
		ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
		ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
	%>

	<div>

		<div class="parallax-container">
			<div class="parallax">
				<img src="${pageContext.request.contextPath}/assets/img/planet.jpg" />
			</div>
		</div>


		<div class="section white">
			<div class="row container center">
				<h2 class="header">Explore a new world.</h2>
				<p class="grey-text text-darken-3 lighten-3">Entra nel mondo
					dell'IoT con BetterHome.</p>
			</div>
		</div>

		<div class="parallax-container" style="height: 150px;">
			<div class="parallax">
				<img src="${pageContext.request.contextPath}/assets/img/network.jpg" />
			</div>
		</div>



		<div class="container center section white">
			<h3>Prodotti in evidenza</h3>
			<div class="wrap-row" style="justify-content: center;">
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


		<div class="row">
			<div class="container center"
				style="padding-top: 10px; padding-bottom: 20px;">

				<h4>Categorie</h4>
				<div class="wrap-row" style="justify-content: space-around;">
					<%
						for (int i = 0; i < categories.size(); i++) {
					%>
					<a
						href="${pageContext.request.contextPath}/shop/category?id=<%=categories.get(i).getId()%>"
						style="margin: 5px;"><h5><%=categories.get(i).getName()%></h5></a>
					<%
						}
					%>
				</div>
			</div>
		</div>


		<div class="parallax-container" style="height: 150px;">
			<div class="parallax">
				<img src="${pageContext.request.contextPath}/assets/img/network.jpg" />
			</div>
		</div>


	</div>
	
	<a href="https://api.whatsapp.com/send?phone=3899098485 class="float" target="_blank">
		<i class="fa fa-whatsapp my-float"></i>
	</a>
	

	<jsp:include page="Footer.jsp" />
	<script>
		document.addEventListener('DOMContentLoaded', function() {
			console.log("Contenuto letto")
			var elems = document.querySelectorAll('.parallax');
			var instances = M.Parallax.init(elems, {
				responsiveThreshold : 0
			});
		});
	</script>
</body>
</html>