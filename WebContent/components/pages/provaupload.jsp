<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>

<form action="${pageContext.request.contextPath}/provaup" method="post" enctype="multipart/form-data">
  Select image to upload:
  <input type="file" name="fileToUpload" id="fileToUpload">
  Product code: <input type = "text" name="fileToUpload" id="fileToUpload>
         <br />
  <input type="submit" value="Upload Image" name="submit">
</form>

</body>
</html>