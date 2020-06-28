function valida() {
	// Variabili associate ai campi del modulo
	var id = document.invio.id.value;
	var name = document.invio.name.value;
	var days = document.invio.days.value;
	var price = document.invio.price.value;
	var val = document.getElementById("val");
	var letters = /^[A-Za-z]+$/;
	var controlPrice = /(\d+\.\d{1,2})/g;
	var numbers = /^[0-9]+$/;
	if (!id.match(numbers) || (isNaN(id)) || (id == "") || (id == "undefined")) {
		val.innerHTML = "Inserisci un id valido!";
		document.invio.id.value = "";
		document.invio.id.focus();
		return false;
	}
	if (!name.match(letters) || name == "") {
		val.innerHTML = "Inserisci un nome valido!";
		document.invio.nome.focus();
		return false;
	}
	if (!days.match(numbers) || (isNaN(days)) || (days == "") || (days == "undefined")) {
		val.innerHTML = "Inserisci un numero di giorni valido!";
		document.invio.days.value = "";
		document.invio.days.focus();
		return false;
	}
	if (!price.match(controlPrice) || (isNaN(price)) || (price == "") || (price == "undefined")) {
		val.innerHTML = "Inserisci un prezzo valido!";
		document.invio.price.value = "";
		document.invio.price.focus();
		return false;
	} else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/shipping/update";
		document.invio.submit();
	}
}