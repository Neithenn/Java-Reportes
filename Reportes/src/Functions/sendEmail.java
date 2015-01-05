package Functions;

import javax.mail.*; 
import javax.mail.internet.*;

import DAO.dao_email;

import java.util.Properties;

public class sendEmail 
{


public void Send(String email, String msj, String asunto)
{

String host ="127.0.0.1";//Direccion del servidor SMTP
String from ="daemon@lojack.com.ar";
String to = email;


System.out.println ("Envio de mail..." + new java.util.Date());

Properties prop = new Properties();

prop.put("mail.smtp.host", host); 
prop.put("mail.smtp.auth", "true");

/*Añadir esta linea si queremos ver una salida detallada del programa*/
//prop.put("mail.debug", "true");

try{

SMTPAuthentication auth = new SMTPAuthentication(); 
Session session = Session.getInstance(prop , auth ); 
Message msg = getMessage(session, from, to, msj, asunto); 
System.out.println ("Enviando ..." );


Transport.send(msg);
System.out.println ("Mensaje enviado!");

}

catch (Exception e)
{

ExceptionManager.ManageException(e);

}

}

private static MimeMessage getMessage(Session session, String from, String to, String msj, String asunto) 
{

	try{

	MimeMessage msg = new MimeMessage(session); 
	msg.setText(msj);
	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	msg.setSubject("asunto");
	msg.setFrom(new InternetAddress(from,"Lo Jack"));
	
/////////////////////////////Guardar tabla Mail
	
	dao_email.Save(msj, to);

/////////////////////////////
	
	return msg;

	}

	catch (java.io.UnsupportedEncodingException ex)
	{
		
		ExceptionManager.ManageException(ex);
		return null;
	
	}
	
	catch (MessagingException ex)
	{
	
		ExceptionManager.ManageException(ex);
		return null;
	
	}
	
	}
	
}

class SMTPAuthentication extends javax.mail.Authenticator
{

	public PasswordAuthentication getPasswordAuthentication()
	{

		String username = "ezequiel";
		
		String password = "1234";
		
		return new PasswordAuthentication(username, password);

	}

}

class ExceptionManager
{

	public static void ManageException (Exception e) 
	{
	
		System.out.println ("Se ha producido una exception");
	
		System.out.println (e.getMessage());
	
		e.printStackTrace(System.out);
	
	}

}

