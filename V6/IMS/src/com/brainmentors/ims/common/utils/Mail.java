package com.brainmentors.ims.common.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Mail {

	public static boolean mailSender() throws TemplateException, IOException{
		final String username = "arunkumarmean@gmail.com";
		final String password = "arun123456";
		// Mail Paramters Configure
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		// Mail Session Create
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		// Sending Mail
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("amit.shashi.srivastava@gmail.com"));
			message.setSubject("Testing Subject");
			Configuration cfg = new Configuration();
			 Template template = cfg.getTemplate("./src/templates/adminmail.ftl");
			 Map<String, Object> data = new HashMap<String, Object>();
			 data.put("username", "Ram");
			 data.put("times", 5);
			 Writer out = new StringWriter();
	            template.process(data, out);
	            out.flush();
	            System.out.println("OUtput is "+out.toString());
	 
	          /*  // File output
	            Writer file = new FileWriter (new File("C:\\FTL_helloworld.txt"));
	            template.process(data, file);
	            file.flush();
	            file.close();*/
			 
			message.setText(out.toString());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return true;

	}
	
	public static void main(String[] args) throws TemplateException, IOException {
		mailSender();
		System.out.println("Mail Send...");
	}
	
	
	
}
