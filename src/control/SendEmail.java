package control;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

	private String host;
	private String port;
	private String email;
	private String password;

	public SendEmail(String host, String port, String email, String password) {
		this.host = host;
		this.port = port;
		this.email = email;
		this.password = password;
	}

	public void send(String to, String subject, String text) throws MessagingException {
		// Set up the SMTP server.
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(text);

		Transport.send(message);

		System.out.println("Done");
	}

}