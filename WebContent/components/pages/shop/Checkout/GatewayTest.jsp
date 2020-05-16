<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../HeaderData.jsp"></jsp:include>
<title>Test gateway di pagamento</title>
</head>
<body>
	<script>
	
		const openGateway = ()=>{
			const payWindow = window.open("./gateway","Ratting","width=600, height=700,left=150,top=200,toolbar=0,status=0,")
			payWindow.onbeforeunload = function(){ 
				const token = window.token
				if(typeof token !== "undefined"){
					alert("Token di avvenuto pagamento: " + window.token)
				}else{
					alert("Pagamento non riuscito...")
				}
			}
		}
	
	</script>

	<input type=button onClick="openGateway()" value="Open Window">

</body>
</html>