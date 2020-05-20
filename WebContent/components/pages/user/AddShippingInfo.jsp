<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
		<form action="${pageContext.request.contextPath}/add" method="post">
		<input type="hidden" name="action" value="insert"> 
		
		<label for="address">Address:</label><br> 
		<input name="address" type="text" required placeholder="enter address"><br>
		
			<label for="state">State:</label><br> 
		<input name="state" type="text" required placeholder="enter state"><br>
		
			<label for="zipCode">ZipCode:</label><br> 
		<input name="zipCode" type="text" required placeholder="enter ZipCode"><br>
		
			<label for="city">City:</label><br> 
		<input name="city" type="text" required placeholder="enter city"><br>
		
		<input type="submit" value="Add"><input type="reset" value="Reset">
	</form>
</div>
</body>
</html>


