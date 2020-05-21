<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>spedizioni utente</title>
</head>
<body>
	<%@page import="java.util.ArrayList"%>
	<%@page import="model.bean.ShippingInfo"%>
	<%
		ArrayList<ShippingInfo> ship = (ArrayList<ShippingInfo>) request.getAttribute("shipInfo");
	%>
	<div>
	<%
						for (int i = 0; i < ship.size(); i++) {
								out.print("indirizzo: "+ ship.get(i).getAddress()+" ");
								out.print("stato: "+ship.get(i).getState()+" ");
								out.print("zipCode: "+ship.get(i).getZipCode()+" ");
								out.print("città: "+ship.get(i).getCity()+" ");
								out.println();
						}
					%>
	
	</div>
</body>
</html>