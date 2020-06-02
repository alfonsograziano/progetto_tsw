function valida() {
	// Variabili associate ai campi del modulo
	var email = document.invio.email.value;
	var name = document.invio.name.value;
	var surname = document.invio.surname.value;
	var password = document.invio.password.value;
	var letters = /^[A-Za-z]+$/;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var passformat = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	if (!password.match(passformat)|| password=="") {
		alert("Devi inserire una password che contenga dai 7 ai 15 caratteri, contenga almeno un numero e un carattere speciale");
		document.invio.password.focus();
		return false;
	}
	if (!surname.match(letters)|| surname=="") {
		alert("Devi inserire un cognome");
		document.invio.surname.focus();
		return false;
	}
	if (!name.match(letters)|| name=="") {
		alert("Devi inserire un nome");
		document.invio.name.focus();
		return false;
	}
	if (!email.match(mailformat)|| email=="") {
		alert("Devi inserire una mail valida");
		document.invio.email.focus();
		return false;
	} else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/signup";
		document.invio.submit();
	}
}