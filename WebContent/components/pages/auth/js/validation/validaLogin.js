function valida() {
	// Variabili associate ai campi del modulo
	var email = document.invio.email.value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (!email.match(mailformat)|| email=="") {
		alert("Devi inserire una mail valida.");
		document.invio.email.focus();
		return false;
	} else {
		document.invio.method = "post";
		document.invio.action = "/BetterHome/login";
		document.invio.submit();
	}
}