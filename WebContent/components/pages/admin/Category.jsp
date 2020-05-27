<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.Category"%>
	<%
		ArrayList<Category> products = (ArrayList<Category>) request.getAttribute("categories");
	%>


	<div
		style="width: 100%; display: flex; flex-direction: column; justify-content: center; align-items: center;">
		<div style="width: 90%; max-width: 600px;">
			<h1>Categorie</h1>
			<table>
				<thead>
					<tr>
						<th>Slug</th>
						<th>Name</th>
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
						<td>
							<div style="display: inline-block;">

								<form method="post"
									action="${pageContext.request.contextPath}/category/delete">
									<input type="hidden" name="id"
										value="<%=products.get(i).getId()%>">
									<button type='submit'>
										<i class="material-icons tiny" style="color: #455a64;">delete</i>
									</button>

								</form>


							</div>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>

			<a style="margin-top: 30px;"
				href="${pageContext.request.contextPath}/category/add"
				class="waves-effect waves-light btn"><i
				class="material-icons right">add</i>Aggiungi categoria</a> <a
				style="margin-top: 30px;"
				href="${pageContext.request.contextPath}/category/update"
				class="waves-effect waves-light btn"><i
				class="material-icons right">edit</i>Modifica categoria</a>

		</div>
	</div>
