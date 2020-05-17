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
	<%@page import="model.bean.Product"%>

	<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin == null) || (admin == false)) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	%>
	<%ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products"); %>
	
	<jsp:include page="VNav.jsp" />


	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div style="width:90%; max-width:600px;">
		<h1>Prodotti</h1>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Visiblity</th>
					<th>Actions</th>
				<tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < products.size(); i++) {
				%>
					<tr>
						<td><%=products.get(i).getId()%></td>
						<td><%=products.get(i).getName()%></td>
						<td><%=products.get(i).getPrice()%></td>
						<td><%=products.get(i).getVisible()%></td>
						<td>
							<div style="display:inline-block;">
								
									  <a href="${pageContext.request.contextPath}/admin/dashboard/products/update?id=<%=products.get(i).getId()%>">
									  	<i class="material-icons tiny" style="color:#455a64; margin-right:20px;">edit</i>
									  </a>
									  
							</div>
						</td>

					</tr>
				<%
					}
				%>
			</tbody>
		</table>
		
		<a style="margin-top:30px;"
			href="${pageContext.request.contextPath}/product/add" 
			class="waves-effect waves-light btn"><i class="material-icons right">add</i>Aggiungi prodotto</a>

		
		</div>
	</div>


</body>
</html>