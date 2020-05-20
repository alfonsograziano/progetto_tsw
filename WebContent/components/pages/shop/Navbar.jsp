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

		<ul id="nav-mobile" class="right hide-on-med-and-down ">
			<li>
				<div class="center row">
					<div class="col s12 ">
						<div class="row" id="topbarsearch" style="margin-right: 20px;">
							<div class="input-field col s6 s12">
								<i class="material-icons prefix">search</i> <input type="text"
									placeholder="search" id="autocomplete-input"
									class="autocomplete" style="color:white;" />
							</div>
						</div>
					</div>
				</div>
			</li>
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
			<li><a href="#"><i class="material-icons">person</i></a></li>
		</ul>
	</div>
</nav>


<div id="nav-margin"></div>


<script>
	$(document).ready(function() {
		$("#nav-margin").height($("#nav-main").height())
	});
</script>