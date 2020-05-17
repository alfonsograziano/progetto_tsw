<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
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
		ArrayList<Category> productCategories = (ArrayList<Category>) request.getAttribute("productCategories");
	%>
	<%
		Product product = (Product) request.getAttribute("product");
	%>

	<script>
	
	const updateProduct = () => {
		
		var array = []
		var checkboxes = document.querySelectorAll('input[type=checkbox]:checked')

		for (var i = 0; i < checkboxes.length; i++) {
		  array.push(checkboxes[i].value)
		}
		
		console.log(array)
		
		//Bisogna fare la richiesta per l'aggiornamento
		/*
		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", "${pageContext.request.contextPath}/products", true);
		xhttp.onreadystatechange = function() {
			  if (this.readyState == 4 && this.status == 200) {
			    alert("#ttappost")
			  }
		};
		*/
		
	}
	
	
	</script>
	
	<script>
	console.log('<%=productCategories.toString()%>')
	
	</script>
	
	

	<jsp:include page="VNav.jsp" />


	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div class="section"></div>

		<h4>Modifica prodotto</h4>
		<form class="col s12" style="width: 100%; max-width: 500px;" method="post"
		action="${pageContext.request.contextPath}/admin/dashboard/products/update2">
		<input id="id" name="id" type="hidden" value="${product.id}">
		
			<div class='input-field col s12'>
				<input class='validate' type='text' name='name' id='name'
					value="${product.name}" /> <label for='email'>Nome del
					prodotto</label>
			</div>

			<div class="input-field col s12">
				<textarea name='description' id="description"
					class="materialize-textarea">${product.description}</textarea>
				<label for="textarea1">Descrizione del prodotto</label>
			</div>

			<div class='input-field col s12'>
				<input type="number" step="0.01" name='price' id="'price'"
					value="${product.price}"> <label for='password'>Prezzo</label>
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
					<%
					for(int j = 0; j < productCategories.size(); j++){
						if(categories.get(i).getId().equals(productCategories.get(j).getId())){
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


</body>
</html>
