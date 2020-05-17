<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Uploading using Java</title>
</head>
<body>
<form method="post" action="${ pageContext.request.contextPath}/Uploader" enctype='multipart/form-data'>
<input class="file" type="file" name="file" value="select images..."/>
prodotto id: <input type = "text" name = "product_id">
         <br />
<input type="submit" value="start upload"/>
</form>
</body>
</html>