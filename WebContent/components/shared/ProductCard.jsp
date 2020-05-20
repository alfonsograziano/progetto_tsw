<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<a class="card" href="${pageContext.request.contextPath}/shop/product?id=${param.id}">
	<div style="height:100px; width:100px; display:block; margin-left:auto; margin-right:auto;">
		<img src=${param.image} style="max-width:100%; max-height:100%;"/>
	</div>
	<h6>${param.title}</h6>
	<h5>${param.price}&#8364;</h5>
	
</a>