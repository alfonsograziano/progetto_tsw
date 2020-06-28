function valida() {
	// Variabili associate ai campi del modulo
	var name = document.invio.name.value;
	var id = document.invio.id.value;
	var newId = document.invio.newId.value;
	var val = document.getElementById("val");
	var letters = /^[A-Za-z]+$/;
	if (!name.match(letters) || (name == "") || (name == "undefined")) {
		val.innerHTML = "Inserisci un nome valido!";
		document.invio.name.focus();
		return false;
	}
	if (!id.match(letters) || (id == "") || (id == "undefined")) {
		val.innerHTML = "Inserisci un id valido!";
		document.invio.id.focus();
		return false;
	} else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/category/update";
		document.invio.submit();
	}
}