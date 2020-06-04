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
		<li><a href="<%=c%>/home" class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">home</i><p>Home</p></a></li>
		<li><a href="<%=c%>/admin/dashboard"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">dashboard</i><p>Dashboard</p></a></li>
		<li><a href="<%=c%>/admin/dashboard/orders"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">archive</i><p>Ordini</p></a></li>
		<li><a href="<%=c%>/admin/dashboard/products"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">shopping_cart</i><p>Prodotti</p></a></li>
		<li><a href="<%=c%>/admin/dashboard/categories"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">attach_file</i><p>Categorie</p></a></li>
		<li><a href="<%=c%>/admin/dashboard/shipping_type"  class="admin-menu-item"><i class="material-icons" style="color:white; padding:10px;">local_shipping</i><p>Spedizioni</p></a></li>

	</ul>
</div>


<script>
$( document ).ready(function() {
    let width = $(window).width()
    if(width < 480)
    	$("p").remove();
    
});

</script>