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
	<%@page import="model.bean.Category"%>
	<%@page import="model.bean.Product"%>
	<%
		Product product = (Product) request.getAttribute("product");
		ArrayList<Category> productCategories = product.getCategories();
	%>

	<jsp:include page="Header.jsp" />
	<div class="container">
		<div class="row header-section">
			<div class="col s12 l5">
				<div class="row">
					<%if(product.getImages().size() >0){ %>
					<img
						src="${pageContext.request.contextPath}/getPicture?id=<%=product.getImages().get(0).getId()%>"
						class="main-product-image" />
					<%}else{ %>
					<img
						src="${pageContext.request.contextPath}/assets/img/image-not-found.jpg"
						class="main-product-image" />
					<%} %>
					
				</div>
				<div class="row">
					<div style="display: flex; flex-wrap: wrap;">
						<img
							src="${pageContext.request.contextPath}/assets/img/products/mouse.jpg"
							class="product-image-thumbnail" /> <img
							src="${pageContext.request.contextPath}/assets/img/products/mouse.jpg"
							class="product-image-thumbnail" /> <img
							src="${pageContext.request.contextPath}/assets/img/products/mouse.jpg"
							class="product-image-thumbnail" />
					</div>

				</div>

			</div>

			<div class="col s12 l7">
				<h1 style="margin-top: 0px;"><%=product.getName() %></h1>
				<div class="wrap-row">
					<%for(int i = 0; i < productCategories.size(); i++){ %>
						<a class="category-item-product-page" 
						href="${pageContext.request.contextPath}/shop/category?id=<%=productCategories.get(i).getId()%>"><%=productCategories.get(i).getName() %></a>
					<%} %>
					

				</div>
				<p><%=product.getDescription() %></p>
				<h4><%=product.getPrice() %>&#8364;</h4>
				<form>
					<div class="wrap-row center">
						<div class="input-field">
							<input value="1" id="quantity" type="number" class="validate"
								style="max-width: 60px;"> <label for="quantity">Quantity</label>
						</div>
						<div class="input-field">
							<input value="1" id="product" type="hidden" 
								style="max-width: 60px;">
						</div>
						<a href="${pageContext.request.contextPath}/cart/add-to-cart" class="waves-effect btn orange darken-4 buy-button">Acquista
							ora</a>

					</div>
				</form>

			</div>
		</div>
		<h3>Prodotti collegati</h3>
		<div style="justify-content: space-around;" class="section wrap-row">
			<%
				for (int i = 0; i < 5; i++) {
			%>

			<jsp:include page="../../shared/ProductCard.jsp">
				<jsp:param name="image"
					value="${pageContext.request.contextPath}/assets/img/products/mouse.jpg" />

				<jsp:param name="title" value="Solito mouse" />
				<jsp:param name="price" value="15,40" />
			</jsp:include>
			<%
				}
			%>
		</div>
	</div>

	<div class="section" style="margin-bottom: 20px;"></div>


	<jsp:include page="Footer.jsp" />

</body>
</html>