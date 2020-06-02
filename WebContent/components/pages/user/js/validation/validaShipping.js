function valida() {
	// Variabili associate ai campi del modulo
	var state = document.invio.state.value;
	var address = document.invio.address.value;
	var zipCode = document.invio.zipCode.value;
	var city = document.invio.city.value;
	if (state=="") {
		alert("Devi inserire uno stato");
		document.invio.state.focus();
		return false;
	}
	else if (address=="") {
		alert("Devi inserire un indirizzo");
		document.invio.address.value = "";
		document.invio.address.focus();
		return false;
	} else if (zipCode=="") {
		alert("Devi inserire uno zip code");
		document.invio.zipCode.value = "";
		document.invio.zipCode.focus();
		return false;
	} else if (city=="") {
		alert("Devi inserire una città");
		document.invio.city.value = "";
		document.invio.city.focus();
		return false;
	} else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/add";
		document.invio.submit();
	}
}