<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div>
		<form action="product" method="post">
		<input type="hidden" name="action" value="insert"> 
		
		 <div class="input-field col s6">
          <input placeholder="Product name..." id="name" type="text" class="validate">
          <label for="name">Product name</label>
        </div>
		
		<label for="description">Description:</label><br>
		<textarea name="description" maxlength="100" rows="3" required placeholder="enter description"></textarea><br>
		
		<label for="price">Price:</label><br> 
		<input name="price" type="text" min="0" value="0" required><br>

		<label for="brand">Brand:</label><br> 
		<input name="brand" type="text" required placeholder="enter imgPath"><br>
		
		<label for="imgPath">imgPath:</label><br> 
		<input name="imgPath" type="text" maxlength="200" required placeholder="enter imgPath"><br> 
		
		<input type="submit" value="Add"><input type="reset" value="Reset">
	</form>
</div>