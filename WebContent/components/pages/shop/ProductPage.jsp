<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>BetterHome</title>
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Category"%>
	<%@page import="model.bean.Product"%>
	<%@page import="java.text.DecimalFormat"%>
	<%@page import="java.math.RoundingMode"%>
	<%
		Product product = (Product) request.getAttribute("product");
		ArrayList<Product> related = (ArrayList<Product>) request.getAttribute("related_products");

		ArrayList<Category> productCategories = product.getCategories();
		Double price = product.getPrice() + ((product.getPrice() * product.getIva()) / 100);
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
	%>

	<script type="text/javascript">
		function setMainImage(id){
			 $("#main-product-image").attr("src", "${pageContext.request.contextPath}/getPicture?id="+id);
		}
	</script>


	<jsp:include page="Header.jsp" />
	<div class="container">
		<div class="row header-section">
			<div class="col s12 l5">
				<div class="row">
					<div style="width: 100%; height: 300px;" class="center"
						id="main-product-image-box">
						<%
							if (product.getImages().size() > 0) {
						%>
						<img
							src="${pageContext.request.contextPath}/getPicture?id=<%=product.getImages().get(0).getId()%>"
							id="main-product-image" class="main-product-image" />
						<%
							} else {
						%>
						<img
							src="${pageContext.request.contextPath}/assets/img/image-not-found.jpg"
							id="main-product-image" class="main-product-image" />
						<%
							}
						%>

					</div>

				</div>
				<div class="row">
					<div style="display: flex; flex-wrap: wrap;">
						<%
							if (product.getImages().size() > 0) {
								for (int i = 0; i < product.getImages().size(); i++) {
						%>
						<img
							onClick="setMainImage(<%=product.getImages().get(i).getId()%>)"
							src="${pageContext.request.contextPath}/getPicture?id=<%=product.getImages().get(i).getId()%>"
							class="product-image-thumbnail" />
						<%
							}
							}
						%>

					</div>

				</div>

			</div>

			<div class="col s12 l7">
				<h1 style="margin-top: 0px;"><%=product.getName()%></h1>
				<div class="wrap-row">
					<%
						for (int i = 0; i < productCategories.size(); i++) {
					%>
					<a class="category-item-product-page"
						href="${pageContext.request.contextPath}/shop/category?id=<%=productCategories.get(i).getId()%>"><%=productCategories.get(i).getName()%></a>
					<%
						}
					%>


				</div>
				<p><%=product.getDescription()%></p>
				<div class="wrap-row" style="align-items: flex-end;">
					<h4><%=df.format(price)%>&#8364;
					</h4>
					<p style="margin-left: 10px;">/iva inclusa</p>
				</div>
				<form id="form"
					action="${pageContext.request.contextPath}/cart/add-to-cart"
					method="get">
					<div class="wrap-row center">
						<div class="input-field">
							<input value="1" id="quantity" name="quantity" type="number"
								min="1" class="validate" style="max-width: 60px; margin-bottom:0px;" > <label
								for="quantity">Quantity</label>
						</div>
						<div class="input-field">
							<input value="<%=product.getId()%>" id="product" name="product"
								type="hidden" style="max-width: 60px;">
						</div>
						<a href="#" class="waves-effect btn orange darken-4 buy-button "
							onclick="document.getElementById('form').submit();">Acquista
							ora</a>

					</div>
				</form>
				<div style="display: flex; align-items: center;">
					<i class=" small material-icons">remove_red_eye</i><span style="margin-left:10px;" id="visitors"></span>
				</div>
			</div>
		</div>
		<h3>Prodotti collegati</h3>
		<div style="justify-content: space-around;" class="section wrap-row">
			<%
				int size = related.size() > 5 ? 5 : related.size();
				for (int i = 0; i < size; i++) {

					String image = request.getContextPath() + "/assets/img/image-not-found.jpg";
					if (related.get(i).getImages().size() > 0) {
						image = request.getContextPath() + "/getPicture?id=" + related.get(i).getImages().get(0).getId();
					}
			%>

			<jsp:include page="../../shared/ProductCard.jsp">
				<jsp:param name="id" value="<%=related.get(i).getId()%>" />
				<jsp:param name="title" value="<%=related.get(i).getName()%>" />
				<jsp:param name="price" value="<%=related.get(i).getPrice()%>" />
				<jsp:param name="image" value='<%=image%>' />
			</jsp:include>
			<%
				}
			%>
		</div>
	</div>

	<div class="section" style="margin-bottom: 20px;"></div>


	<jsp:include page="Footer.jsp" />

	<script>
	
	$( document ).ready(function() {
		$.get( "/BetterHome/visitors", function( data ) {
			  $( "#visitors" ).html( data.visitors + " utenti stanno visualizzando ora questo prodotto" );
			  console.log(data)
			}); 
	});
	
	$("#main-product-image").hover(function() {
		console.log("Eccomi")
	    $(this).css({"transform":"scale(1.2)", "transition":"transform .5s"});

	}, function() {
	    $(this).css({"transform":"scale(1)", "transition":"transform .5s"});

	})
	</script>

</body>
</html>