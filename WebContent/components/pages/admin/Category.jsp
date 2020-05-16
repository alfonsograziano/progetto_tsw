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

	<%
		Boolean admin = (Boolean) session.getAttribute("isAdmin");
		if ((admin == null) || (admin == false)) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	%>
	<%ArrayList<Category> products = (ArrayList<Category>) request.getAttribute("categories"); %>
	
	<jsp:include page="VNav.jsp" />


	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div style="width:90%; max-width:600px;">
		<h1>Categorie</h1>
		<table>
			<thead>
				<tr>
					<th>Slug</th>
					<th>Name</th>
				<tr>
			</thead>
			<tbody>
				<%
					for (int i = 0; i < products.size(); i++) {
				%>
					<tr>
						<td><%=products.get(i).getId()%></td>
						<td><%=products.get(i).getName()%></td>

					</tr>
				<%
					}
				%>
			</tbody>
		</table>
		
		<a style="margin-top:30px;"
			href="${pageContext.request.contextPath}/components/pages/admin/AddCategory.jsp" 
			class="waves-effect waves-light btn"><i class="material-icons right">add</i>Aggiungi categoria</a>
			<a style="margin-top:30px;"
			href="${pageContext.request.contextPath}/components/pages/admin/UpdateCategory.jsp" 
			class="waves-effect waves-light btn"><i class="material-icons right">mode_edit</i>Modifica categoria</a>
			<a style="margin-top:30px;"
			href="${pageContext.request.contextPath}/components/pages/admin/DeleteCategory.jsp" 
			class="waves-effect waves-light btn"><i class="material-icons right">delete</i>Elimina categoria</a>

		
		</div>
	</div>


</body>
</html>