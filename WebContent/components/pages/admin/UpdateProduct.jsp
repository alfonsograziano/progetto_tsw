<html>
<head>
<jsp:include page="../HeaderData.jsp"></jsp:include>
<title>Insert title here</title>

</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Category"%>
	<%@page import="model.bean.Product"%>

	<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin == null) || (admin == false)) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	%>
	<%
		ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
	%>
	<%
		Product product = (Product) request.getAttribute("product");
	%>
	<%
		ArrayList<Category> productCategories = product.getCategories();
	%>


	<script>
	
	const updateProduct = () => {
		
		var array = []
		var checkboxes = document.querySelectorAll('input[type=checkbox]:checked')
		for (var i = 0; i < checkboxes.length; i++) {
		  array.push(checkboxes[i].value)
		}
		
		console.log(array)
		
	}
	
	$( document ).ready(function() {
		$('#visible-select').val("<%=product.getVisible()%>");
	    $('#visible-select').formSelect();
	});
	
	</script>


	<div style="width: 100%; margin-left: 150px;" class="container">
		<div style="display: flex; flex-direction: column;">
			<div>

				<h4>Modifica prodotto</h4>
				<form style="width: 100%; max-width: 500px;" method="post"
					action="${pageContext.request.contextPath}/admin/dashboard/products/update2">
					<input id="id" name="id" type="hidden" value="${product.id}">

					<div class='input-field '>
						<input class='validate' type='text' name='name' id='name'
							value="${product.name}" /> <label for='email'>Nome del
							prodotto</label>
					</div>

					<div class="input-field ">
						<textarea name='description' id="description"
							class="materialize-textarea">${product.description}</textarea>
						<label for="textarea1">Descrizione del prodotto</label>
					</div>

					<div class='input-field '>
						<input type="number" step="0.01" name='price' id="'price'"
							value="${product.price}"> <label for='password'>Prezzo</label>
					</div>
					
					<div class='input-field '>
						<input type="number" step="1.00" name='iva' id="iva"
							value="${product.iva}"> <label for='password'>Iva</label>
					</div>

					<div class="input-field">
						<p style="margin-bottom: 0px;">Visibile nel catalogo</p>
						<select class="browser-default" id="visible-select" name="visible">
							<option value="true">True</option>
							<option value="false">False</option>
						</select>
					</div>

					<div
						style="display: flex; flex-direction: column; margin-top: 20px; margin-bottom: 30px;">
						<h5>Categorie</h5>

						<%
							for (int i = 0; i < categories.size(); i++) {
						%>

						<label> <input type="checkbox"
							id="<%=categories.get(i).getId()%>" name="categories"
							value="<%=categories.get(i).getId()%>"
							<%for (int j = 0; j < productCategories.size(); j++) {
					if (categories.get(i).getId().equals(productCategories.get(j).getId())) {
						out.print("checked=\"checked\"");
					}
				}%> />

							<span><%=categories.get(i).getName()%></span>
						</label>

						<%
							}
						%>

					</div>

					<button onClick="updateProduct()" name='btn_login'
						class='col s12 btn btn-large waves-effect indigo'>Aggiorna</button>
				</form>
			</div>
			<div style="margin: 20px;">
				<h5>Immagini</h5>
				<div class="wrap-row">
					<%
						for (int i = 0; i < product.getImages().size(); i++) {
					%>
					<div
						style="padding: 10px; background-color: rgba(0, 0, 0, 0.1); margin: 10px; display: flex; flex-direction: column; justify-content: flex-end;">
						<img style="width: 70px; margin-bottom: 10px;"
							src="${pageContext.request.contextPath}/getPicture?id=<%=product.getImages().get(i).getId()%>" />
						<form method="post"
							action="${pageContext.request.contextPath}/DeleteImage">
							<input id="image_id" name="image_id" type="hidden"
								value="<%=product.getImages().get(i).getId()%>"> <input
								type="submit" value="Cancella" />
						</form>

					</div>

					<%
						}
					%>

				</div>


				<form method="post"
					action="${ pageContext.request.contextPath}/upload"
					enctype='multipart/form-data'>
					<input class="file" type="file" name="file"
						value="Aggiungi immagine" /> <br /> <input type="hidden"
						name="product_id" value="<%=product.getId()%>"> <input
						type="submit" value="carica" class=" btn indigo white-color" />
				</form>
			</div>
		</div>

	</div>


</body>
</html>