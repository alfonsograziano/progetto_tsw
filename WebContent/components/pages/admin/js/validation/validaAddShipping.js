function valida() {
	// Variabili associate ai campi del modulo
	var name = document.invio.name.value;
	var days = document.invio.days.value;
	var price = document.invio.price.value;
	var letters = /^[A-Za-z]+$/;
	var controlPrice = /(\d+\.\d{1,2})/g;
	var numbers = /^[0-9]+$/;
	if (!name.match(letters) || name == "") {
		alert("Devi inserire un nome");
		document.invio.nome.focus();
		return false;
	}
	if (!days.match(numbers) || (isNaN(days)) || (days == "") || (days == "undefined")) {
		alert("Devi inserire il numero di giorni, attenzione deve essere numerico!");
		document.invio.days.value = "";
		document.invio.days.focus();
		return false;
	}
	if (!price.match(controlPrice) || (isNaN(price)) || (price == "") || (price == "undefined")) {
		alert("Devi inserire il prezzo, attenzione deve essere numerico!");
		document.invio.price.value = "";
		document.invio.price.focus();
		return false;
	} else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/shipping/add";
		document.invio.submit();
	}
}