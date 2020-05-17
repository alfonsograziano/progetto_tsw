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
	<div class="container">
		<div class="row header-section">
			<div class="col s12 l5">
				<div class="row">
					<img
						src="${pageContext.request.contextPath}/assets/img/products/mouse.jpg"
						class="main-product-image" />
				</div>
				<div class="row">
					<div style="display: flex; flex-wrap: wrap;">
						<img
							src="${pageContext.request.contextPath}/assets/img/products/mouse.jpg"
							class="product-image-thumbnail" />
						<img
							src="${pageContext.request.contextPath}/assets/img/products/mouse.jpg"
							class="product-image-thumbnail" />
						<img
							src="${pageContext.request.contextPath}/assets/img/products/mouse.jpg"
							class="product-image-thumbnail" />
					</div>

				</div>

			</div>

			<div class="col s12 l7">
				<h1 style="margin-top: 0px;">Product page</h1>
				<div class="wrap-row">
					<a class="category-item-product-page">Categoria1</a> <a
						class="category-item-product-page">Categoria2</a> <a
						class="category-item-product-page">Categoria3</a>

				</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
					non molestie turpis. Vestibulum ut turpis felis. Donec accumsan
					iaculis hendrerit. Quisque ut nisi nec justo fringilla cursus eget
					non metus. Donec vitae nunc feugiat, imperdiet augue in, laoreet
					dui. Aliquam ornare eget lectus vitae lacinia. 
				</p>
				<h4>
					15.99
				</h4>
				<form>
					<div
						class="wrap-row center" >
						<div class="input-field">
							<input value="1" id="quantity" type="number" class="validate"
								style="max-width: 60px;"> <label for="quantity">Quantity</label>
						</div>
						<a class="waves-effect btn orange darken-4 buy-button">Acquista
							ora</a>

					</div>
				</form>

			</div>
		</div>
			<h3>Prodotti collegati</h3>
			<div style="justify-content:space-around;" class="section wrap-row">
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

	<div class="section" style="margin-bottom:20px;"></div>


	<jsp:include page="Footer.jsp" />

</body>
</html>