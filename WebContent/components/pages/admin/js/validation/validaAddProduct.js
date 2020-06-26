function valida() {
	// Variabili associate ai campi del modulo
	var name = document.invio.name.value;
	var price = document.invio.price.value;
	var iva = document.invio.iva.value;
	var controlPrice = /(\d+\.\d{1,2})/g;
	var number = /^\d+$/;
	if (name=="") {
		alert("Devi inserire un nome");
		document.invio.name.focus();
		return false;
	}
	else if (!price.match(controlPrice) || price=="") {
		alert("Devi inserire il prezzo, attenzione deve essere numerico!");
		document.invio.price.value = "";
		document.invio.price.focus();
		return false;
	}
	else if (!iva.match(number) || iva=="") {
		alert("Devi inserire l'iva, attenzione deve essere numerico!");
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