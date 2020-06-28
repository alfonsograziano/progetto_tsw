function valida() {
	// Variabili associate ai campi del modulo
	var name = document.invio.name.value;
	var price = document.invio.price.value;
	var iva = document.invio.iva.value;
	var val = document.getElementById("val");
	var controlPrice = /(\d+\.\d{1,2})/g;
	var number = /^\d+$/;
	if (name=="") {
		val.innerHTML = "Inserisci un nome valido!";
		document.invio.name.focus();
		return false;
	}
	else if (!price.match(controlPrice) || price=="") {
		val.innerHTML = "Inserisci un prezzo valido!";
		document.invio.price.value = "";
		document.invio.price.focus();
		return false;
	}
	else if (!iva.match(number) || iva=="") {
		val.innerHTML = "Inserisci una percentuale di iva valida!";
		document.invio.price.value = "";
		document.invio.price.focus();
		return false;
	}
	else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/product/add";
		document.invio.submit();
	}
}