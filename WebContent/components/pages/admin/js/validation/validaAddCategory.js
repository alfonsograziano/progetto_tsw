function valida() {
	// Variabili associate ai campi del modulo
	var name = document.invio.name.value;
	var id = document.invio.id.value;
	var letters = /^[A-Za-z]+$/;
	if (!name.match(letters)|| name=="") {
		alert("Devi inserire un nome");
		document.invio.name.focus();
		return false;
	}
	else if (!id.match(letters)|| id=="") {
		alert("Devi inserire uno slug");
		document.invio.id.focus();
		return false;
	} else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/category/add";
		document.invio.submit();
	}
}