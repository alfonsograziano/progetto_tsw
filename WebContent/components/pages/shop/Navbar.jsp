<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="model.bean.ChoosenProduct"%>
<%@page import="java.util.ArrayList"%>


<%
	ArrayList<ChoosenProduct> cart = (ArrayList<ChoosenProduct>) request.getSession().getAttribute("cart");
	if (cart == null) {
		cart = new ArrayList<ChoosenProduct>();
	}

	int items = 0;
	for (int i = 0; i < cart.size(); i++) {
		items += cart.get(i).getQuantity();
	}
%>

<nav class="blue-grey darken-3"
	style="position: fixed; top: 0px; z-index: 1000;" id="nav-main">
	<div class="nav-wrapper" style="margin-left: 20px; margin-right: 20px;">
		<a href="${pageContext.request.contextPath}/home" class="brand-logo"
			style="display: flex; align-items: center; justify-content: center;">
			<img src="${pageContext.request.contextPath}/assets/img/logo.png"
			style="width: 50px; margin-right: 10px;" /> Better <b>Home</b>
		</a>
      <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>

		<ul id="nav-mobile" class="right hide-on-med-and-down ">
			<li>
				<div class="center row">
					<div class="col s12 ">
						<div class="row" id="topbarsearch" style="margin-right: 20px;">
							<div class="input-field col s6 s12">
								<i class="material-icons prefix">search</i> <input type="text"
									placeholder="search" id="search"
									class="autocomplete" style="color:white;" />
							</div>
						</div>
					</div>
				</div>
			</li>
			<%
				Boolean admin = (Boolean) session.getAttribute("isAdmin");
				if (admin != null && admin != false) {
			%>	
			<li><a href="${pageContext.request.contextPath}/admin/dashboard"><i class="material-icons">dashboard</i></a></li>
			<%}%>
			
			<li>
				<div id="ex4">
					<%if(items >0){ %>
					<span class="p1 fa-stack fa-2x has-badge" data-count="<%=items%>"> <a
						href="${pageContext.request.contextPath}/cart"><i
							class="material-icons ">shopping_cart</i> </a>
					</span>
					<%}else{ %>
					<a
						href="${pageContext.request.contextPath}/cart"><i
							class="material-icons ">shopping_cart</i> </a>
					<%} %>
					
				</div>

			</li>
			<li><a href="${pageContext.request.contextPath}/profile"><i class="material-icons">person</i></a></li>
			
			
		</ul>
	</div>
</nav>


  <ul class="sidenav" id="mobile-demo" style="z-index:10000;">
  	<li style="margin-top:20px; margin-bottom:20px;"><a href="${pageContext.request.contextPath}/home" class="brand-logo"
			style="display: flex; align-items: center; justify-content: center;">
			<img src="${pageContext.request.contextPath}/assets/img/logo.png"
			style="width: 50px; margin-right: 10px;" /> Better <b>Home</b>
		</a></li>
    <%
		if (admin != null && admin != false) {
	%>	
	<li><a href="${pageContext.request.contextPath}/admin/dashboard">Admin dashboard</a></li>
	<%}%>
    <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
	<li><a href="${pageContext.request.contextPath}/cart">Cart <%if(items >0) out.print("("+items+")");%></a></li>
  </ul>

<div id="nav-margin"></div>


<script>

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems, {});
  });



	$(document).ready(function() {
		$("#nav-margin").height($("#nav-main").height())
	});
	
	$('#search').bind("enterKey",function(e){
		console.log("Search enter key pressed-...")
		
	   window.location = "${pageContext.request.contextPath}/product/search?name="+$('#search').val()
	});
	$('#search').keyup(function(e){
	    if(e.keyCode == 13)
	    {
	        $(this).trigger("enterKey");
	    }
	});
	
</script>

