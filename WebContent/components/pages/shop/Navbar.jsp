<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <nav class="blue-grey darken-3">
    <div class="nav-wrapper" style="margin-left:20px; margin-right:20px;">
      <a href="${pageContext.request.contextPath}/home" class="brand-logo" style="display:flex; align-items:center; justify-content:center;">
      		<img src="${pageContext.request.contextPath}/assets/img/logo.png" style="width:50px; margin-right:10px;"/>
      		Better <b>Home</b>
      </a>
   
      <ul id="nav-mobile" class="right hide-on-med-and-down ">
        <li>    
         <div class="center row">
            <div class="col s12 " >
              <div class="row" id="topbarsearch" style="margin-right:20px;">
                <div class="input-field col s6 s12">
                  <i class="material-icons prefix">search</i>
                  <input type="text" placeholder="search" id="autocomplete-input" class="autocomplete style=""color:white;" >
                  </div>
                </div>
              </div>
            </div>          
        </li>         
        <li><a href="${pageContext.request.contextPath}/cart"><i class="material-icons">shopping_cart</i></a></li>
        <li><a href="#"><i class="material-icons">person</i></a></li>
      </ul>
    </div>
  </nav>
        