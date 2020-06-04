<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<footer class="page-footer blue-grey darken-3">

<!-- Cookie consent (volendolo attivare bisogna impostare il cookie così che non compaia su ogni pagine)
	<div id="cookieConsent">
		<div id="closeCookieConsent">x</div>
		Questo sito utilizza i cookie <a
			href="${ pageContext.request.contextPath}/privacy-policy"
			target="_blank">Leggi di più</a>. <a class="cookieConsentOK">Ok</a>
	</div>
	<script>
		$(document).ready(function() {
			setTimeout(function() {
				$("#cookieConsent").fadeIn(200);
			}, 1000);
			$("#closeCookieConsent, .cookieConsentOK").click(function() {
				$("#cookieConsent").fadeOut(200);
			});
		});
	</script>
	-->

<a href="https://api.whatsapp.com/send?phone=+39 3899098485" class="float" target="_blank">
		<i class="fa fa-whatsapp my-float"></i>
	</a>

	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Hai bisogno di aiuto?</h5>
				<p class="grey-text text-lighten-4">
					Se hai bisogno di aiuto puoi contattarci via email <a
						href="mailto:info@betterhome.it" style="color:gray;">info@betterhome.it</a>
					<br/>
					Puoi anche scriverci sulla nostra pagina <a style="color:gray;">Facebook</a>
				</p>
			</div>
			<div class="col l4 offset-l2 s12">
				<h5 class="white-text">Links</h5>
				<ul>
					<li><a class="grey-text text-lighten-3"
						href="${pageContext.request.contextPath}/privacy-policy">Privacy
							Policy</a></li>
					<li><a class="grey-text text-lighten-3"
						href="${pageContext.request.contextPath}/privacy-policy">Cookie
							Policy</a></li>
					<li><a class="grey-text text-lighten-3"
						href="${pageContext.request.contextPath}/login">Login</a></li>
				</ul>
				<img
					src="${pageContext.request.contextPath}/assets/img/safe-paypal.png"
					style="width: 200px;" />
			</div>
		</div>
	</div>
	<div class="footer-copyright blue-grey darken-4">
		<div class="container">
			© 2020 BetterHome <a class="grey-text text-lighten-4 right"
				href="https://github.com/lokk3d/progetto_tsw" target="_blank">Github</a>
		</div>
	</div>
</footer>
