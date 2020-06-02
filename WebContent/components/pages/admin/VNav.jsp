<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<style>
.admin-menu-item {
	display:flex;
	color:white;
	align-items:center;	
}
.admin-menu-item:hover {
	color:gray;
}
</style>
<div class=" blue-grey darken-4" style=" padding:10px; height:100%;">
	<%String c = request.getContextPath(); %>
	<ul style="margin-right:10px;">
		<li><a href="<%=c%>/home" class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">home</i>Home</a></li>
		<li><a href="<%=c%>/admin/dashboard"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">dashboard</i>Dashboard</a></li>
		<li><a href="<%=c%>/admin/dashboard/orders"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">archive</i>Ordini</a></li>
		<li><a href="<%=c%>/admin/dashboard/products"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">shopping_cart</i>Prodotti</a></li>
		<li><a href="<%=c%>/admin/dashboard/categories"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">attach_file</i>Categorie</a></li>
		<li><a href="<%=c%>/admin/dashboard/shipping_type"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">local_shipping</i>Spedizioni</a></li>

	</ul>
</div>